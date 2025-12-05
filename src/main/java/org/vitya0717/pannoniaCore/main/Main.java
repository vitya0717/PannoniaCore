package org.vitya0717.pannoniaCore.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.vitya0717.pannoniaCore.moduleManager.ModuleManager;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {


    private Main plugin;
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {
       this.plugin = this; // set the plugin instance

        moduleManager = new ModuleManager(this);
        //IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
        try {
            moduleManager.LoadModules(); // load plugin modules
        } catch (Exception e) {
            Logger.getLogger("ModuleLoader").severe("Error occurred while trying to load modules.");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        this.plugin = null; //remove plugin instance
    }

    public Main getPlugin() {
        return plugin;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
