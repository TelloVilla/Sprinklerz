package com.tellovilla.sprinklerz.client.renderer.item;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SprinklerBaseItemModel extends GeoModel<SprinklerBaseItem> {
    private static final Identifier modelResource = new Identifier(SprinklerzMod.MOD_ID, "geo/sprinkler_base.geo.json");
    private static final Identifier textureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/copper_sprinkler.png");
    private static final Identifier ironTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/iron_sprinkler.png");
    private static final Identifier goldTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/gold_sprinkler.png");
    private static final Identifier diamondTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/diamond_sprinkler.png");
    private static final Identifier netheriteTextureResource = new Identifier(SprinklerzMod.MOD_ID, "textures/blocks/netherite_sprinkler.png");
    private static final Identifier animationResource = new Identifier(SprinklerzMod.MOD_ID, "animations/sprinkler.animation.json");

    @Override
    public Identifier getModelResource(SprinklerBaseItem object) {
        return modelResource;
    }

    @Override
    public Identifier getTextureResource(SprinklerBaseItem item) {
        if(item.type == SprinklerType.IRON){
            return ironTextureResource;
        } else if (item.type == SprinklerType.GOLD) {
            return goldTextureResource;
        } else if (item.type == SprinklerType.DIAMOND) {
            return diamondTextureResource;
        } else if (item.type == SprinklerType.NETHERITE) {
            return netheriteTextureResource;
        }
        return textureResource;
    }

    @Override
    public Identifier getAnimationResource(SprinklerBaseItem animatable) {
        return animationResource;
    }
}
