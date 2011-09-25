package  me.aleksi.NoOctoSpider;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoOctoSpider extends JavaPlugin {

	public static NoOctoSpider plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final ServerCreatureListener creatureListener = new ServerCreatureListener(this);
	
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " is now disabled");
	}
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.CREATURE_SPAWN,this.creatureListener,Event.Priority.Normal, this);
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " version " + pdffile.getVersion() + " is Enabled");
	}
}
