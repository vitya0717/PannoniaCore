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
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class ConfigurationAPI {

    private final File configFile;
    private final File configFolder;
    private FileConfiguration fileConfiguration;

    private final static File BASE_PATH = Main.getPlugin(Main.class).getDataFolder();

    public ConfigurationAPI(String moduleName, String configFileName) {
        this.configFolder = new File(BASE_PATH + "/modules/", moduleName);
        this.configFile = new File(configFolder, configFileName);
    }

    public void saveDefaultConfig() throws IOException {
        if (!configFolder.exists()) {
            configFolder.mkdirs();
        }

        if (!configFile.getName().endsWith(".yml")) try {
            throw new InvalidConfigurationException();
        } catch (InvalidConfigurationException e) {
            Logger.getLogger("PannoniaCore").severe("Sorry, only YAML files are supported at this time.");
        }

        var file = new File(BASE_PATH + "/modules/" + configFolder.getName());

        JarEntry findEntry = null;
        JarFile jarFile = new JarFile(file);

        Enumeration<JarEntry> enumerations = jarFile.entries();

        while (enumerations.hasMoreElements()) {
            JarEntry current = enumerations.nextElement();
            if (current.getName().equalsIgnoreCase(configFile.getName())) {
                findEntry = current;
                break;
            }
        }


        if (findEntry == null) throw new FileNotFoundException();

        try (InputStream in = jarFile.getInputStream(findEntry)) {

            if (in == null) throw new FileNotFoundException();
            String content = new String(in.readAllBytes());

            Logger.getLogger("PannoniaCore").warning(content);

            if (!configFile.exists()) {
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

            if (!configFile.exists()) {
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
