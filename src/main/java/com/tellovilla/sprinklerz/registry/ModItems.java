package com.tellovilla.sprinklerz.registry;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.items.MulchItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final MulchItem MULCH = new MulchItem();

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(SprinklerzMod.MOD_ID, "mulch"), MULCH);
    }
}
