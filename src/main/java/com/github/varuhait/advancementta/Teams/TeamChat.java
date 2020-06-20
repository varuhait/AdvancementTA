package com.github.varuhait.advancementta.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamChat implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String pname = player.getName();
			Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
			Team team = board.getEntryTeam(pname);

			Team red = board.getTeam("red");
			Team red_spy = board.getTeam("red_spy");
			Team blue = board.getTeam("blue");
			Team blue_spy = board.getTeam("blue_spy");

			String tname = team.getName();
			String message = "";

			for(String s: args) {
				message +=	s + " ";
			}
			if(message == "") return false;

			for(Player p: Bukkit.getOnlinePlayers()) {
				Team pteam = board.getEntryTeam(p.getName());
				switch(tname) {
					case "blue":
						if(!pteam.equals(red)) {
							if(pteam.equals(blue_spy)){
								if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
									p.sendMessage(ChatColor.BLUE + "[青]" + pname + ":" + ChatColor.RESET + message);
								}else p.sendMessage(ChatColor.YELLOW + "[青]" + "****" + ":" + "******");
							}else p.sendMessage(ChatColor.BLUE + "[青]" + pname + ":" + ChatColor.RESET + message);
						}
						break;
					case "red":
						if(!pteam.equals(blue)) {
							if(pteam.equals(red_spy)){
								if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
									p.sendMessage(ChatColor.RED + "[赤]" + pname + ":" + ChatColor.RESET + message);
								}else p.sendMessage(ChatColor.YELLOW + "[赤]" + "****" + ":" + "******");
							}else p.sendMessage(ChatColor.RED + "[赤]" + pname + ":" + ChatColor.RESET + message);
						}
						break;
					case "blue_spy":
						if(!player.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
							if(!pteam.equals(blue)) {
								if(pteam.equals(red_spy)){
									if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
										p.sendMessage(ChatColor.RED + "[赤]" + pname + ":" + ChatColor.RESET + message);
									}else p.sendMessage(ChatColor.YELLOW + "[赤]" + "****" + ":" + "******");
								}else p.sendMessage(ChatColor.RED + "[赤]" + pname + ":" + ChatColor.RESET + message);
							}
						}else {
							if(!pteam.equals(red)) {
								if(pteam.equals(blue_spy)){
									if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
										p.sendMessage(ChatColor.BLUE + "[青](スパイ)" + pname + ":" + ChatColor.RESET + message);
									}else p.sendMessage(ChatColor.YELLOW + "[青](スパイ)" + "****" + ":" + "******");
								}else p.sendMessage(ChatColor.BLUE + "[青](スパイ)" + pname + ":" + ChatColor.RESET + message);
							}
						}
						break;
					case "red_spy":
						if(!player.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
							if(!pteam.equals(red)) {
								if(pteam.equals(blue_spy)){
									if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
										p.sendMessage(ChatColor.BLUE + "[青]" + pname + ":" + ChatColor.RESET + message);
									}else p.sendMessage(ChatColor.YELLOW + "[青]" + "****" + ":" + "******");
								}else p.sendMessage(ChatColor.BLUE + "[青]" + pname + ":" + ChatColor.RESET + message);
							}
						}else {
							if(!pteam.equals(blue)) {
								if(pteam.equals(red_spy)){
									if(p.getInventory().getItemInMainHand().getType().equals(Material.MUSIC_DISC_11)) {
										p.sendMessage(ChatColor.RED + "[赤](スパイ)" + pname + ":" + ChatColor.RESET + message);
									}else p.sendMessage(ChatColor.YELLOW + "[[赤](スパイ)" + "****" + ":" + "******");
								}else p.sendMessage(ChatColor.RED + "[赤](スパイ)" + pname + ":" + ChatColor.RESET + message);
							}
						}
						break;

				}
			}
			return true;
		}
		return false;
	}
}
