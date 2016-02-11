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
    
    private static Lobby instance;
    private SkyWars game;
    
    //Méthode d'activation
    @Override
    public void onEnable() {
        instance = this;
        game = new SkyWars();
        
        createExia();
        
        this.getServer().getWorld("world").setPVP(false);
        this.getServer().getWorld("world").setStorm(false);
        this.getServer().getWorld("world").setThundering(false);
        this.getServer().getWorld("world").setWeatherDuration(Integer.MAX_VALUE);
        this.getServer().getWorld("World").setAutoSave(false);
        this.getServer().getWorld("world").setGameRuleValue("doDaylightCycle ", "false");
        
        //Message en vert
        Bukkit.getConsoleSender().sendMessage("§aLobby actif!");
        
        this.getCommand("hub").setExecutor(new CmdManager());
        this.getCommand("exia").setExecutor(new CmdManager());
        this.getCommand("templerun").setExecutor(new CmdManager());
        this.getCommand("prairie").setExecutor(new CmdManager());
        this.getCommand("netherwars").setExecutor(new CmdManager());
        
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    }
    
    //Méthode de désactivation
    @Override
    public void onDisable() {
        //Message en rouge
        Bukkit.getConsoleSender().sendMessage("§aLobby desactive");
    }
    
    public void createExia() {
        WorldCreator worldCreator = new WorldCreator("exia");
        worldCreator.generateStructures(false);
	World world = worldCreator.createWorld();
    }
    
    public static Lobby get() {
        return instance;
    }
    
    public SkyWars getSW() {
        return game;
    }
}
