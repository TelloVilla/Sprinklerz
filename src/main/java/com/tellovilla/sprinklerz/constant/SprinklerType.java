package com.tellovilla.sprinklerz.constant;

import com.tellovilla.sprinklerz.SprinklerzMod;

public enum SprinklerType {
    COPPER(SprinklerzMod.CONFIG.getCopperRadius(),
            SprinklerzMod.CONFIG.getCopperFertDelay()),
    IRON(SprinklerzMod.CONFIG.getIronRadius(),
            SprinklerzMod.CONFIG.getIronFertDelay()),
    GOLD(SprinklerzMod.CONFIG.getGoldRadius(),
            SprinklerzMod.CONFIG.getGoldFertDelay()),
    DIAMOND(SprinklerzMod.CONFIG.getDiamondRadius(),
            SprinklerzMod.CONFIG.getDiamFertDelay()),
    NETHERITE(SprinklerzMod.CONFIG.getNetheriteRadius(),
            SprinklerzMod.CONFIG.getNethFertDelay());
    private int range;
    private int delay;
    private SprinklerType(int range, int delay){
        this.range = range;
        this.delay = delay;
    }

    public int getRange(){
        if(this.range < 1 || this.range > 5){
            return 1;
        }
        return range;
    }
    public int getDelay() {
        return delay; }
}
