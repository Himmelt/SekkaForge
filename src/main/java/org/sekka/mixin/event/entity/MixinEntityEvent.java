package org.sekka.mixin.event.entity;


import org.sekka.api.event.entity.EntityEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraftforge.event.entity.EntityEvent.class)
public abstract class MixinEntityEvent implements EntityEvent {
}
