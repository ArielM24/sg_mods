package com.sg.mods.util;

import java.util.List;

import com.sg.mods.SGMods;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.server.world.ServerWorld;

public class ModFunctions {
    public static boolean isSameEnchanment(Enchantment enchantment,RegistryKey<Enchantment>  enchanmentRegistry){
		boolean res = ModConstants.dynamicRegistryManager.getOptional(RegistryKeys.ENCHANTMENT).get().getEntry(enchantment).matchesKey(enchanmentRegistry);
		return res;
	}
	
	public static boolean containsEnchanment(Enchantment enchantment, List<RegistryKey<Enchantment>> enchanments){
		for(RegistryKey<Enchantment> e : enchanments){
			if(isSameEnchanment(enchantment, e)){
				return true;
			}
		}
		return false;
	}
    public static boolean isSword(Item item) {
		if (item.getName().getString().contains(Items.WOODEN_SWORD.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.STONE_SWORD.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.GOLDEN_SWORD.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.IRON_SWORD.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.DIAMOND_SWORD.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.NETHERITE_SWORD.getName().getString())) {
			return true;
		}
		return false;
	}
    public static boolean isAxe(Item item) {
		if (item.getName().getString().contains(Items.WOODEN_AXE.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.STONE_AXE.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.GOLDEN_AXE.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.IRON_AXE.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.DIAMOND_AXE.getName().getString())) {
			return true;
		}
		if (item.getName().getString().contains(Items.NETHERITE_AXE.getName().getString())) {
			return true;
		}
		return false;
	}
    public static void applyTrim(Entity entity, ServerWorld world){
		try{
			HostileEntity hostileEntity = null;
			if(entity instanceof ZombieEntity){
				hostileEntity = (ZombieEntity)entity;
			}else if(entity instanceof SkeletonEntity){
				hostileEntity = (SkeletonEntity)entity;
			}

			ItemStack head = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.HEAD);
			ItemStack chest = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.CHEST);
			ItemStack legs = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.LEGS);
			ItemStack feet = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.FEET);
			
			Reference<ArmorTrimMaterial> trimMaterial = world.getRegistryManager().getOrThrow(RegistryKeys.TRIM_MATERIAL).getRandom(world.random).get();
			Reference<ArmorTrimPattern> trimPattern = world.getRegistryManager().getOrThrow(RegistryKeys.TRIM_PATTERN).getRandom(world.random).get();

			ArmorTrim at = new ArmorTrim(trimMaterial, trimPattern);
			head.set(DataComponentTypes.TRIM, at);
			hostileEntity.equipStack(EquipmentSlot.HEAD, head);
			chest.set(DataComponentTypes.TRIM, at);
			hostileEntity.equipStack(EquipmentSlot.CHEST, head);
			legs.set(DataComponentTypes.TRIM, at);
			hostileEntity.equipStack(EquipmentSlot.LEGS, head);
			feet.set(DataComponentTypes.TRIM, at);
			hostileEntity.equipStack(EquipmentSlot.FEET, head);
		}catch(Exception ex){
			SGMods.LOGGER.info(ex.toString());
		}
	}
}
