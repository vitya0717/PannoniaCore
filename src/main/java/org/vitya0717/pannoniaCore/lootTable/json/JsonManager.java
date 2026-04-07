package org.vitya0717.pannoniaCore.lootTable.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.NamespacedKey;
import org.vitya0717.pannoniaCore.lootTable.json.gson.RuntimeTypeAdapterFactory;
import org.vitya0717.pannoniaCore.lootTable.models.item.ItemEntry;
import org.vitya0717.pannoniaCore.lootTable.models.item.types.Spawner;
import org.vitya0717.pannoniaCore.lootTable.models.item.types.arrays.EnchantedBooks;
import org.vitya0717.pannoniaCore.lootTable.models.item.types.arrays.PotionEffects;
import org.vitya0717.pannoniaCore.lootTable.models.table.LootTable;
import org.vitya0717.pannoniaCore.main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonManager {

    private final Main instance;
    private final String BASE_PATH = "plugins/PannoniaCore/modules";

    public JsonManager(Main instance) {
        this.instance = instance;
    }

    public Main getInstance() {
        return instance;
    }

    public Map<NamespacedKey, LootTable> ReadLootTables(String path) throws FileNotFoundException {
        Map<NamespacedKey, LootTable> response = new HashMap<>();
        File lootFolder = new File(BASE_PATH + path);

        if (lootFolder.listFiles() == null) throw new FileNotFoundException();

        for (String fileName : Arrays.stream(lootFolder.listFiles()).map(File::getName).toList()) {

            Gson gson = createLootGson();

            String finalPath = BASE_PATH + path + "/" + (fileName.contains(".json") ? fileName : fileName + ".json");

            try (Reader reader = new FileReader(finalPath)) {
                LootTable table = gson.fromJson(reader, LootTable.class);
                table.setName(fileName.contains(".json") ? fileName.substring(0, fileName.indexOf('.')) : fileName);

                response.putIfAbsent(new NamespacedKey("pannoniacore", "loot_" + table.getName()), table);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return response;
    }

    private Gson createLootGson() {

        RuntimeTypeAdapterFactory<ItemEntry> adapterFactory = RuntimeTypeAdapterFactory.of(ItemEntry.class, "type");           // a "type" mező alapján dönt

        adapterFactory.registerSubtype(ItemEntry.class, "item");
        adapterFactory.registerSubtype(PotionEffects.class, "potion");
        adapterFactory.registerSubtype(Spawner.class, "spawner");
        adapterFactory.registerSubtype(EnchantedBooks.class, "enchanted_book");


        return new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .setPrettyPrinting()
                .create();
    }
}
