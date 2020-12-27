package org.sekka.api.plugin;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Himmelt
 */
public interface PluginManager {

    String MINECRAFT_PLUGIN_ID = "minecraft";
    String SEKKA_PLUGIN_ID = "sekka";

    Optional<PluginContainer> fromInstance(Object instance);

    Optional<PluginContainer> getPlugin(String id);

    Collection<PluginContainer> getPlugins();

    boolean isLoaded(String id);
}
