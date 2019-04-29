package org.sekka.mixin.event.block;

import org.sekka.api.event.block.BlockEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = net.minecraftforge.event.world.BlockEvent.class,remap = false)
public abstract class MixinBlockEvent implements BlockEvent {
}
