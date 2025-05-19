package com.printstat;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerStatPlugin extends JavaPlugin 
{
    @Override
    public void onEnable() 
    {
        this.getCommand("print").setExecutor((sender, command, label, args) -> 
        {
            if (args.length == 0) 
            {
                sender.sendMessage("Usage: /print memory | set-lang [en|kr]");
                return true;
            }

            switch (args[0].toLowerCase()) 
            {
                case "memory":
                    return new MemoryCommand().onCommand(sender, command, label, args);
                case "set-lang":
                    return new SetLangCommand().onCommand(sender, command, label, args.length > 1 ? new String[]{args[1]} : new String[0]);
                default:
                    sender.sendMessage("Usage: /print memory | set-lang [en|kr]");
                    return true;
            }
        });
    }
}
