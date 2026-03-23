package revilo.reach;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregapi.api.Abstract_Proxy;
import gregapi.data.LH.Chat;
import revilo.reach.recipes.RecipeUtil;

public class CommonProxy extends Abstract_Proxy {

    // Server-Side Events

    @SuppressWarnings("unlikely-arg-type")
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (RecipeUtil.toNuke.contains(event.itemStack.getItem())) {
            event.toolTip.add(Chat.RED + "DISABLED ITEM!");
        }
    }
}
