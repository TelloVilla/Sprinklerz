package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks {


    public static final SprinklerBase.CopperSprinkler COPPER_SPRINKLER = new SprinklerBase.CopperSprinkler();
    public static final SprinklerBase.IronSprinkler IRON_SPRINKLER = new SprinklerBase.IronSprinkler();
    public static final SprinklerBase.GoldSprinkler GOLD_SPRINKLER = new SprinklerBase.GoldSprinkler();
    public static final SprinklerBase.DiamondSprinkler DIAMOND_SPRINKLER = new SprinklerBase.DiamondSprinkler();
    public static final SprinklerBase.NetheriteSprinkler NETHERITE_SPRINKLER = new SprinklerBase.NetheriteSprinkler();

    public static final SprinklerBaseItem COPPER_SPRINKLER_ITEM = new SprinklerBaseItem(COPPER_SPRINKLER, new FabricItemSettings().group(SprinklerzMod.ITEM_GROUP), SprinklerType.COPPER);
    public static final SprinklerBaseItem IRON_SPRINKLER_ITEM = new SprinklerBaseItem(IRON_SPRINKLER, new FabricItemSettings().group(SprinklerzMod.ITEM_GROUP), SprinklerType.IRON);
    public static final SprinklerBaseItem GOLD_SPRINKLER_ITEM = new SprinklerBaseItem(GOLD_SPRINKLER, new FabricItemSettings().group(SprinklerzMod.ITEM_GROUP), SprinklerType.GOLD);
    public static final SprinklerBaseItem DIAMOND_SPRINKLER_ITEM = new SprinklerBaseItem(DIAMOND_SPRINKLER, new FabricItemSettings().group(SprinklerzMod.ITEM_GROUP), SprinklerType.DIAMOND);
    public static final SprinklerBaseItem NETHERITE_SPRINKLER_ITEM = new SprinklerBaseItem(NETHERITE_SPRINKLER, new FabricItemSettings().group(SprinklerzMod.ITEM_GROUP), SprinklerType.NETHERITE);

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(SprinklerzMod.MOD_ID, "copper_sprinkler"), COPPER_SPRINKLER);
        Registry.register(Registry.BLOCK, new Identifier(SprinklerzMod.MOD_ID, "iron_sprinkler"), IRON_SPRINKLER);
        Registry.register(Registry.BLOCK, new Identifier(SprinklerzMod.MOD_ID, "gold_sprinkler"), GOLD_SPRINKLER);
        Registry.register(Registry.BLOCK, new Identifier(SprinklerzMod.MOD_ID, "diamond_sprinkler"), DIAMOND_SPRINKLER);
        Registry.register(Registry.BLOCK, new Identifier(SprinklerzMod.MOD_ID, "netherite_sprinkler"), NETHERITE_SPRINKLER);
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "copper_sprinkler"), COPPER_SPRINKLER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "iron_sprinkler"), IRON_SPRINKLER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "gold_sprinkler"), GOLD_SPRINKLER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "diamond_sprinkler"), DIAMOND_SPRINKLER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "netherite_sprinkler"), NETHERITE_SPRINKLER_ITEM);
    }
}
