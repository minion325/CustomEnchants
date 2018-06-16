package me.minion325.customenchant.listeners;

import me.minion325.customenchant.CustomEnchantPlugin;
import me.minion325.customenchant.enchanting.EnchantsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

public class PluginEnableListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onLoad(PluginEnableEvent event){
        if (event.getPlugin() instanceof CustomEnchantPlugin){
            CustomEnchantPlugin plugin = ((CustomEnchantPlugin) event.getPlugin());
            plugin.registerEnchants(EnchantsManager.getEnchantsManager());
        }
    }

}
