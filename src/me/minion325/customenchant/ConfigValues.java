package me.minion325.customenchant;

import org.bukkit.ChatColor;

public class ConfigValues {

    private static Main plugin = Main.getPlugin(Main.class);

    public static String NO_PERMISSION, NO_SUCH_ENCHANT, ENCHANT_ADDED;

    public static void loadConfig(){
        NO_PERMISSION = ChatColor.translateAlternateColorCodes('&' , plugin.getConfig().getString("no-permission", "&4You do not have permission to execute that command."));
        NO_SUCH_ENCHANT = ChatColor.translateAlternateColorCodes('&' , plugin.getConfig().getString("no-such-enchant", "&4That enchantment does not exist."));
        ENCHANT_ADDED = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("enchant-added", "&b%enchant% %level% was successfully added to the item in hand."));

    }

}
