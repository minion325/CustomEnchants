package me.minion325.customenchant.enchanting;

import org.bukkit.Material;

public enum MaterialType {
    HELMET,CHESPLATE,LEGGINGS,BOOTS,SWORD,PICKAXE,SHOVEL,AXE,BOOK,ROD,BOW;

    public MaterialType getMaterialType(Material material) {
        return MaterialType.valueOf(material.toString().split("_")[material.toString().split("-").length - 1]);
    }
}
