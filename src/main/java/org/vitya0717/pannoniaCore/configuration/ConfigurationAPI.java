package org.vitya0717.pannoniaCore.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.vitya0717.pannoniaCore.main.Main;
import org.vitya0717.pannoniaCore.moduleManager.PannoniaModule;
import org.vitya0717.pannoniaCore.utils.ConsoleUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ConfigurationAPI {

    private File configFile;
    private final Class<?> module;
    private File configFolder;
    private FileConfiguration fileConfiguration;

    public ConfigurationAPI(Class<?> module, String moduleName, String configFileName) {
        this.module = module;
        this.configFolder = new File(Main.getPlugin(Main.class).getDataFolder()+"/modules", moduleName);
        this.configFile = new File(configFolder, configFileName);
    }

    public void saveDefaultConfig() {
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        try (InputStream in = module.getResourceAsStream("/config.yml")) {

            if (in == null) {
                ConsoleUtils.SendConsole("&cNull");
                fileConfiguration = new YamlConfiguration();
                fileConfiguration.save(configFile);
                return;
            }

           if(!configFile.exists()) {
               configFile.mkdirs();
           }

           fileConfiguration = new YamlConfiguration();

           fileConfiguration.load(configFile);

        } catch (IOException | InvalidConfigurationException e) {
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
