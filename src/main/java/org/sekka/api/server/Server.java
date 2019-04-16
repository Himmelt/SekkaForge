package org.sekka.api.server;

import org.jetbrains.annotations.NotNull;
import org.sekka.api.entity.Entity;
import org.sekka.api.entity.Player;
import org.sekka.api.storage.User;
import org.sekka.api.world.World;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public interface Server {

    String getName();

    String getVersion();

    World getWorld(int dimension);

    Collection<? extends Player> getPlayers();

    int getMaxPlayers();

    int getPort();

    int getViewDistance();

    String getIp();

    String getServerName();

    String getServerId();

    String getWorldType();

    boolean getGenerateStructures();

    boolean getAllowEnd();

    boolean getAllowNether();

    boolean hasWhitelist();

    void setWhitelist(boolean value);

    Set<User> getWhitelist();

    void reloadWhitelist();

    int broadcastMessage(String message);

    String getUpdateFolder();

    File getUpdateFolderFile();

    long getConnectionThrottle();

    int getTicksPerAnimalSpawns();

    int getTicksPerMonsterSpawns();

    Player getPlayer(String name);

    Player getPlayerExact(String name);

    List<Player> matchPlayer(String name);

    Player getPlayer(UUID id);

    List<World> getWorlds();

    boolean unloadWorld(String name, boolean save);

    boolean unloadWorld(World world, boolean save);

    World getWorld(String levelName);

    World getWorld(@NotNull UUID uuid);

    Logger getLogger();

    void savePlayers();

    void clearRecipes();

    void resetRecipes();

    Map<String, String[]> getCommandAliases();

    int getSpawnRadius();

    void setSpawnRadius(int value);

    boolean getOnlineMode();

    boolean getAllowFlight();

    boolean isHardcore();

    void shutdown();

    int broadcast(String message, String permission);

    User getUser(String name);

    User getUser(UUID uuid);

    Set<String> getIPBans();

    void banIP(String address);

    void unbanIP(String address);

    Set<User> getBannedPlayers();

    File getWorldContainer();

    User[] getOfflinePlayers();

    int getMonsterSpawnLimit();

    int getAnimalSpawnLimit();

    int getWaterAnimalSpawnLimit();

    int getAmbientSpawnLimit();

    boolean isPrimaryThread();

    String getMotd();

    String getShutdownMessage();

    void setIdleTimeout(int threshold);

    int getIdleTimeout();

    Entity getEntity(UUID uuid);
}
