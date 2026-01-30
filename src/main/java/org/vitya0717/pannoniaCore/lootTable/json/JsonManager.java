package org.vitya0717.pannoniaCore.lootTable.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.vitya0717.pannoniaCore.lootTable.functions.count.SetConstantCountFunction;
import org.vitya0717.pannoniaCore.lootTable.json.gson.RuntimeTypeAdapterFactory;
import org.vitya0717.pannoniaCore.lootTable.models.ItemEntry;
import org.vitya0717.pannoniaCore.lootTable.models.ItemFunction;
import org.vitya0717.pannoniaCore.lootTable.models.LootPool;
import org.vitya0717.pannoniaCore.lootTable.models.LootTable;
import org.vitya0717.pannoniaCore.main.Main;

import java.io.FileReader;
import java.io.Reader;

public class JsonManager {

    private final Main instance;
    private final String BASE_PATH = "plugins/PannoniaCore/modules/";


    public JsonManager(Main instance) {
        this.instance = instance;
    }

    public Main getInstance() {
        return instance;
    }

    public void ReadLootTables(String path, String fileName) {
        Gson gson = createLootGson();

        try (Reader reader = new FileReader(BASE_PATH + path + "/" + (fileName.contains(".json") ?  fileName : fileName + ".json"))) {
            LootTable table = gson.fromJson(reader, LootTable.class);
            System.out.println("Sikeresen betöltve! Pools száma: " + table.getLootPools().size());

            // Teszteld az első pool első entry első function-jét
            LootPool firstPool = table.getLootPools().iterator().next();
            ItemEntry entry = firstPool.getEntries().iterator().next();
            ItemFunction func = entry.getFunctions().getFirst();
            if (func instanceof SetConstantCountFunction) {
                System.out.println("set_count function megtalálva!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Gson createLootGson() {
        RuntimeTypeAdapterFactory<ItemFunction> functionFactory =
                RuntimeTypeAdapterFactory
                        .of(ItemFunction.class, "function", true)  // true = maintainType (opcionális)
                        .registerSubtype(SetConstantCountFunction.class, "set_count")
                        //.registerSubtype(FurnaceSmeltFunction.class, "furnace_smelt")
                // később hozzáadod a többit: enchant_with_levels stb.
        ;

        return new GsonBuilder()
                .registerTypeAdapterFactory(functionFactory)
                .setPrettyPrinting()
                .create();
    }
}
