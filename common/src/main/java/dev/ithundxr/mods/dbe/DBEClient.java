package dev.ithundxr.mods.dbe;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class DBEClient {

    public static void init() {
        // TODO
        //CRBlockPartials.init();
    }


    @ExpectPlatform
    public static void registerBuiltinPack(String id, String name) {
        throw new AssertionError();
    }
}
