package org.vitya0717.pannoniaCore.lootTable.models.item;

import com.google.gson.annotations.SerializedName;
import org.bukkit.inventory.ItemFlag;

import java.util.List;
import java.util.Map;

public class ItemEntry {

    @SerializedName("type")
    private String type;

    @SerializedName("material")
    private String material;

    @SerializedName("custom_model_data")
    private int custom_model_data = 1;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("chance")
    private double chance;

    @SerializedName("metadata")
    private MetaData metaData;

    @SerializedName("enchantments")
    private List<Enchantment> enchantments;

    @SerializedName("item_flags")
    private List<String> itemFlags;

    @SerializedName("public_bukkit_values")
    private Map<String, Object> publicBukkitValues;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCustom_model_data() {
        return custom_model_data;
    }

    public void setCustom_model_data(int custom_model_data) {
        this.custom_model_data = custom_model_data;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {this.chance = chance;}

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public void setEnchantments(List<Enchantment> enchantments) {
        this.enchantments = enchantments;
    }

    public List<String> getItemFlags() {return itemFlags;}

    public void setItemFlags(List<String> itemFlags) {this.itemFlags = itemFlags;}

    public Map<String, Object> getPublicBukkitValues() {return publicBukkitValues;}

    public void setPublicBukkitValues(Map<String, Object> publicBukkitValues) {this.publicBukkitValues = publicBukkitValues;}

    @Override
    public String toString() {
        return "ItemEntry{" +
                "type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", custom_model_data=" + custom_model_data +
                ", quantity=" + quantity +
                ", chance=" + chance +
                ", metaData=" + metaData +
                ", enchantments=" + enchantments +
                ", itemFlags=" + itemFlags +
                '}';
    }
}
