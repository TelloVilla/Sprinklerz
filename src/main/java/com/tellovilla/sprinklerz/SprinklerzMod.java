package com.tellovilla.sprinklerz;

import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import com.tellovilla.sprinklerz.registry.ModBlocks;
import com.tellovilla.sprinklerz.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.tellovilla.sprinklerz.registry.ModBlocks.*;

public class SprinklerzMod implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "sprinklerz";

    public static Configuration CONFIG = new Configuration();



    @Override
    public void onInitialize() {
        initConfiguration();
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();

    }

    protected void initConfiguration(){
        CONFIG = Configuration.load();
    }

}
