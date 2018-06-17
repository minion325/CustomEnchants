package me.minion325.customenchant.enchanting;

import me.minion325.customenchant.CustomEnchantPlugin;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

public class EnchantsManager {

    private static EnchantsManager enchantsManager = new EnchantsManager();

    public static EnchantsManager getEnchantsManager() {
        return enchantsManager;
    }

    private Map<Enchant, CustomEnchantPlugin> enchants;

    private EnchantsManager(){
        enchants = new HashMap<>();
    }

    public void register(CustomEnchantPlugin plugin, Class<? extends Enchant> customEnchantClass) {
        try {
            Enchant enchant = customEnchantClass.newInstance();
            for (Enchant enchantment : enchants.keySet()) {
                if (enchantment.getClass() == customEnchantClass || enchant.getName().equals(enchantment.getName())) {
                    Bukkit.getLogger().severe(enchant.getName()+ " could not be registered due to a conflict with another enchant");
                    return;
                }

            }
            enchants.put(enchant, plugin);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Enchant getEnchantByName(String name){
        for (Enchant enchant: enchants.keySet()){
            if (enchant.getName().equalsIgnoreCase(name)) return  enchant;
        }
        return null;
    }

    public Map<Enchant, CustomEnchantPlugin> getEnchants() {
        return enchants;
    }
}
