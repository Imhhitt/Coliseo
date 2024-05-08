package hhitt.coliseo.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SaveLocation {

    private Location player1Location;
    private Location player2Location;


    //Save the coords of the players to come back
    public SaveLocation(Player sender, Player player2) {
        player1Location = sender.getLocation();
        player2Location = player2.getLocation();
    }


    public Location getPlayer1Location(){
        return  player1Location;
    }
    public Location getPlayer2Location(){
        return  player2Location;
    }
}
