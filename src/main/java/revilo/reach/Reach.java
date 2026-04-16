package revilo.reach;

import static gregapi.data.CS.*;
import static revilo.reach.data.RCCS.*;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ArrayListNoNulls;
import gregapi.config.Config;
import gregapi.data.CS.ModIDs;
import revilo.reach.data.RCCS;
import revilo.reach.data.RCMD;
import revilo.reach.loaders.a.FluidLoader;
import revilo.reach.loaders.a.ItemLoader;
import revilo.reach.loaders.a.MultiTileEntityLoader;
import revilo.reach.loaders.a.RocksLoader;
import revilo.reach.loaders.a.WorldGenLoader;
import revilo.reach.loaders.b.gt.GregTechLoader;
import revilo.reach.loaders.c.LoaderRecipesAlloys;
import revilo.reach.loaders.c.LoaderRecipesGems;
import revilo.reach.loaders.c.LoaderRecipesOthers;
import revilo.reach.loaders.c.LoaderRecipesPlastics;
import revilo.reach.modpack.LoadedModsExporter;
import revilo.reach.scripts.ScriptLoader;

@Mod(
    modid = ModIds.REACH,
    version = Tags.VERSION,
    name = Reach.MODNAME,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:" + ModIDs.GAPI_POST
        + ";after:"
        + ModIDs.GC_ADV_ROCKETRY
        + ";after:"
        + ModIDs.AE
        + ";after:"
        + ModIds.AE2FC
        + ";after:"
        + ModIDs.AV
        + ";after:"
        + ModIds.BP
        + ";after:"
        + ModIDs.MO
        + ";after:"
        + ModIds.PerDim)
public class Reach extends Abstract_Mod {

    public static final Logger LOG = LogManager.getLogger("Reach");

    public static final String MODNAME = "Reach";

    @SidedProxy(clientSide = "revilo.reach.ClientProxy", serverSide = "revilo.reach.CommonProxy")
    public static Abstract_Proxy PROXY;

    @Override
    public String getModID() {
        return ModIds.REACH;
    }

    @Override
    public String getModName() {
        return MODNAME;
    }

    @Override
    public String getModNameForLog() {
        return MODNAME;
    }

    @Override
    public Abstract_Proxy getProxy() {
        return PROXY;
    }

    // Keep these
    @Mod.EventHandler
    public final void onPreLoad(FMLPreInitializationEvent aEvent) {
        onModPreInit(aEvent);
    }

    @Mod.EventHandler
    public final void onLoad(FMLInitializationEvent aEvent) {
        onModInit(aEvent);
    }

    @Mod.EventHandler
    public final void onPostLoad(FMLPostInitializationEvent aEvent) {
        onModPostInit(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStarting(FMLServerStartingEvent aEvent) {
        onModServerStarting(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStarted(FMLServerStartedEvent aEvent) {
        onModServerStarted(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStopping(FMLServerStoppingEvent aEvent) {
        onModServerStopping(aEvent);
    }

    @Mod.EventHandler
    public final void onServerStopped(FMLServerStoppedEvent aEvent) {
        onModServerStopped(aEvent);
    }

    // Only use these

    @Override
    public void onModPreInit2(FMLPreInitializationEvent aEvent) {
    	DirectoriesRC.CONFIG_REACH = new File(DirectoriesGT.CONFIG, "Reach");
    	if (!DirectoriesRC.CONFIG_REACH.exists()) DirectoriesRC.CONFIG_REACH = new File(DirectoriesGT.CONFIG, "reach");
    	
    	ConfigsRC.BIOME = new Config(DirectoriesRC.CONFIG_REACH, "Biomes.cfg");

        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(
            F,
            new FluidLoader(),
            new ItemLoader(),
            new RocksLoader(),
            new LoaderRecipesAlloys(),
            new LoaderRecipesGems(),
            new LoaderRecipesOthers(),
            new LoaderRecipesPlastics());

        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
        new MultiTileEntityRegistry("reach.multitileentity");

        MultiTileEntityBlock.getOrCreate(
            ModIds.REACH,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_cutter,
            0,
            0,
            15,
            F,
            F); // Wires
        MultiTileEntityBlock.getOrCreate(
            RCMD.RC.mID,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_wrench,
            0,
            0,
            15,
            F,
            F);
        MultiTileEntityBlock
            .getOrCreate(RCCS.ModIds.REACH, "wood", Material.wood, Block.soundTypeWood, TOOL_axe, 0, 0, 15, F, F); // Machines
    }

    @Override
    public void onModInit2(FMLInitializationEvent aEvent) {

        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(
            F,
            new GregTechLoader(),
            new ScriptLoader(),
            new MultiTileEntityLoader(),
            new WorldGenLoader());

        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }

    }

    @Override
    public void onModPostInit2(FMLPostInitializationEvent aEvent) {
        new ScriptLoader().postInit();

        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(F, new LoadedModsExporter());

        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

    @Override
    public void onModServerStarting2(FMLServerStartingEvent aEvent) {
        // Insert your ServerStarting Code here and not above
    }

    @Override
    public void onModServerStarted2(FMLServerStartedEvent aEvent) {
        // Insert your ServerStarted Code here and not above
    }

    @Override
    public void onModServerStopping2(FMLServerStoppingEvent aEvent) {
        // Insert your ServerStopping Code here and not above
    }

    @Override
    public void onModServerStopped2(FMLServerStoppedEvent aEvent) {
        // Insert your ServerStopped Code here and not above
    }

}
