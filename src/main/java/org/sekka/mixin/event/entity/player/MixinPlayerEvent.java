package org.sekka.mixin.event.entity.player;

import org.sekka.api.event.entity.player.PlayerEvent;
import org.sekka.mixin.event.entity.MixinEntityEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value=net.minecraftforge.event.entity.player.PlayerEvent.class,remap = false)
public abstract class MixinPlayerEvent extends MixinEntityEvent implements PlayerEvent {
}
