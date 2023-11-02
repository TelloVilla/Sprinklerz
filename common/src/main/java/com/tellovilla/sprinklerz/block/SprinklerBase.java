package com.tellovilla.sprinklerz.block;

import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.entity.block.SprinklerBlockEntity;
import com.tellovilla.sprinklerz.registry.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;


public class SprinklerBase extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.FACING;


    private SprinklerType type;

    //TODO: Find a better way to track an active redstone signal
    public static final BooleanProperty LIT = Properties.LIT;

    public SprinklerBase(SprinklerType type){
        super(AbstractBlock.Settings.copy(Blocks.BLACKSTONE).ticksRandomly().sounds(BlockSoundGroup.COPPER));
        this.type = type;
        this.setDefaultState((BlockState) this.getDefaultState().with(LIT, true).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(LIT, FACING);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify){
        if(!world.isClient){
            boolean active = state.get(LIT);
            if(world.isReceivingRedstonePower(pos) && active){
                world.setBlockState(pos, state.cycle(LIT), 2);
            }else if(!world.isReceivingRedstonePower(pos) && !active ){
                world.setBlockState(pos, state.cycle(LIT), 2);
            }
        }
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx){
        Direction direction;
        World world = ctx.getWorld();
        if (ctx.getVerticalPlayerLookDirection() == Direction.UP && !world.getBlockState(ctx.getBlockPos().up()).isAir()){
            direction = Direction.SOUTH;
        }else{
            direction = Direction.NORTH;
        }
        return this.getDefaultState().with(LIT, !(ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()))).with(FACING, direction);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState block, BlockView view, BlockPos pos, ShapeContext context){
        if(block.get(FACING) == Direction.SOUTH){
            return VoxelShapes.cuboid(0.25f, 0.6f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
        return VoxelShapes.cuboid(0.25f, 0f, 0.25f, 0.75f, 0.4f, 0.75f);

    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        return ActionResult.PASS;

    }
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random){
        double radius = 0.25 * type.getRange();
        double yPos = 0.10d;
        int spirals = 4;

        if (state.get(FACING) == Direction.SOUTH){
            yPos *= -1.0d;
        }
        if(state.get(LIT) && random.nextFloat() < 0.1f){
            //world.addParticle(ParticleTypes.FISHING, pos.getX() + 0.5d, pos.getY() + 0.6d, pos.getZ() + 0.5d, 0, 0.1d, 0);
            for(int j = 0; j < spirals; j++){
                for(double i = 0d; i < 8d; i += 1d){
                    double x = Math.cos((j + 2 * Math.PI * i) / 8) * (radius + (0.1d * j));
                    double z = Math.sin((j + 2 * Math.PI * i) / 8) * (radius + (0.1d * j));
                    world.addParticle(ParticleTypes.FISHING, pos.getX() + 0.5d + x, pos.getY() + 0.75d + (yPos * j), pos.getZ() + 0.5d + z, x * 0.1d, -0.05d, z * 0.1d);
                }
            }


        }

    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos){
        if(world.getBlockState(pos.up()).isAir() && world.getBlockState(pos.down()).isAir()){
            return false;
        }
        return true;
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
            if(state.get(FACING) == Direction.SOUTH){
                return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.upsideDownTick(world1, pos, state1, (SprinklerBlockEntity) be));
            }
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, (SprinklerBlockEntity) be));
        }
    }
    public static class IronSprinkler extends SprinklerBase{
        public IronSprinkler(){
            super(SprinklerType.IRON);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            if(state.get(FACING) == Direction.SOUTH){
                return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.upsideDownTick(world1, pos, state1, (SprinklerBlockEntity) be));
            }
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, (SprinklerBlockEntity) be));
        }
    }
    public static class GoldSprinkler extends SprinklerBase{
        public GoldSprinkler(){
            super(SprinklerType.GOLD);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            if(state.get(FACING) == Direction.SOUTH){
                return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.upsideDownTick(world1, pos, state1, (SprinklerBlockEntity) be));
            }
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, (SprinklerBlockEntity) be));
        }
    }
    public static class DiamondSprinkler extends SprinklerBase{
        public DiamondSprinkler(){
            super(SprinklerType.DIAMOND);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            if(state.get(FACING) == Direction.SOUTH){
                return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.upsideDownTick(world1, pos, state1, (SprinklerBlockEntity) be));
            }
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, (SprinklerBlockEntity) be));
        }
    }
    public static class NetheriteSprinkler extends SprinklerBase{
        public NetheriteSprinkler(){
            super(SprinklerType.NETHERITE);
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type){
            if(state.get(FACING) == Direction.SOUTH){
                return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.upsideDownTick(world1, pos, state1, (SprinklerBlockEntity) be));
            }
            return checkType(type, ModBlockEntities.SPRINKLER_BLOCK_ENTITY.get(), (world1, pos, state1, be) -> SprinklerBlockEntity.tick(world1, pos, state1, (SprinklerBlockEntity) be));
        }
    }
}

