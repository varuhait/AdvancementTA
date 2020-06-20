package com.github.varuhait.advancementta.AdvancementList;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import com.github.varuhait.advancementta.Main;

public class CreateGUIInventory implements CommandExecutor{
	private final Main plg;

	public CreateGUIInventory(Main plg_) {
		plg = plg_;
	}

	Inventory selectedadvs = null;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "使用方法：/so v");
			return true;
		}
		if(args[0] != "v") {
			sender.sendMessage(ChatColor.RED + "使用方法：/so v");
			return true;
		}

		int square = 5;
		List<String> advs = new AdvancementSelection(args[0], square).AllAdv;
		FileConfiguration conf = plg.getConfig();
		conf.set("advs", advs);
		conf.set("square", square);
		conf.set("objs", true);

		List<Integer> owner = new ArrayList<Integer>();
		for(int i=0; i<Math.pow(square,2); i++) {
			owner.add(0);
		}
		conf.set("ownership", owner);
		sender.sendMessage("Vanillaモードで進捗リストの設定に成功しました");
		return true;
	}

}
