package net.guns.main;

import net.guns.main.utils.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class playerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public playerJoin(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		playerJoin.giveItems(p);
	}
	
	public static void giveItems(Player p){
		ItemStack selector = util.createItem(Material.COMPASS,1,0,util.color("&c&lGun Selector &e- &b&lRight Click"), null);
	
		p.getInventory().setItem(0, selector);
	}

}
