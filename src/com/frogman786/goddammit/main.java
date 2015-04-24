package com.frogman786.goddammit;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public final Logger Log = Logger.getLogger("Minecarft");
	public static Map<String, Integer> bans = new HashMap<String,Integer>();
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.Log.info(pdfFile.getName() + " Has Been Disabled! ");
	}

	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.Log.info(pdfFile.getName() + " " + pdfFile.getVersion() +  " Has Been Enabled! ");
		if(loadbans()){
			this.Log.info("loaded bans list successfully");
		}else{
			this.Log.severe("ERROR LOADING BANS LIST");
		}

}

	private boolean loadbans() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean addban(String player, int expire, String reason) {
		// TODO Auto-generated method stub
		int ct = (int) (System.currentTimeMillis()/1000L);
		int exp = expire + ct;
		return false;
	}
	
	private boolean savebans() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void kickplayer(String player, String reason) {
		Bukkit.broadcastMessage("");
		Bukkit.getPlayer(player).kickPlayer(reason);
	}
	
	
	
	
	
	
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args){
		if(lbl.equalsIgnoreCase("tempban")){
			boolean allow = false;
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frogban.ban")){
					allow = true;
				}
			}else{
				allow = true;
			}
			if(allow){
				//TODO ban stuffs here
				int time = Integer.parseInt(args[1]);
				//unit parsing
				String unit = args[2].toLowerCase();
				if(unit.startsWith("m")){
					time = time*60;
				}else if(unit.startsWith("h")){
					time = time*3600;
				}else if(unit.startsWith("d")){
					time = time*86400;
				}
				//do some more shit
				String reason = stringstriper(3, args);
			 
				addban(args[0],time,reason);
				kickplayer(args[0], reason);
				
				
				
			}
			
		}
		if(lbl.equalsIgnoreCase("unban")){
			boolean allow = false;
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frogban.unban")){
					allow = true;
				}
			}else{
				allow = true;
			}
			if(allow){
				//TODO unban stuffs here
				
				
				
				
				
			}
			
		}
		if(lbl.equalsIgnoreCase("kick")){
			boolean allow = false;
			if(sender instanceof Player){
				Player player = (Player) sender;
				if(player.hasPermission("frogban.kick")){
					allow = true;
				}
			}else{
				allow = true;
			}
			if(allow){
				kickplayer(args[0], stringstriper(1,args));
			}
		}
		return false;
	}

	private String stringstriper(int cut, String[] args) {
		StringBuilder looper = new StringBuilder();
		for(int i=0; i<args.length+1; i++){
			if(i>cut-1){
			looper.append(args[i] + " ");
			}
		}
		return looper.toString();
	}
	
	
}
