package com.tellovilla.sprinklerz.items;

import com.tellovilla.sprinklerz.SprinklerzMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MulchItem extends Item {
    public MulchItem() {
        super(new FabricItemSettings().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient() && hand == Hand.MAIN_HAND){
            SprinklerzMod.LOGGER.info(entity);

        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if(!world.isClient){
            if(blockstate.getBlock() instanceof Fertilizable){
                Fertilizable fertilizable = (Fertilizable) blockstate.getBlock();
                if(fertilizable.canGrow(world, world.random, blockpos, blockstate)){
                    fertilizable.grow((ServerWorld) world, world.random, blockpos, blockstate);
                    world.syncWorldEvent(2005, blockpos, 0);

                }
            }


        }
        return super.useOnBlock(context);
    }
}
