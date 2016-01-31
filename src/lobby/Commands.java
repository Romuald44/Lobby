/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Romuald
 */
public class Commands {
    
    public void InstanceSkyWars(Player p) {
        //Plugin test = Bukkit.getPluginManager().getPlugin("SkyWars");
        //test.onEnable();
        Bukkit.dispatchCommand(p, "skywars");
    }
    
    public void addSkyWars(Player p) {
        //Plugin test = Bukkit.getPluginManager().getPlugin("SkyWars");
        p.sendMessage("Ok pour la commands");
        //Bukkit.dispatchCommand(p, "skywars enter");
    }
    
}
