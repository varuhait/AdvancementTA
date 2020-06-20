package com.github.varuhait.advancementta.AdvancementList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.advancement.Advancement;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.github.varuhait.advancementta.Main;

public class AdvancementListener implements Listener {
	private final Main plg;
	int num = -1;

	public AdvancementListener(Main plg_) {
		plg = plg_;
	}

	@EventHandler
	public void AdCatcher(PlayerAdvancementDoneEvent e) {
		FileConfiguration conf = plg.getConfig();
		List<String> advs = conf.getStringList("advs");
		List<Integer> owns = conf.getIntegerList("ownership");
		Player player = e.getPlayer();

		Advancement advancement = e.getAdvancement();
		String name = advancement.getKey().getKey();

		int bluePoint = conf.getInt("bluePoint");
		int redPoint = conf.getInt("redPoint");

		num = advs.indexOf(name);

		if(num != -1) {
			if(owns.get(num) == 0) {

				String playername = player.getName();

				Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
				Objective points = board.getObjective("indpoints");
				Scoreboard pboard = player.getScoreboard();
				int ppoint = points.getScore(playername).getScore() + 10;

				Team team = board.getEntryTeam(playername);
				if(team == null) return;

				if(team.equals(board.getTeam("blue"))) {
					bluePoint += 10;
					owns.set(num, 1);
					bluePoint += BingoChecker.bingoCheck(num, owns);
				}else if(team.equals(board.getTeam("red"))) {
					redPoint += 10;
					owns.set(num, 2);
					redPoint += BingoChecker.bingoCheck(num, owns);
				}else if(team.equals(board.getTeam("blue_spy"))) {
					bluePoint += 10;
					owns.set(num, 1);
					bluePoint += BingoChecker.bingoCheck(num, owns);
				}else if(team.equals(board.getTeam("red_spy"))) {
					redPoint += 10;
					owns.set(num, 2);
					redPoint += BingoChecker.bingoCheck(num, owns);
				}
				pboard.getTeam("ind_score").setSuffix(ChatColor.YELLOW + String.valueOf(ppoint));
				points.getScore(playername).setScore(ppoint);

				for(Player p: Bukkit.getOnlinePlayers()){
					Scoreboard pboards = p.getScoreboard();
					pboards.getTeam("blue_points").setSuffix(ChatColor.YELLOW + String.valueOf(bluePoint));
					pboards.getTeam("red_points").setSuffix(ChatColor.YELLOW + String.valueOf(redPoint));
				}

				conf.set("bluePoint",bluePoint);
				conf.set("redPoint",redPoint);
				conf.set("ownership",owns);

				String adv;
				switch(advancement.getKey().getKey()) {
					case "story/root":
						adv = ChatColor.YELLOW + "Minecraft";
						break;
					case "story/mine_stone":
						adv = ChatColor.YELLOW + "石器時代";
						break;
					case "story/upgrade_tools":
						adv = ChatColor.YELLOW + "アップグレード";
						break;
					case "story/smelt_iron":
						adv = ChatColor.YELLOW + "金属を手に入れる";
						break;
					case "story/obtain_armor":
						adv = ChatColor.YELLOW + "装備せよ";
						break;
					case "story/lava_bucket":
						adv = ChatColor.YELLOW + "ホットスタッフ";
						break;
					case "story/iron_tools":
						adv = ChatColor.YELLOW + "鉄のツルハシで決まり";
						break;
					case "story/deflect_arrow":
						adv = ChatColor.YELLOW + "今日はやめておきます";
						break;
					case "story/form_obsidian":
						adv = ChatColor.YELLOW + "アイス・バケツ・チャレンジ";
						break;
					case "story/mine_diamond":
						adv = ChatColor.YELLOW + "ダイヤモンド！";
						break;
					case "story/enter_the_nether":
						adv = ChatColor.YELLOW + "さらなる深みへ";
						break;
					case "story/shiny_gear":
						adv = ChatColor.YELLOW + "ダイヤモンドで私を覆って";
						break;
					case "story/enchant_item":
						adv = ChatColor.YELLOW + "エンチャントの使い手";
						break;
					case "story/cure_zombie_villager":
						adv = ChatColor.YELLOW + "ゾンビドクター";
						break;
					case "story/follow_ender_eye":
						adv = ChatColor.YELLOW + "アイ・スパイ";
						break;
					case "story/enter_the_end":
						adv = ChatColor.YELLOW + "おしまい？";
						break;

					case "nether/root":
						adv = ChatColor.YELLOW + "ネザー";
						break;
					case "nether/return_to_sender":
						adv = ChatColor.YELLOW + "差出人に返送";
						break;
					case "nether/fast_travel":
						adv = ChatColor.YELLOW + "亜空間バブル";
						break;
					case "nether/find_fortress":
						adv = ChatColor.YELLOW + "恐ろしい要塞";
						break;
					case "nether/uneasy_alliance":
						adv = ChatColor.YELLOW + "不安な同盟";
						break;
					case "nether/get_wither_skull":
						adv = ChatColor.YELLOW + "不気味で怖いスケルトン";
						break;
					case "nether/obtain_blaze_rod":
						adv = ChatColor.YELLOW + "炎の中へ";
						break;
					case "nether/summon_wither":
						adv = ChatColor.YELLOW + "荒が丘";
						break;
					case "nether/brew_potion":
						adv = ChatColor.YELLOW + "町のお薬屋さん";
						break;
					case "nether/create_beacon":
						adv = ChatColor.YELLOW + "生活のビーコン";
						break;
					case "nether/all_potions":
						adv = ChatColor.YELLOW + "猛烈なカクテル";
						break;
					case "nether/create_full_beacon":
						adv = ChatColor.YELLOW + "ビーコネーター";
						break;
					case "nether/all_effects":
						adv = ChatColor.YELLOW + "どうやってここまで？";
						break;

					case "end/root":
						adv = ChatColor.YELLOW + "エンド";
						break;
					case "end/kill_dragon":
						adv = ChatColor.YELLOW + "エンドの解放";
						break;
					case "end/dragon_egg":
						adv = ChatColor.YELLOW + "ザ・ネクストジェネレーション";
						break;
					case "end/enter_end_gateway":
						adv = ChatColor.YELLOW + "遠方への逃走";
						break;
					case "end/respawn_dragon":
						adv = ChatColor.YELLOW + "おしまい…再び…";
						break;
					case "end/dragon_breath":
						adv = ChatColor.YELLOW + "口臭に気をつけよう";
						break;
					case "end/find_end_city":
						adv = ChatColor.YELLOW + "ゲームの果ての都市";
						break;
					case "end/elytra":
						adv = ChatColor.YELLOW + "空はどこまでも高く";
						break;
					case "end/levitate":
						adv = ChatColor.YELLOW + "ここからの素晴らしい眺め";
						break;

					case "adventure/root":
						adv = ChatColor.YELLOW + "冒険";
						break;
					case "adventure/voluntary_exile":
						adv = ChatColor.YELLOW + "自主的な亡命";
						break;
					case "adventure/kill_a_mob":
						adv = ChatColor.YELLOW + "モンスターハンター";
						break;
					case "adventure/trade":
						adv = ChatColor.YELLOW + "良い取引だ！";
						break;
					case "adventure/honey_block_slide":
						adv = ChatColor.YELLOW + "べとべとな状況";
						break;
					case "adventure/ol_besty":
						adv = ChatColor.YELLOW + "おてんば";
						break;
					case "adventure/sleep_in_bed":
						adv = ChatColor.YELLOW + "良い夢見てね";
						break;
					case "adventure/hero_of_the_village":
						adv = ChatColor.YELLOW + "村の英雄";
						break;
					case "adventure/throw_trident":
						adv = ChatColor.YELLOW + "もったいぶった一言";
						break;
					case "adventure/shoot_arrow":
						adv = ChatColor.YELLOW + "狙いを定めて";
						break;
					case "adventure/kill_all_mobs":
						adv = ChatColor.YELLOW + "モンスター狩りの達人";
						break;
					case "adventure/totem_of_undying":
						adv = ChatColor.YELLOW + "死を超えて";
						break;
					case "adventure/summon_iron_golem":
						adv = ChatColor.YELLOW + "お手伝いさん";
						break;
					case "adventure/two_birds_one_arrow":
						adv = ChatColor.YELLOW + "一石二鳥";
						break;
					case "adventure/whos_the_pillager_now":
						adv = ChatColor.YELLOW + "どっちが略奪者？";
						break;
					case "adventure/arbalistic":
						adv = ChatColor.YELLOW + "クロスボウの達人";
						break;
					case "adventure/adventuring_time":
						adv = ChatColor.YELLOW + "冒険の時間";
						break;
					case "adventure/very_very_frightening":
						adv = ChatColor.YELLOW + "とてもとても恐ろしい";
						break;
					case "adventure/sniper_duel":
						adv = ChatColor.YELLOW + "スナイパー対決";
						break;

					case "husbandry/root":
						adv = ChatColor.YELLOW + "農業";
						break;
					case "husbandry/safely_harvest_honey":
						adv = ChatColor.YELLOW + "大切なお客様";
						break;
					case "husbandry/breed_an_animal":
						adv = ChatColor.YELLOW + "コウノトリの贈り物";
						break;
					case "husbandry/tame_an_animal":
						adv = ChatColor.YELLOW + "永遠の親友となるだろう";
						break;
					case "husbandry/fishy_business":
						adv = ChatColor.YELLOW + "生臭い仕事";
						break;
					case "husbandry/silk_touch_nest":
						adv = ChatColor.YELLOW + "完全な引越し";
						break;
					case "husbandry/plant_seed":
						adv = ChatColor.YELLOW + "種だらけの場所";
						break;
					case "husbandry/bred_all_animals":
						adv = ChatColor.YELLOW + "二匹ずつ";
						break;
					case "husbandry/complete_catalogue":
						adv = ChatColor.YELLOW + "猫大全集";
						break;
					case "husbandry/tactical_fishing":
						adv = ChatColor.YELLOW + "戦術的漁業";
						break;
					case "husbandry/balanced_diet":
						adv = ChatColor.YELLOW + "バランスの取れた食事";
						break;
					case "husbandry/break_diamond_hoe":
						adv = ChatColor.YELLOW + "真面目な献身";
						break;

					default:
						adv = null;
				}

				if(adv != null) {
					for(Player p: Bukkit.getOnlinePlayers()) {
						p.sendMessage(player.getName() + "が" + adv + "を取得しました");
					}
				}
			}
		}

	}

}
