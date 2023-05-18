package com.tellovilla.sprinklerz.client.renderer.blockentity;

import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class SprinklerBaseRenderer extends GeoBlockRenderer<SprinklerBlockEntity> {
    public SprinklerBaseRenderer(){
        super(new SprinklerBaseModel());
    }
}
