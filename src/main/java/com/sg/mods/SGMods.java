package com.sg.mods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sg.mods.events.RecoverExpEvent;
import com.sg.mods.events.SpawnEvents;
import com.sg.mods.events.StoreExpEvent;

public class SGMods implements ModInitializer {
	public static final String MOD_ID = "sg-mods";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final List<RegistryKey<Enchantment>> tridentEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.BREACH, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> maceEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.IMPALING, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> swordEnchantments = List.of(Enchantments.BREACH, Enchantments.IMPALING);
	public static final List<RegistryKey<Enchantment>> axeEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.BREACH, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> crossbowEnchantments = List.of(Enchantments.FLAME, Enchantments.POWER, Enchantments.PUNCH, Enchantments.INFINITY);
	public static final List<RegistryKey<Enchantment>> bowEnchantments = List.of(Enchantments.PIERCING, Enchantments.MULTISHOT);
	public static final List<RegistryKey<Enchantment>> protectionEnchantments = List.of(Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION);
	public static final List<RegistryKey<Enchantment>> shieldEnchantments = List.of(Enchantments.THORNS);
	private static DynamicRegistryManager dynamicRegistryManager;
	public static final int EXPERIENCE_PER_BOTTLE = 30;

	@Override
	public void onInitialize() {
		initBedrock();
		initEchantments();
		initXPStore();
		initSpawns();
	}

	public static void initBedrock(){
		UseBlockCallback.EVENT.register((player, world, hand, result) -> {
			ItemStack itemInHand = player.getStackInHand(hand);
			String interactingBlockName = world.getBlockState(result.getBlockPos()).getBlock().getName().getString();
			boolean isUsingDragonBreath = itemInHand.getItem().getName().getString()
					.equals(Items.DRAGON_BREATH.getName().getString());
			boolean isInteractingWithBedrock = interactingBlockName.equals(Blocks.BEDROCK.getName().getString());
			if(!isInteractingWithBedrock || !isUsingDragonBreath){
			return ActionResult.PASS;
				
			}
			world.breakBlock(result.getBlockPos(), false);
			player.increaseStat(Stats.USED.getOrCreateStat(itemInHand.getItem()), 1);
			itemInHand.setCount(itemInHand.getCount() - 1);
			player.giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
			return ActionResult.PASS;
		});
	}
	public static boolean isSameEnchanment(Enchantment enchantment,RegistryKey<Enchantment>  enchanmentRegistry){
		boolean res=  dynamicRegistryManager.getOptional(RegistryKeys.ENCHANTMENT).get().getEntry(enchantment).matchesKey(enchanmentRegistry);

		return res;
	}
	
	public static boolean containsEnchanment(Enchantment enchantment, List<RegistryKey<Enchantment>> enchanments){
		for(RegistryKey<Enchantment> e : enchanments){
			if(SGMods.isSameEnchanment(enchantment, e)){
				return true;
			}
		}
		return false;
	}
	public static void initEchantments(){
		ServerLifecycleEvents.SERVER_STARTED.register(server->{
			dynamicRegistryManager = server.getRegistryManager();
		});
	}

	public static void initXPStore(){
		StoreExpEvent.registerStoreXP();
		RecoverExpEvent.registerUseExperienceBottle();
	}
	public static void initSpawns(){
		SpawnEvents.registerBreezeSpawn();
		SpawnEvents.registerCaveSpiderSpawn();
		SpawnEvents.registerSilverfishSpawn();
		SpawnEvents.registerIllusionerSpawn();
	}
}