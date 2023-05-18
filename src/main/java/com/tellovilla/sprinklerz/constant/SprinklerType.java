package com.tellovilla.sprinklerz.constant;

import com.tellovilla.sprinklerz.SprinklerzMod;

public enum SprinklerType {
    COPPER(1, SprinklerzMod.CONFIG.getCopperFertDelay()),
    IRON(2, SprinklerzMod.CONFIG.getIronFertDelay()),
    GOLD(3, SprinklerzMod.CONFIG.getGoldFertDelay()),
    DIAMOND(3, SprinklerzMod.CONFIG.getDiamFertDelay()),
    NETHERITE(3, SprinklerzMod.CONFIG.getNethFertDelay());
    private int range;
    private int delay;
    private SprinklerType(int range, int delay){
        this.range = range;
        this.delay = delay;
    }

    public int getRange(){
        return range;
    }
    public int getDelay() {return delay; }
}
