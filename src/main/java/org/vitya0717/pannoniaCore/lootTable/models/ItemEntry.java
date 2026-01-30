package org.vitya0717.pannoniaCore.lootTable.models;

import com.google.gson.annotations.SerializedName;
import org.vitya0717.pannoniaCore.lootTable.enums.ItemEntryType;

import java.util.ArrayList;
import java.util.Collection;

public class ItemEntry {

    @SerializedName("itemType")
    private ItemEntryType itemType;
    @SerializedName("name")
    private String name;
    @SerializedName("weight")
    private double weight = 1;
    @SerializedName("quality")
    private int quality = 1;
    @SerializedName("itemFunctions")
    private final ArrayList<ItemFunction> itemFunctions = new ArrayList<>();

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemEntryType getItemType() {
        return itemType;
    }

    public void setItemType(ItemEntryType itemType) {
        this.itemType = itemType;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public ArrayList<ItemFunction> getFunctions() {
        return itemFunctions;
    }
}
