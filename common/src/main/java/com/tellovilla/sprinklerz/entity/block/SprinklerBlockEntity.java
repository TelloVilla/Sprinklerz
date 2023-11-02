package com.tellovilla.sprinklerz.entity.block;

import com.tellovilla.sprinklerz.SprinklerzMod;
import com.tellovilla.sprinklerz.block.SprinklerBase;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SprinklerBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation ROTATE = RawAnimation.begin().thenLoop("animation.sprinkler.idle");
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.sprinkler.idle");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int timer = 6000;
    private int timerMax = 6000;
    public SprinklerType type;

    public SprinklerBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), pos, state);
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
        }else if(block instanceof SprinklerBase.DiamondSprinkler){
            this.type = SprinklerType.DIAMOND;
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
        if(world.isClient() || !SprinklerzMod.CONFIG.getBoneMealEffect() || be.timerMax == 0 || !state.get(Properties.LIT)){
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
            if (block instanceof Fertilizable && pos.isWithinDistance(blockPos, (be.type.getRange() + 1))) {
                Fertilizable growable = (Fertilizable) block;
                growable.grow(currWorld, world.getRandom(), blockPos, blockState);
                world.syncWorldEvent(2005, blockPos, 0);
            }
        }
        be.timer = be.timerMax;
    }

    public static void upsideDownTick(World world, BlockPos pos, BlockState state, SprinklerBlockEntity be) {
        if(world.isClient() || !SprinklerzMod.CONFIG.getBoneMealEffect() || be.timerMax == 0 || !state.get(Properties.LIT)){
            return;
        }
        if(be.timer > 0){
            be.timer--;
            return;
        }
        int range = be.type.getRange();
        //Get current ServerWorld
        ServerWorld currWorld = world.getServer().getWorld(world.getRegistryKey());

        BlockPos belowPos = pos;
        BlockState belowState = state;

        int ceilingRange = SprinklerzMod.CONFIG.getCeilingRange();

        for(int i = 0; i < ceilingRange; i++){
            belowPos = belowPos.down();
            belowState = world.getBlockState(belowPos);
            if(!belowState.isAir())
                break;
        }

        if(belowState.isAir()){
            return;
        }


        for (BlockPos blockPos : BlockPos.iterate(belowPos.add(-range, 0, -range), belowPos.add(range, 0, range))) {
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            if (block instanceof Fertilizable && pos.isWithinDistance(blockPos, (be.type.getRange() + 1))) {
                Fertilizable growable = (Fertilizable) block;
                growable.grow(currWorld, world.getRandom(), blockPos, blockState);
                world.syncWorldEvent(2005, blockPos, 0);
            }
        }
        be.timer = be.timerMax;
    }

    protected <E extends SprinklerBlockEntity>PlayState idleAnimatController(final AnimationState<E> state){
        if(!this.getCachedState().get(Properties.LIT)){
            return PlayState.STOP;
        }
        return state.setAndContinue(ROTATE);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, this::idleAnimatController));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
