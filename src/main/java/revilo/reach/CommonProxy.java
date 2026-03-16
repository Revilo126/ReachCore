package revilo.reach;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import revilo.reach.config.ReachConfig;
import revilo.reach.recipes.RecipeUtil;

public class CommonProxy extends Abstract_Proxy {

    public static final Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void onProxyBeforeInit(Abstract_Mod aMod, FMLInitializationEvent aEvent) {
        Reach.LOG.info(
            "REACH SERVER LOG OUTPUT:\nCurrent Modpack Version: {}\nCurrent Core Version: {}",
            ReachConfig.getModpackVersion(),
            Tags.VERSION);
    }

    @SuppressWarnings("unlikely-arg-type")
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (RecipeUtil.toNuke.contains(event.itemStack.getItem())) {
            event.toolTip.add("DISABLED ITEM!");
        }
    }
}
