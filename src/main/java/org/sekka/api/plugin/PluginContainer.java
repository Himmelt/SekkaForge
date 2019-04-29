package org.sekka.api.plugin;

import net.minecraftforge.fml.common.ModContainer;
import org.sekka.api.assets.Asset;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PluginContainer extends ModContainer {

    default String getId() {
        return getModId();
    }

    default String getName() {
        return getId();
    }

    default String getVersion() {
        return "x.y.z";
    }

    default String getDescription() {
        return "Plugin - " + getName() + " - " + getVersion() + " .";
    }

    default Optional<String> getUrl() {
        return Optional.empty();
    }

    default List<String> getAuthors() {
        return Collections.emptyList();
    }

    default Set<PluginDependency> getPluginDependencies() {
        return Collections.emptySet();
    }

    default Optional<PluginDependency> getDependency(String id) {
        return Optional.empty();
    }

    default Optional<Asset> getAsset(String name) {
        return Optional.empty();
    }

    default Optional<Path> getPath() {
        return Optional.empty();
    }

    default Optional<?> getInstance() {
        return Optional.empty();
    }
}
