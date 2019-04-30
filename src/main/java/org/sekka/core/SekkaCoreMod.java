package org.sekka.core;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.relauncher.FMLInjectionData;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.sekka.api.Sekka;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class SekkaCoreMod implements IFMLLoadingPlugin {

    static File modFile;
    private static Path gameDir;
    private static Path pluginsDir;
    private static Path additionalPluginsDir;
    private static Path configDir;
    private static Path sekkaConfigDir;
    private static Path pluginConfigDir;

    public SekkaCoreMod() {
        System.out.println("<init> SekkaCoreMod");
        Launch.classLoader.addClassLoaderExclusion("org.slf4j.");
        initPaths((File) FMLInjectionData.data()[6]); // 6 = game dir
        setupMixinEnvironment();
        Mixins.addConfiguration("mixins.sekka.preinit.json");
        Launch.classLoader.addClassLoaderExclusion("org.sekka.api.event.Event");
        Launch.classLoader.addClassLoaderExclusion("org.sekka.api.event.Cancelable");
    }

    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return "org.sekka.core.SekkaMod";
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
        modFile = (File) data.get("coremodLocation");
        if (modFile == null) {
            modFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        }
    }

    public String getAccessTransformerClass() {
        return "org.sekka.core.asm.SekkaAccessTransformer";
    }

    private static void initPaths(File gameDirIn) {
        gameDir = gameDirIn.toPath();
        pluginsDir = gameDir.resolve("mods");
        configDir = gameDir.resolve("config");
        sekkaConfigDir = configDir.resolve(Sekka.MOD_ID);
    }

    private static void setupMixinEnvironment() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.sekka.core.json");
    }
}
