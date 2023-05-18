package com.tellovilla.sprinklerz.client.renderer.item;

import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class SprinklerBaseItemRenderer extends GeoItemRenderer<SprinklerBaseItem> {
    public SprinklerBaseItemRenderer(){
        super(new SprinklerBaseItemModel());
    }
}
