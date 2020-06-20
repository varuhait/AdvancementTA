package com.github.varuhait.advancementta.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.github.varuhait.advancementta.Main;

public class SetIndScoreboard {

	public static void IndInit() {

		final Main main = Main.getPlugin(Main.class);
		FileConfiguration conf = main.getConfig();

		Scoreboard board;
		Scoreboard mboard = Bukkit.getScoreboardManager().getMainScoreboard();
		Objective points = mboard.getObjective("indpoints");
		if(points == null)mboard.registerNewObjective("indpoints", "dummy", "個人ポイント");

		int time = conf.getInt("time");
		String line = "-----------";
		for(Player player: Bukkit.getOnlinePlayers()) {

			board = Bukkit.getScoreboardManager().getNewScoreboard();

			Objective obj = board.registerNewObjective("info", "dummy","Xx_題名_xX");
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);

			obj.getScore(line).setScore(-1);

			Team status = board.registerNewTeam("status");
			status.addEntry(ChatColor.DARK_PURPLE.toString());
			status.setPrefix(ChatColor.YELLOW + "状態： ");
			status.setSuffix(ChatColor.GREEN + "待機中");
			obj.getScore(ChatColor.DARK_PURPLE.toString()).setScore(-2);

			Team timer = board.registerNewTeam("Timer");
			timer.addEntry(ChatColor.YELLOW.toString());
			timer.setPrefix(ChatColor.YELLOW + "残り時間： ");
			timer.setSuffix(ChatColor.YELLOW + String.valueOf(time) + ChatColor.YELLOW + "秒");
			obj.getScore(ChatColor.YELLOW.toString()).setScore(-3);

			obj.getScore(line + ChatColor.YELLOW.toString()).setScore(-4);

			Team blue_points = board.registerNewTeam("blue_points");
			blue_points.addEntry(ChatColor.BLUE.toString());
			blue_points.setPrefix(ChatColor.BLUE + "青チーム： ");
			blue_points.setSuffix(ChatColor.YELLOW + "0");
			obj.getScore(ChatColor.BLUE.toString()).setScore(-5);

			Team red_points = board.registerNewTeam("red_points");
			red_points.addEntry(ChatColor.RED.toString());
			red_points.setPrefix(ChatColor.RED + "赤チーム： ");
			red_points.setSuffix(ChatColor.YELLOW + "0");
			obj.getScore(ChatColor.RED.toString()).setScore(-6);

			obj.getScore(line+ ChatColor.BLUE.toString()).setScore(-7);

			Team ind_score = board.registerNewTeam("ind_score");
			ind_score.addEntry(ChatColor.GREEN.toString());
			ind_score.setPrefix(ChatColor.GREEN + "獲得ポイント： ");
			ind_score.setSuffix(ChatColor.YELLOW + "0");
			obj.getScore(ChatColor.GREEN.toString()).setScore(-9);

			points.getScore(player.getName()).setScore(0);

			Team your_team = board.registerNewTeam("your_team");
			your_team.addEntry(ChatColor.AQUA.toString());

			switch(mboard.getEntryTeam(player.getName()).getName()) {
				case "blue":
					your_team.setPrefix(ChatColor.GREEN + "チーム：");
					your_team.setSuffix(ChatColor.BLUE + " 青");
					obj.getScore(ChatColor.AQUA.toString()).setScore(-8);
					break;
				case "red":
					your_team.setPrefix(ChatColor.GREEN + "チーム：");
					your_team.setSuffix(ChatColor.RED + " 赤");
					obj.getScore(ChatColor.AQUA.toString()).setScore(-8);
					break;
				case "blue_spy":
					your_team.setPrefix(ChatColor.GREEN + "チーム：");
					your_team.setSuffix(ChatColor.BLUE + " 青(スパイ)");
					obj.getScore(ChatColor.AQUA.toString()).setScore(-8);
					break;
				case "red_spy":
					your_team.setPrefix(ChatColor.GREEN + "チーム：");
					your_team.setSuffix(ChatColor.RED + " 赤(スパイ)");
					obj.getScore(ChatColor.AQUA.toString()).setScore(-8);
				default:
					break;
			}

			obj.getScore(line + ChatColor.GREEN.toString()).setScore(-10);

			player.setScoreboard(board);

		}


	}
}
