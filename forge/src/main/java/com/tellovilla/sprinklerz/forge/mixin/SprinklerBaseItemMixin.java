package com.tellovilla.sprinklerz.forge.mixin;

import com.tellovilla.sprinklerz.client.renderer.item.SprinklerBaseItemRenderer;
import com.tellovilla.sprinklerz.items.SprinklerBaseItem;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin(SprinklerBaseItem.class)
public class SprinklerBaseItemMixin extends Item {

    public SprinklerBaseItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer){
        consumer.accept(new IClientItemExtensions() {
            private SprinklerBaseItemRenderer renderer;

            @Override
            public BuiltinModelItemRenderer getCustomRenderer(){
                if(this.renderer == null){
                    this.renderer = new SprinklerBaseItemRenderer();
                }
                return this.renderer;

            }
        });
    }
}
