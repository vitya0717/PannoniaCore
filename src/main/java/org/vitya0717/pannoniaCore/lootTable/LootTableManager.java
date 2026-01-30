package org.vitya0717.pannoniaCore.lootTable;

import org.bukkit.NamespacedKey;
import org.vitya0717.pannoniaCore.lootTable.json.JsonManager;
import org.vitya0717.pannoniaCore.lootTable.models.LootTable;
import org.vitya0717.pannoniaCore.main.Main;

import java.util.HashMap;

public class LootTableManager {

    private final HashMap<NamespacedKey, LootTable> lootTables = new HashMap<>();
    private final Main instance;
    private final JsonManager jsonManager;

    public LootTableManager(Main main) {
        this.instance = main;
        jsonManager = new JsonManager(instance);
    }

    public HashMap<NamespacedKey, LootTable> getLootTables() {
        return lootTables;
    }

    public Main getInstance() {
        return instance;
    }

    public JsonManager getJsonManager() {
        return jsonManager;
    }
}
