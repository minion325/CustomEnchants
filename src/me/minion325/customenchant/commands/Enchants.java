package me.minion325.customenchant.commands;

import me.minion325.customenchant.ConfigValues;
import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.EnchantsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Iterator;

public class Enchants implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
        if (sender.hasPermission("enchantapi.enchants")){
            StringBuilder stringBuilder = new StringBuilder(ChatColor.GREEN + "");
            Iterator<Enchant> iterator = EnchantsManager.getEnchantsManager().getEnchants().keySet().iterator();
            while (true){
                stringBuilder.append(iterator.next().getName());
                if (iterator.hasNext()) {
                    stringBuilder.append(", ");
                    continue;
                }
                break;
            }
            sender.sendMessage(stringBuilder.toString());
            return true;
        } else {
            sender.sendMessage(ConfigValues.NO_PERMISSION);
            return true;
        }
    }

}
