package com.tellovilla.sprinklerz;

import com.google.common.base.Suppliers;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import com.tellovilla.sprinklerz.registry.ModBlocks;
import dev.architectury.registry.registries.RegistrarManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

import static com.tellovilla.sprinklerz.registry.ModBlocks.*;

public class SprinklerzMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "sprinklerz";

    public static Configuration CONFIG = new Configuration();



    public static void init() {
        initConfiguration();
        ModBlocks.init();
        ModBlockEntities.init();

    }

    protected static void initConfiguration(){
        CONFIG = Configuration.load();
    }

}
