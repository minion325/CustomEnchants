package me.minion325.customenchant.enchants;

import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.MaterialType;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Death extends Enchant {

    public Death() {
        super("Death", 5, MaterialType.SWORD, MaterialType.AXE);
    }

    @Override
    public void onHit(EntityDamageByEntityEvent event, int level) {
        if (event.getEntity() instanceof LivingEntity){
            ((LivingEntity) event.getEntity()).setHealth(0);
            event.getDamager().sendMessage(ChatColor.GRAY + "Your opponent is dead");
        }
    }
}
