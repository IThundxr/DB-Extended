package dev.ithundxr.mods.dbe;

import dev.ithundxr.mods.dbe.registry.*;

public class ModSetup {
    public static void register() {
        DBETrackMaterials.register();
        DBEItems.register();
        DBEBlockEntities.register();
        DBEBlocks.register();
        DBEContainerTypes.register();
        DBEEntities.register();
        DBESounds.register();
        DBETags.register();
        DBEEdgePointTypes.register();
        DBESchedule.register();
    }
}
