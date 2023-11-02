package com.tellovilla.sprinklerz.forge;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.client.renderer.blockentity.SprinklerBaseRenderer;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SprinklerzMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SprinklerzModForgeClient {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new SprinklerBaseRenderer());
    }



}
