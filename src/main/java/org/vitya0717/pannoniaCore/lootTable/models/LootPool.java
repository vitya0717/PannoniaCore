package org.vitya0717.pannoniaCore.lootTable.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

public class LootPool {

    @SerializedName("rolls")
    private int rolls = 1;
    @SerializedName("entries")
    private final Collection<ItemEntry> entries = new ArrayList<>();


    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public Collection<ItemEntry> getEntries() {
        return entries;
    }
}
