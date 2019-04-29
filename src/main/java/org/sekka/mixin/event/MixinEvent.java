package org.sekka.mixin.event;

import org.sekka.api.event.Event;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = net.minecraftforge.fml.common.eventhandler.Event.class, remap = false)
public abstract class MixinEvent implements Event {
}
