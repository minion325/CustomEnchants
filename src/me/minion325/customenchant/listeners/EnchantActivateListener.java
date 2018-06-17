package me.minion325.customenchant.listeners;

import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.EnchantUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantActivateListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler(ignoreCancelled = true)
    public void onHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        if (((Player) event.getDamager()).getItemInHand() != null && ((Player) event.getDamager()).getItemInHand().hasItemMeta() && ((Player) event.getDamager()).getItemInHand().getItemMeta().hasLore()) {
            Map<Enchant, Integer> enchants = EnchantUtils.getEnchants(((Player) event.getDamager()).getItemInHand());
            for (Enchant enchant : enchants.keySet()) {
                enchant.onHit(event, enchants.get(enchant));
            }
        }
    }

    @SuppressWarnings("unused")
    @EventHandler(ignoreCancelled = true)
    public void onMine(BlockBreakEvent event) {
        if (event.getPlayer().getItemInHand() != null && event.getPlayer().getItemInHand().hasItemMeta() && event.getPlayer().getItemInHand().getItemMeta().hasLore()) {
            Map<Enchant, Integer> enchants = EnchantUtils.getEnchants(event.getPlayer().getItemInHand());
            for (Enchant enchant : enchants.keySet()) {
                enchant.onMine(event, enchants.get(enchant));
            }
        }
    }

    @SuppressWarnings("unused")
    @EventHandler(ignoreCancelled = true)
    public void onGetHit(EntityDamageEvent event){
        if (!(event.getEntity() instanceof Player)) return;
        for (ItemStack armor : ((Player) event.getEntity()).getInventory().getArmorContents()){
            if (armor != null && armor.hasItemMeta() && armor.getItemMeta().hasLore()){
                Map<Enchant, Integer> enchants = EnchantUtils.getEnchants(armor);
                for (Enchant enchant : enchants.keySet()) {
                    enchant.onGetHit(event, enchants.get(enchant));
                }
            }
        }
    }

    


}
