package me.minion325.customenchant;

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



}
