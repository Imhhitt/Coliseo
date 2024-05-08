package hhitt.coliseo.commands;

import hhitt.coliseo.Coliseo;
import hhitt.coliseo.utils.MessageUtils;
import hhitt.coliseo.utils.SaveLocation;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColiseoCommand implements CommandExecutor {

    //IMPORTANT: sender = player who send fight request & player2 is the player who gets the fight request.


    private Coliseo plugin;
    public ColiseoCommand(Coliseo plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        ArenaManager arenaManager = new ArenaManager(plugin);

        // Sender must be a player
        if(!(sender instanceof Player)){
            Bukkit.getLogger().info("no consola");
            return true;
        }

        //Player permission check
        if(!(sender.hasPermission("Coliseo.fight.request")) | !(sender.hasPermission("Coliseo.fight"))){
            sender.sendMessage(MessageUtils.getColoredMessages("no permiso"));
            return true;
        }

        //Check that the command isn't "/Coliseo" (need a player as argument)
        if(args.length == 0){
            sender.sendMessage("mensaje de mal comando");
            return true;
        }

        //Fight command is correct
        if(args.length == 1){

            //Verify if the arg is a valid player
            Player player2 = Bukkit.getPlayer(args[0]);
            if(player2 == null){
                sender.sendMessage("mensaje de jugador no encontrado");
                return true;
            }

            //Save the players locations with the method to tp back while fight finished
            new SaveLocation((Player) sender, player2);

        }

        //Command for manage spawn
        if(args.length >=2){

            //Set position of tp to player1 (sender)
            if(args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase("spawn1")){
                arenaManager.setArenaPoint1((Player) sender);
            }

            //Set position of tp to player2 (who accepts)
            if(args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase("spawn2")){
                arenaManager.setArenaPoint2((Player) sender);
            }

        }

        return true;
    }
}
