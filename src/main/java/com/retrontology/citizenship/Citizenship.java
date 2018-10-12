package com.retrontology.citizenship;

import org.bukkit.plugin.java.JavaPlugin;

import me.lucko.luckperms.LuckPerms;
import com.Ben12345rocks.VotingPlugin.UserManager.UserManager;
import org.bukkit.Statistic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Citizenship 
  extends JavaPlugin
{
	
	CitizenshipConfig config;
	
	public void onEnable()
	{
		config = new CitizenshipConfig();
		getCommand("citizenship").setExecutor(new CitizenshipCommandExecutor());
		Bukkit.getServer().getPluginManager().registerEvents(new CitizenshipListener(), this);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new CitizenshipTimedTask(), 0L, config.getUpdateTime());
	}
	
	public void onDisable()
	{
		
	}
	
	private boolean setParent(Player player, String group)
	{
		return LuckPerms.getApi().getUser(player.getUniqueId()).setPrimaryGroup(group).wasSuccess();
	}
	
	private String getParent(Player player)
	{
		return LuckPerms.getApi().getUser(player.getUniqueId()).getPrimaryGroup();

	}
	
	private int getVotes(Player player)
	{
		return UserManager.getInstance().getVotingPluginUser(player.getUniqueId()).getMonthTotal();
	}
	
	private int getPlayTime(Player player)
	{
		return player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
	}
	
	private CitizenshipRank getPlayerRank(Player player)
	{
		String parent = getParent(player);
		for(CitizenshipRank rank : CitizenshipRank.values())
		{
			if(parent == rank.name())
			{
				return rank;
			}
		}
		return null;
	}
	
	private CitizenshipRank getNextRank(Player player)
	{
		CitizenshipRank playerRank = getPlayerRank(player);
		if(playerRank == null) { return null; }
		for(CitizenshipRank rank : CitizenshipRank.values())
		{
			if(rank.getRank() == playerRank.getRank() + 1)
			{
				return rank;
			}
		}
		return null;
	}
	
	private boolean playerMeetsReqs(Player player, CitizenshipRank rank)
	{
		boolean timeReq = getVotes(player) >= config.getVoteReq(rank);
		boolean voteReq = getPlayTime(player) >= config.getPlayTimeReq(rank);
		return voteReq && timeReq;
	}
	
	public boolean checkForPromotion(Player player)
	{
		CitizenshipRank nextRank = getNextRank(player);
		if(nextRank == null) { return false; }
		if(playerMeetsReqs(player, nextRank))
		{
			setRank(player, nextRank);
			this.getLogger().info(player.getName() + " has been found qualified for a promotion");
			return true;
		}
		return false;
	}
	
	public boolean setRank(Player player, CitizenshipRank rank)
	{
		boolean ret = setParent(player, rank.getName());
		if(ret)
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				p.sendMessage(config.getMessage(rank).replace("%p", player.getName()));
			    this.getLogger().info(player.getName() + " has had their primary group set to " + rank.getName());
			}
		}
		return ret;
	}
}