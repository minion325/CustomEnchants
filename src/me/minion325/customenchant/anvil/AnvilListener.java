package me.minion325.customenchant.anvil;

import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.EnchantUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;

import java.util.Map;

public class AnvilListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler(ignoreCancelled = true)
    public void onPrepareAnvil(InventoryClickEvent event){
        if (!(event.getView().getTopInventory() instanceof AnvilInventory)) return;
        AnvilInventory inventory = (AnvilInventory) event.getView().getTopInventory();
        if (inventory.getItem(2) == null) return;
        Map<Enchant,Integer>  enchantsOf0 = EnchantUtils.getEnchants(inventory.getItem(0));
        Map<Enchant,Integer>  enchantsOf1 = EnchantUtils.getEnchants(inventory.getItem(1));
        for (Enchant enchant : enchantsOf0.keySet()){
            if (enchantsOf1.containsKey(enchant)){
                int level;
                if ((level = enchantsOf0.get(enchant)) == (enchantsOf1.get(enchant))){
                    EnchantUtils.addEnchant(inventory.getItem(2), enchant, level>=enchant.getMaxLevel() ? enchant.getMaxLevel() : level + 1);
                }
            }
        }

    }

}
