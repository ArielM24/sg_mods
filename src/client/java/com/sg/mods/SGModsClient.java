package com.sg.mods;


import com.sg.mods.init.InitClientMods;

import net.fabricmc.api.ClientModInitializer;

public class SGModsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		InitClientMods.initAutoAttackEvents();
		InitClientMods.initCompassEvents();
		InitClientMods.initSwapElytraEvents();
	}
}