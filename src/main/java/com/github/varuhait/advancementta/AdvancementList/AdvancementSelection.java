package com.github.varuhait.advancementta.AdvancementList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class AdvancementSelection{

	List<String> AllAdv = new ArrayList<String>();

	public AdvancementSelection(String mode, int square) {
		switch(mode) {
		case "v":
			VanillaAdd(AllAdv);
			AllAdv = RandomSelect(AllAdv, square);
		}
	}

	private List<String> RandomSelect(List<String> a, int r) {

		List<String> result = new ArrayList<>();
		List<String> remaining = new ArrayList<>(a);
		Random random = new Random();
		for(int i=0; i<Math.pow(r, 2); i++) {
			int remainingCount = remaining.size();
			int ind = random.nextInt(remainingCount);

			String selected = remaining.get(ind);
			result.add(selected);

			String last = remaining.remove(remainingCount - 1);
			if(ind < remainingCount - 1) {
				remaining.set(ind, last);
			}
		}
		return result;
	}

	private void VanillaAdd(List<String> a) {
		a.addAll(Arrays.asList(
				//Minecraftタブ
				"story/root","story/mine_stone","story/upgrade_tools","story/smelt_iron",
				"story/obtain_armor","story/lava_bucket","story/iron_tools","story/deflect_arrow",
				"story/form_obsidian","story/mine_diamond","story/enter_the_nether","story/shiny_gear",
				"story/enchant_item","story/cure_zombie_villager","story/follow_ender_eye",	"story/enter_the_end",

				//Netherタブ
				"nether/root","nether/return_to_sender","nether/fast_travel","nether/find_fortress",
				"nether/uneasy_alliance","nether/get_wither_skull","nether/obtain_blaze_rod","nether/summon_wither",
				"nether/brew_potion","nether/create_beacon","nether/all_potions","nether/create_full_beacon",
				"nether/all_effects",

				//Endタブ
				"end/root","end/kill_dragon","end/dragon_egg","end/enter_end_gateway",
				"end/respawn_dragon","end/dragon_breath","end/find_end_city","end/elytra",
				"end/levitate",

				//Adventureタブ
				"adventure/root","adventure/voluntary_exile","adventure/kill_a_mob","adventure/trade",
				"adventure/honey_block_slide","adventure/ol_besty","adventure/sleep_in_bed","adventure/hero_of_the_village",
				"adventure/throw_trident","adventure/shoot_arrow","adventure/kill_all_mobs","adventure/totem_of_undying",
				"adventure/summon_iron_golem","adventure/two_birds_one_arrow","adventure/whos_the_pillager_now","adventure/arbalistic",
				"adventure/adventuring_time","adventure/very_very_frightening","adventure/sniper_duel",

				//Husbandryタブ
				"husbandry/root","husbandry/safely_harvest_honey","husbandry/breed_an_animal","husbandry/tame_an_animal",
				"husbandry/fishy_business","husbandry/silk_touch_nest","husbandry/plant_seed","husbandry/bred_all_animals",
				"husbandry/complete_catalogue","husbandry/tactical_fishing","husbandry/balanced_diet","husbandry/break_diamond_hoe"));
	}

}
