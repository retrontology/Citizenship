package com.retrontology.citizenship;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class CitizenshipCommandExecutor
implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("citizenship.admin") || sender instanceof ConsoleCommandSender)
		{
			if (command.getName().equalsIgnoreCase("visitor"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || !player.isOnline()))
					{
						if(((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.VISITOR))
						{
							return true;
						}
						else
						{
							sender.sendMessage(ChatColor.RED + "There was an error processing your request");
						}
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /visitor <player>");
					return true;
				}
		    }
			if (command.getName().equalsIgnoreCase("citizen"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || !player.isOnline()))
					{
						if(((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.CITIZEN))
						{
							return true;
						}
						else
						{
							sender.sendMessage(ChatColor.RED + "There was an error processing your request");
						}
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /citizen <player>");
					return true;
				}
		    }
			if (command.getName().equalsIgnoreCase("veteran"))
			{
				if(args.length == 1)
				{
					Player player = Bukkit.getPlayer(args[0]);
					if(!(player == null || !player.isOnline()))
					{
						if(((Citizenship)(Bukkit.getPluginManager().getPlugin("Citizenship"))).setRank(player, CitizenshipRank.VETERAN))
						{
							return true;
						}
						else
						{
							sender.sendMessage(ChatColor.RED + "There was an error processing your request");
						}
					}
					else
					{
						sender.sendMessage(ChatColor.RED + "The specified player is not available");
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.YELLOW + "The usage is /citizen <player>");
					return true;
				}
		    }
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "What do you think you're doing :I");
			return true;
		}
		return false;
	}
	
}
