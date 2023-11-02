package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(SprinklerzMod.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> CREATIVE_TAB = TABS.register(SprinklerzMod.MOD_ID,
            ()-> CreativeTabRegistry.create(Text.translatable("category.sprinklerz"), ()-> new ItemStack(ModBlocks.COPPER_SPRINKLER_ITEM.get())));

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SprinklerzMod.MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SprinklerzMod.MOD_ID, RegistryKeys.ITEM);


    public static final RegistrySupplier<Block> COPPER_SPRINKLER = BLOCKS.register("copper_sprinkler", ()-> new SprinklerBase.CopperSprinkler());
    public static final RegistrySupplier<Block> IRON_SPRINKLER = BLOCKS.register("iron_sprinkler", ()-> new SprinklerBase.IronSprinkler());
    public static final RegistrySupplier<Block> GOLD_SPRINKLER = BLOCKS.register("gold_sprinkler", ()-> new SprinklerBase.GoldSprinkler());
    public static final RegistrySupplier<Block> DIAMOND_SPRINKLER = BLOCKS.register("diamond_sprinkler", ()-> new SprinklerBase.DiamondSprinkler());
    public static final RegistrySupplier<Block> NETHERITE_SPRINKLER = BLOCKS.register("netherite_sprinkler", ()-> new SprinklerBase.NetheriteSprinkler());


    public static final RegistrySupplier<Item> COPPER_SPRINKLER_ITEM = ITEMS.register("copper_sprinkler", ()-> new SprinklerBaseItem( COPPER_SPRINKLER.get(), new Item.Settings().arch$tab(CREATIVE_TAB), SprinklerType.COPPER));
    public static final RegistrySupplier<Item> IRON_SPRINKLER_ITEM = ITEMS.register("iron_sprinkler", ()-> new SprinklerBaseItem( IRON_SPRINKLER.get(), new Item.Settings().arch$tab(CREATIVE_TAB), SprinklerType.IRON));
    public static final RegistrySupplier<Item> GOLD_SPRINKLER_ITEM = ITEMS.register("gold_sprinkler", ()-> new SprinklerBaseItem( GOLD_SPRINKLER.get(), new Item.Settings().arch$tab(CREATIVE_TAB), SprinklerType.GOLD));
    public static final RegistrySupplier<Item> DIAMOND_SPRINKLER_ITEM = ITEMS.register("diamond_sprinkler", ()-> new SprinklerBaseItem( DIAMOND_SPRINKLER.get(), new Item.Settings().arch$tab(CREATIVE_TAB), SprinklerType.DIAMOND));
    public static final RegistrySupplier<Item> NETHERITE_SPRINKLER_ITEM = ITEMS.register("netherite_sprinkler", ()-> new SprinklerBaseItem( NETHERITE_SPRINKLER.get(), new Item.Settings().arch$tab(CREATIVE_TAB), SprinklerType.NETHERITE));


    public static void init(){
        BLOCKS.register();
        TABS.register();
        ITEMS.register();


    }
}
