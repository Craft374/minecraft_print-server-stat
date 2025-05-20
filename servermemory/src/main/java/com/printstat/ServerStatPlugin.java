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
                sender.sendMessage("Usage: help print");
                return true;
            }

            switch (args[0].toLowerCase()) 
            {
                case "memory":
                    return new memory_Command().onCommand(sender, command, label, args);
                case "tps":
                    return new tps_Command().onCommand(sender, command, label, args);
                case "info":
                    return new info_Command().onCommand(sender, command, label, args);
                default:
                    sender.sendMessage("Usage: help print");
                    return true;
            }
        });
    }
}
