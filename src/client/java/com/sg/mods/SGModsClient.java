package com.sg.mods;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class SGModsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		initAttack();
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
}