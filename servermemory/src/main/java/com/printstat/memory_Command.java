package com.printstat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class memory_Command implements CommandExecutor 
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
        Runtime runtime = Runtime.getRuntime();
        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        long totalMem = runtime.totalMemory() / 1048576;
        long maxMem = runtime.maxMemory() / 1048576;
        sender.sendMessage(usedMem + "," + totalMem + "," + maxMem);
        return true;
    }
}
