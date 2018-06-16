package me.minion325.customenchant;

import org.bukkit.ChatColor;

public class ConfigValues {

    private static Main plugin = Main.getPlugin(Main.class);

    public static String NO_PERMISSION;

    public void loadConfig(){
        NO_PERMISSION = ChatColor.translateAlternateColorCodes('&' , plugin.getConfig().getString("no-permission", "&4You do not have permission to execute that command"));
    }

}
