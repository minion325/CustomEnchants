package me.minion325.customenchant;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static Map<Enchant, Integer> getEnchants(ItemStack item){
        List<String> lore = item.getItemMeta().getLore();
        Map<Enchant, Integer> returnMap = new HashMap<>();
        for (String loreLine : lore){
            Enchant enchant = parseEnchant(loreLine);
            if (enchant == null) continue;
            String args[] = loreLine.split(" ");
            int level = getNumFromRoman(args[args.length-1]);
            returnMap.put(enchant, level);
        }
        return returnMap;
    }

    public static Enchant parseEnchant(String name){
        if (!name.contains(" ")) return null;
        String[] args = name.split(" ");
        if (args.length == 2){
            return EnchantsManager.getInstance().getEnchantByName(args[0]);
        }
        StringBuilder sb = new StringBuilder(args[0]);
        for (int i = 1; i<args.length -1; i++){
            sb.append(" ").append(args[i]);
        }
        return EnchantsManager.getInstance().getEnchantByName(sb.toString());
    }

    public static int getNumFromRoman(String romanNumeral){
        return 0;
    }

    public static String getRomanFromNum(int i){
        return "";
    }

    public static void main(String[] args) {
        parseEnchant("Sharpness of Sword III");
    }


}
