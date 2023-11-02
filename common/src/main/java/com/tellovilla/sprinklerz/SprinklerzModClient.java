package com.tellovilla.sprinklerz;

import com.tellovilla.sprinklerz.registry.ModBlockEntities;


public class SprinklerzModClient {

    public static void init() {
        ClientExpectPlatform.registerRenderers(ModBlockEntities.SPRINKLER_BLOCK_ENTITY);
    }
}
