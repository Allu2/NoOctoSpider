package me.aleksi.NoOctoSpider;

import java.util.logging.Logger;

import org.bukkit.entity.CreatureType;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityListener;

public class ServerCreatureListener extends EntityListener {
	public static NoOctoSpider plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public ServerCreatureListener(NoOctoSpider instance){
		plugin = instance;
	}
	public void onCreatureSpawn(CreatureSpawnEvent event){
		CreatureType c = event.getCreatureType();
		String name = c.getName().toLowerCase();
		//this.logger.info("Logged a Spawning of a " + c.getName());
		if(name.contains("spider") || name.contains("squid")){
			event.setCancelled(true);
			this.logger.info("We have prevented Spawning of a " + c.getName());
			
		}
	}
}
