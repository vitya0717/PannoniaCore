package org.vitya0717.pannoniaCore.lootTable.models.item.types;

import com.google.gson.annotations.SerializedName;
import org.vitya0717.pannoniaCore.lootTable.models.item.ItemEntry;

public class Spawner extends ItemEntry {

    @SerializedName("spawner_type")
    public String spawnerType;


    public String getSpawnerType() {
        return spawnerType;
    }

    public void setSpawnerType(String spawnerType) {
        this.spawnerType = spawnerType;
    }
}
