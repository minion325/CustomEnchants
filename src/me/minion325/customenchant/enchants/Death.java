package me.minion325.customenchant.enchants;

import me.minion325.customenchant.enchanting.Enchant;
import me.minion325.customenchant.enchanting.MaterialType;
import org.bukkit.Effect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blinded extends Enchant {

    public Blinded() {
        super("Blinded", 5, MaterialType.SWORD, MaterialType.AXE);
    }

    @Override
    public void onHit(EntityDamageByEntityEvent event, int level) {
        if (event.getEntity() instanceof LivingEntity){
            LivingEntity entity = ((LivingEntity) event.getEntity());
            entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, level * 20, 0));
            entity.getWorld().playEffect(entity.getEyeLocation(), Effect.SMOKE, 0);
        }
    }
}
