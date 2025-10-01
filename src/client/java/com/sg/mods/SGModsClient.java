package com.sg.mods;


import com.sg.mods.init.InitMods;

import net.fabricmc.api.ClientModInitializer;

public class SGModsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		InitMods.initAutoAttackEvents();
		InitMods.initCompassEvents();
		InitMods.initSwapElytraEvents();
	}
}