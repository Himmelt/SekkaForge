package org.sekka.api.block;

import org.jetbrains.annotations.NotNull;
import org.sekka.api.util.BlockFace;
import org.sekka.api.util.Location;
import org.sekka.api.world.Chunk;
import org.sekka.api.world.World;

public class Block {

    private final int x, y, z;
    @NotNull
    private final Chunk chunk;

    public Block(@NotNull Chunk chunk, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.chunk = chunk;
    }

    public byte getMeta() {
        // TODO 检查 相对坐标
        return chunk.getMetaAt(x >> 4, y, z >> 4);
    }

    public Block getRelative(int modX, int modY, int modZ) {
        return null;
    }

    public Block getRelative(BlockFace face) {
        return null;
    }

    public Block getRelative(BlockFace face, int distance) {
        return null;
    }

    public BlockType getType() {
        return null;
    }

    public int getTypeId() {
        return 0;
    }

    public byte getLightLevel() {
        return 0;
    }

    public byte getLightFromSky() {
        return 0;
    }

    public byte getLightFromBlocks() {
        return 0;
    }

    public World getWorld() {
        return null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Location getLocation() {
        return new Location(chunk.getWorld(), x, y, z);
    }

    @NotNull
    public Chunk getChunk() {
        return chunk;
    }

    public void setMeta(byte data) {
        chunk.setMetaAt(data, x, y, z);
    }

    public void setMeta(byte data, boolean applyPhysics) {

    }

    public void setType(BlockType type) {

    }

    public void setType(BlockType type, boolean applyPhysics) {
    }

    public BlockFace getFace(Block block) {
        return null;
    }

    public boolean isBlockPowered() {
        return false;
    }

    public boolean isBlockIndirectlyPowered() {
        return false;
    }

    public boolean isBlockFacePowered(BlockFace face) {
        return false;
    }

    public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
        return false;
    }

    public int getBlockPower(BlockFace face) {
        return 0;
    }

    public int getBlockPower() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isLiquid() {
        return false;
    }

    public double getTemperature() {
        return 0;
    }

    public double getHumidity() {
        return 0;
    }

    public boolean breakNaturally() {
        return false;
    }
}
