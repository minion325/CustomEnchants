package me.minion325.customenchant;

import me.minion325.customenchant.enchanting.EnchantsManager;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CustomEnchantPlugin extends JavaPlugin {

    public abstract void registerEnchants(EnchantsManager manager);

}
