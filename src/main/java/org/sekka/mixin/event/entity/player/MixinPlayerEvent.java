package org.sekka.mixin.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import org.sekka.api.entity.Player;
import org.sekka.api.event.entity.player.PlayerEvent;
import org.sekka.mixin.event.entity.MixinEntityEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = net.minecraftforge.event.entity.player.PlayerEvent.class, remap = false)
public abstract class MixinPlayerEvent extends MixinEntityEvent implements PlayerEvent {
    @Shadow
    @Final
    private EntityPlayer entityPlayer;

    public Player getPlayer() {
        return (Player) entityPlayer;
    }
}
