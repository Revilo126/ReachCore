package revilo.reach;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.myname.mymodid.Tags;

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

@Mod(
    modid = Reach.MODID,
    version = Tags.VERSION,
    name = Reach.MODNAME,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:gregapi_post")
public class Reach extends Abstract_Mod {

    public static final String MODID = "reach";
    public static final String MODNAME = "Reach";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "revilo.reach.ClientProxy", serverSide = "revilo.reach.CommonProxy")
    public static Abstract_Proxy PROXY;

    @Override
    public String getModID() {
        return MODID;
    }

    @Override
    public String getModName() {
        return MODNAME;
    }

    @Override
    public String getModNameForLog() {
        return "Example_Mod";
    }

    @Override
    public gregapi.api.Abstract_Proxy getProxy() {
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
    public void onModPreInit2(cpw.mods.fml.common.event.FMLPreInitializationEvent aEvent) {}

    @Override
    public void onModInit2(cpw.mods.fml.common.event.FMLInitializationEvent aEvent) {

    }

    @Override
    public void onModPostInit2(cpw.mods.fml.common.event.FMLPostInitializationEvent aEvent) {
        // Insert your PostInit Code here and not above
    }

    @Override
    public void onModServerStarting2(cpw.mods.fml.common.event.FMLServerStartingEvent aEvent) {
        // Insert your ServerStarting Code here and not above
    }

    @Override
    public void onModServerStarted2(cpw.mods.fml.common.event.FMLServerStartedEvent aEvent) {
        // Insert your ServerStarted Code here and not above
    }

    @Override
    public void onModServerStopping2(cpw.mods.fml.common.event.FMLServerStoppingEvent aEvent) {
        // Insert your ServerStopping Code here and not above
    }

    @Override
    public void onModServerStopped2(cpw.mods.fml.common.event.FMLServerStoppedEvent aEvent) {
        // Insert your ServerStopped Code here and not above
    }

}
