package org.sekka.api.event.entity;

import org.sekka.api.entity.LivingEntity;

public interface LivingEvent extends EntityEvent {
    LivingEntity getLiving();
}
