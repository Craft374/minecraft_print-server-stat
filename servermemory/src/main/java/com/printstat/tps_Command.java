package com.printstat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class tps_Command implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        try
        {
            Object minecraftServer = getMinecraftServer();
            Field recentTpsField = minecraftServer.getClass().getField("recentTps");
            double[] recentTps = (double[]) recentTpsField.get(minecraftServer);

            String formatted = String.format("%.1f,%.1f,%.1f", recentTps[0], recentTps[1], recentTps[2]);
            sender.sendMessage(formatted);
        }
        catch (Exception e)
        {
            sender.sendMessage("-1,-1,-1");
        }
        return true;
    }

    private Object getMinecraftServer() throws Exception
    {
        Method getServerMethod = Bukkit.getServer().getClass().getMethod("getServer");
        return getServerMethod.invoke(Bukkit.getServer());
    }
}
