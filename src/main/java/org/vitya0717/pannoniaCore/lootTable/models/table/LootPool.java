package org.vitya0717.pannoniaCore.lootTable.models.table;

import com.google.gson.annotations.SerializedName;
import org.vitya0717.pannoniaCore.lootTable.models.item.ItemEntry;

import java.util.ArrayList;
import java.util.Collection;

public class LootPool {

    @SerializedName("rolls")
    private float rolls = 1;
    @SerializedName("loots")
    private final Collection<ItemEntry> loots = new ArrayList<>();

    public float getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public Collection<ItemEntry> getLoots() {
        return loots;
    }

    @Override
    public String toString() {
        return "LootPool{" +
                "rolls=" + rolls +
                ", loots=" + loots +
                '}';
    }
}
