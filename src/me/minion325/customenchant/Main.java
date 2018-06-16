package me.minion325.customenchant;

import me.minion325.customenchant.commands.Enchant;
import me.minion325.customenchant.commands.Enchants;
import me.minion325.customenchant.enchanting.EnchantsManager;
import me.minion325.customenchant.listeners.PluginEnableListener;

public class Main extends CustomEnchantPlugin {

    @Override
    public void onEnable() {
        this.getCommand("enchants").setExecutor(new Enchants());
        this.getCommand("enchant").setExecutor(new Enchant());
        this.getServer().getPluginManager().registerEvents(new PluginEnableListener(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void registerEnchants(EnchantsManager manager) {

    }
}
