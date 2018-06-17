package me.minion325.customenchant;

import me.minion325.customenchant.anvil.AnvilListener;
import me.minion325.customenchant.commands.Enchant;
import me.minion325.customenchant.commands.Enchants;
import me.minion325.customenchant.enchanting.EnchantsManager;
import me.minion325.customenchant.enchants.Death;
import me.minion325.customenchant.listeners.EnchantActivateListener;
import me.minion325.customenchant.listeners.PluginEnableListener;

public class Main extends CustomEnchantPlugin {

    @Override
    public void onEnable() {
        this.getCommand("cenchants").setExecutor(new Enchants());
        this.getCommand("cenchant").setExecutor(new Enchant());
        this.getServer().getPluginManager().registerEvents(new PluginEnableListener(), this);
        this.getServer().getPluginManager().registerEvents(new EnchantActivateListener(), this);
        this.getServer().getPluginManager().registerEvents(new AnvilListener(), this);
        this.saveDefaultConfig();
        ConfigValues.loadConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void registerEnchants(EnchantsManager manager) {
        manager.register(this, Death.class);
    }
}
