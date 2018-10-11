package com.retrontology.citizenship;

import org.bukkit.plugin.java.JavaPlugin;

import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.User;
import com.Ben12345rocks.VotingPlugin.UserManager.UserManager;

import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Citizenship 
  extends JavaPlugin
{
	
	public void onEnable()
	{
		CitizenshipCommandExecutor ccommandexec = new CitizenshipCommandExecutor();
		getCommand("citizenship").setExecutor(ccommandexec);
	}
	
	public void onDisable()
	{
		
	}
	
	private boolean setParent(OfflinePlayer player, String group)
	{
		return LuckPerms.getApi().getUser(player.getUniqueId()).setPrimaryGroup(group).wasSuccess();
	}
	
	private String getParent(OfflinePlayer player)
	{
		return LuckPerms.getApi().getUser(player.getUniqueId()).getPrimaryGroup();

	}
	
	private int getVotes(OfflinePlayer player)
	{
		return UserManager.getInstance().getVotingPluginUser(player.getUniqueId()).getMonthTotal();
	}
}