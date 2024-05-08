package hhitt.coliseo.config;

import hhitt.coliseo.Coliseo;
import org.bukkit.configuration.file.FileConfiguration;

public class MainConfigManager {
    private final MainConfig configFile;

    public MainConfigManager(Coliseo Coliseo) {
        configFile = new MainConfig("config.yml", null, Coliseo);
        configFile.registerConfig();
        loadConfig();
    }
    public void loadConfig(){
        FileConfiguration configuration = configFile.getConfig();
    }
    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }
    public String getString(String s) {
        return s;
    }
}
