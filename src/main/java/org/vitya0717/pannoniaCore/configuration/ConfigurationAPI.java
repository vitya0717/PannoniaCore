package org.vitya0717.pannoniaCore.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.vitya0717.pannoniaCore.main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class ConfigurationAPI {

    private final File configFile;
    private final InputStream module;
    private final File configFolder;
    private FileConfiguration fileConfiguration;

    public ConfigurationAPI(InputStream module, String moduleName, String configFileName) {
        this.module = module;
        this.configFolder = new File(Main.getPlugin(Main.class).getDataFolder()+"/modules/", moduleName);
        this.configFile = new File(configFolder, configFileName);
    }

    public void saveDefaultConfig() {
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        if(!configFile.getName().endsWith(".yml")) try {
            throw new InvalidConfigurationException();
        } catch (InvalidConfigurationException e) {
            Logger.getLogger("PannoniaCore").severe("Sorry, only YAML files are supported at this time.");
        }

        try (InputStream in = module) {

            if (in == null) throw new FileNotFoundException();

           if(!configFile.exists()) {
               Files.copy(in, configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
           }

           fileConfiguration = new YamlConfiguration();
           fileConfiguration.load(configFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            Logger.getLogger("PannoniaCore").severe("Error occurred while trying to load configuration.");
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public void reloadConfig() {
        fileConfiguration = null;

        fileConfiguration = new YamlConfiguration();

        try {

            if(!configFile.exists())  {
                saveDefaultConfig();
                return;
            }

            fileConfiguration.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            Logger.getLogger("PannoniaCore").severe("Error occurred trying to reload configuration.");
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            fileConfiguration.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public File getFile() {
        return configFile;
    }
}
