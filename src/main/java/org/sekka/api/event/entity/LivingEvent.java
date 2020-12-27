package org.sekka.api.event.entity;

import org.sekka.api.entity.LivingEntity;

/**
 * @author Himmelt
 */
public interface LivingEvent extends EntityEvent {
    LivingEntity getLiving();
}
