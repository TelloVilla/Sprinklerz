package com.tellovilla.sprinklerz.forge;

import com.tellovilla.sprinklerz.SprinklerzMod;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SprinklerzMod.MOD_ID)
public class SprinklerzModForge {
    public SprinklerzModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SprinklerzMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SprinklerzMod.init();
    }
}
