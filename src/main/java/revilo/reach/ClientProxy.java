package revilo.reach;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import revilo.reach.client.FirstLoginHandler;
import revilo.reach.config.ReachConfig;

public class ClientProxy extends Abstract_Proxy {

    @Override
    public void onProxyBeforeInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
        Reach.LOG.info(
            "REACH CLIENT LOG OUTPUT:\nCurrent Modpack Version: {}\nCurrent Core Version: {}",
            ReachConfig.getModpackVersion(),
            Tags.VERSION);
    }

    @Override
    public void onProxyAfterInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
        FMLCommonHandler.instance()
            .bus()
            .register(new FirstLoginHandler());
    }
}
