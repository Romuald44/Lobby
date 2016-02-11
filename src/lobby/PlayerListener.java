/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobby;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Romuald
 */
class PlayerListener implements Listener {

    private static Location spawn_start = new Location(Bukkit.getWorld("world"), 0.5, 101, 0.5);
    private static Location choice_class = new Location(Bukkit.getWorld("world"), 500.5, 96, 500.5);
    private static Location choice_skywars = new Location(Bukkit.getWorld("world"), -498.5, 103, -501.5);
    private static Location map_pvp = new Location(Bukkit.getWorld("world"), 500.5, 101, -500.0);
    
    private static Lobby plugin;
    private SkyWars game;
            
    public PlayerListener() {
        plugin = Lobby.get();
        game = Lobby.get().getSW();
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        p.teleport(spawn_start);
        sendTitle(p, ChatColor.GREEN + "Bienvenue", ChatColor.BLUE + p.getName(), 20, 50, 20);
        p.sendMessage("Développement par : "+ChatColor.GREEN+"EpicSaxGuy, MrTwixo, Guitou388");
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().getName().equalsIgnoreCase("world") || p.getWorld().getName().equalsIgnoreCase("exia")) {
        
        /*p.sendMessage("X : "+p.getLocation().getBlockX());
        p.sendMessage("Y : "+p.getLocation().getBlockY());
        p.sendMessage("Z : "+p.getLocation().getBlockZ());*/
        
            if((p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 102) &&
               (p.getLocation().getBlockZ() == 12) ||
                    (p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 103) &&
               (p.getLocation().getBlockZ() == 12) ||
                    (p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 104) &&
               (p.getLocation().getBlockZ() == 12)) {

                for (PotionEffect effect : p.getActivePotionEffects()) {
                    p.removePotionEffect(effect.getType());
                }
                p.teleport(choice_class);
                sendTitle(p, ChatColor.GOLD + "Mode PVP", ChatColor.RED + "Choississez votre classe", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 102) &&
               (p.getLocation().getBlockZ() == -12) ||
                    (p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 103) &&
               (p.getLocation().getBlockZ() == -12) ||
                    (p.getLocation().getBlockX() == -12) &&
               (p.getLocation().getBlockY() == 104) &&
               (p.getLocation().getBlockZ() == -12)) {

                for (PotionEffect effect : p.getActivePotionEffects()) {
                    p.removePotionEffect(effect.getType());
                }
                p.teleport(choice_skywars);
                sendTitle(p, ChatColor.GOLD + "Mode SkyWars", "", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 501) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 500) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 499) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 489) ||
                    (p.getLocation().getBlockX() == 501) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 500) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 499) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 489) ||
                    (p.getLocation().getBlockX() == 501) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 500) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 489) || (p.getLocation().getBlockX() == 499) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 489)) {

                p.teleport(map_pvp);
                stuffArcher(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Archer", ChatColor.RED + "Ca va gicler !", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 491) ||
                    (p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 491) ||
                    (p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 491)) {

                p.teleport(map_pvp);
                stuffBourrin(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Bourrin", ChatColor.RED + "Tape dans le fond chui pas ta mère !", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 501) ||
                    (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 501) ||
                    (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 511) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 501)) {

                p.teleport(map_pvp);
                stuffAssassin(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Assassin", ChatColor.RED + "Prendre par derrière ça fait mal", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 509) ||
                    (p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 509) ||
                    (p.getLocation().getBlockX() == 509) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 509)) {

                p.teleport(map_pvp);
                stuffTank(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Tank", ChatColor.RED + "Prêt à recevoir ?", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 501) ||
                    (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 501) ||
                    (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 499) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 500) || (p.getLocation().getBlockX() == 489) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 501)) {

                p.teleport(map_pvp);
                stuffNormal(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Normal", ChatColor.RED + "Pour des gens normaux... Ou presque !", 20, 50, 20);
            }
            else if((p.getLocation().getBlockX() == 491) &&
               (p.getLocation().getBlockY() == 99) &&
               (p.getLocation().getBlockZ() == 491) ||
                    (p.getLocation().getBlockX() == 491) &&
               (p.getLocation().getBlockY() == 100) &&
               (p.getLocation().getBlockZ() == 491) ||
                    (p.getLocation().getBlockX() == 491) &&
               (p.getLocation().getBlockY() == 101) &&
               (p.getLocation().getBlockZ() == 491)) {

                p.teleport(map_pvp);
                stuffPopo(p);
                sendTitle(p, ChatColor.GREEN + "Classe "+ ChatColor.BLUE + "Potions", ChatColor.RED + "La drogue c mal ! mvoyez", 20, 50, 20);
            }
        }
    }
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = event.getEntity().getPlayer();
            if(player.getWorld().getName().equals("world")) {
                player.teleport(spawn_start);
            }
        }
    }
    
    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
            if(ent.getWorld().getName().equals("world") || ent.getWorld().getName().equals("exia")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if(e.getWorld().getName().equals("world") || e.getWorld().getName().equals("exia")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity damager = e.getDamager();
        if(ent instanceof Player && damager instanceof Player) {
            if(ent.getWorld().getName().equals("world") || ent.getWorld().getName().equals("exia")) {
                e.setCancelled(true); 
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
           if(ent.getWorld().getName().equals("world") || ent.getWorld().getName().equals("exia")) {
               if (e.getCause().equals(DamageCause.FALL)) {
                   e.setCancelled(true);
               }
               else if (!e.getCause().equals(DamageCause.VOID)) {
                   e.setCancelled(true);
               }
           }
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if((player.getWorld().getName().equals("world") || player.getWorld().getName().equals("exia")) && player.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if((player.getWorld().getName().equals("world") || player.getWorld().getName().equals("exia")) && player.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }
	
    @EventHandler 
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if((player.getWorld().getName().equals("world") || player.getWorld().getName().equals("exia")) && player.getGameMode() == GameMode.SURVIVAL) {
            
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(e.getClickedBlock().getType() == Material.WALL_SIGN) {
                Sign s = (Sign) e.getClickedBlock().getState();
                    if(s.getLine(0).equalsIgnoreCase("SkyWars")) {
                        if(s.getLine(1).equalsIgnoreCase("TempleRun")) {
                            s.setLine(0, ChatColor.BLUE+"§lSkyWars");
                            s.setLine(1, ChatColor.DARK_RED+"TempleRun");
                            s.setLine(2, ChatColor.DARK_RED+"Disponible");
                            s.setLine(3, ChatColor.BLUE+"§l0 / 4");
                            s.update();
                        }
                        else if(s.getLine(1).equalsIgnoreCase("SkyBool")) {
                            s.setLine(0, ChatColor.BLUE+"§lSkyWars");
                            s.setLine(1, ChatColor.DARK_RED+"SkyBool");
                            s.setLine(2, ChatColor.DARK_RED+"Disponible");
                            s.setLine(3, ChatColor.BLUE+"§l0 / 8");
                            s.update();
                        }
                    }
                    else {
                        e.setCancelled(true);
                    }
                }
                else {
                    e.setCancelled(true);
                }
            }
        }
    }
    
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if((player.getWorld().getName().equals("world") || player.getWorld().getName().equals("exia")) && player.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if((player.getWorld().getName().equals("world") || player.getWorld().getName().equals("exia")) && player.getGameMode() == GameMode.SURVIVAL) {
            e.setCancelled(true);
        }
    }
    
    public void hologramme(Player p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        
        sb.append("PVP");
        sb1.append("SkyWars");
        String name_pvp = sb.toString();
        String name_skw = sb1.toString();
        
        ArmorStand pvp = Bukkit.getWorld(p.getWorld().getName()).spawn(new Location(Bukkit.getWorld("World"), -11.5, 102, 12.5), ArmorStand.class);
        ArmorStand skw = Bukkit.getWorld(p.getWorld().getName()).spawn(new Location(Bukkit.getWorld("World"), -11.5, 102, -11.5), ArmorStand.class);
        pvp.setVisible(false);
        pvp.setCustomName(name_pvp);
        pvp.setCustomNameVisible(true);
        
        skw.setVisible(false);
        skw.setCustomName(name_skw);
        skw.setCustomNameVisible(true);
    }
    
    public void sendTitle(Player p, String title, String subTitle, int fadeIn, int duration, int fadeOut)
    {
            CraftPlayer craftplayer = (CraftPlayer)p;
            PlayerConnection connection = craftplayer.getHandle().playerConnection;
            IChatBaseComponent titleJSON = IChatBaseComponent.ChatSerializer.a("{'text': '" + title + "'}");
            IChatBaseComponent subtitleJSON = IChatBaseComponent.ChatSerializer.a("{'text': '" + subTitle + "'}");
            PacketPlayOutTitle timesPacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, titleJSON, fadeIn, duration, fadeOut);
            PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleJSON);
            PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleJSON);
            connection.sendPacket(timesPacket);
            connection.sendPacket(titlePacket);
            connection.sendPacket(subtitlePacket);
    }
    
    public void stuffArcher(Player p) {
        ItemStack arc = new ItemStack(Material.BOW);
        arc.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        arc.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
        arc.getItemMeta().spigot().setUnbreakable(true);

        ItemStack fleche = new ItemStack(Material.ARROW);

        ItemStack sign = new ItemStack(Material.SIGN);
        sign.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
        sign.getItemMeta().spigot().setUnbreakable(true);

        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        helmet.getItemMeta().spigot().setUnbreakable(true);

        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.getItemMeta().spigot().setUnbreakable(true);

        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        leggings.getItemMeta().spigot().setUnbreakable(true);

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.getItemMeta().spigot().setUnbreakable(true);

        p.getInventory().clear();//Vider l'inventaire
        p.getInventory().addItem(new ItemStack[] { arc, fleche, sign });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { boots, leggings, chestplate, helmet  });//Enfilé l'équipement sur le joueur
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }

    public void stuffBourrin(Player p) {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
        sword.getItemMeta().spigot().setUnbreakable(true);

        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        helmet.getItemMeta().spigot().setUnbreakable(true);

        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        chestplate.getItemMeta().spigot().setUnbreakable(true);

        ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        leggings.getItemMeta().spigot().setUnbreakable(true);

        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        boots.getItemMeta().spigot().setUnbreakable(true);

        p.getInventory().clear();//Vider l'inventaire
        p.getInventory().addItem(new ItemStack[] { sword });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { boots, leggings, chestplate, helmet });//Enfilé l'équipement sur le joueur
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }

    public void stuffTank(Player p) {
        ItemStack daxe = new ItemStack(Material.WOOD_AXE);
        daxe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        
        ItemStack dhelmet = new ItemStack(Material.DIAMOND_HELMET);
        dhelmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        dhelmet.getItemMeta().spigot().setUnbreakable(true);
        
        ItemStack dchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        dchestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        dchestplate.getItemMeta().spigot().setUnbreakable(true);
        
        ItemStack dleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        dleggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        dleggings.getItemMeta().spigot().setUnbreakable(true);
        
        ItemStack dboots = new ItemStack(Material.DIAMOND_BOOTS);
        dboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        dboots.getItemMeta().spigot().setUnbreakable(true);
        
        p.getInventory().clear();//Vider l'inventaire
        p.getInventory().addItem(new ItemStack[] { daxe });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { dboots, dleggings, dchestplate, dhelmet });//Enfilé l'équipement sur le joueur
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }

    public void stuffNormal(Player p) {
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        sword.getItemMeta().spigot().setUnbreakable(true);

        ItemStack arc = new ItemStack(Material.BOW);
        arc.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
        arc.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
        arc.getItemMeta().spigot().setUnbreakable(true);

        ItemStack fleche = new ItemStack(Material.ARROW);

        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        helmet.getItemMeta().spigot().setUnbreakable(true);

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.getItemMeta().spigot().setUnbreakable(true);

        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        leggings.getItemMeta().spigot().setUnbreakable(true);

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.getItemMeta().spigot().setUnbreakable(true);

        p.getInventory().clear();//Vider l'inventaire
        p.getInventory().addItem(new ItemStack[] { sword, arc, fleche });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { boots, leggings, chestplate, helmet });//Enfilé l'équipement sur le joueur
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }

    public void stuffAssassin(Player p) {
        ItemStack armor = new ItemStack(Material.AIR);
        
        ItemStack spade = new ItemStack(Material.DIAMOND_SPADE);
        spade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        spade.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        spade.getItemMeta().spigot().setUnbreakable(true);

        ItemStack briquet = new ItemStack(Material.FLINT_AND_STEEL);
        briquet.getItemMeta().spigot().setUnbreakable(true);

        p.getInventory().clear();//Vider l'inventaire
        p.getInventory().addItem(new ItemStack[] { spade, briquet });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { armor, armor, armor, armor });//Enfilé l'équipement sur le joueur
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }
    
    public void stuffPopo(Player p) {
        
        ItemStack poison = new ItemStack(Material.POTION, 2, (short) 16452); //Poison 1:30
        
        ItemStack soin = new ItemStack(Material.POTION, 2, (short) 16421); //Soin Instant 2
        
        ItemStack jump = new ItemStack(Material.POTION, 1, (short) 16427); //Saut 2 1:07
        
        ItemStack speed = new ItemStack(Material.POTION, 2, (short) 16418); //Vitesse 2
        
        ItemStack lent = new ItemStack(Material.POTION, 1, (short) 16392); //Lenteur 2
        
        ItemStack damage = new ItemStack(Material.POTION, 1, (short) 16428); //Dommage 2
        
        ItemStack regen = new ItemStack(Material.POTION, 1, (short) 16417); //Regénération 2
        
        ItemStack spade = new ItemStack(Material.IRON_SPADE);
        
        ItemStack armor = new ItemStack(Material.AIR);
        
        spade.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        spade.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        spade.getItemMeta().spigot().setUnbreakable(true);
        
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        
        p.getInventory().clear();//Vider l'inventaire
        
        p.getInventory().addItem(new ItemStack[] { poison, soin, jump, speed, lent, damage, regen });//Ajouter l'épée dans l'inventaire
        p.getInventory().setArmorContents(new ItemStack[] { armor, armor, armor, armor });//Enfilé l'équipement sur le joueur
        
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 18000, 0));
        p.updateInventory();//Mettre à jour l'inventaire
    }
    
}
