package org.vitya0717.pannoniaCore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ConsoleUtils {

    public static void SendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(translateColors(message));
    }


    public static String translateColors(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);

        return s;
    }

}
