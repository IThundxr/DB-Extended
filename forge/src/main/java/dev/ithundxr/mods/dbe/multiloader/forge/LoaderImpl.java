package dev.ithundxr.mods.dbe.multiloader.forge;

import dev.ithundxr.mods.dbe.multiloader.Loader;

public class LoaderImpl {
    public static Loader getCurrent() {
        return Loader.FORGE;
    }
}
