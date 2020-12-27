package org.sekka.api.event;

/**
 * @author Himmelt
 */
public interface Cancelable {
    boolean isCancelled();

    void setCancelled(boolean cancel);
}
