package com.tellovilla.sprinklerz;

import com.tellovilla.sprinklerz.client.renderer.item.SprinklerBaseItemRenderer;
import com.tellovilla.sprinklerz.client.renderer.blockentity.SprinklerBaseRenderer;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import com.tellovilla.sprinklerz.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class SprinklerzModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (BlockEntityRendererFactory.Context redererDispactcherIn) -> new SprinklerBaseRenderer());
        GeoItemRenderer.registerItemRenderer(ModBlocks.COPPER_SPRINKLER_ITEM, new SprinklerBaseItemRenderer());
        GeoItemRenderer.registerItemRenderer(ModBlocks.IRON_SPRINKLER_ITEM, new SprinklerBaseItemRenderer());
        GeoItemRenderer.registerItemRenderer(ModBlocks.GOLD_SPRINKLER_ITEM, new SprinklerBaseItemRenderer());
        GeoItemRenderer.registerItemRenderer(ModBlocks.NETHERITE_SPRINKLER_ITEM, new SprinklerBaseItemRenderer());
    }
}
