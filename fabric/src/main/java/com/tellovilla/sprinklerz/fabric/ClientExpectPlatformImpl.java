package com.tellovilla.sprinklerz.fabric;

import com.tellovilla.sprinklerz.client.renderer.blockentity.SprinklerBaseRenderer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

import java.util.function.Supplier;

public class ClientExpectPlatformImpl {
    public static void registerRenderers(Supplier<BlockEntityType> blockEntity){
        BlockEntityRendererFactories.register(blockEntity.get(), (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new SprinklerBaseRenderer());
    }




}
