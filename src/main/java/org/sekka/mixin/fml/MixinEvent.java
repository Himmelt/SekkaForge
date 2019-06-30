package org.sekka.mixin.fml;

import org.sekka.api.event.Event;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraftforge.fml.common.eventhandler.Event.class, remap = false)
public abstract class MixinEvent implements Event {
    @Shadow
    public abstract void setCanceled(boolean cancel);

    @Shadow
    public abstract boolean isCanceled();
}
