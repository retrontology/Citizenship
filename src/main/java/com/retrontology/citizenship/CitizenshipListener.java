package com.retrontology.citizenship;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import com.Ben12345rocks.VotingPlugin.Events.PlayerVoteEvent;

public class CitizenshipListener
implements Listener
{
	@EventHandler
	public void onLogin(PlayerLoginEvent event)
	{
		Player player = event.getPlayer();
		((Citizenship)Bukkit.getServer().getPluginManager().getPlugin("Citizenship")).checkForPromotion(player);
	}
	
	@EventHandler
	public void onVote(PlayerVoteEvent event)
	{
		Player player = Bukkit.getServer().getPlayer(event.getPlayer());
		if(player.isOnline() && !event.isCancelled())
		{
			((Citizenship)Bukkit.getPluginManager().getPlugin("Citizenship")).checkForPromotion(player);
		}
	}
	
	@EventHandler
	public void onCitizenshipTimedUpdate(CitizenshipTimedUpdate event)
	{
		Bukkit.getServer().getPluginManager().getPlugin("Citizenship").getLogger().info("Checking for applicable promotions amongst online players");
		for(Player player : Bukkit.getOnlinePlayers())
		{
			((Citizenship)Bukkit.getServer().getPluginManager().getPlugin("Citizenship")).checkForPromotion(player);
		}
	}
}
