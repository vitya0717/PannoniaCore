package org.vitya0717.pannoniaCore.moduleManager;

import org.bukkit.Bukkit;
import org.vitya0717.pannoniaCore.Main;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

public class ModuleManager {

    private final Main plugin;
    private final List<String> enabledModules = List.of("Test.jar");



    public ModuleManager(Main plugin) {
        this.plugin=plugin;
    }


    public void LoadModules() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        File folder = new File(plugin.getDataFolder(), "modules");

        if(!folder.exists()) {
            folder.mkdirs();
        }

        if(folder.list() != null && !Arrays.stream(folder.list()).toList().isEmpty()) {
            for (File file : folder.listFiles()) {
                URLClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()}, getClass().getClassLoader());

                JarFile jarFile = new JarFile(file);

                Enumeration<JarEntry> entries = jarFile.entries();

                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();

                    if(!entry.getName().endsWith(".class")) continue;

                    String className = entry.getName().replace("/", ".").replace(".class", "");
                    Bukkit.getLogger().info(className);
                    Class<?> clazz = classLoader.loadClass(className);

                    PannoniaModule module = (PannoniaModule) clazz.getDeclaredConstructor().newInstance();

                    module.setInstance(plugin);
                    module.loadConfig();
                }
                classLoader.close();
            }
        }
    }

    public Main getPlugin() {
        return plugin;
    }
}
