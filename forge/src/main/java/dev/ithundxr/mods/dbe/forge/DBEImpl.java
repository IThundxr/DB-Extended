package dev.ithundxr.mods.dbe.forge;

import dev.ithundxr.mods.dbe.DBE;
import dev.ithundxr.mods.dbe.multiloader.Env;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.List;

@Mod(DBE.MODID)
public class DBEImpl {
    static IEventBus bus;

    public DBEImpl() {
        bus = FMLJavaModLoadingContext.get().getModEventBus();
        DBE.init();
        //noinspection Convert2MethodRef
        Env.CLIENT.runIfCurrent(() -> () -> DBEClientImpl.init());
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

        List<IModInfo> infoList = ModList.get().getModFileById(DBE.MODID).getMods();
        if (infoList.size() > 1) {
            DBE.LOGGER.error("Multiple mods for MOD_ID: " + DBE.MODID);
        }
        for (IModInfo info : infoList) {
            if (info.getModId().equals(DBE.MODID)) {
                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
                break;
            }
        }
        return versionString;
    }

    public static void finalizeRegistrate() {
        DBE.registrate().registerEventListeners(bus);
    }
}