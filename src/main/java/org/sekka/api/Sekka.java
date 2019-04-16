package org.sekka.api;

import org.jetbrains.annotations.Nullable;
import org.sekka.api.server.Server;
import org.sekka.api.world.World;

import java.util.UUID;

public final class Sekka {

    private static Server server;

    private Sekka() {
    }

    public static Server getServer() {
        return server;
    }

    public static World getWorld(@Nullable UUID uuid) {
        if (server != null && uuid != null) return server.getWorld(uuid);
        return null;
    }

    public static World getWorld(String levelName) {
        if (server != null && levelName != null && !levelName.isEmpty()) return server.getWorld(levelName);
        return null;
    }
}
