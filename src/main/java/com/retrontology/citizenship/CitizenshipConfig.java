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
			this.config.save(this.file);
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
		if(this.config.contains(base + ".seconds"))
		{
			duration = Duration.ofSeconds(this.config.getInt(base + ".seconds"));
		}
		if(this.config.contains(base + ".minutes"))
		{
			duration = duration.plusMinutes(this.config.getInt(base + ".minutes"));
		}
		if(this.config.contains(base + ".hours"))
		{
			duration = duration.plusHours(this.config.getInt(base + ".hours"));
		}
		if(this.config.contains(base + ".days"))
		{
			duration = duration.plusDays(this.config.getInt(base + ".days"));
		}
		if(this.config.contains(base + ".weeks"))
		{
			duration = duration.plusDays(this.config.getInt(base + ".weeks")*7);
		}
		if(this.config.contains(base + ".months"))
		{
			duration = duration.plusDays(Math.round((this.config.getInt(base + ".months")*30.4167)));
		}
		if(this.config.contains(base + ".years"))
		{
			duration = duration.plusDays(Math.round((this.config.getInt(base + ".years")*365)));
		}
		return duration;
	}
	
	public int getVoteReq(CitizenshipRank rank)
	{
		return this.config.getInt("ranks." + rank.getName() + ".requirements.votes.total");
	}
	
	public long getPlayTimeReq(CitizenshipRank rank)
	{
		return this.getDuration("ranks." + rank.getName() + ".requirements.playtime").getSeconds();
	}
	
	public String getMessage(CitizenshipRank rank)
	{
		return this.config.getString("ranks." + rank.getName() + ".message");
	}

}
