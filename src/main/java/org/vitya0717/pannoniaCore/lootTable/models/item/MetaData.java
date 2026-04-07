package org.vitya0717.pannoniaCore.lootTable.models.item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MetaData {

    @SerializedName("displayname")
    private String displayName;

    @SerializedName("lore")
    private List<String> lore;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "displayName='" + displayName + '\'' +
                ", lore=" + lore +
                '}';
    }
}
