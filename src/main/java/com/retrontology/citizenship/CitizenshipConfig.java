package com.retrontology.citizenship;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;

public class CitizenshipConfig {
	
    private File file;
	private FileConfiguration config;
	
	public CitizenshipConfig()
	{
		File filedir = Bukkit.getServer().getPluginManager().getPlugin("Citizenship").getDataFolder();
		if (!filedir.exists())
		{
			filedir.mkdir();
		}
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("Citizenship").getDataFolder(), File.separator + "config.yml");
		if (!file.exists())
		{
			this.saveDefaultConfig();
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	private void saveDefaultConfig()
	{
		Bukkit.getServer().getPluginManager().getPlugin("Citizenship").saveDefaultConfig();
		Bukkit.getServer().getLogger().info("[Top Survivor] No config file was found so the default file was copied over");
	}

}
