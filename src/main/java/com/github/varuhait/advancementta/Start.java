package com.github.varuhait.advancementta;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

public class Start implements CommandExecutor{

	private final Main plg;

	public Start(Main _plg) {
		plg = _plg;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length != 0) {
			sender.sendMessage(ChatColor.RED + "使用方法：/start");
			return true;
		}
		FileConfiguration conf = plg.getConfig();
		Scoreboard mboard = Bukkit.getScoreboardManager().getMainScoreboard();

		for(Player p: Bukkit.getOnlinePlayers()) {
			Scoreboard board1 = p.getScoreboard();
			board1.getTeam("status").setSuffix(ChatColor.RED + "試合中");
			p.sendTitle(ChatColor.GREEN + "START!",ChatColor.YELLOW + "出来るだけ多くの目標を取得しよう", 0, 60, 20);
			ItemStack clock = new ItemStack(Material.CLOCK);
			ItemMeta clm = clock.getItemMeta();
			clm.setDisplayName(ChatColor.YELLOW + "進捗リスト");
			clock.setItemMeta(clm);
			clock.addUnsafeEnchantment(Enchantment.MENDING, 1);
			p.getInventory().addItem(clock);
			switch(mboard.getEntryTeam(p.getName()).getName()) {
				case "red_spy":
				case "blue_spy":
					ItemStack tran = new ItemStack(Material.MUSIC_DISC_11);
					ItemMeta tranm = tran.getItemMeta();
					tranm.setDisplayName(ChatColor.GREEN + "通信機");
					tran.setItemMeta(tranm);
					tran.addUnsafeEnchantment(Enchantment.MENDING, 1);
					p.getInventory().addItem(tran);
					break;
				default:
					break;
			}
		}

		 new BukkitRunnable() {
			int time = conf.getInt("time");

			@Override
			public void run() {
				if(time <= 0) {
					cancel();
					endGame();
				}
				for(Player player: Bukkit.getOnlinePlayers()) {
					Scoreboard board2 = player.getScoreboard();
					board2.getTeam("Timer").setSuffix(ChatColor.YELLOW + String.valueOf(time) + ChatColor.YELLOW + "秒");
				}
				time--;
			}
		}.runTaskTimer(plg, 0, 20);
		return true;
	}

	public void endGame() {
		//Scoreboard mboard = Bukkit.getScoreboardManager().getMainScoreboard();
		FileConfiguration c = plg.getConfig();
		String winner;
		int win = c.getInt("bluePoint") - c.getInt("redPoint");
		winner = win > 0 ? "blue" : "red";
		if(win == 0) winner = "draw";
		for(Player pl: Bukkit.getOnlinePlayers()) {
			switch(winner) {
				case "blue":
					pl.sendTitle(ChatColor.BLUE + "BLUE WIN", ChatColor.YELLOW + "青チームの勝ち", 0, 60, 20);
					break;
				case "red":
					pl.sendTitle(ChatColor.RED + "RED WIN", ChatColor.YELLOW + "赤チームの勝ち", 0, 60, 20);
					break;
				case "draw":
					pl.sendTitle(ChatColor.GRAY + "DRAW", ChatColor.YELLOW + "引き分け", 0, 60, 20);
					break;
			}
			pl.getScoreboard().getTeam("status").setSuffix(ChatColor.YELLOW + "試合終了");
			pl.setGameMode(GameMode.SPECTATOR);
		}
	}
}
