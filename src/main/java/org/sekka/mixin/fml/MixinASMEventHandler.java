package org.sekka.mixin.fml;

import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.*;
import org.apache.logging.log4j.ThreadContext;
import org.sekka.api.event.Listener;
import org.sekka.core.event.SekkaEventManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author Himmelt
 */
@Mixin(value = ASMEventHandler.class, remap = false)
public class MixinASMEventHandler {

    @Shadow
    @Final
    private SubscribeEvent subInfo;
    @Shadow
    @Final
    private static boolean GETCONTEXT;
    @Shadow
    private ModContainer owner;
    @Shadow
    @Final
    private IEventListener handler;
    @Shadow
    private Type filter;
    private EventPriority priority;
    private boolean ignoreCancelled;

    @Inject(method = "<init>(Ljava/lang/Object;Ljava/lang/reflect/Method;Lnet/minecraftforge/fml/common/ModContainer;Z)V", at = @At("RETURN"))
    private void onInit(Object target, Method method, ModContainer owner, boolean isGeneric, CallbackInfo info) {
        if (subInfo != null) {
            priority = subInfo.priority();
            ignoreCancelled = !subInfo.receiveCanceled();
        } else {
            Listener listener = method.getAnnotation(Listener.class);
            if (listener != null) {
                priority = SekkaEventManager.PRIORITY_MAPPINGS.inverse().getOrDefault(listener.priority(), EventPriority.NORMAL);
                ignoreCancelled = listener.ignoreCancelled();
            } else {
                priority = EventPriority.NORMAL;
                ignoreCancelled = true;
            }
        }
    }

    /**
     * @author Himmelt
     */
    @Overwrite
    public void invoke(Event event) {
        if (GETCONTEXT) {
            ThreadContext.put("mod", owner == null ? "" : owner.getName());
        }
        if (handler != null) {
            if (!event.isCancelable() || !event.isCanceled() || !ignoreCancelled) {
                if (filter == null || filter == ((IGenericEvent) event).getGenericType()) {
                    handler.invoke(event);
                }
            }
        }
        if (GETCONTEXT) {
            ThreadContext.remove("mod");
        }
    }

    /**
     * @author Himmelt
     */
    @Overwrite
    public EventPriority getPriority() {
        return priority;
    }
}
