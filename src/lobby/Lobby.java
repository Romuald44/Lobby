/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Romuald
 */
public class Lobby extends JavaPlugin {
    
    private static Location spawn_start = new Location(Bukkit.getWorld("World"), 0.5, 101, 0.5);
    private static Location choice_class = new Location(Bukkit.getWorld("World"), 500.5, 101, 500.5);
    private static Location choice_skywars = new Location(Bukkit.getWorld("World"), -498.5, 103, -501.5);
    private static Location map_pvp = new Location(Bukkit.getWorld("World"), 21, 101, -55);
    
    private SkyWars game;
    private static Lobby instance;
    
    //Méthode d'activation
    @Override
    public void onEnable() {
        instance = this;
        
        WorldCreator worldCreator = new WorldCreator("exia");
        worldCreator.generateStructures(false);
	World world = worldCreator.createWorld();
        
        this.getServer().getWorld("World").setPVP(false);
        this.getServer().getWorld("World").setStorm(false);
        this.getServer().getWorld("World").setThundering(false);
        this.getServer().getWorld("World").setWeatherDuration(Integer.MAX_VALUE);
        this.getServer().getWorld("World").setAutoSave(false);
        this.getServer().getWorld("World").setGameRuleValue("doDaylightCycle ", "false");
        
        //Message en vert
        Bukkit.getConsoleSender().sendMessage("§aLobby actif!");
        game = new SkyWars();
        
        this.getCommand("hub").setExecutor(new CmdManager());
        this.getCommand("pvp").setExecutor(new CmdManager());
        this.getCommand("exia").setExecutor(new CmdManager());
        
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    }
    
    //Méthode de désactivation
    @Override
    public void onDisable() {
        //Message en rouge
        Bukkit.getConsoleSender().sendMessage("§aLobby desactive");
    }
    
    public static Lobby get() {
        return instance;
    }
    
    public SkyWars getSW() {
        return game;
    }
    
    public Location getSpawn() {
        return spawn_start;
    }
    
    public Location getLobbyPVP() {
        return choice_class;
    }
    
    public Location getLobbySW() {
        return choice_skywars;
    }
    
    public Location getMapPVP() {
        return map_pvp;
    }
}
