package revilo.reach;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import revilo.reach.client.FirstLoginHandler;
import revilo.reach.util.CF;

public class ClientProxy extends Abstract_Proxy {

    private boolean hasMessages = false;

    @Override
    public void onProxyAfterInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
        FMLCommonHandler.instance()
            .bus()
            .register(new FirstLoginHandler());
    }

    public void onProxyAfterServerStarted(Abstract_Mod aMod, FMLServerStartedEvent aEvent) {
        if (!hasMessages) {
            CF.serverStartMessages();
            hasMessages = true;
        }
    }
}
