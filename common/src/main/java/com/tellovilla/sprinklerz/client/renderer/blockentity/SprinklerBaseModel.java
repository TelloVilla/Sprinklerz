package com.tellovilla.sprinklerz.client.renderer.blockentity;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import software.bernie.geckolib.model.GeoModel;


public class SprinklerBaseModel extends GeoModel<SprinklerBlockEntity> {
    private static final Identifier modelResource = new Identifier(SprinklerzMod.MOD_ID, "geo/sprinkler_base.geo.json");
    private static final Identifier modelUpsideDownResource = new Identifier(SprinklerzMod.MOD_ID, "geo/sprinkler_upsidedown.geo.json");
    private static final Identifier textureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/copper_sprinkler.png");
    private static final Identifier ironTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/iron_sprinkler.png");
    private static final Identifier goldTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/gold_sprinkler.png");
    private static final Identifier diamondTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/diamond_sprinkler.png");

    private static final Identifier netheriteTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/netherite_sprinkler.png");
    private static final Identifier animationResource = new Identifier(SprinklerzMod.MOD_ID, "animations/sprinkler.animation.json");


    @Override
    public Identifier getModelResource(SprinklerBlockEntity object) {
        if (object.getCachedState().get(Properties.FACING) == Direction.SOUTH){
            return modelUpsideDownResource;
        }
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(SprinklerBlockEntity be) {
        if(be.type == SprinklerType.IRON){
            return ironTextureResource;
        } else if (be.type == SprinklerType.GOLD) {
            return goldTextureResource;
        } else if (be.type == SprinklerType.DIAMOND) {
            return diamondTextureResource;
        } else if (be.type == SprinklerType.NETHERITE) {
            return netheriteTextureResource;
        }
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(SprinklerBlockEntity animatable) {
        return animationResource;

    }
}
