package me.minion325.customenchant;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class CustomEnchantPlugin extends JavaPlugin {
    abstract void registerEnchants(EnchantsManager manager);
}
