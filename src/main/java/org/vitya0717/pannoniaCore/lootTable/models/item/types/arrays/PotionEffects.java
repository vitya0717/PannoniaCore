package org.vitya0717.pannoniaCore.lootTable.models.item.types.arrays;

import com.google.gson.annotations.SerializedName;
import org.vitya0717.pannoniaCore.lootTable.models.item.ItemEntry;
import org.vitya0717.pannoniaCore.lootTable.models.item.types.Potion;

import java.util.List;

public class PotionEffects extends ItemEntry {

    @SerializedName("potion_effects")
    private List<Potion> potionEffects;


    public List<Potion> getPotionEffects() {
        return potionEffects;
    }

    public void setPotionEffects(List<Potion> potionEffects) {
        this.potionEffects = potionEffects;
    }
}
