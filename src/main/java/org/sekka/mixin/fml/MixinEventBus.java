package org.sekka.mixin.fml;

import com.google.common.collect.Sets;
import com.google.common.reflect.TypeToken;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.sekka.api.event.Listener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(value = EventBus.class, remap = false)
public abstract class MixinEventBus {

    @Shadow
    private ConcurrentHashMap<Object, ArrayList<IEventListener>> listeners;

    @Shadow
    private Map<Object, ModContainer> listenerOwners;

    @Shadow
    protected abstract void register(Class<?> eventType, Object target, Method method, ModContainer owner);

    /**
     * @author Himmelt
     */
    @Overwrite
    public void register(Object target) {
        if (listeners.containsKey(target)) return;

        ModContainer activeModContainer = Loader.instance().activeModContainer();
        if (activeModContainer == null) {
            FMLLog.log.error("Unable to determine registrant mod for {}. This is a critical error and should be impossible", target, new Throwable());
            activeModContainer = Loader.instance().getMinecraftModContainer();
        }
        listenerOwners.put(target, activeModContainer);
        boolean isStatic = target.getClass() == Class.class;
        @SuppressWarnings("unchecked")
        Set<? extends Class<?>> supers = isStatic ? Sets.newHashSet((Class<?>) target) : TypeToken.of(target.getClass()).getTypes().rawTypes();
        for (Method method : (isStatic ? (Class<?>) target : target.getClass()).getMethods()) {
            if (isStatic && !Modifier.isStatic(method.getModifiers())) continue;
            else if (!isStatic && Modifier.isStatic(method.getModifiers())) continue;

            for (Class<?> cls : supers) {
                try {
                    Method real = cls.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    boolean isSubscribeAnnotation = real.isAnnotationPresent(SubscribeEvent.class);
                    boolean isListenerAnnotation = real.isAnnotationPresent(Listener.class);
                    if (isSubscribeAnnotation || isListenerAnnotation) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length != 1) {
                            throw new IllegalArgumentException(
                                    "Method " + method + " has " + (isListenerAnnotation ? "@Listener" : "@SubscribeEvent") + " annotation, but requires " + parameterTypes.length +
                                            " arguments.  Event handler methods must require a single argument."
                            );
                        }

                        Class<?> eventType = parameterTypes[0];

                        if (!Event.class.isAssignableFrom(eventType)) {
                            throw new IllegalArgumentException("Method " + method + " has " + (isListenerAnnotation ? "@Listener" : "@SubscribeEvent") + " annotation, but takes a argument that is not an Event " + eventType);
                        }

                        register(eventType, target, real, activeModContainer);
                        break;
                    }
                } catch (NoSuchMethodException e) {
                    // Eat the error, this is not unexpected
                }
            }
        }
    }

}
