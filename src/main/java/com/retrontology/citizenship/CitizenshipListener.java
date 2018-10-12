package com.retrontology.citizenship;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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
		
	}
	
	@EventHandler
	public void onVote(PlayerVoteEvent event)
	{
		OfflinePlayer player = Bukkit.getServer().getOfflinePlayer(event.getPlayer());
		if(player.isOnline() && !event.isCancelled())
		{
			
		}
	}
	
	@EventHandler
	public void onCitizenshipTimedUpdate(CitizenshipTimedUpdate event)
	{
		
	}
}
