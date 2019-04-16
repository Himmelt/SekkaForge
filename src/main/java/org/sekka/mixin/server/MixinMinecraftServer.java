package org.sekka.mixin.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.sekka.api.command.CommandException;
import org.sekka.api.command.CommandSender;
import org.sekka.api.command.ConsoleSender;
import org.sekka.api.entity.Entity;
import org.sekka.api.entity.Player;
import org.sekka.api.server.Server;
import org.sekka.api.storage.User;
import org.sekka.api.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.File;
import java.util.*;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer implements Server {

    @Shadow
    public abstract String getMinecraftVersion();

    @Shadow
    public WorldServer[] worlds;

    public String getName() {
        return "SekkaForge";
    }

    public String getVersion() {
        return getMinecraftVersion();
    }

    @Nullable
    public World getWorld(int dimension) {
        for (WorldServer world : worlds) if (((World) world).getDimension() == dimension) return (World) world;
        return null;
    }

    public World getWorld(@NotNull String levelName) {
        for (WorldServer world : worlds) if (((World) world).getName().equals(levelName)) return (World) world;
        return null;
    }

    public World getWorld(@NotNull UUID uuid) {
        for (WorldServer world : worlds) if (((World) world).getUUID().equals(uuid)) return (World) world;
        return null;
    }

    public Collection<Player> getPlayers() {
        return null;
    }

    public int getMaxPlayers() {
        return 0;
    }

    public int getPort() {
        return 0;
    }

    public int getViewDistance() {
        return 0;
    }

    public String getIp() {
        return null;
    }

    public String getServerName() {
        return null;
    }

    public String getServerId() {
        return null;
    }

    public String getWorldType() {
        return null;
    }

    public boolean getGenerateStructures() {
        return false;
    }

    public boolean getAllowEnd() {
        return false;
    }

    public boolean getAllowNether() {
        return false;
    }

    public boolean hasWhitelist() {
        return false;
    }

    public void setWhitelist(boolean value) {
    }

    public Set<User> getWhitelist() {
        return null;
    }

    public void reloadWhitelist() {
    }

    public int broadcastMessage(String message) {
        return 0;
    }

    public String getUpdateFolder() {
        return null;
    }

    public File getUpdateFolderFile() {
        return null;
    }

    public long getConnectionThrottle() {
        return 0;
    }

    public int getTicksPerAnimalSpawns() {
        return 0;
    }

    public int getTicksPerMonsterSpawns() {
        return 0;
    }

    public Player getPlayer(String name) {
        return null;
    }

    public Player getPlayerExact(String name) {
        return null;
    }

    public List<Player> matchPlayer(String name) {
        return null;
    }

    public Player getPlayer(UUID id) {
        return null;
    }

/*  public PluginManager getPluginManager() {}
    public BukkitScheduler getScheduler() {}
    public ServicesManager getServicesManager() {}*/

    @NotNull
    public List<World> getWorlds() {
        ArrayList<World> list = new ArrayList<>();
        if (worlds != null) for (WorldServer world : worlds) list.add((World) world);
        return list;
    }

    /*public World createWorld(WorldCreator creator) {}*/

    public boolean unloadWorld(String name, boolean save) {
        return false;
    }

    public boolean unloadWorld(World world, boolean save) {
        return false;
    }

    /*public MapView createMap(World world) {}*/

    public java.util.logging.Logger getLogger() {
        return null;
    }

    public void savePlayers() {
    }

    public boolean dispatchCommand(CommandSender sender, String command) throws CommandException {
        return false;
    }

/*
    public boolean addRecipe(Recipe recipe) {}
    public List<Recipe> getRecipesFor(ItemStack result) {}
    public Iterator<Recipe> recipeIterator() {}
*/

    public void clearRecipes() {
    }

    public void resetRecipes() {
    }

    public Map<String, String[]> getCommandAliases() {
        return null;
    }

    public int getSpawnRadius() {
        return 0;
    }

    public void setSpawnRadius(int value) {
    }

    public boolean getOnlineMode() {
        return false;
    }

    public boolean getAllowFlight() {
        return false;
    }

    public boolean isHardcore() {
        return false;
    }

    public void shutdown() {
    }

    public int broadcast(String message, String permission) {
        return 0;
    }

    public User getUser(String name) {
        return null;
    }

    public User getUser(UUID uuid) {
        return null;
    }

    public Set<String> getIPBans() {
        return null;
    }

    public void banIP(String address) {
    }

    public void unbanIP(String address) {
    }

    public Set<User> getBannedPlayers() {
        return null;
    }

/*
    public BanList getBanList(BanList.Type type) {
        return null;
    }

    public Set<OfflinePlayer> getOperators() {
        return null;
    }

    public GameMode getDefaultGameMode() {
        return null;
    }

    public void setDefaultGameMode(GameMode mode) {

    }
*/

    public ConsoleSender getConsoleSender() {
        return null;
    }

    public File getWorldContainer() {
        return null;
    }

    public User[] getOfflinePlayers() {
        return new User[0];
    }

    /* public Messenger getMessenger() {
         return null;
     }

     public HelpMap getHelpMap() {
         return null;
     }

     public Inventory createInventory(InventoryHolder owner, InventoryType type) {
         return null;
     }

     public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
         return null;
     }

     public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
         return null;
     }

     public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
         return null;
     }

     public Merchant createMerchant(String title) {
         return null;
     }
 */
    public int getMonsterSpawnLimit() {
        return 0;
    }

    public int getAnimalSpawnLimit() {
        return 0;
    }

    public int getWaterAnimalSpawnLimit() {
        return 0;
    }

    public int getAmbientSpawnLimit() {
        return 0;
    }

    public boolean isPrimaryThread() {
        return false;
    }

    public String getMotd() {
        return null;
    }

    public String getShutdownMessage() {
        return null;
    }
/*

    public Warning.WarningState getWarningState() {
        return null;
    }

    public ItemFactory getItemFactory() {
        return null;
    }

    public ScoreboardManager getScoreboardManager() {
        return null;
    }

    public CachedServerIcon getServerIcon() {
        return null;
    }

    public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        return null;
    }

    public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
        return null;
    }
*/

    public void setIdleTimeout(int threshold) {

    }

    public int getIdleTimeout() {
        return 0;
    }
/*
    public ChunkGenerator.ChunkData createChunkData(World world) {
        return null;
    }

    public BossBar createBossBar(String title, BarColor color, BarStyle style, BarFlag... flags) {
        return null;
    }
*/

    public Entity getEntity(UUID uuid) {
        return null;
    }
/*
    public Advancement getAdvancement(NamespacedKey key) {
        return null;
    }

    public Iterator<Advancement> advancementIterator() {
        return null;
    }*/
}
