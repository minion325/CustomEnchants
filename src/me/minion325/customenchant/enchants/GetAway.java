package me.minion325.customenchant.enchants;

import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.MaterialType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class GetAway extends Enchant {

    public GetAway(){
        super("Get Away", 3, MaterialType.CHESPLATE, MaterialType.LEGGINGS);
    }

    @Override
    public void onGetHit(EntityDamageEvent event, int level) {
        if (!(event instanceof EntityDamageByEntityEvent)) return;
        EntityDamageByEntityEvent e = ((EntityDamageByEntityEvent) event);
        // COMMENTED FOR TESTING PURPOSESif (!(new Random().nextInt(500) < level)) return;
        ((EntityDamageByEntityEvent) event).getDamager().setVelocity(((EntityDamageByEntityEvent) event).getDamager().getLocation().getDirection().normalize().multiply(-3));
    }
}
