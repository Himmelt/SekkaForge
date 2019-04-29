package org.sekka.core;

import net.minecraftforge.fml.common.ModContainerFactory;
import org.objectweb.asm.Type;
import org.sekka.api.plugin.Plugin;
import org.sekka.core.plugin.SekkaPluginContainer;

public class SekkaCoreMod {
    public SekkaCoreMod() {
        ModContainerFactory.instance().registerContainerType(Type.getType(Plugin.class), SekkaPluginContainer.class);
    }
}
