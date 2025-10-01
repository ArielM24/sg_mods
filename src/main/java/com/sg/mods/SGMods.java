package com.sg.mods;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sg.mods.init.InitMods;

public class SGMods implements ModInitializer {
	public static final String MOD_ID = "sg-mods";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		InitMods.initRegistryManager();
		InitMods.initBedrockBreaker();
		InitMods.initExpStorer();
		InitMods.initMobSpawnEvents();
		InitMods.initMobTrimsEvents();
		InitMods.initRotationEvents();
		InitMods.initStackEvents();
		InitMods.initTotemEvents();
		InitMods.initTradesEvents();
		InitMods.initVaultEvents();
	}
}