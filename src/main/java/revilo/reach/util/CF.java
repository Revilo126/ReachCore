package revilo.reach.util;

import static gregapi.data.CS.*;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.LH;

/**
 * Chat Functions
 */
public class CF {

    public static ArrayListNoNulls<IChatComponent> delayedChat = new ArrayListNoNulls<>(F);

    public static void addMessageToChat(IChatComponent mComponent) {
        if (Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(mComponent);
        }
    }

    public static void addMessageToChat(String mMessage) {
        addMessageToChat(new ChatComponentText(mMessage));
    }

    public static void addErrorToChat(String mError) {
        addMessageToChat(LH.Chat.RED + mError);
    }

    public static void addMessageToChatServerStart(IChatComponent mComponent) {
        delayedChat.add(mComponent);
    }

    public static void addErrorToChatServerStart(String mError) {
        delayedChat.add(new ChatComponentText(LH.Chat.RED + mError));
    }

    public static void serverStartMessages() {
        for (IChatComponent i : delayedChat) {
            addMessageToChat(i);
        }
    }
}
