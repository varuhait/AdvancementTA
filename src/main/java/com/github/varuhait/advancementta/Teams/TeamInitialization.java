package com.github.varuhait.advancementta.Teams;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.github.varuhait.advancementta.Main;

public class TeamInitialization {


	public static  void teamRegister() {
		final Main main = Main.getPlugin(Main.class);
		FileConfiguration conf = main.getConfig();
		Team blue;
		Team red;
		Team blue_spy;
		Team red_spy;

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getMainScoreboard();
		for(Team team: board.getTeams()) {
			team.unregister();
		}

		blue = board.registerNewTeam("blue");
		blue.setDisplayName("青チーム");
		blue.setCanSeeFriendlyInvisibles(true);

		red = board.registerNewTeam("red");
		red.setDisplayName("赤チーム");
		red.setCanSeeFriendlyInvisibles(true);

		final boolean spy = conf.getBoolean("spy");
		if(spy) {
			blue_spy = board.registerNewTeam("blue_spy");
			blue_spy.setDisplayName("赤チーム");
			blue_spy.setCanSeeFriendlyInvisibles(true);

			red_spy = board.registerNewTeam("red_spy");
			red_spy.setDisplayName("青チーム");
			red_spy.setCanSeeFriendlyInvisibles(true);
		}


	}

}
