package org.sekka.api.entity;

import org.sekka.api.block.Block;
import org.sekka.api.server.Server;
import org.sekka.api.util.Location;
import org.sekka.api.util.math.Vec3d;
import org.sekka.api.world.World;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Entity {

    Location getLocation();

    Block getBlockPos();

    void setMotion(double x, double y, double z);

    void setMotion(Vec3d velocity);

    Vec3d getMotion();

    double getHeight();

    double getWidth();

    boolean isOnGround();

    World getWorld();

    boolean teleport(Location location);

    boolean teleport(Entity destination);

    List<Entity> getNearbyEntities(double x, double y, double z);

    int getEntityId();

    int getFireTicks();

    int getMaxFireTicks();

    void setFireTicks(int ticks);

    void remove();

    boolean isDead();

    boolean isValid();

    Server getServer();

    Entity getPassenger();

    List<Entity> getPassengers();

    boolean addPassenger(Entity passenger);

    boolean removePassenger(Entity passenger);

    boolean isEmpty();

    boolean eject();

    float getFallDistance();

    void setFallDistance(float distance);

    UUID getUniqueId();

    int getTicksLived();

    void setTicksLived(int value);

    EntityType getType();

    boolean isInsideVehicle();

    boolean leaveVehicle();

    Entity getVehicle();

    void setCustomNameVisible(boolean flag);

    boolean isCustomNameVisible();

    void setGlowing(boolean flag);

    boolean isGlowing();

    void setInvulnerable(boolean flag);

    boolean isInvulnerable();

    boolean isSilent();

    void setSilent(boolean flag);

    boolean hasGravity();

    void setGravity(boolean gravity);

    int getPortalCooldown();

    void setPortalCooldown(int cooldown);

    Set<String> getScoreboardTags();

    boolean addScoreboardTag(String tag);

    boolean removeScoreboardTag(String tag);
}
