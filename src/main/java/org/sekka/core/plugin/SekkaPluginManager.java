package org.sekka.core.plugin;

import org.sekka.api.plugin.PluginContainer;
import org.sekka.api.plugin.PluginManager;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Himmelt
 */
public class SekkaPluginManager implements PluginManager {
    @Override
    public Optional<PluginContainer> fromInstance(Object o) {
        return Optional.empty();
    }

    @Override
    public Optional<PluginContainer> getPlugin(String s) {
        return Optional.empty();
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        return null;
    }

    @Override
    public boolean isLoaded(String id) {
        return false;
    }
}
