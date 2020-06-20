package com.github.varuhait.advancementta.AdvancementList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.varuhait.advancementta.Main;

/*
 * 目標進捗のリスト化GUI表示クラス
 * @author varuhait
 */

public class AdvancementListGUI implements Listener{

	Inventory selectedadvs =null;

	@EventHandler
	public void openGUI(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
			if(e.getItem().getType().equals(Material.CLOCK)) {
				final Main main = Main.getPlugin(Main.class);
				FileConfiguration conf = main.getConfig();
				if(conf.getBoolean("objs")) {
					List<String> advs = conf.getStringList("advs");
					int square = conf.getInt("square");
					List<Integer> owns = conf.getIntegerList("ownership");
					selectedadvs = Bukkit.createInventory(null, square*9, "目標進捗（クリックで条件表示）");
					int c = 0;
					ItemStack adv;
					for(int i=0; i<square*9; i++) {
						if(i%9 >= 4-Math.round(square/2) && i%9 <= 4+Math.round(square/2)){
							switch(owns.get(c)) {
								case 1:
									adv = advSet(Material.BLUE_STAINED_GLASS_PANE, "青チーム獲得済み", "");
									break;
								case 2:
									adv = advSet(Material.RED_STAINED_GLASS_PANE, "赤チーム獲得済み", "");
									break;
								default:
									switch(advs.get(c)) {
										case "story/root":
											adv = advSet(Material.GRASS_BLOCK, "Minecraft", "ゲームのストーリーと核心");
											break;
										case "story/mine_stone":
											adv = advSet(Material.WOODEN_PICKAXE, "石器時代", "真新しいツルハシで石を採掘する");
											break;
										case "story/upgrade_tools":
											adv = advSet(Material.STONE_PICKAXE, "アップグレード", "より良いツルハシをつくる");
											break;
										case "story/smelt_iron":
											adv = advSet(Material.IRON_INGOT, "金属を手に入れる", "鉄インゴットを製錬する");
											break;
										case "story/obtain_armor":
											adv = advSet(Material.IRON_CHESTPLATE, "装備せよ", "鉄の防具で身を守る");
											break;
										case "story/lava_bucket":
											adv = advSet(Material.LAVA_BUCKET, "ホットスタッフ", "バケツを溶岩で満たす");
											break;
										case "story/iron_tools":
											adv = advSet(Material.IRON_PICKAXE, "鉄のツルハシで決まり", "ツルハシを強化する");
											break;
										case "story/deflect_arrow":
											adv = advSet(Material.SHIELD, "今日はやめておきます", "盾で矢を跳ね返す");
											break;
										case "story/form_obsidian":
											adv = advSet(Material.OBSIDIAN, "アイス・バケツ・チャレンジ", "黒曜石を採掘する");
											break;
										case "story/mine_diamond":
											adv = advSet(Material.DIAMOND, "ダイヤモンド！", "ダイヤモンドを手に入れる");
											break;
										case "story/enter_the_nether":
											adv = advSet(Material.FLINT_AND_STEEL, "さらなる深みへ", "ネザーポータルを作り、着火し、入る");
											break;
										case "story/shiny_gear":
											adv = advSet(Material.DIAMOND_CHESTPLATE, "ダイヤモンドで私を覆って", "ダイヤモンドの防具は命を救います");
											break;
										case "story/enchant_item":
											adv = advSet(Material.ENCHANTED_BOOK, "エンチャントの使い手", "エンチャントテーブルでアイテムをエンチャントする");
											break;
										case "story/cure_zombie_villager":
											adv = advSet(Material.GOLDEN_APPLE, "ゾンビドクター", "村人ゾンビを弱らせてから治療する");
											break;
										case "story/follow_ender_eye":
											adv = advSet(Material.ENDER_EYE, "アイ・スパイ", "エンダーアイを追いかける");
											break;
										case "story/enter_the_end":
											adv = advSet(Material.END_STONE, "おしまい？", "エンドポータルに入る");
											break;

										case "nether/root":
											adv = advSet(Material.NETHERRACK, "ネザー", "夏服を持って来る");
											break;
										case "nether/return_to_sender":
											adv = advSet(Material.FIRE_CHARGE, "差出人に返送", "火の玉をガストに打ち返す");
											break;
										case "nether/fast_travel":
											adv = advSet(Material.PAPER, "亜空間バブル", "ネザーを利用してオーバーワールドでの7kmを移動する");
											break;
										case "nether/find_fortress":
											adv = advSet(Material.NETHER_BRICK, "恐ろしい要塞", "ネザー要塞に侵入する");
											break;
										case "nether/uneasy_alliance":
											adv = advSet(Material.GHAST_TEAR, "不安な同盟", "ガストをネザーから救出し、安全にオーバーワールドに持ち帰り…そして倒す。");
											break;
										case "nether/get_wither_skull":
											adv = advSet(Material.WITHER_SKELETON_SKULL, "不気味で怖いスケルトン", "ウィザースケルトンの頭蓋骨を手に入れる");
											break;
										case "nether/obtain_blaze_rod":
											adv = advSet(Material.BLAZE_ROD, "炎の中へ", "ブレイズロッドを手に入れる");
											break;
										case "nether/summon_wither":
											adv = advSet(Material.NETHER_STAR, "荒が丘", "ウィザーを召喚する");
											break;
										case "nether/brew_potion":
											adv = advSet(Material.POTION, "町のお薬屋さん", "ポーションを醸造する");
											break;
										case "nether/create_beacon":
											adv = advSet(Material.BEACON, "生活のビーコン", "ビーコンを準備して起動させる");
											break;
										case "nether/all_potions":
											adv = advSet(Material.MILK_BUCKET, "猛烈なカクテル", "すべての種類のポーション効果の付与を同時に受ける");
											break;
										case "nether/create_full_beacon":
											adv = advSet(Material.BEACON, "ビーコネーター", "最大パワーのビーコンを作る");
											break;
										case "nether/all_effects":
											adv = advSet(Material.BUCKET, "どうやってここまで？", "すべての種類の効果の付与を同時に受ける");
											break;

										case "end/root":
											adv = advSet(Material.END_STONE, "ジ・エンド", "それともはじまり？");
											break;
										case "end/kill_dragon":
											adv = advSet(Material.DRAGON_HEAD, "エンドの解放", "幸運を祈る");
											break;
										case "end/dragon_egg":
											adv = advSet(Material.DRAGON_EGG, "ザ・ネクストジェネレーション", "ドラゴンの卵を持つ");
											break;
										case "end/enter_end_gateway":
											adv = advSet(Material.ENDER_PEARL, "遠方への逃走", "島を脱出する");
											break;
										case "end/respawn_dragon":
											adv = advSet(Material.END_CRYSTAL, "おしまい…再び…", "エンダードラゴンを復活させる");
											break;
										case "end/dragon_breath":
											adv = advSet(Material.DRAGON_BREATH, "口臭に気をつけよう", "ガラス瓶にドラゴンの息を集める");
											break;
										case "end/find_end_city":
											adv = advSet(Material.PURPUR_BLOCK, "ゲームの果ての都市", "入りたまえ、何が起こるだろうか？");
											break;
										case "end/elytra":
											adv = advSet(Material.ELYTRA, "空はどこまでも高く", "エリトラを見つける");
											break;
										case "end/levitate":
											adv = advSet(Material.SHULKER_BOX, "ここからの素晴らしい眺め", "シュルカーの攻撃で50ブロック以上浮遊する");
											break;

										case "adventure/root":
											adv = advSet(Material.PAPER, "冒険", "冒険、探索、戦闘");
											break;
										case "adventure/voluntary_exile":
											adv = advSet(Material.BLACK_BANNER, "自主的な亡命", "襲撃隊の大将を倒す。当分の間村から離れて過ごされてみてはいかがでしょうか...");
											break;
										case "adventure/kill_a_mob":
											adv = advSet(Material.IRON_SWORD, "モンスターハンター", "敵対的なモンスターを倒す");
											break;
										case "adventure/trade":
											adv = advSet(Material.EMERALD, "良い取引だ！", "村人と取引をする");
											break;
										case "adventure/honey_block_slide":
											adv = advSet(Material.HONEY_BLOCK, "べとべとな状況", "	ハチミツブロックに飛び込み、落下を阻止する");
											break;
										case "adventure/ol_besty":
											adv = advSet(Material.CROSSBOW, "おてんば", "クロスボウを撃つ");
											break;
										case "adventure/sleep_in_bed":
											adv = advSet(Material.RED_BED, "良い夢見てね", "リスポーン地点を設定する");
											break;
										case "adventure/hero_of_the_village":
											adv = advSet(Material.BLACK_BANNER, "村の英雄", "襲撃から村を守る");
											break;
										case "adventure/throw_trident":
											adv = advSet(Material.TRIDENT, "もったいぶった一言", "トライデントを投げつける。");
											break;
										case "adventure/shoot_arrow":
											adv = advSet(Material.BOW, "狙いを定めて", "弓と矢で何かを撃つ");
											break;
										case "adventure/kill_all_mobs":
											adv = advSet(Material.DIAMOND_SWORD, "モンスター狩りの達人", "すべての種類の敵対的なモンスターを倒す");
											break;
										case "adventure/totem_of_undying":
											adv = advSet(Material.TOTEM_OF_UNDYING, "死を超えて", "不死のトーテムを使用して死を免れる");
											break;
										case "adventure/summon_iron_golem":
											adv = advSet(Material.PUMPKIN, "お手伝いさん", "村を守ってもらうためにアイアンゴーレムを召喚する");
											break;
										case "adventure/two_birds_one_arrow":
											adv = advSet(Material.CROSSBOW, "一石二鳥", "矢を貫通させて2体のファントムを倒す");
											break;
										case "adventure/whos_the_pillager_now":
											adv = advSet(Material.CROSSBOW, "どっちが略奪者？", "略奪者を奴らの手段で懲らしめる");
											break;
										case "adventure/arbalistic":
											adv = advSet(Material.CROSSBOW, "クロスボウの達人", "5種類のMobをクロスボウを使って一度に倒す");
											break;
										case "adventure/adventuring_time":
											adv = advSet(Material.DIAMOND_BOOTS, "冒険の時間", "すべての種類のバイオームを発見する");
											break;
										case "adventure/very_very_frightening":
											adv = advSet(Material.TRIDENT, "とてもとても恐ろしい", "雷で村人を打つ");
											break;
										case "adventure/sniper_duel":
											adv = advSet(Material.ARROW, "スナイパー対決", "50m以上離れた場所からスケルトンを倒す");
											break;

										case "husbandry/root":
											adv = advSet(Material.HAY_BLOCK, "農業", "この世界は友達と食べ物でいっぱいです");
											break;
										case "husbandry/safely_harvest_honey":
											adv = advSet(Material.HONEY_BOTTLE, "大切なお客様", "	焚き火を利用してミツバチを怒らせずにガラス瓶でハチミツを手に入れる");
											break;
										case "husbandry/breed_an_animal":
											adv = advSet(Material.WHEAT, "コウノトリの贈り物", "動物を繁殖させる");
											break;
										case "husbandry/tame_an_animal":
											adv = advSet(Material.LEAD, "永遠の親友となるだろう", "動物を手懐ける");
											break;
										case "husbandry/fishy_business":
											adv = advSet(Material.FISHING_ROD, "生臭い仕事", "魚を釣る");
											break;
										case "husbandry/silk_touch_nest":
											adv = advSet(Material.BEE_NEST, "完全な引越し", "シルクタッチを使用して、3匹のミツバチが中に入っているハチの巣を移動する");
											break;
										case "husbandry/plant_seed":
											adv = advSet(Material.WHEAT, "種だらけの場所", "種を植え、成長を観察する");
											break;
										case "husbandry/bred_all_animals":
											adv = advSet(Material.GOLDEN_CARROT, "二匹ずつ", "すべての種類の動物を繁殖させる");
											break;
										case "husbandry/complete_catalogue":
											adv = advSet(Material.COD, "猫大全集", "すべての種類のネコを手懐ける");
											break;
										case "husbandry/tactical_fishing":
											adv = advSet(Material.PUFFERFISH_BUCKET, "戦術的漁業", "魚を捕る... 釣竿なしで！");
											break;
										case "husbandry/balanced_diet":
											adv = advSet(Material.APPLE, "バランスの取れた食事", "身体にどんな影響があろうと、食べられるものはすべて食べる");
											break;
										case "husbandry/break_diamond_hoe":
											adv = advSet(Material.DIAMOND_HOE, "真面目な献身", "ダイヤモンドのクワを使い切り、自分について考え直す");
											break;

										default:
											adv = new ItemStack(Material.BARRIER);


										}
							}
							selectedadvs.setItem(i,adv);
							c++;
						}
					}
					if(selectedadvs != null)e.getPlayer().openInventory(selectedadvs);
				}
			}
		}

	}

	private ItemStack advSet(Material m, String name, String lore_) {
		//List<String> lore = Arrays.asList(ChatColor.RESET + lore_);
		ItemStack adv = new ItemStack(m);
		ItemMeta advmeta = adv.getItemMeta();
		advmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		advmeta.setDisplayName(ChatColor.YELLOW + name);
		advmeta.setLocalizedName(name);
		//advmeta.setLore(lore);
		adv.setItemMeta(advmeta);
		return adv;
	}

}
