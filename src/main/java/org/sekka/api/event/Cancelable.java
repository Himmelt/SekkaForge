package org.sekka.api.event;

public interface Cancelable {
    boolean isCancelled();

    void setCancelled(boolean cancel);
}