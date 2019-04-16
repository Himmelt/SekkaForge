package org.sekka.mixin.block;

import net.minecraft.block.Block;
import org.sekka.api.block.BlockType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Block.class)
public abstract class MixinBlock implements BlockType {
}
