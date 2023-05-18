package com.tellovilla.sprinklerz;

import com.tellovilla.sprinklerz.client.renderer.blockentity.SprinklerBaseRenderer;
import com.tellovilla.sprinklerz.registry.SprinklerzRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SprinklerzMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SprinklerzModClient {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(SprinklerzRegistry.SPRINKLER_BLOCK_ENTITY.get(), SprinklerBaseRenderer::new);
    }

}
