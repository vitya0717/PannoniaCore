package org.vitya0717.pannoniaCore.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ConfigurationAPI {

    private File configFile;
    private File configFolder;
    private FileConfiguration fileConfiguration;

    public ConfigurationAPI(JavaPlugin plugin, String moduleName, String configFileName) {
        this.configFolder = new File(plugin.getDataFolder().getParentFile(), moduleName);
        this.configFile = new File(configFolder, configFileName);
    }

    public void saveDefaultConfig() {
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        try (InputStream in = getClass().getResourceAsStream("/config.yml")) {
            if (in == null) {
                fileConfiguration = new YamlConfiguration();
                fileConfiguration.save(configFile);
                return;
            }
            Files.copy(in, configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public File getFile() {
        return configFile;
    }
}
