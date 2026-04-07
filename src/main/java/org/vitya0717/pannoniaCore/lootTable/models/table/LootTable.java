package org.vitya0717.pannoniaCore.lootTable.models.table;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;

public class LootTable {

    //LootTable Name
    @SerializedName("name")
    private String name;
    // Items number to choose inside the following list
    @SerializedName("pools")
    private final Collection<LootPool> pools = new ArrayList<>();

    public Collection<LootPool> getLootPools() {
        return pools;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "LootTable{" +
                "name='" + name + '\'' +
                ", pools=" + pools +
                '}';
    }
}
