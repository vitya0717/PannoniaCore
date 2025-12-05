package org.vitya0717.pannoniaCore.moduleManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.vitya0717.pannoniaCore.Main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModuleManager {

    private final Main plugin;
    private final List<String> enabledModules = List.of("Test.jar");


    public ModuleManager(Main plugin) {
        this.plugin = plugin;
    }


    public void LoadModules() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File folder = new File(plugin.getDataFolder(), "modules");
        if (!folder.exists()) folder.mkdirs();

        File[] files = folder.listFiles(f -> f.getName().endsWith(".jar"));
        if (files == null || files.length == 0) return;

        URL[] urls = Arrays.stream(files)
                .map(f -> {
                    try {
                        return f.toURI().toURL();
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }).toArray(URL[]::new);

        try (URLClassLoader classLoader = new URLClassLoader(urls, getClass().getClassLoader())) {

            for (File file : files) {
                try (JarFile jarFile = new JarFile(file)) {

                    Enumeration<JarEntry> entries = jarFile.entries();

                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();

                        if (entry.isDirectory() || !entry.getName().endsWith(".class")) continue;

                        String className = entry.getName().replace('/', '.').substring(0, entry.getName().length() - 6);
                        Class<?> clazz = classLoader.loadClass(className);

                        if (PannoniaModule.class.isAssignableFrom(clazz) && !clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())) {

                            Bukkit.getLogger().info("Loading module: " + clazz.getSimpleName());

                            PannoniaModule module = (PannoniaModule) clazz.getDeclaredConstructor().newInstance();
                            module.setInstance(plugin);
                            module.onEnable();
                        }
                    }
                }
            }
        }
    }

    public Main getPlugin() {
        return plugin;
    }
}
