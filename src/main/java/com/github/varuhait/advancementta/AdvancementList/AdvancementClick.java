package com.github.varuhait.advancementta.AdvancementList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AdvancementClick implements Listener{

	ItemStack adv;
	String advname;

	@EventHandler
	public void AdClicked(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		adv = e.getCurrentItem();
		String invname = e.getView().getTitle();

		if(adv != null) {
			if(adv.getType() != Material.AIR) {
				if(invname == "目標進捗（クリックで条件表示）") {
				advname = adv.getItemMeta().getLocalizedName();
					if(advname != null) {

						switch(advname) {
							case "Minecraft":
								advExp(p, "Minecraft", "作業台をインベントリに入れる");
								break;
							case "石器時代":
								advExp(p, "石器時代", "丸石をインベントリに入れる");
								break;
							case "アップグレード":
								advExp(p, "アップグレード", "	石のツルハシをインベントリに入れる");
								break;
							case "金属を手に入れる":
								advExp(p, "金属を手に入れる", "鉄インゴットをインベントリに入れる");
								break;
							case "装備せよ":
								advExp(p, "装備せよ", "鉄の防具をインベントリに入れる");
								break;
							case "ホットスタッフ":
								advExp(p, "ホットスタッフ", "溶岩入りバケツをインベントリに入れる");
								break;
							case "鉄のツルハシで決まり":
								advExp(p, "鉄のツルハシで決まり", "鉄のツルハシをインベントリに入れる");
								break;
							case "今日はやめておきます":
								advExp(p, "今日はやめておきます", "盾で発射物を跳ね返す");
								break;
							case "アイス・バケツ・チャレンジ":
								advExp(p, "アイス・バケツ・チャレンジ", "黒曜石をインベントリに入れる");
								break;
							case "ダイヤモンド！":
								advExp(p, "ダイヤモンド！", "ダイヤモンドをインベントリに入手する");
								break;
							case "さらなる深みへ":
								advExp(p, "さらなる深みへ", "ネザーへ行く");
								break;
							case "ダイヤモンドで私を覆って":
								advExp(p, "ダイヤモンドで私を覆って", "ダイヤモンドの防具をインベントリに入れる");
								break;
							case "エンチャントの使い手":
								advExp(p, "エンチャントの使い手", "エンチャントテーブルでアイテムをエンチャントする");
								break;
							case "ゾンビドクター":
								advExp(p, "ゾンビドクター", "村人ゾンビを弱らせてから治療する");
								break;
							case "アイ・スパイ":
								advExp(p, "アイ・スパイ", "要塞に入る");
								break;
							case "おしまい？":
								advExp(p, "おしまい？", "ジ・エンドへ行くためにエンドポータルに入る");
								break;

							case "ネザー":
								advExp(p, "ネザー", "ネザーポータルを使ってネザーに行く");
								break;
							case "差出人に返送":
								advExp(p, "差出人に返送", "ガストの火の玉を用いてガストを倒す");
								break;
							case "亜空間バブル":
								advExp(p, "亜空間バブル", "ネザーを利用してオーバーワールドでの7kmを移動する");
								break;
							case "恐ろしい要塞":
								advExp(p, "恐ろしい要塞", "ネザー要塞に侵入する");
								break;
							case "不安な同盟":
								advExp(p, "不安な同盟", "ガストをオーバーワールドで殺す");
								break;
							case "不気味で怖いスケルトン":
								advExp(p, "不気味で怖いスケルトン", "ウィザースケルトンの頭蓋骨をインベントリに入手する");
								break;
							case "炎の中へ":
								advExp(p, "炎の中へ", "ブレイズロッドをインベントリに入手する");
								break;
							case "荒が丘":
								advExp(p, "荒が丘", "ウィザーを召喚する");
								break;
							case "町のお薬屋さん":
								advExp(p, "町のお薬屋さん", "ポーションを醸造する");
								break;
							case "生活のビーコン":
								advExp(p, "生活のビーコン", "ビーコンを準備して起動させる");
								break;
							case "猛烈なカクテル":
								advExp(p, "猛烈なカクテル", "すべての種類のポーション効果の付与を同時に受ける");
								break;
							case "ビーコネーター":
								advExp(p, "ビーコネーター", "最大パワーのビーコンを作る");
								break;
							case "どうやってここまで？":
								advExp(p, "どうやってここまで？", "すべての種類の効果の付与を同時に受ける");
								break;

							case "ジ・エンド":
								advExp(p, "ジ・エンド", "	エンドポータルを使ってジ・エンドに行く");
								break;
							case "エンドの解放":
								advExp(p, "エンドの解放", "エンダードラゴンを倒す");
								break;
							case "ザ・ネクストジェネレーション":
								advExp(p, "ザ・ネクストジェネレーション", "ドラゴンの卵をインベントリに入手する");
								break;
							case "遠方への逃走":
								advExp(p, "遠方への逃走", "エンドゲートウェイを通過する");
								break;
							case "おしまい…再び…":
								advExp(p, "おしまい…再び…", "それぞれの辺に1個ずつ、計4つのエンドクリスタルを出口ポータルに設置する");
								break;
							case "口臭に気をつけよう":
								advExp(p, "口臭に気をつけよう", "ドラゴンブレスの瓶をインベントリに入れる");
								break;
							case "ゲームの果ての都市":
								advExp(p, "ゲームの果ての都市", "	エンドシティに入る");
								break;
							case "空はどこまでも高く":
								advExp(p, "空はどこまでも高く", "エリトラをインベントリに入れる");
								break;
							case "ここからの素晴らしい眺め":
								advExp(p, "ここからの素晴らしい眺め", "浮遊の効果を受けた状態で垂直距離を50ブロック分移動する");
								break;

							case "冒険":
								advExp(p, "冒険", "任意のエンティティを倒すか、エンティティによって倒される");
								break;
							case "自主的な亡命":
								advExp(p, "自主的な亡命", "ピリジャーの前哨基地または襲撃隊の大将から不吉な旗を入手する");
								break;
							case "モンスターハンター":
								advExp(p, "モンスターハンター", "敵対的なモンスターを倒す");
								break;
							case "良い取引だ！":
								advExp(p, "良い取引だ！", "村人と取引をする");
								break;
							case "べとべとな状況":
								advExp(p, "べとべとな状況", "	ハチミツブロックに飛び込み、落下を阻止する");
								break;
							case "おてんば":
								advExp(p, "おてんば", "クロスボウを撃つ");
								break;
							case "良い夢見てね":
								advExp(p, "良い夢見てね", "	ベッドの上で横になる");
								break;
							case "村の英雄":
								advExp(p, "村の英雄", "襲撃から村を守る");
								break;
							case "もったいぶった一言":
								advExp(p, "もったいぶった一言", "トライデントを投げつける");
								break;
							case "狙いを定めて":
								advExp(p, "狙いを定めて", "弓と矢で何かを撃つ");
								break;
							case "モンスター狩りの達人":
								advExp(p, "モンスター狩りの達人", "すべての種類の敵対的なモンスターを倒す");
								break;
							case "死を超えて":
								advExp(p, "死を超えて", "不死のトーテムを使用して死を免れる");
								break;
							case "お手伝いさん":
								advExp(p, "お手伝いさん", "アイアンゴーレムを召喚する");
								break;
							case "一石二鳥":
								advExp(p, "一石二鳥", "矢を貫通させて2体のファントムを倒す");
								break;
							case "どっちが略奪者？":
								advExp(p, "どっちが略奪者？", "クロスボウを使用してピリジャーを倒す");
								break;
							case "クロスボウの達人":
								advExp(p, "クロスボウの達人", "5種類のMobをクロスボウを使って一度に倒す");
								break;
							case "冒険の時間":
								advExp(p, "冒険の時間", "すべての種類のバイオームを発見する");
								break;
							case "とてもとても恐ろしい":
								advExp(p, "とてもとても恐ろしい", "召雷のエンチャントを施したトライデントを村人に投げつけ、生み出した雷で村人を打つ");
								break;
							case "スナイパー対決":
								advExp(p, "スナイパー対決", "50m以上離れた場所からスケルトンを倒す");
								break;

							case "農業":
								advExp(p, "農業", "食べられるものを何か1つ食べる");
								break;
							case "大切なお客様":
								advExp(p, "大切なお客様", "	焚き火を利用してミツバチを怒らせずにガラス瓶でハチミツを手に入れる");
								break;
							case "コウノトリの贈り物":
								advExp(p, "コウノトリの贈り物", "動物を繁殖させる");
								break;
							case "永遠の親友となるだろう":
								advExp(p, "永遠の親友となるだろう", "動物を手懐ける");
								break;
							case "生臭い仕事":
								advExp(p, "生臭い仕事", "釣り竿を使って魚を釣る");
								break;
							case "完全な引越し":
								advExp(p, "完全な引越し", "シルクタッチを使用して、3匹のミツバチが中に入っているハチの巣を移動する");
								break;
							case "種だらけの場所":
								advExp(p, "種だらけの場所", "種を植える");
								break;
							case "二匹ずつ":
								advExp(p, "二匹ずつ", "すべての種類の動物を繁殖させる");
								break;
							case "猫大全集":
								advExp(p, "猫大全集", "すべての種類のネコを手懐ける");
								break;
							case "戦術的漁業":
								advExp(p, "戦術的漁業", "水入りバケツを魚に対して使用し、魚入りバケツを作る");
								break;
							case "バランスの取れた食事":
								advExp(p, "バランスの取れた食事", "身体にどんな影響があろうと、食べられるものはすべて食べる");
								break;
							case "青チーム獲得済み":
								p.sendMessage(ChatColor.BLUE + "この実績は青チームが獲得済みです");
								p.closeInventory();
								break;
							case "赤チーム獲得済み":
								p.sendMessage(ChatColor.RED + "この実績は赤チームが獲得済みです");
								p.closeInventory();
								break;

							default:
								break;
						}
					}
				}
			}
		}
	}

	private void advExp(Player player, String advname, String advexp) {
		player.sendMessage(ChatColor.GREEN + "実績名：" + ChatColor.YELLOW + advname);
		player.sendMessage(ChatColor.GREEN + "条件  ：" + ChatColor.RESET + advexp);
		player.closeInventory();
	}
}
