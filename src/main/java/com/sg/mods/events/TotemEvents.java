package com.sg.mods.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;

public class TotemEvents {
    public static void registerTotemEvent(){
		ServerLivingEntityEvents.ALLOW_DEATH.register((LivingEntity le, DamageSource ds, float damageAmount) -> {
			if (!(le instanceof ServerPlayerEntity)) {
				return true;
			}
			ServerPlayerEntity player = (ServerPlayerEntity) le;
			PlayerInventory inv = player.getInventory();

			if (!inv.contains(is -> is.getItem().equals(Items.TOTEM_OF_UNDYING))) {
				return true;
			}
			ItemStack totemstack = null;
			for (int i = 0; i < inv.size(); i++) {
				ItemStack stack = inv.getStack(i);
				if (stack.getItem().equals(Items.TOTEM_OF_UNDYING)) {
					totemstack = stack;
					break;
				}
			}
			player.increaseStat(Stats.USED.getOrCreateStat(Items.TOTEM_OF_UNDYING), 1);
			Criteria.USED_TOTEM.trigger(player, totemstack);
			player.setHealth(1.0F);
			player.clearStatusEffects();
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
			player.getEntityWorld().sendEntityStatus(player, (byte)35);
			totemstack.setCount(totemstack.getCount() - 1);
			return false;
		});
	}
}
