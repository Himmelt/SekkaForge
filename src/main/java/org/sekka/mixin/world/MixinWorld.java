package org.sekka.mixin.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldInfo;
import org.sekka.api.block.BlockType;
import org.sekka.api.util.Location;
import org.sekka.api.world.Chunk;
import org.sekka.api.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(net.minecraft.world.World.class)
public abstract class MixinWorld implements World {

    @Shadow
    protected WorldInfo worldInfo;

    @Shadow
    public abstract net.minecraft.world.chunk.Chunk getChunk(int chunkX, int chunkZ);

    @Shadow
    public abstract IBlockState getBlockState(BlockPos pos);

    private int dimension;
    private UUID uniqueId;

    public UUID getUUID() {
        return uniqueId;
    }

    public String getName() {
        return worldInfo.getWorldName();
    }

    public Chunk getChunkAt(Location loc) {
        return (Chunk) this.getChunk(loc.getBlockX() >> 4, loc.getBlockZ() >> 4);
    }

    public Chunk getChunkAt(int x, int z) {
        return (Chunk) this.getChunk(x >> 4, z >> 4);
    }

    public BlockType getBlockAt(Location loc) {
        return (BlockType) getBlockState(new BlockPos(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ())).getBlock();
    }

    public int getDimension() {
        return dimension;
    }
}
