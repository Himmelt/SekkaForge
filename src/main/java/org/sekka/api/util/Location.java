package org.sekka.api.util;

import org.jetbrains.annotations.NotNull;
import org.sekka.api.block.BlockType;
import org.sekka.api.util.math.MathUtil;
import org.sekka.api.util.math.Vec3d;
import org.sekka.api.world.Chunk;
import org.sekka.api.world.World;

public class Location implements Cloneable {

    private double x, y, z;
    private float yaw, pitch;
    @NotNull
    private World world;

    public Location(@NotNull World world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public Location(@NotNull World world, double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.world = world;
    }

    @NotNull
    public World getWorld() {
        return world;
    }

    public Chunk getChunk() {
        return world.getChunkAt(this);
    }

    public BlockType getBlockType() {
        return world.getBlockAt(this);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public int getBlockX() {
        return MathUtil.floor(x);
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public int getBlockY() {
        return MathUtil.floor(y);
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public int getBlockZ() {
        return MathUtil.floor(z);
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getYaw() {
        return yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getPitch() {
        return pitch;
    }

    public Location add(Vec3d vec) {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
        return this;
    }

    public Location add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Location subtract(Vec3d vec) {
        this.x -= vec.getX();
        this.y -= vec.getY();
        this.z -= vec.getZ();
        return this;
    }

    public Location subtract(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    public double distance(Location to) {
        return Math.sqrt(distanceSquared(to));
    }

    public double distanceSquared(Location to) {
        if (to == null) {
            throw new IllegalArgumentException("Cannot measure distance to a null location");
        } else if (to.world != world) {
            throw new IllegalArgumentException("Cannot measure distance between " + world.getName() + " and " + to.world.getName());
        }

        return (x - to.x) * (x - to.y) + (y - to.y) * (y - to.y) + (z - to.z) * (z - to.z);
    }

    public Location multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public Location zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Location)) return false;
        Location another = (Location) other;
        if (world != another.world) return false;
        // TODO == 和 doubleToLongBits 区别
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(another.getX())) return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(another.getY())) return false;
        if (Double.doubleToLongBits(z) != Double.doubleToLongBits(another.getZ())) return false;
        if (Float.floatToIntBits(pitch) != Float.floatToIntBits(another.getPitch())) return false;
        return Float.floatToIntBits(yaw) == Float.floatToIntBits(another.getYaw());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (world.hashCode());
        hash = 19 * hash + (int) (Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
        hash = 19 * hash + Float.floatToIntBits(pitch);
        hash = 19 * hash + Float.floatToIntBits(yaw);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "world=" + world.getName() + ",x=" + x + ",y=" + y + ",z=" + z + ",pitch=" + pitch + ",yaw=" + yaw + '}';
    }

    public Vec3d getVec3d() {
        return new Vec3d(x, y, z);
    }

    @Override
    public Location clone() {
        try {
            Location location = (Location) super.clone();
            location.x = x;
            location.y = y;
            location.z = z;
            location.pitch = pitch;
            location.yaw = yaw;
            location.world = world;
            return location;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
