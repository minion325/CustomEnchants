package me.minion325.customenchant.commands;

import me.minion325.customenchant.ConfigValues;
import me.minion325.customenchant.enchanting.EnchantUtils;
import me.minion325.customenchant.enchanting.EnchantsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Enchant implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use that");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("enchantapi.enchant")) {
            player.sendMessage(ConfigValues.NO_PERMISSION);
            return true;
        }
        if (args.length == 0) {
            //TODO SEND USAGE
            return true;
        }
        if (args.length == 1) {
            //TODO SEND USAGE
            return true;
        }
        if (player.getItemInHand() == null) {
            player.sendMessage("You must hold an item in hand to perform this command");
            return true;
        }
        try {
            me.minion325.customenchant.enchanting.Enchant enchant;
            if ((enchant = EnchantsManager.getEnchantsManager().getEnchantByName(args[0].replace('_', ' '))) == null) {
                player.sendMessage(ConfigValues.NO_SUCH_ENCHANT);
                return true;
            }
            int level = Integer.parseInt(args[1]);
            EnchantUtils.addEnchant(player.getItemInHand(), enchant, level);
            player.sendMessage(ConfigValues.ENCHANT_ADDED);
            return true;
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + args[1] + " is not a valid enchantment level");
            return true;
        }


    }

}
