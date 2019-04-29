package org.sekka.mixin.fml;

import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.ModContainerFactory;
import org.objectweb.asm.Type;
import org.sekka.api.plugin.Plugin;
import org.sekka.core.plugin.SekkaPluginContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModContainerFactory.class,remap = false)
public abstract class MixinModContainerFactory {

    @Shadow(remap = false)
    public abstract void registerContainerType(Type type, Class<? extends ModContainer> container);

    @Inject(method = "<init>", at = @At("RETURN"))
    private void registerPluginAnnotation(CallbackInfo info) {
        System.out.println("registerContainerType:" + Plugin.class);
        registerContainerType(Type.getType(Plugin.class), SekkaPluginContainer.class);
    }
}
