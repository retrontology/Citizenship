package com.retrontology.citizenship;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class CitizenshipTimedTask 
extends BukkitRunnable
{
	public void run()
	{
		Bukkit.getPluginManager().callEvent(new CitizenshipTimedUpdate());
	}
}
