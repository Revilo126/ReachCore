package revilo.reach;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FirstLoginHandler {

    public static boolean completedMessage = false;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !completedMessage) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(
                new ChatComponentText(
                    "[Welcome to " + EnumChatFormatting.BLUE
                        + "Reach"
                        + EnumChatFormatting.DARK_PURPLE
                        + player.getDisplayName()
                        + EnumChatFormatting.WHITE
                        + "]"));
            completedMessage = true;
        }
    }

}
