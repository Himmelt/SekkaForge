package org.sekka.mixin.event.entity.player;

import org.sekka.api.event.entity.player.FillBucketEvent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = net.minecraftforge.event.entity.player.FillBucketEvent.class, remap = false)
public abstract class MixinFillBucketEvent extends MixinPlayerEvent implements FillBucketEvent {
    public boolean isCancelled() {
        return isCanceled();
    }

    public void setCancelled(boolean cancel) {
        setCanceled(cancel);
    }
}
