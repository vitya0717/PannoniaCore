package org.vitya0717.pannoniaCore.lootTable;

import org.vitya0717.pannoniaCore.lootTable.json.JsonManager;
import org.vitya0717.pannoniaCore.main.Main;

public class LootTableManager {

    private final Main instance;
    private final JsonManager jsonManager;

    public LootTableManager(Main main) {
        this.instance = main;
        jsonManager = new JsonManager(instance);
    }

    public Main getInstance() {
        return instance;
    }

    public JsonManager getJsonManager() {
        return jsonManager;
    }
}
