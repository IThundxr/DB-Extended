package dev.ithundxr.mods.dbe;

import com.mojang.brigadier.CommandDispatcher;
import com.railwayteam.railways.base.data.CRTagGen;
import com.railwayteam.railways.base.data.lang.CRLangPartials;
import com.railwayteam.railways.base.data.recipe.RailwaysSequencedAssemblyRecipeGen;
import com.railwayteam.railways.base.data.recipe.RailwaysStandardRecipeGen;
import com.railwayteam.railways.registry.CRBlocks;
import com.railwayteam.railways.registry.CRCommands;
import com.railwayteam.railways.registry.CRItems;
import com.railwayteam.railways.registry.CRPackets;
import com.railwayteam.railways.track_api.TrackMaterial;
import com.railwayteam.railways.util.RegistrationListening;
import com.railwayteam.railways.util.Utils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.LangMerger;
import com.simibubi.create.foundation.ponder.PonderLocalization;
import com.tterrag.registrate.providers.ProviderType;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.ithundxr.mods.dbe.base.data.DBETagGen;
import dev.ithundxr.mods.dbe.base.data.recipe.DBEStandardRecipeGen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public class DBE {
    public static final String MODID = "dbe";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final String VERSION = findVersion();

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .creativeModeTab(() -> CRItems.itemGroup, "Dave's Building Extended");

    public static void init() {
        ModSetup.register();
        finalizeRegistrate();

        if (Utils.isDevEnv()) // force all mixins to load in dev
            MixinEnvironment.getCurrentEnvironment().audit();
    }

    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(MODID, name);
    }

    public static void gatherData(DataGenerator gen) {
        REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, DBETagGen::generateBlockTags);
        REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, DBETagGen::generateItemTags);
        gen.addProvider(true, DBEStandardRecipeGen.create(gen));
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    @ExpectPlatform
    public static String findVersion() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void finalizeRegistrate() {
        throw new AssertionError();
    }
}
