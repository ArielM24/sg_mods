package com.sg.mods.events;

import org.lwjgl.glfw.GLFW;

import com.sg.mods.util.SwapKeyBinding;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class SwapElytraEvents {
    public static void registerSwapElytraEvent(){
		SwapKeyBinding keyBinding = new SwapKeyBinding("SG Elytra swap", GLFW.GLFW_KEY_Z, "SG Elytra swap");
		KeyBindingHelper.registerKeyBinding(keyBinding);
	}
}
