package org.vitya0717.pannoniaCore.lootTable.models.item.types.arrays;

import com.google.gson.annotations.SerializedName;
import org.vitya0717.pannoniaCore.lootTable.models.item.Enchantment;
import org.vitya0717.pannoniaCore.lootTable.models.item.ItemEntry;

import java.util.List;

public class EnchantedBooks extends ItemEntry {

    @SerializedName("book_enchantments")
    private List<Enchantment> enchantedBooks;

    public List<Enchantment> getEnchantedBooks() {
        return enchantedBooks;
    }

    public void setEnchantedBooks(List<Enchantment> enchantedBooks) {
        this.enchantedBooks = enchantedBooks;
    }


    @Override
    public String toString() {
        return "EnchantedBooks{" +
                "enchantedBooks=" + enchantedBooks +
                '}';
    }
}
