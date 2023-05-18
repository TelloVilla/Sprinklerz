package com.tellovilla.sprinklerz.items;

import com.tellovilla.sprinklerz.constant.SprinklerType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SprinklerBaseItem extends BlockItem implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public SprinklerType type;

    public SprinklerBaseItem(Block block, Settings settings, SprinklerType type){
        super(block, settings);
        this.type = type;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
//        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sprinkler.idle", ILoopType.EDefaultLoopTypes.LOOP));
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
}
