package org.sekka.api.event.entity.player;

import org.sekka.api.entity.Player;
import org.sekka.api.event.entity.LivingEvent;

public interface PlayerEvent extends LivingEvent {
    Player getPlayer();
}
