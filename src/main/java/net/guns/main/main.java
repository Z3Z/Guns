package net.guns.main;

import net.guns.main.handlers.itemHandler;
import net.guns.main.menus.gunMenu;
import net.guns.main.utils.packets;
import net.guns.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		loadClasses();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&e[&cCore&e] &aHas been enabled!"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&e[&cCore&e] &cHas been disabled!"));
	}
	
	public void loadClasses(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new playerJoin(this), this);
		pm.registerEvents(new util(this), this);
		pm.registerEvents(new packets(this), this);
		pm.registerEvents(new itemHandler(this), this);
		pm.registerEvents(new gunMenu(this), this);
	}
}
