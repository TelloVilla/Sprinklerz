package com.tellovilla.sprinklerz.fabric;

import com.tellovilla.sprinklerz.SprinklerzMod;
import net.fabricmc.api.ModInitializer;

public class SprinklerzModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SprinklerzMod.init();
    }
}
