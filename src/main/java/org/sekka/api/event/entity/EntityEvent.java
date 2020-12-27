package org.sekka.api.event.entity;

import org.sekka.api.entity.Entity;
import org.sekka.api.event.Event;

public interface EntityEvent extends Event {
    Entity getEntity();
}
