package net.guns.main.handlers;

import java.util.HashMap;

import net.guns.main.main;
import net.guns.main.menus.gunMenu;
import net.guns.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class itemHandler implements Listener {
	private main plugin;

	public itemHandler(main hub) {
		this.plugin = hub;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void gunMenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(util.color("&c&lGun Selector &e- &b&lRight Click"))){
							gunMenu.Menu(e.getPlayer());
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void gunHandler(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.PHYSICAL) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.WOOD_HOE || e.getPlayer().getItemInHand().getType() == Material.STONE_HOE || e.getPlayer().getItemInHand().getType() == Material.IRON_HOE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_HOE) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(util.color("&c&lGun 1")) || e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(util.color("&c&lGun 2")) || e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(util.color("&c&lGun 3")) || e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(util.color("&c&lGun 4"))){
							Entity bullet = e.getPlayer().getWorld().spawnEntity(e.getPlayer().getEyeLocation(), EntityType.SNOWBALL);
							bullet.setVelocity(e.getPlayer().getLocation().getDirection().normalize().multiply(5));
						}
					}
				}
			}
		}
	}
	
	public static HashMap<String, BukkitTask> Bullets = new HashMap<String, BukkitTask>();
	public static HashMap<String, String> crateFired = new HashMap<String, String>();
	@EventHandler
	public void crateHandler(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getHand() == EquipmentSlot.HAND){
			if (e.getClickedBlock() != null) {
				if (e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME){
				if(!crateFired.containsKey("inUse")){
					crateFired.put("inUse", "true");
					final ShulkerBullet bullet = (ShulkerBullet) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ShulkerBullet.class);
					bullet.setCustomName(util.color("&eCALCULATING"));
					bullet.setCustomNameVisible(true);
					bullet.setGlowing(true);
					e.getPlayer().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_SHULKER_OPEN, Integer.MAX_VALUE, Integer.MAX_VALUE);
					BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
					Bullets.put("starter", scheduler.runTaskTimer(plugin, new Runnable() {
								public void run() {
									bullet.setVelocity(new Vector(0,0.04,0));
								}
					}, 0, 1L));
					Bullets.put("particles", scheduler.runTaskTimer(plugin, new Runnable() {
						public void run() {
							bullet.getWorld().playEffect(bullet.getLocation().add(0, 0.2, 0), Effect.WITCH_MAGIC, Integer.MAX_VALUE);
						}
			}, 0, 1L));
					Bullets.put("name", scheduler.runTaskTimer(plugin, new Runnable() {
						public void run() {
							if(bullet.getCustomName().equals(util.color("&eCALCULATING"))){
								bullet.setCustomName(util.color("&aCALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&aCALCULATING"))){
								bullet.setCustomName(util.color("&bCALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&bCALCULATING"))){
								bullet.setCustomName(util.color("&cCALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&cCALCULATING"))){
								bullet.setCustomName(util.color("&dCALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&dCALCULATING"))){
								bullet.setCustomName(util.color("&5CALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&5CALCULATING"))){
								bullet.setCustomName(util.color("&6CALCULATING"));
								bullet.setCustomNameVisible(true);
							}else if(bullet.getCustomName().equals(util.color("&6CALCULATING"))){
								bullet.setCustomName(util.color("&eCALCULATING"));
								bullet.setCustomNameVisible(true);
							}
						}
			}, 0, 2L));
					scheduler.runTaskLater(plugin, new Runnable() {
						public void run() {
							Bullets.get("starter").cancel();
							Bullets.get("particles").cancel();
							Bullets.get("name").cancel();
							final ArmorStand stand = (ArmorStand) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ArmorStand.class);
							stand.setCustomName(util.color("&cClick to open a crate!"));
							stand.setCustomNameVisible(true);
							stand.setGravity(false);
							stand.setVisible(false);
							bullet.getWorld().playEffect(bullet.getLocation().add(0, 0.2, 0), Effect.CLOUD, Integer.MAX_VALUE);
						}
			}, 5 * 20);
					scheduler.runTaskLater(plugin, new Runnable() {
						public void run() {
							bullet.remove();
							final ArmorStand stand = (ArmorStand) e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0.5, 1.5, 0.5), ArmorStand.class);
							stand.remove();
							crateFired.remove("inUse");
							e.getPlayer().playSound(e.getClickedBlock().getLocation(), Sound.ENTITY_ITEM_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
							e.getPlayer().sendMessage(util.color("&eMay click crate again!"));
						}
			}, 7 * 20);
				}else{
					e.getPlayer().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_LAVA_EXTINGUISH, Integer.MAX_VALUE, Integer.MAX_VALUE);
					e.getPlayer().sendMessage(util.color("&cCrate is already in use!"));
				}
			}
		}
		}
		}
	}
	
	
	@EventHandler
    public void onBlockadEvent(EntityDeathEvent e){
		Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        if(e.getEntityType() == EntityType.SHULKER_BULLET){
        	e.getEntity().setHealth(20);
        	Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        }
    }
	
	@EventHandler
    public void asdf(EntityDamageEvent e){
		Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        if(e.getEntityType() == EntityType.SHULKER_BULLET){
        	Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        }
    }
	
	@EventHandler
    public void asdf(EntityCombustEvent e){
		Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
		if(e.getEntityType() == EntityType.SHULKER_BULLET){
        	Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        }
		if(e.getEntity() instanceof ShulkerBullet){
        	Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        }
    }
	
	@EventHandler
    public void asdf(EntityDamageByEntityEvent e){
		Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        if(e.getEntityType() == EntityType.SHULKER_BULLET){
        	Bukkit.getServer().broadcastMessage("ITS A SHULKER BULLET");
        }
    }
	
}