package net.guns.main.menus;

import net.guns.main.main;
import net.guns.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class gunMenu implements Listener{
	
	public static Inventory inv;
	
	@SuppressWarnings("unused")
	private main plugin;
	public gunMenu(main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 45, util.color("&c&lGun Menu"));
		Border();
		oneGun();
		twoGun();
		threeGun();
		fourGun();
		p.openInventory(inv);
	}
	
	public static void Border(){
		ItemStack border = util.createItem(Material.STAINED_GLASS_PANE, 1, 15, util.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void oneGun(){
		ItemStack item = util.createItem(Material.WOOD_HOE, 1, 0, util.color("&c&lGun 1"), null);
		inv.setItem(19, item);
	}
	
	public static void twoGun(){
		ItemStack item = util.createItem(Material.STONE_HOE, 1, 0, util.color("&c&lGun 2"), null);
		inv.setItem(21, item);
	}
	
	public static void threeGun(){
		ItemStack item = util.createItem(Material.IRON_HOE, 1, 0, util.color("&c&lGun 3"), null);
		inv.setItem(23, item);
	}
	
	public static void fourGun(){
		ItemStack item = util.createItem(Material.DIAMOND_HOE, 1, 0, util.color("&c&lGun 4"), null);
		inv.setItem(25, item);
	}
	
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(util.color("&c&lGun Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(!(e.getInventory() == null)){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							
							
							
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(util.color(" "))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.WOOD_HOE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(util.color("&c&lGun 1"))){
									e.setCancelled(true);
									p.getInventory().addItem(util.createItem(Material.WOOD_HOE, 1, 0, util.color("&c&lGun 1"), null));
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.STONE_HOE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(util.color("&c&lGun 2"))){
									e.setCancelled(true);
									p.getInventory().addItem(util.createItem(Material.STONE_HOE, 1, 0, util.color("&c&lGun 2"), null));
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.IRON_HOE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(util.color("&c&lGun 3"))){
									e.setCancelled(true);
									p.getInventory().addItem(util.createItem(Material.IRON_HOE, 1, 0, util.color("&c&lGun 3"), null));
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.DIAMOND_HOE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(util.color("&c&lGun 4"))){
									e.setCancelled(true);
									p.getInventory().addItem(util.createItem(Material.DIAMOND_HOE, 1, 0, util.color("&c&lGun 4"), null));
								}
							}
							
							
						}else{
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
						}
					}else{
						e.setCancelled(true);
						p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Integer.MAX_VALUE, Integer.MAX_VALUE);
					}
				}else{
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}

}
