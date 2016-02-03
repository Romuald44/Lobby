/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Romuald
 */
public class CmdManager implements CommandExecutor {
    
    private Location spawn_start = new Location(Bukkit.getWorld("World"), 0.5, 101, 0.5);
    private Location choice_class = new Location(Bukkit.getWorld("World"), 500.5, 101, 500.5);
    private SkyWars game;
    
    public CmdManager() {
        game = Lobby.getSW();
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        
        if(cmd.getName().equalsIgnoreCase("hub") && sender instanceof Player) {
            if(p.getWorld().equals("SkyBool1")) {
                game.removePlayer(p);
            }
            p.teleport(spawn_start);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au spawn");
        }
        else if(cmd.getName().equalsIgnoreCase("pvp") && sender instanceof Player) {
            p.teleport(choice_class);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au lobby PVP");
        }
        return false;
    }
}
