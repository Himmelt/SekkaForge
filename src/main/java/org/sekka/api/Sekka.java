package org.sekka.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.sekka.api.event.EventManager;
import org.sekka.api.server.Server;
import org.sekka.api.world.World;

import java.util.UUID;

/**
 * @author Himmelt
 */
public final class Sekka {

    private static Server server;
    private static EventManager eventManager;

    public static final String MOD_ID = "sekka";
    public static final String MOD_NAME = "Sekka";
    public static final String MOD_VERSION = "0.0.1";

    private Sekka() {
    }

    public static Server getServer() {
        return server;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static World getWorld(@Nullable UUID uuid) {
        if (server != null && uuid != null) {
            return server.getWorld(uuid);
        }
        return null;
    }

    public static World getWorld(String levelName) {
        if (server != null && levelName != null && !levelName.isEmpty()) {
            return server.getWorld(levelName);
        }
        return null;
    }

    public static void registerListener(@NotNull Object listener) {
        eventManager.register(listener);
    }

    public static void unregisterListener(@NotNull Object listener) {
        eventManager.unregister(listener);
    }
}
