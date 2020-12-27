package org.sekka.api.event;

import org.jetbrains.annotations.NotNull;

/**
 * @author Himmelt
 */
public interface EventManager {
    void register(@NotNull Object listener);

    void unregister(@NotNull Object listener);

    boolean post(@NotNull Event event);
}
