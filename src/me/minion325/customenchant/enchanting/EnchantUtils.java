package me.minion325.customenchant.enchanting;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnchantUtils {

    private static String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private  static int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

    public static Map<Enchant, Integer> getEnchants(ItemStack item) {
        List<String> lore = item.getItemMeta().getLore();
        Map<Enchant, Integer> returnMap = new HashMap<>();
        for (String loreLine : lore) {
            loreLine = ChatColor.stripColor(loreLine);
            Enchant enchant = parseEnchant(loreLine);
            if (enchant == null) continue;
            String args[] = loreLine.split(" ");
            int level = getNumFromRoman(args[args.length - 1]);
            returnMap.put(enchant, level);
        }
        return returnMap;
    }

    public static Enchant parseEnchant(String name) {
        if (!name.contains(" ")) return null;
        String[] args = name.split(" ");
        if (args.length == 2) {
            return EnchantsManager.getEnchantsManager().getEnchantByName(args[0]);
        }
        StringBuilder sb = new StringBuilder(args[0]);
        for (int i = 1; i < args.length - 1; i++) {
            sb.append(" ").append(args[i]);
        }
        return EnchantsManager.getEnchantsManager().getEnchantByName(sb.toString());
    }

    public static int getNumFromRoman(String romanNumeral) {
        switch (romanNumeral) {
            case "I" : return 1;
            case "II" : return 2;
            case "III" : return 3;
            case "IV" : return 4;
            case "V" : return 5;
            default:return 0;
        }
    }

    public static String getRomanFromNum(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();

    }


}