/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
    
    private static Lobby plugin;
    private SkyWars game;
    
    public CmdManager() {
        plugin = Lobby.get();
        game = Lobby.get().getSW();
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        
        if(cmd.getName().equalsIgnoreCase("hub") && sender instanceof Player) {
            if(p.getWorld().getName().equalsIgnoreCase("world")) {
                p.setGameMode(GameMode.SURVIVAL);//Mettre le joueur en survie
                p.getInventory().clear();//Vider l'inventaire
                p.getInventory().setArmorContents(null);//A poil !
                p.teleport(plugin.getSpawn());
                p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au HUB");
            }
        }
        else if(cmd.getName().equalsIgnoreCase("pvp") && sender instanceof Player) {
            p.teleport(plugin.getLobbyPVP());
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au lobby PVP");
        }
        else if(cmd.getName().equalsIgnoreCase("exia") && sender instanceof Player) {
            p.teleport(new Location(Bukkit.getWorld("exia"), 0, 4, 0));
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter à l'exia");
        }
        return false;
    }
}
