package org.vitya0717.pannoniaCore.lootTable.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

public class LootTable {

    //LootTable type Chest Content,Mob Drops, Fishing Treasure
    @SerializedName("type")
    private String type;
    //LootTable Name
    @SerializedName("name")
    private String name;
    // Items number to choose inside the following list
    @SerializedName("lootPools")
    private final Collection<LootPool> lootPools = new ArrayList<>();

    public Collection<LootPool> getLootPools() {
        return lootPools;
    }
}
