package org.sekka.mixin.event.entity;


import org.sekka.api.entity.Entity;
import org.sekka.api.event.entity.EntityEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraftforge.event.entity.EntityEvent.class, remap = false)
public abstract class MixinEntityEvent implements EntityEvent {
    @Shadow
    @Final
    private net.minecraft.entity.Entity entity;

    public Entity getEntity() {
        return (Entity) entity;
    }
}
