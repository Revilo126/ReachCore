package revilo.reach.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;

/**
 * Chat Functions
 */
public class CF {

    public static void addMessageToChat(IChatComponent mComponent) {
        if (Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(mComponent);
        }
    }
}
