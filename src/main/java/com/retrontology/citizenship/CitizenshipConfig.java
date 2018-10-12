package com.retrontology.citizenship;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;

public class CitizenshipConfig {
	
    private File file;
	private FileConfiguration config;
	
	public CitizenshipConfig()
	{
		this.loadConfig();
	}
	
	private void saveDefaultConfig()
	{
		Bukkit.getServer().getPluginManager().getPlugin("Citizenship").saveDefaultConfig();
		Bukkit.getServer().getLogger().info("[Top Survivor] No config file was found so the default file was copied over");
	}
	
	private boolean saveConfig()
	{
		try
	    {
			config.save(this.file);
			return true;
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    	return false;
	    }
	    
	}
	
	private boolean loadConfig()
	{
		try
	    {
			File filedir = Bukkit.getServer().getPluginManager().getPlugin("Citizenship").getDataFolder();
			if (!filedir.exists())
			{
				filedir.mkdir();
			}
			this.file = new File(Bukkit.getServer().getPluginManager().getPlugin("Citizenship").getDataFolder(), File.separator + "config.yml");
			if (!file.exists())
			{
				this.saveDefaultConfig();
			}
			this.config = YamlConfiguration.loadConfiguration(this.file);
			return true;
	    }
		catch (Exception e)
	    {
			e.printStackTrace();
	      	return false;
	    }
	}
	
	public long getUpdateTime()
	{
		return this.getDuration("update.interval").getSeconds();
	}
	
	private Duration getDuration(String base)
	{
		Duration duration = Duration.ofSeconds(0);
		if(config.contains(base + ".seconds"))
		{
			duration = Duration.ofSeconds(config.getInt(base + ".seconds"));
		}
		if(config.contains(base + ".minutes"))
		{
			duration = duration.plusMinutes(config.getInt(base + ".minutes"));
		}
		if(config.contains(base + ".hours"))
		{
			duration = duration.plusHours(config.getInt(base + ".hours"));
		}
		if(config.contains(base + ".days"))
		{
			duration = duration.plusDays(config.getInt(base + ".days"));
		}
		if(config.contains(base + ".weeks"))
		{
			duration = duration.plusDays(config.getInt(base + ".weeks")*7);
		}
		if(config.contains(base + ".months"))
		{
			duration = duration.plusDays(Math.round((config.getInt(base + ".months")*30.4167)));
		}
		if(config.contains(base + ".years"))
		{
			duration = duration.plusDays(Math.round((config.getInt(base + ".years")*365)));
		}
		return duration;
	}

}
