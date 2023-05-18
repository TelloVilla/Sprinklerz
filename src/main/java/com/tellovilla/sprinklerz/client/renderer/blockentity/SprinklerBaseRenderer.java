package com.tellovilla.sprinklerz.client.renderer.blockentity;

import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class SprinklerBaseRenderer extends GeoBlockRenderer<SprinklerBlockEntity> {

    public SprinklerBaseRenderer(BlockEntityRendererFactory.Context renderDispatcherIn) {
        super(renderDispatcherIn, new SprinklerBaseModel());
    }
    @Override
    public RenderLayer getRenderType(SprinklerBlockEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int PackedLightIn, Identifier textureLocation){
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));

    }

}
