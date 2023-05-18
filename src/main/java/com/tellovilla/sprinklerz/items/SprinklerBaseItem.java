package com.tellovilla.sprinklerz.items;

import com.tellovilla.sprinklerz.constant.SprinklerType;
import com.tellovilla.sprinklerz.client.renderer.item.SprinklerBaseItemRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.BlockItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Consumer;

public class SprinklerBaseItem extends BlockItem implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public SprinklerType type;

    public SprinklerBaseItem(Block block, Settings settings, SprinklerType type){
        super(block, settings);
        this.type = type;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sprinkler.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<SprinklerBaseItem>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer){
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            private final BuiltinModelItemRenderer renderer = new SprinklerBaseItemRenderer();
            @Override
            public BuiltinModelItemRenderer getCustomRenderer(){
                return renderer;
            }
        });
    }
}
