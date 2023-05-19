package com.tellovilla.sprinklerz.mixin;

import com.tellovilla.sprinklerz.block.SprinklerBase;
import net.minecraft.block.FarmlandBlock;
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
        for(BlockPos blockPos : BlockPos.iterate(pos.add(-4, 1, -4), pos.add(4, 1, 4))){
            if(world.getBlockState(blockPos).getBlock() instanceof SprinklerBase){
                cir.setReturnValue(true);
                cir.cancel();
            }
        }

    }
}
