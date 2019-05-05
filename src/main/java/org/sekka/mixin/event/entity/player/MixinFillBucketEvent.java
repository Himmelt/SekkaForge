package org.sekka.mixin.event.entity.player;

import org.sekka.api.event.entity.player.FillBucketEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = net.minecraftforge.event.entity.player.FillBucketEvent.class, remap = false)
public class MixinFillBucketEvent extends MixinPlayerEvent implements FillBucketEvent {

    public boolean isCancelled() {
        return false;
    }

    public void setCancelled(boolean cancel) {

    }
}
