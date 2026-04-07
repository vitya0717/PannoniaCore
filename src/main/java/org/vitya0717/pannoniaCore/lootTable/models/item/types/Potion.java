package org.vitya0717.pannoniaCore.lootTable.models.item.types;

import com.google.gson.annotations.SerializedName;

public class Potion {

    @SerializedName("effectType")
    private String potionEffectType;
    @SerializedName("effectDuration")
    private float effectDuration;
    @SerializedName("effectStrength")
    private float effectStrength;

    public String getPotionEffectType() {
        return potionEffectType;
    }

    public void setPotionEffectType(String potionEffectType) {
        this.potionEffectType = potionEffectType;
    }

    public float getEffectDuration() {
        return effectDuration;
    }

    public void setEffectDuration(float effectDuration) {
        this.effectDuration = effectDuration;
    }

    public float getEffectStrength() {
        return effectStrength;
    }

    public void setEffectStrength(float effectStrength) {
        this.effectStrength = effectStrength;
    }
}
