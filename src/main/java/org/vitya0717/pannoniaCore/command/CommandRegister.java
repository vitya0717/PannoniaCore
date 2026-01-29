package org.vitya0717.pannoniaCore.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;

public class CommandRegister {

    private static CommandMap getCommandMap() {
        try {
            Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            return (CommandMap) f.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void registerCommand(Command command, Plugin plugin) {
        CommandMap commandMap = getCommandMap();
        if (commandMap != null) {
            commandMap.register(plugin.getName().toLowerCase(), command);
        }
    }
}