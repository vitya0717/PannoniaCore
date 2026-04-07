package org.vitya0717.pannoniaCore.lootTable.models.item;

import com.google.gson.annotations.SerializedName;

public class Enchantment {

    @SerializedName("enchantment")
    private String enchantment;

    @SerializedName("level")
    private int level;

    public String getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(String enchantment) {
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Enchantment{" +
                "enchantment='" + enchantment + '\'' +
                ", level=" + level +
                '}';
    }
}
