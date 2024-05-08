package hhitt.coliseo;

import hhitt.coliseo.commands.ColiseoCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Coliseo extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("Coliseo").setExecutor(new ColiseoCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
