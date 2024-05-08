package hhitt.coliseo.utils;

import org.bukkit.ChatColor;

public class MessageUtils {

    public static String getColoredMessages(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
