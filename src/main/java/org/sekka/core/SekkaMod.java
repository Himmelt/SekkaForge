package org.sekka.core;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModContainerFactory;
import net.minecraftforge.fml.common.ModMetadata;
import org.objectweb.asm.Type;
import org.sekka.api.Sekka;
import org.sekka.api.plugin.Plugin;
import org.sekka.core.event.SekkaEventManager;
import org.sekka.core.plugin.SekkaPluginContainer;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Himmelt
 */
public class SekkaMod extends DummyModContainer {

    private File modFile;

    public SekkaMod() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = Sekka.MOD_ID;
        meta.name = Sekka.MOD_NAME;
        meta.version = Sekka.MOD_VERSION;
        meta.credits = "Made possible with help from many people";
        meta.authorList = Collections.singletonList("Himmelt");
        meta.description = "Sekka Plugin Mod.";
        meta.url = "http://github.com/Himmelt/SekkaForge";
        meta.screenshots = new String[0];
        meta.logoFile = "/sekka_logo.png";

        // TODO remove
        System.out.println("<init> SekkaMod");
        ModContainerFactory.instance().registerContainerType(Type.getType(Plugin.class), SekkaPluginContainer.class);
        this.modFile = SekkaCoreMod.modFile;
        init();
    }

    private void init() {
        try {
            Field eventManager = Sekka.class.getDeclaredField("eventManager");
            eventManager.setAccessible(true);
            eventManager.set(null, new SekkaEventManager());
        } catch (Throwable e) {
            System.out.println("CAN NOT construct eventManager field in Sekka.class !");
        }
    }

    @Override
    public File getSource() {
        return modFile;
    }
}
