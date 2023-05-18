package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.tellovilla.sprinklerz.registry.ModBlocks.*;
import static com.tellovilla.sprinklerz.registry.ModBlocks.NETHERITE_SPRINKLER;

public class ModBlockEntities {

    public static BlockEntityType<SprinklerBlockEntity> SPRINKLER_BLOCK_ENTITY;


    public static void registerBlockEntities(){
        SPRINKLER_BLOCK_ENTITY = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier(SprinklerzMod.MOD_ID, "sprinkler_block_entity"),
                FabricBlockEntityTypeBuilder.create(SprinklerBlockEntity::new, COPPER_SPRINKLER, IRON_SPRINKLER, GOLD_SPRINKLER, DIAMOND_SPRINKLER, NETHERITE_SPRINKLER).build()
        );
    }

}
