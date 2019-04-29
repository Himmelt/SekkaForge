package org.sekka.core.plugin;

import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import org.sekka.api.plugin.PluginContainer;

import java.util.Map;

public class SekkaPluginContainer extends FMLModContainer implements PluginContainer {
    public SekkaPluginContainer(String className, ModCandidate container, Map<String, Object> modDescriptor) {
        super(className, container, modDescriptor);
    }
}
