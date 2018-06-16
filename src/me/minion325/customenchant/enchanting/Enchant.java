package me.minion325.customenchant.enchanting;

import me.minion325.customenchant.events.ArmorEquipEvent;
import net.minecraft.server.v1_8_R3.EntityDamageSource;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Enchant {

    private String name;
    private int maxLevel;

    public String getName() {
        return name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void onHit(EntityDamageByEntityEvent event){}

    public void onGetHit(EntityDamageSource event){}

    public void onMine(BlockBreakEvent event){}

    public void onEquip(ArmorEquipEvent event){}

    public void onUnequip(ArmorEquipEvent event){}



}
