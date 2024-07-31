package lol.vanished.solarwarp;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandSolarWarp extends CommandBase {
    @Override
    public String getName() {
        return "solarwarp";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/solarwarp";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            if (!server.getPlayerList().canSendCommands(player.getGameProfile())) {
                player.sendMessage(new TextComponentString(TextFormatting.RED + "You must be op to edit in a multiplayer server."));
            } else {
                // Add your command logic here for OP players
                player.sendMessage(new TextComponentString(TextFormatting.GREEN + "You have access to /solarwarp command."));
            }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }
}
