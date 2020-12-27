package org.sekka.api.world;

public interface Chunk {
    World getWorld();

    byte getMetaAt(int x, int y, int z);

    void setMetaAt(byte data, int x, int y, int z);
}
