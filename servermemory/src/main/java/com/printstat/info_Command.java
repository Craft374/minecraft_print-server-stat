package com.printstat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class info_Command implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        String bukkitVersion = Bukkit.getBukkitVersion();
        String platform = Bukkit.getServer().getName();
        sender.sendMessage(bukkitVersion + "," + platform);
        return true;
    }
}
