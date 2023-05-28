package dev.ithundxr.mods.dbe.fabric;

import com.mojang.brigadier.CommandDispatcher;
import com.railwayteam.railways.Railways;
import com.railwayteam.railways.RailwaysClient;
import com.railwayteam.railways.content.conductor.fabric.ConductorCapItemRenderer;
import com.railwayteam.railways.fabric.events.ClientEventsFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.commands.SharedSuggestionProvider;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DBEClientImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        DBEClient.init();
        ClientEventsFabric.init();
    }

    public static void registerBuiltinPack(String id, String name) {
        ModContainer mod = FabricLoader.getInstance().getModContainer(DBE.MODID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(
                DBE.asResource(id), mod, name, ResourcePackActivationType.NORMAL
        );
    }
}