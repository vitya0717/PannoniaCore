package org.vitya0717.pannoniaCore.moduleManager;

import org.vitya0717.pannoniaCore.Main;

public interface PannoniaModule {

    void setInstance(Main plugin);
    void loadConfig();
    void onEnable();
}
