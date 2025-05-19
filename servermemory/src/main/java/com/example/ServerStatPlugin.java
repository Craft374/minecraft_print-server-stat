package com.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerStatPlugin extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {
        getCommand("server").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("memory")) {
            Runtime runtime = Runtime.getRuntime();
            long totalMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            long usedMemory = totalMemory - freeMemory;
            long maxMemory = runtime.maxMemory();

            sender.sendMessage((usedMemory / 1024 / 1024)+","+(totalMemory / 1024 / 1024)+","+(maxMemory / 1024 / 1024));
            sender.sendMessage("§a[서버 메모리 정보]");
            sender.sendMessage("§f사용 중: " + (usedMemory / 1024 / 1024) + " MB");
            sender.sendMessage("§f총 할당: " + (totalMemory / 1024 / 1024) + " MB");
            sender.sendMessage("§f최대: " + (maxMemory / 1024 / 1024) + " MB");
        } else {
            sender.sendMessage("§c사용법: /server memory");
        }
        return true;
    }
}
