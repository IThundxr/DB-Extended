package dev.ithundxr.mods.dbe.compat;

import dev.ithundxr.mods.dbe.util.Utils;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * For compatibility with and without another mod present, we have to define load conditions of the specific code
 */
public enum Mods {
    // This isn't actually used yet, but it's good to have it here
    // It's called example mod because this file isn't used atm
    EXAMPLE("example-mod");

    public final boolean isLoaded;
    public final @Nullable String fabricId;

    Mods() {
        this(null);
    }

    Mods(@Nullable String fabricId) {
        this.fabricId = fabricId;
        this.isLoaded = Utils.isModLoaded(name(), fabricId);
    }

    /**
     * Simple hook to run code if a mod is installed
     * @param toRun will be run only if the mod is loaded
     * @return Optional.empty() if the mod is not loaded, otherwise an Optional of the return value of the given supplier
     */
    public <T> Optional<T> runIfInstalled(Supplier<Supplier<T>> toRun) {
        if (isLoaded)
            return Optional.of(toRun.get().get());
        return Optional.empty();
    }

    /**
     * Simple hook to execute code if a mod is installed
     * @param toExecute will be executed only if the mod is loaded
     */
    public void executeIfInstalled(Supplier<Runnable> toExecute) {
        if (isLoaded) {
            toExecute.get().run();
        }
    }
}
