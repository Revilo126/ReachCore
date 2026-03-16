package revilo.reach.util;

import net.minecraft.util.IChatComponent;

import revilo.reach.CommonProxy;

/**
 * Chat Functions
 */
public class CF {

    public static void addMessageToChat(IChatComponent mComponent) {
        if (CommonProxy.mc.theWorld != null && CommonProxy.mc.thePlayer != null) {
            CommonProxy.mc.thePlayer.addChatMessage(mComponent);
        }
    }
}
