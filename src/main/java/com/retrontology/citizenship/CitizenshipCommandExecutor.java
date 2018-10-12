package com.retrontology.citizenship;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class CitizenshipCommandExecutor
implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("citizenship.admin"))
		{
			if (command.getName().equalsIgnoreCase("visitor"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || player.isOnline()))
					{
						((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.VISITOR);
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return false;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /visitor <player>");
					return false;
				}
		    }
			if (command.getName().equalsIgnoreCase("citizen"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || player.isOnline()))
					{
						((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.CITIZEN);
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return false;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /citizen <player>");
					return false;
				}
		    }
			if (command.getName().equalsIgnoreCase("veteran"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || player.isOnline()))
					{
						((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.VETERAN);
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return false;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /citizen <player>");
					return false;
				}
		    }
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "What do you think you're doing :I");
			return false;
		}
		return false;
	}
	
}
