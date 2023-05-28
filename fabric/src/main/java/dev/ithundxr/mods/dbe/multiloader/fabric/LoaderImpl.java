package dev.ithundxr.mods.dbe.multiloader.fabric;

import dev.ithundxr.mods.dbe.multiloader.Loader;

public class LoaderImpl {
    public static Loader getCurrent() {
        return Loader.FABRIC;
    }
}