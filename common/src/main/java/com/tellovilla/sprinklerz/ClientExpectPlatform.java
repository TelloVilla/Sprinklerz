package com.tellovilla.sprinklerz;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ClientExpectPlatform {
    @ExpectPlatform
    public static void registerRenderers(Supplier<BlockEntityType> blockEntity){
        throw new AssertionError();
    }

}
