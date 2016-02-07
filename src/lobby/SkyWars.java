/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author Romuald
 */
public class SkyWars {
    
    public SkyWars() {
        
    }
    
    public void InstanceSkyWars(Player p) {
        Bukkit.dispatchCommand(p, "skywars");
    }
    
    public void addSkyWars(Player p) {
        Bukkit.dispatchCommand(p, "skybool enter");
    }
    
    public void removePlayer(Player p) {
        Bukkit.dispatchCommand(p, "skybool rmplayer");
    }
}
