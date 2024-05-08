package hhitt.coliseo.commands;

import hhitt.coliseo.Coliseo;
import org.bukkit.entity.Player;

public class ArenaManager {
    private Coliseo plugin;
    private String spawn1;
    private String spawn2;

    public ArenaManager(Coliseo plugin) {
        this.plugin = plugin;
    }

    public boolean setArenaPoint1(Player sender){

        //Check that player has permission to perform the command
        if(!(sender.hasPermission("Coliseo.admin"))){
            sender.sendMessage(plugin.getConfig().getString("Messages.No_Permission"));
            return true;
        }

        //Get the coords for the point of spawn for sender (player1)
        spawn1 = sender.getLocation().toString();
        plugin.getConfig().set("Spawn_Locations.player1", spawn1);
        return true;
    }

    public boolean setArenaPoint2(Player sender){

        //Check that player has permission to perform the command
        if(!(sender.hasPermission("Coliseo.admin"))){
            sender.sendMessage(plugin.getConfig().getString("Messages.No_Permission"));
            return true;
        }

        //Get the coords for the point of spawn for sender (player1)
        spawn2 = sender.getLocation().toString();
        plugin.getConfig().set("Spawn_Locations.player2", spawn2);
        return true;
    }
}
