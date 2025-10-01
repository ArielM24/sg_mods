package com.sg.mods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.CompassItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class SGModsClient implements ClientModInitializer {
	private static final Identifier HUD_LAYER = Identifier.of(SGMods.MOD_ID, "compass-layer");
	@Override
	public void onInitializeClient() {
		initAttack();
		initElytra();
		initCompass();
	}

	public static void initAttack(){
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			PlayerEntity player = client.player;
			if (player == null) {
				return;
			}
			HitResult hit = client.crosshairTarget;
			if ((player.age % 40) != 39) {
				return;
			}
			if (!(hit instanceof EntityHitResult)) {
				return;
			}
			EntityHitResult entityHitResult = (EntityHitResult) hit;
			Entity entity = entityHitResult.getEntity();
			PlayerInventory inv = player.getInventory();
			ArrayList<String> hitTargets = new ArrayList<>();
			if (inv.isEmpty()) {
				return;
			}
			ItemStack firstSlot = inv.getStack(9);
			if (firstSlot.isEmpty()) {
				return;
			}
			Text customName = firstSlot.getCustomName();
			if (customName == null) {
				return;
			}
			if (!customName.getString().startsWith("hit")) {
				return;
			}
			String[] targets = customName.getString().split("\\.");
			hitTargets.addAll(List.of(targets));
			if (hitTargets.isEmpty()) {
				return;
			}
			boolean isTarget = hitTargets.stream()
					.anyMatch(t -> entity.getName().getString().toLowerCase().contains(t.toLowerCase()));
			if (!isTarget) {
				return;
			}
			client.interactionManager.attackEntity(player, entity);
			player.swingHand(Hand.MAIN_HAND);
			client.interactionManager.stopUsingItem(player);
			return;
		});
	}
	public static void initElytra(){
		SwapKeyBinding keyBinding = new SwapKeyBinding("SG Elytra swap", GLFW.GLFW_KEY_Z, "SG Elytra swap");
		KeyBindingHelper.registerKeyBinding(keyBinding);
	}
	private static void initCompass(){
		HudElementRegistry.attachElementBefore(VanillaHudElements.HOTBAR, HUD_LAYER, SGModsClient::renderCompass);
	}
	private static void renderCompass(DrawContext ctx, RenderTickCounter tickCounter) {
		MinecraftClient client = MinecraftClient.getInstance();
		ClientPlayerEntity player = client.player;
		TextRenderer renderer = client.textRenderer;
		BlockPos pos = player.getBlockPos();
		PlayerInventory inv = client.player.getInventory();
		boolean hasCompass = inv.contains(is -> {
			return (is.getItem().toString().endsWith("compass") || is.getItem() instanceof CompassItem);
		});
		float degrees = MathHelper.wrapDegrees(player.getYaw());
		if (degrees < 0) {
			degrees += 360;
		}
		int facing = Math.round(degrees / 45);
		List<String> direction = Arrays.asList("S", "SW", "W", "NW", "N", "NE", "E", "SE", "S");
		
		if (hasCompass) {
			String displayFacing = direction.get(facing);
			String displayCoords = pos.toShortString();
			String displayBiome = client.world.getBiome(pos).getIdAsString().replaceAll("minecraft:", "").replaceAll("_", " ");

			ctx.drawText(renderer, String.format("%s %s", displayFacing, displayCoords), 10, 10,
					0xFFFFFFFF, false);
			ctx.drawText(renderer, String.format("%s%s", displayBiome.substring(0, 1).toUpperCase(), displayBiome.substring(1)), 10, 20,
					0xFFFFFFFF, false);
		}
	}
}