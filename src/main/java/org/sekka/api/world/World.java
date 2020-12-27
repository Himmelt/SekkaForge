package org.sekka.api.world;

import org.sekka.api.block.BlockType;
import org.sekka.api.util.Location;

import java.util.UUID;

public interface World {

    UUID getUUID();

    String getName();

    Chunk getChunkAt(Location loc);

    Chunk getChunkAt(int x, int z);

    BlockType getBlockAt(Location loc);

    int getDimension();
}
