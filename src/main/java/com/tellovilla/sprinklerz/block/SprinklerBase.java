package com.tellovilla.sprinklerz.block;

import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public class SprinklerBase extends BlockWithEntity implements BlockEntityProvider {

    private SprinklerType type;
    public SprinklerBase(SprinklerType type){
        super(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).ticksRandomly().sounds(BlockSoundGroup.COPPER));
        this.type = type;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState block, BlockView view, BlockPos pos, ShapeContext context){
        return VoxelShapes.cuboid(0.25f, 0f, 0.25f, 0.75f, 0.4f, 0.75f);

    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        return ActionResult.PASS;

    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        double radius = 0.35 * type.getRange();
        int spirals = 4;
        if(random.nextFloat() < 0.1f){
            //world.addParticle(ParticleTypes.FISHING, pos.getX() + 0.5d, pos.getY() + 0.6d, pos.getZ() + 0.5d, 0, 0.1d, 0);
            for(int j = 0; j < spirals; j++){
                for(double i = 0d; i < 8d; i += 1d){
                    double x = Math.cos((j + 2 * Math.PI * i) / 8) * (radius + (0.1d * j));
                    double z = Math.sin((j + 2 * Math.PI * i) / 8) * (radius + (0.1d * j));
                    world.addParticle(ParticleTypes.FISHING, pos.getX() + 0.5d + x, pos.getY() + 0.75d + (0.10d * j), pos.getZ() + 0.5d + z, x * 0.1d, -0.05d, z * 0.1d);
                }
            }


        }

    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SprinklerBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state){
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }



    public static class CopperSprinkler extends SprinklerBase{
        public CopperSprinkler(){
            super(SprinklerType.COPPER);
        }

        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, be));
        }
    }
    public static class IronSprinkler extends SprinklerBase{
        public IronSprinkler(){
            super(SprinklerType.IRON);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, be));
        }
    }
    public static class GoldSprinkler extends SprinklerBase{
        public GoldSprinkler(){
            super(SprinklerType.GOLD);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, be));
        }
    }
    public static class DiamondSprinkler extends SprinklerBase{
        public DiamondSprinkler(){
            super(SprinklerType.DIAMOND);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, be));
        }
    }
    public static class NetheriteSprinkler extends SprinklerBase{
        public NetheriteSprinkler(){
            super(SprinklerType.NETHERITE);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY, (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, be));
        }
    }
}

