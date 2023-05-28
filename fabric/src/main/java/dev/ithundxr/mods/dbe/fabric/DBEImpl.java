package dev.ithundxr.mods.dbe.fabric;

import com.mojang.brigadier.CommandDispatcher;
import dev.ithundxr.mods.dbe.DBE;
import com.railwayteam.railways.fabric.events.CommonEventsFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.util.TriConsumer;

public class DBEImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        DBE.init();
        CommonEventsFabric.init();
    }

    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(DBE.MODID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }

    public static void finalizeRegistrate() {
        DBE.registrate().register();
    }
}
