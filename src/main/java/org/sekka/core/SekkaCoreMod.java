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

/**
 * @author Himmelt
 */
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
        // TODO remove
        System.out.println("<init> SekkaCoreMod");
        initPaths((File) FMLInjectionData.data()[6]); // 6 = game dir
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.sekka.core.json");
        Mixins.addConfiguration("mixins.sekka.preinit.json");
        Launch.classLoader.addClassLoaderExclusion("org.slf4j.");
        Launch.classLoader.addClassLoaderExclusion("org.sekka.api.event.Event");
        Launch.classLoader.addClassLoaderExclusion("org.sekka.api.event.Cancelable");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return "org.sekka.core.SekkaMod";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        modFile = (File) data.get("coremodLocation");
        if (modFile == null) {
            modFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    private static void initPaths(File gameDirIn) {
        gameDir = gameDirIn.toPath();
        pluginsDir = gameDir.resolve("mods");
        configDir = gameDir.resolve("config");
        sekkaConfigDir = configDir.resolve(Sekka.MOD_ID);
    }
}
