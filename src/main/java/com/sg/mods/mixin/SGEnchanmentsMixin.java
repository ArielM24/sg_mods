package com.sg.mods.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.sg.mods.SGMods;

@Mixin(Enchantment.class)
public abstract class SGEnchanmentsMixin {
	@ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
	public boolean isAcceptableItem(boolean original, ItemStack stack) {
		Enchantment enchantment = (Enchantment) (Object) this;
		// TRIDENT
		if (stack.getItem().getName().getString().contains(Items.TRIDENT.getName().getString())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.tridentEnchantments)) {
				return true;
			}
			return original;
		}
		// MACE
		if (stack.getItem().getName().getString().contains(Items.MACE.getName().getString())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.maceEnchantments)) {
				return true;
			}
			return original;
		}
		// SWORD
		if (isSword(stack.getItem())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.swordEnchantments)) {
				return true;
			}
			return original;
		}
		// AXE
		if (isAxe(stack.getItem())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.axeEnchantments)) {
				return true;
			}
			return original;
		}
		// CROSSBOW
		if (stack.getItem().getName().getString().contains(Items.CROSSBOW.getName().getString())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.crossbowEnchantments)) {
				return true;
			}
			return original;
		}
		// BOW
		if (stack.getItem().getName().getString().contains(Items.BOW.getName().getString())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.bowEnchantments)) {
				return true;
			}
			return original;
		}
		// SHIELD
		if (stack.getItem().getName().getString().contains(Items.SHIELD.getName().getString())) {
			if (SGMods.containsEnchanment(enchantment, SGMods.shieldEnchantments)) {
				return true;
			}
			return original;
		}
		return original;
	}

	private static boolean isSword(Item item) {
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

	@ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second){
		if(SGMods.containsEnchanment(first.value(), SGMods.protectionEnchantments) && SGMods.containsEnchanment(second.value(), SGMods.protectionEnchantments)){
			return true;
		}
		if((SGMods.isSameEnchanment(first.value(), Enchantments.INFINITY) && SGMods.isSameEnchanment(second.value(), Enchantments.MENDING))||(SGMods.isSameEnchanment(first.value(), Enchantments.MENDING) && SGMods.isSameEnchanment(second.value(), Enchantments.INFINITY))){
			return true;
		}
		return original;
	}

	private static boolean isAxe(Item item) {
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
}