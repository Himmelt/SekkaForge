package org.sekka.core.plugin;

import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import org.sekka.api.plugin.PluginContainer;

import java.util.Map;

public class SekkaPluginContainer extends FMLModContainer implements PluginContainer {
    public SekkaPluginContainer(String className, ModCandidate container, Map<String, Object> descriptor) {
        super(className, container, pluginFix(descriptor));
    }

    public String getId() {
        return getModId();
    }

    private static Map<String, Object> pluginFix(Map<String, Object> descriptor) {
        if (descriptor.containsKey("id") && !descriptor.containsKey("modid")) {
            descriptor.put("modid", descriptor.get("id"));
        } else if (!descriptor.containsKey("id") && descriptor.containsKey("modid")) {
            descriptor.put("id", descriptor.get("modid"));
        }
        return descriptor;
    }
}
