package me.minion325.customenchant;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class EnchantsManager {

    private static EnchantsManager enchantsManager = new EnchantsManager();

    public static EnchantsManager getInstance() {
        return enchantsManager;
    }

    private List<Enchant> enchants;

    public EnchantsManager(){
        enchants = new ArrayList<>();
    }

    public void register(Class<? extends Enchant> customEnchantClass) {
        try {
            Enchant enchant = customEnchantClass.newInstance();
            for (Enchant enchantment : enchants) {
                if (enchant.getClass() == customEnchantClass || enchant.getName().equals(enchantment.getName())) {
                    Bukkit.getLogger().warning(enchant.getName()+ " could not be registered due to a conflict with another enchant");
                    return;
                }

            }
            enchants.add(enchant);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Enchant getEnchantByName(String name){
        for (Enchant enchant: enchants){
            if (enchant.getName().equals(name)) return  enchant;
        }
        return null;
    }

}
