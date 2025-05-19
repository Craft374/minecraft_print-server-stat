package com.printstat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MemoryCommand implements CommandExecutor 
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
        Runtime runtime = Runtime.getRuntime();
        long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        long totalMem = runtime.totalMemory() / 1048576;
        long maxMem = runtime.maxMemory() / 1048576;

        UUID uuid = (sender instanceof Player)
                ? ((Player) sender).getUniqueId()
                : LangManager.CONSOLE_UUID;

        String lang = LangManager.getLanguage(uuid);

        if (lang.equals("en")) 
        {
            sender.sendMessage(usedMem+","+totalMem+","+maxMem);
            sender.sendMessage("[Server Memory Info]");
            sender.sendMessage("Used: " + usedMem + " MB");
            sender.sendMessage("Allocated: " + totalMem + " MB");
            sender.sendMessage("Max: " + maxMem + " MB");
        } 
        else 
        {
            sender.sendMessage(usedMem+","+totalMem+","+maxMem);
            sender.sendMessage("[서버 메모리 정보]");
            sender.sendMessage("사용 중: " + usedMem + " MB");
            sender.sendMessage("총 할당: " + totalMem + " MB");
            sender.sendMessage("최대: " + maxMem + " MB");
        }
        return true;
    }
}
