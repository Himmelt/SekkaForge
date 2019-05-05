package org.sekka.mixin.event.entity;


import net.minecraft.entity.EntityLivingBase;
import org.sekka.api.entity.LivingEntity;
import org.sekka.api.event.entity.LivingEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraftforge.event.entity.living.LivingEvent.class, remap = false)
public abstract class MixinLivingEvent extends MixinEntityEvent implements LivingEvent {
    @Shadow
    @Final
    private EntityLivingBase entityLiving;

    public LivingEntity getLiving() {
        return (LivingEntity) entityLiving;
    }
}
