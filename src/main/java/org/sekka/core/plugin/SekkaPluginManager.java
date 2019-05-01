package org.sekka.core.plugin;

import org.sekka.api.plugin.PluginContainer;
import org.sekka.api.plugin.PluginManager;

import java.util.Collection;
import java.util.Optional;

public class SekkaPluginManager implements PluginManager {
    public Optional<PluginContainer> fromInstance(Object o) {
        return Optional.empty();
    }

    public Optional<PluginContainer> getPlugin(String s) {
        return Optional.empty();
    }

    public Collection<PluginContainer> getPlugins() {
        return null;
    }

    public boolean isLoaded(String s) {
        return false;
    }
}
