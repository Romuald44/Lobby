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
import org.bukkit.potion.PotionEffect;

/**
 *
 * @author Romuald
 */
public class CmdManager implements CommandExecutor {
    
    private static Location spawn_start = new Location(Bukkit.getWorld("world"), 0.5, 101, 0.5);
    private static Location choice_class = new Location(Bukkit.getWorld("world"), 500.5, 96, 500.5);
    private static Location choice_skywars = new Location(Bukkit.getWorld("world"), -498.5, 103, -501.5);
    private static Location map_pvp = new Location(Bukkit.getWorld("world"), 500.5, 101, -500.0);
    
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
            if(p.getWorld().getName().equalsIgnoreCase("world") ||
               p.getWorld().getName().equalsIgnoreCase("exia") ||
               p.getWorld().getName().equalsIgnoreCase("templerun1") ||
                p.getWorld().getName().equalsIgnoreCase("prairie1") ||
                p.getWorld().getName().equalsIgnoreCase("netherwars1")) {
                p.setGameMode(GameMode.SURVIVAL);//Mettre le joueur en survie
                p.getInventory().clear();//Vider l'inventaire
                p.getInventory().setArmorContents(null);//A poil !
                for (PotionEffect effect : p.getActivePotionEffects()) {
                    p.removePotionEffect(effect.getType());
                }
                p.teleport(spawn_start);
                p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au HUB");
            }
        }
        else if(cmd.getName().equalsIgnoreCase("exia") && sender instanceof Player) {
            p.teleport(new Location(Bukkit.getWorld("exia"), 0, 4, 0));
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter à l'exia");
        }
        else if(cmd.getName().equalsIgnoreCase("templerun") && sender instanceof Player) {
            p.teleport(new Location(Bukkit.getWorld("templerun1"), -204, 22, -624));
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au TempleRun");
        }
        else if(cmd.getName().equalsIgnoreCase("prairie") && sender instanceof Player) {
            p.teleport(new Location(Bukkit.getWorld("prairie1"), -204, 22, -624));
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter a la Prairie");
        }
        else if(cmd.getName().equalsIgnoreCase("netherwars") && sender instanceof Player) {
            p.teleport(new Location(Bukkit.getWorld("netherwars1"), -30, 17, -1090));
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.RED+p.getName()+ChatColor.RESET+" Téléporter au NetherWars");
        }
        return false;
    }
}
