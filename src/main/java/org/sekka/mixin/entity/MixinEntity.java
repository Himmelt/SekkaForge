package org.sekka.mixin.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
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

    @Shadow public abstract void sendMessage(ITextComponent message);

    @Override
    public Location getLocation() {
        return new Location((World) world, posX, posY, posZ);
    }

    @Override
    public Block getBlockPos() {
        BlockPos pos = getPosition();
        return new Block((Chunk) world.getChunk(pos), pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void setMotion(Vec3d vec) {
        motionX = vec.getX();
        motionY = vec.getY();
        motionZ = vec.getZ();
    }

    @Override
    public void setMotion(double x, double y, double z) {
        motionX = x;
        motionY = y;
        motionZ = z;
    }

    @Override
    public Vec3d getMotion() {
        return new Vec3d(motionX, motionY, motionZ);
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public boolean isOnGround() {
        return onGround;
    }

    @Override
    public World getWorld() {
        return (World) world;
    }

    @Override
    public boolean teleport(Location location) {
        return false;
    }

    @Override
    public boolean teleport(Entity destination) {
        return false;
    }

    /* public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
         return false;
     }
     public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
         return false;
     }*/

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return null;
    }

    @Override
    public int getEntityId() {
        return entityId;
    }

    @Override
    public int getFireTicks() {
        return fire;
    }

    @Override
    public int getMaxFireTicks() {
        return 0;
    }

    @Override
    public void setFireTicks(int ticks) {
        setFire(ticks);
    }

    @Override
    public void remove() {
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Server getServer() {
        return (Server) world.getMinecraftServer();
    }

    @Override
    public Entity getPassenger() {
        return null;
    }

    @Override
    public List<Entity> getPassengers() {
        return null;
    }

    @Override
    public boolean addPassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean removePassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean eject() {
        return false;
    }

    @Override
    public float getFallDistance() {
        return fallDistance;
    }

    @Override
    public void setFallDistance(float distance) {
        fallDistance = distance;
    }

    @Override
    public UUID getUniqueId() {
        return entityUniqueID;
    }

    @Override
    public int getTicksLived() {
        return ticksExisted;
    }

    @Override
    public void setTicksLived(int ticks) {
        ticksExisted = ticks;
    }

    /*public void playEffect(EntityEffect type) { }*/

    @Override
    public EntityType getType() {
        return null;
    }

    @Override
    public boolean isInsideVehicle() {
        return false;
    }

    @Override
    public boolean leaveVehicle() {
        return false;
    }

    @Override
    public Entity getVehicle() {
        return null;
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }

    @Override
    public void setGlowing(boolean flag) {
        glowing = flag;
    }

    @Override
    public boolean isGlowing() {
        return glowing;
    }

    @Override
    public void setInvulnerable(boolean flag) {

    }

    @Override
    public boolean isInvulnerable() {
        return false;
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    @Override
    public void setSilent(boolean flag) {

    }

    @Override
    public boolean hasGravity() {
        return !hasNoGravity();
    }

    @Override
    public void setGravity(boolean gravity) {
        setNoGravity(!gravity);
    }

    @Override
    public int getPortalCooldown() {
        return 0;
    }

    @Override
    public void setPortalCooldown(int cooldown) {

    }

    @Override
    public Set<String> getScoreboardTags() {
        return null;
    }

    @Override
    public boolean addScoreboardTag(String tag) {
        return false;
    }

    @Override
    public boolean removeScoreboardTag(String tag) {
        return false;
    }

    /*public PistonMoveReaction getPistonMoveReaction() { }*/
}
