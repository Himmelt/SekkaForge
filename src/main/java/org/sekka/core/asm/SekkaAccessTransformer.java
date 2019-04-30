package org.sekka.core.asm;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

import java.io.IOException;

public class SekkaAccessTransformer extends AccessTransformer {

    public SekkaAccessTransformer() throws IOException {
        super("META-INF/common_at.cfg");
    }
}
