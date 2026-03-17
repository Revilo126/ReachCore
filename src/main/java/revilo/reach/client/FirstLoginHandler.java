package revilo.reach.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.data.LH;
import revilo.reach.util.CF;

public class FirstLoginHandler {

    public static boolean completedMessage = false;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !completedMessage) {
            CF.addMessageToChat(
                new ChatComponentText(
                    LH.Chat.PURPLE + "Welcome to Reach "
                        + LH.Chat.DBLUE
                        + Minecraft.getMinecraft().thePlayer.getDisplayName()));
            completedMessage = true;
        }
    }

}
