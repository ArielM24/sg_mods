package com.sg.mods.events;

import com.sg.mods.SGMods;
import com.sg.mods.SGModsClient;
import com.sg.mods.util.RenderUtils;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.util.Identifier;

public class CompassEvents {
    public static void registerRenderCompassEvent(){
		HudElementRegistry.attachElementBefore(VanillaHudElements.HOTBAR, Identifier.of(SGMods.MOD_ID, "compass-layer"), RenderUtils::renderCompass);
	}
}
