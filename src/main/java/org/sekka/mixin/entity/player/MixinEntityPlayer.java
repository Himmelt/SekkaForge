package org.sekka.mixin.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import org.sekka.api.entity.Player;
import org.sekka.mixin.entity.MixinEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityPlayer.class)
public abstract class MixinEntityPlayer extends MixinEntity implements Player {

    @Shadow
    public int experienceLevel;

    @Inject(method = "jump", at = @At("RETURN"))
    private void onJump(CallbackInfo info) {
        sendMessage(new TextComponentString("I am junping !"));
    }

    public int getLevel() {
        return experienceLevel;
    }
}
