package com.github.varuhait.advancementta;


import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.varuhait.advancementta.AdvancementList.AdvancementClick;
import com.github.varuhait.advancementta.AdvancementList.AdvancementListGUI;
import com.github.varuhait.advancementta.AdvancementList.AdvancementListener;
import com.github.varuhait.advancementta.AdvancementList.CreateGUIInventory;
import com.github.varuhait.advancementta.Teams.PlayerRandomTeam;
import com.github.varuhait.advancementta.Teams.TeamChat;
import com.github.varuhait.advancementta.Teams.TeamInitialization;


public class Main extends JavaPlugin implements CommandExecutor{


	@Override
	public void onEnable() {
		this.saveDefaultConfig();

		getCommand("so").setExecutor(new CreateGUIInventory(this));
		getCommand("rdt").setExecutor(new PlayerRandomTeam());
		getCommand("t").setExecutor(new TeamChat());
		getCommand("start").setExecutor(new Start(this));

		getServer().getPluginManager().registerEvents(new AdvancementListGUI(), this);
		getServer().getPluginManager().registerEvents(new AdvancementListener(this), this);
		getServer().getPluginManager().registerEvents(new AdvancementClick(), this);

		TeamInitialization.teamRegister();

		getLogger().info("ATA Enabled");
	}

	@Override
	public void onDisable() {
		getLogger().info("ATA Disabled");

	}
}