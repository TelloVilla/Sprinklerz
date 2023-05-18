package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface SprinklerzRegistry {

    ItemGroup ITEM_GROUP = new ItemGroup(SprinklerzMod.MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public @NotNull ItemStack createIcon() {
            return new ItemStack(COPPER_SPRINKLER_ITEM.get());
        }
    };
    DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SprinklerzMod.MOD_ID);
    DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SprinklerzMod.MOD_ID);

    DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SprinklerzMod.MOD_ID);

    List<DeferredRegister<?>> REGISTERS = List.of(
            BLOCK_REGISTRY,
            ITEM_REGISTRY,
            BLOCK_ENTITY_REGISTRY
    );

    //Blocks
    RegistryObject<Block> COPPER_SPRINKLER = BLOCK_REGISTRY.register("copper_sprinkler", SprinklerBase.CopperSprinkler::new);
    RegistryObject<Block> IRON_SPRINKLER = BLOCK_REGISTRY.register("iron_sprinkler", SprinklerBase.IronSprinkler::new);
    RegistryObject<Block> GOLD_SPRINKLER = BLOCK_REGISTRY.register("gold_sprinkler", SprinklerBase.GoldSprinkler::new);
    RegistryObject<Block> NETHERITE_SPRINKLER = BLOCK_REGISTRY.register("netherite_sprinkler", SprinklerBase.NetheriteSprinkler::new);

    //Block Items
    RegistryObject<Item> COPPER_SPRINKLER_ITEM = ITEM_REGISTRY.register("copper_sprinkler", ()-> new SprinklerBaseItem(COPPER_SPRINKLER.get(), new Item.Settings().group(ITEM_GROUP), SprinklerType.COPPER));
    RegistryObject<Item> IRON_SPRINKLER_ITEM = ITEM_REGISTRY.register("iron_sprinkler", ()-> new SprinklerBaseItem(IRON_SPRINKLER.get(), new Item.Settings().group(ITEM_GROUP), SprinklerType.IRON));
    RegistryObject<Item> GOLD_SPRINKLER_ITEM = ITEM_REGISTRY.register("gold_sprinkler", ()-> new SprinklerBaseItem(GOLD_SPRINKLER.get(), new Item.Settings().group(ITEM_GROUP), SprinklerType.GOLD));
    RegistryObject<Item> NETHERITE_SPRINKLER_ITEM = ITEM_REGISTRY.register("netherite_sprinkler", ()-> new SprinklerBaseItem(NETHERITE_SPRINKLER.get(), new Item.Settings().group(ITEM_GROUP), SprinklerType.NETHERITE));

    //Block Entity Types
    RegistryObject<BlockEntityType<SprinklerBlockEntity>> SPRINKLER_BLOCK_ENTITY = BLOCK_ENTITY_REGISTRY.register("sprinkler_block_entity", ()-> BlockEntityType.Builder.create(SprinklerBlockEntity::new, COPPER_SPRINKLER.get(), IRON_SPRINKLER.get(), GOLD_SPRINKLER.get(), NETHERITE_SPRINKLER.get()).build(null));




}
