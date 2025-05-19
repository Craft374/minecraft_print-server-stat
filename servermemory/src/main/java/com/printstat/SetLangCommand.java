package com.printstat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SetLangCommand implements CommandExecutor 
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
        if (args.length != 1 || !(args[0].equalsIgnoreCase("en") || args[0].equalsIgnoreCase("kr"))) 
        {
            sender.sendMessage("Usage: /print set-lang [en|kr]");
            return true;
        }

        UUID uuid = (sender instanceof Player)
                ? ((Player) sender).getUniqueId()
                : LangManager.CONSOLE_UUID;

        String lang = args[0].toLowerCase();
        LangManager.setLanguage(uuid, lang);

        if (lang.equals("en")) 
        {
            sender.sendMessage("Language set to English.");
        } 
        else 
        {
            sender.sendMessage("언어가 한글로 설정되었습니다.");
        }
        return true;
    }
}
