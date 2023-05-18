package com.tellovilla.sprinklerz.entity.block;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SprinklerBlockEntity extends BlockEntity implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private int timer = 6000;
    private int timerMax = 6000;
    public SprinklerType type;

    public SprinklerBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.SPRINKLER_BLOCK_ENTITY, pos, state);
        Block block = state.getBlock();
        if(block instanceof SprinklerBase.CopperSprinkler){
            this.type = SprinklerType.COPPER;
            this.timer = type.getDelay();
            this.timerMax = type.getDelay();
        }else if(block instanceof SprinklerBase.IronSprinkler){
            this.type = SprinklerType.IRON;
            this.timer = type.getDelay();
            this.timerMax = type.getDelay();
        }else if(block instanceof SprinklerBase.GoldSprinkler){
            this.type = SprinklerType.GOLD;
            this.timer = type.getDelay();
            this.timerMax = type.getDelay();
        }else if(block instanceof SprinklerBase.NetheriteSprinkler){
            this.type = SprinklerType.NETHERITE;
            this.timer = type.getDelay();
            this.timerMax = type.getDelay();
        }

    }

    @Override
    public void writeNbt(NbtCompound nbt){
        nbt.putInt("timer", timer);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        timer = nbt.getInt("timer");
    }

    public static void tick(World world, BlockPos pos, BlockState state, SprinklerBlockEntity be) {
        if(world.isClient()){
            return;
        }
        if(be.timer > 0){
            be.timer--;
            return;
        }
        int range = be.type.getRange();
        //Get current ServerWorld
        ServerWorld currWorld = world.getServer().getWorld(world.getRegistryKey());

        for (BlockPos blockPos : BlockPos.iterate(pos.add(-range, 0, -range), pos.add(range, 0, range))) {
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            if (block instanceof Fertilizable) {
                Fertilizable growable = (Fertilizable) block;
                growable.grow(currWorld, world.getRandom(), blockPos, blockState);
                world.syncWorldEvent(2005, blockPos, 0);
            }
        }
        be.timer = be.timerMax;
    }



    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sprinkler.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<SprinklerBlockEntity>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
