package com.tellovilla.sprinklerz.mixin;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {
    @Inject(method = "isWaterNearby", at=@At("HEAD"), cancellable = true)
    private static void isWaterNearby(WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        for(BlockPos blockPos : BlockPos.iterate(pos.add(-SprinklerzMod.CONFIG.maxRadius(), 1, -SprinklerzMod.CONFIG.maxRadius()), pos.add(SprinklerzMod.CONFIG.maxRadius(), SprinklerzMod.CONFIG.getCeilingRange(), SprinklerzMod.CONFIG.maxRadius()))){
            BlockState state = world.getBlockState(blockPos);
            Block block = state.getBlock();
            if(block instanceof SprinklerBase){
                if(state.get(Properties.LIT)){
                    if(block instanceof SprinklerBase.CopperSprinkler && pos.isWithinDistance(blockPos, SprinklerType.COPPER.getRange() + 1)){
                        cir.setReturnValue(true);
                        cir.cancel();
                    }
                    else if(block instanceof SprinklerBase.IronSprinkler && pos.isWithinDistance(blockPos, SprinklerType.IRON.getRange() + 1)){
                        cir.setReturnValue(true);
                        cir.cancel();
                    }
                    else if(block instanceof SprinklerBase.GoldSprinkler && pos.isWithinDistance(blockPos, SprinklerType.GOLD.getRange() + 1)){
                        cir.setReturnValue(true);
                        cir.cancel();
                    }
                    else if(block instanceof SprinklerBase.DiamondSprinkler && pos.isWithinDistance(blockPos, SprinklerType.DIAMOND.getRange() + 1)){
                        cir.setReturnValue(true);
                        cir.cancel();
                    }
                    else if(block instanceof SprinklerBase.NetheriteSprinkler && pos.isWithinDistance(blockPos, SprinklerType.NETHERITE.getRange() + 1)){
                        cir.setReturnValue(true);
                        cir.cancel();
                    }

                }
            }
        }

    }
}
