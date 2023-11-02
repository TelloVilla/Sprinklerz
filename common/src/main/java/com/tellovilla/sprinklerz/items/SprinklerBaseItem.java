package com.tellovilla.sprinklerz.items;

import com.tellovilla.sprinklerz.client.renderer.item.SprinklerBaseItemRenderer;
import com.tellovilla.sprinklerz.constant.SprinklerType;
import dev.architectury.injectables.annotations.PlatformOnly;
import dev.architectury.platform.Platform;
import net.minecraft.block.Block;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.BlockItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class SprinklerBaseItem extends BlockItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = Platform.isFabric() ? GeoItem.makeRenderer(this): null;
    public SprinklerType type;

    public SprinklerBaseItem(Block block, Settings settings, SprinklerType type){
        super(block, settings);
        this.type = type;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 0, state -> PlayState.STOP)

        );

    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @PlatformOnly("fabric")
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private SprinklerBaseItemRenderer renderer;
            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                if(this.renderer == null){
                    this.renderer = new SprinklerBaseItemRenderer();
                }
                return this.renderer;
            }
        });


    }

    @PlatformOnly("fabric")
    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }


}
