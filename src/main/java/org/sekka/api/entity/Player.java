package org.sekka.api.entity;

import org.sekka.api.command.CommandSender;
import org.sekka.api.storage.User;
import org.sekka.api.util.Location;

import java.net.InetSocketAddress;

public interface Player extends CommandSender, User {

    String getDisplayName();

    void setDisplayName(String name);

    String getPlayerListName();

    void setPlayerListName(String name);

    void setCompassTarget(Location loc);

    Location getCompassTarget();

    InetSocketAddress getAddress();

    void sendRawMessage(String message);

    void kickPlayer(String message);

    void chat(String msg);

    boolean performCommand(String command);

    boolean isSneaking();

    void setSneaking(boolean sneak);

    boolean isSprinting();

    void setSprinting(boolean sprinting);

    void saveData();

    void loadData();

    void setSleepingIgnored(boolean isSleeping);

    boolean isSleepingIgnored();

    @Deprecated
    void playNote(Location loc, byte instrument, byte note);

   /* void playNote(Location loc, Instrument instrument, Note note);

    void playSound(Location location, Sound sound, float volume, float pitch);

    void playSound(Location location, String sound, float volume, float pitch);

    void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch);

    void playSound(Location location, String sound, SoundCategory category, float volume, float pitch);

    void stopSound(Sound sound);

    void stopSound(String sound);

    void stopSound(Sound sound, SoundCategory category);

    void stopSound(String sound, SoundCategory category);

    @Deprecated
    void playEffect(Location loc, Effect effect, int data);

    <T> void playEffect(Location loc, Effect effect, T data);

    @Deprecated
    void sendBlockChange(Location loc, Material material, byte data);*/

    @Deprecated
    boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data);

    @Deprecated
    void sendBlockChange(Location loc, int material, byte data);

    void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException;

    //void sendMap(MapView map);

    void updateInventory();

    /*  @Deprecated
      void awardAchievement(Achievement achievement);

      @Deprecated
      void removeAchievement(Achievement achievement);

      @Deprecated
      boolean hasAchievement(Achievement achievement);

      void incrementStatistic(Statistic statistic) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic) throws IllegalArgumentException;

      void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException;

      void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException;

      int getStatistic(Statistic statistic) throws IllegalArgumentException;

      void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

      int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException;

      void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException;

      void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException;

      void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

      int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException;

      void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException;

      void decrementStatistic(Statistic statistic, EntityType entityType, int amount);

      void setStatistic(Statistic statistic, EntityType entityType, int newValue);
  */
    void setPlayerTime(long time, boolean relative);

    long getPlayerTime();

    long getPlayerTimeOffset();

    boolean isPlayerTimeRelative();

    void resetPlayerTime();

/*
    void setPlayerWeather(WeatherType type);

    WeatherType getPlayerWeather();
*/

    void resetPlayerWeather();

    void giveExp(int amount);

    void giveExpLevels(int amount);

    float getExp();

    void setExp(float exp);

    int getLevel();

    void setLevel(int level);

    int getTotalExperience();

    void setTotalExperience(int exp);

    float getExhaustion();

    void setExhaustion(float value);

    float getSaturation();

    void setSaturation(float value);

    int getFoodLevel();

    void setFoodLevel(int value);

    Location getBedSpawnLocation();

    void setBedSpawnLocation(Location location);

    void setBedSpawnLocation(Location location, boolean force);

    boolean getAllowFlight();

    void setAllowFlight(boolean flight);

    @Deprecated
    void hidePlayer(Player player);

    //void hidePlayer(Plugin plugin, Player player);

    @Deprecated
    void showPlayer(Player player);

    //void showPlayer(Plugin plugin, Player player);

    boolean canSee(Player player);

    boolean isFlying();

    void setFlying(boolean value);

    void setFlySpeed(float value) throws IllegalArgumentException;

    void setWalkSpeed(float value) throws IllegalArgumentException;

    float getFlySpeed();

    float getWalkSpeed();

    @Deprecated
    void setTexturePack(String url);

    void setResourcePack(String url);

    void setResourcePack(String url, byte[] hash);

    //Scoreboard getScoreboard();

    //void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException;

    boolean isHealthScaled();

    void setHealthScaled(boolean scale);

    void setHealthScale(double scale) throws IllegalArgumentException;

    double getHealthScale();

    Entity getSpectatorTarget();

    void setSpectatorTarget(Entity entity);

    @Deprecated
    void sendTitle(String title, String subtitle);

    void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut);

    void resetTitle();

    /*void spawnParticle(Particle particle, Location location, int count);

    void spawnParticle(Particle particle, double x, double y, double z, int count);

    <T> void spawnParticle(Particle particle, Location location, int count, T data);

    <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data);

    void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ);

    void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);

    <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data);

    <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data);

    void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra);

    void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra);

    <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

    <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data);

    AdvancementProgress getAdvancementProgress(Advancement advancement);
*/
    // TODO 插件根据玩家语言发送对应语言翻译
    String getLocale();
}
