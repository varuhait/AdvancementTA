package com.github.varuhait.advancementta.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.github.varuhait.advancementta.Main;

public class PlayerRandomTeam implements CommandExecutor  {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length != 0) {
			sender.sendMessage(ChatColor.RED + "使用方法：/rdt");
			return true;
		}
		final Main main = Main.getPlugin(Main.class);
		FileConfiguration conf = main.getConfig();

		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team red = board.getTeam("red");
		Team blue = board.getTeam("blue");
		Team red_spy = board.getTeam("red_spy");
		Team blue_spy = board.getTeam("blue_spy");

		Boolean checker = true;
		String pname;

		int spyRate = conf.getInt("spyrate");
		boolean spy = conf.getBoolean("spy");
		int i = 1;

		for(Player player: Bukkit.getOnlinePlayers()) {
			if(player.getGameMode().equals(GameMode.SPECTATOR))continue;

			pname = player.getName();
			if(checker == true) {
				if((i % spyRate) != 0) {
					red.addEntry(pname);
					player.setDisplayName(ChatColor.RED + "[赤]" + pname);
					player.setPlayerListName(ChatColor.RED + "[赤]" + pname);
					player.sendMessage(ChatColor.YELLOW + "あなたは" + ChatColor.RED + "赤" + ChatColor.YELLOW +"チームです");
					checker = false;
				}else if(spy){
					red_spy.addEntry(pname);
					player.setDisplayName(ChatColor.BLUE +  "[青]" + pname);
					player.setPlayerListName(ChatColor.BLUE +  "[青]" + pname);
					player.sendMessage(ChatColor.YELLOW + "あなたは" + ChatColor.BLUE + "青" + ChatColor.YELLOW +"チームです");
					checker = false;
				}
			}else {
				if((i % spyRate) != 0) {
					blue.addEntry(pname);
					player.setDisplayName(ChatColor.BLUE +  "[青]" + pname);
					player.setPlayerListName(ChatColor.BLUE + "[青]"  + pname);
					player.sendMessage(ChatColor.YELLOW + "あなたは" + ChatColor.BLUE +"青(スパイ)" + ChatColor.YELLOW +"チームです");
					checker = true;
					i++;
				}else if(spy) {
					blue_spy.addEntry(pname);
					player.setDisplayName(ChatColor.RED + "[赤]" + pname);
					player.setPlayerListName(ChatColor.RED + "[赤]" + pname);
					player.sendMessage(ChatColor.YELLOW + "あなたは" + ChatColor.RED +"赤(スパイ)" + ChatColor.YELLOW +"チームです");
					checker = true;
					i++;
				}
			}
		}
		SetIndScoreboard.IndInit();
		sender.sendMessage(ChatColor.GREEN + "チーム振り分けに成功しました");
		return true;
	}

}
