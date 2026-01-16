package revilo.reach;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;

public class ClientProxy extends Abstract_Proxy {

    @Override
    public void onProxyAfterInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
        FMLCommonHandler.instance()
            .bus()
            .register(new FirstLoginHandler());
    }
}
