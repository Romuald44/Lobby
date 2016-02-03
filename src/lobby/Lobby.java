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
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Romuald
 */
public class Lobby extends JavaPlugin {
    
    private Location spawn_start = new Location(Bukkit.getWorld("World"), 0.5, 101, 0.5);
    private Location choice_class = new Location(Bukkit.getWorld("World"), 500.5, 101, 500.5);
    private Location choice_skywars = new Location(Bukkit.getWorld("World"), -498.5, 103, -501.5);
    private Location plateform = new Location(Bukkit.getWorld("World"), 21, 101, -55);
    private CmdManager cmd;
    private SkyWars game;
    private static Lobby instance;
    
    //Méthode d'activation
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getWorld("World").setPVP(false);
        //Message en vert
        Bukkit.getConsoleSender().sendMessage("§aLobby actif!");
        cmd = new CmdManager();
        game = new SkyWars();
        
        getCommand("hub").setExecutor(cmd);
        getCommand("pvp").setExecutor(cmd);
        
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    }
    
    //Méthode de désactivation
    @Override
    public void onDisable() {
        //Message en rouge
        Bukkit.getConsoleSender().sendMessage("§aLobby desactive");
    }
    
    public static CmdManager getCmd() {
        return instance.cmd;
    }
    
    public Location getSpawn() {
        return spawn_start;
    }
    
    public static SkyWars getSW() {
        return instance.game;
    }
    
    public static Lobby get() {
        return instance;
    }
}
