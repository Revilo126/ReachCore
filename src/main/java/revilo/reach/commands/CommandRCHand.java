package revilo.reach.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandRCHand extends CommandBase {

    @Override
    public String getCommandName() {
        return "rchand";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/rchand";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayer) {
            String item = ((EntityPlayer) sender).getHeldItem()
                .getItem()
                .getUnlocalizedName();
            sender.addChatMessage(new ChatComponentText("Held item: " + item));
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
