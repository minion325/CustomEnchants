package me.minion325.customenchant.enchanting;

import me.minion325.customenchant.events.ArmorEquipEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Enchant {

    private String name;
    private int maxLevel;
    private MaterialType[] materialTypes;

    public Enchant(String name, int maxLevel, MaterialType... materials){
        this.name = name;
        this.maxLevel = maxLevel;
        this.materialTypes = materials;
    }

    public String getName() {
        return name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void onHit(EntityDamageByEntityEvent event, int level){}

    public void onGetHit(EntityDamageEvent event, int level){}

    public void onMine(BlockBreakEvent event, int level){}

    public void onEquip(ArmorEquipEvent event, int level){}

    public void onUnequip(ArmorEquipEvent event, int level){}

    public MaterialType[] getMaterialTypes() {
        return materialTypes;
    }
}
