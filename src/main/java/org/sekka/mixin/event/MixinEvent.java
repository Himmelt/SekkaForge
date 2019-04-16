package org.sekka.mixin.event;

import org.sekka.api.event.Event;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraftforge.fml.common.eventhandler.Event.class)
public abstract class MixinEvent implements Event {
}
