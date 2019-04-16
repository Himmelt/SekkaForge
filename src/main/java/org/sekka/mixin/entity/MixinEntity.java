package org.sekka.mixin.entity;

import net.minecraft.util.math.BlockPos;
import org.sekka.api.block.Block;
import org.sekka.api.entity.Entity;
import org.sekka.api.entity.EntityType;
import org.sekka.api.server.Server;
import org.sekka.api.util.Location;
import org.sekka.api.util.math.Vec3d;
import org.sekka.api.world.Chunk;
import org.sekka.api.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mixin(value = net.minecraft.entity.Entity.class)
public abstract class MixinEntity implements Entity {

    @Shadow
    public net.minecraft.world.World world;

    @Shadow
    public double posX;
    @Shadow
    public double posY;
    @Shadow
    public double posZ;

    @Shadow
    public boolean onGround;

    @Shadow
    private int entityId;

    @Shadow
    private int fire;

    @Shadow
    public abstract void setFire(int seconds);

    @Shadow
    public boolean isDead;

    @Shadow
    public float fallDistance;

    @Shadow
    protected UUID entityUniqueID;

    @Shadow
    public int ticksExisted;

    @Shadow
    protected boolean glowing;

    @Shadow
    public abstract boolean hasNoGravity();

    @Shadow
    public abstract void setNoGravity(boolean noGravity);

    @Shadow
    public abstract BlockPos getPosition();

    @Shadow
    public double motionX;

    @Shadow
    public double motionY;

    @Shadow
    public double motionZ;

    public Location getLocation() {
        return new Location((World) world, posX, posY, posZ);
    }

    public Block getBlockPos() {
        BlockPos pos = getPosition();
        return new Block((Chunk) world.getChunk(pos), pos.getX(), pos.getY(), pos.getZ());
    }

    public void setMotion(Vec3d vec) {
        motionX = vec.getX();
        motionY = vec.getY();
        motionZ = vec.getZ();
    }

    public void setMotion(double x, double y, double z) {
        motionX = x;
        motionY = y;
        motionZ = z;
    }

    public Vec3d getMotion() {
        return new Vec3d(motionX, motionY, motionZ);
    }

    public double getHeight() {
        return 0;
    }

    public double getWidth() {
        return 0;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public World getWorld() {
        return (World) world;
    }

    public boolean teleport(Location location) {
        return false;
    }

    public boolean teleport(Entity destination) {
        return false;
    }

    /* public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
         return false;
     }
     public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
         return false;
     }*/

    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return null;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getFireTicks() {
        return fire;
    }

    public int getMaxFireTicks() {
        return 0;
    }

    public void setFireTicks(int ticks) {
        setFire(ticks);
    }

    public void remove() {

    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isValid() {
        return false;
    }

    public Server getServer() {
        return (Server) world.getMinecraftServer();
    }

    public Entity getPassenger() {
        return null;
    }

    public List<Entity> getPassengers() {
        return null;
    }

    public boolean addPassenger(Entity passenger) {
        return false;
    }

    public boolean removePassenger(Entity passenger) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean eject() {
        return false;
    }

    public float getFallDistance() {
        return fallDistance;
    }

    public void setFallDistance(float distance) {
        fallDistance = distance;
    }

    public UUID getUniqueId() {
        return entityUniqueID;
    }

    public int getTicksLived() {
        return ticksExisted;
    }

    public void setTicksLived(int ticks) {
        ticksExisted = ticks;
    }

    /*public void playEffect(EntityEffect type) { }*/

    public EntityType getType() {
        return null;
    }

    public boolean isInsideVehicle() {
        return false;
    }

    public boolean leaveVehicle() {
        return false;
    }

    public Entity getVehicle() {
        return null;
    }

    public void setCustomNameVisible(boolean flag) {
    }

    public boolean isCustomNameVisible() {
        return false;
    }

    public void setGlowing(boolean flag) {
        glowing = flag;
    }

    public boolean isGlowing() {
        return glowing;
    }

    public void setInvulnerable(boolean flag) {

    }

    public boolean isInvulnerable() {
        return false;
    }

    public boolean isSilent() {
        return false;
    }

    public void setSilent(boolean flag) {

    }

    public boolean hasGravity() {
        return !hasNoGravity();
    }

    public void setGravity(boolean gravity) {
        setNoGravity(!gravity);
    }

    public int getPortalCooldown() {
        return 0;
    }

    public void setPortalCooldown(int cooldown) {

    }

    public Set<String> getScoreboardTags() {
        return null;
    }

    public boolean addScoreboardTag(String tag) {
        return false;
    }

    public boolean removeScoreboardTag(String tag) {
        return false;
    }

    /*public PistonMoveReaction getPistonMoveReaction() { }*/
}
