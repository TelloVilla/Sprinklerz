package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;


public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(SprinklerzMod.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType> SPRINKLER_BLOCK_ENTITY = BLOCK_ENTITIES.register("sprinkler_block_entity", ()-> BlockEntityType.Builder.create(SprinklerBlockEntity::new, ModBlocks.COPPER_SPRINKLER.get(), ModBlocks.IRON_SPRINKLER.get(), ModBlocks.GOLD_SPRINKLER.get(), ModBlocks.DIAMOND_SPRINKLER.get(), ModBlocks.NETHERITE_SPRINKLER.get()).build(null));


    public static void init(){
        BLOCK_ENTITIES.register();
    }

}
