package com.sg.mods.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.sg.mods.util.ModConstants;
import com.sg.mods.util.ModFunctions;

@Mixin(Enchantment.class)
public abstract class SGEnchanmentsMixin {
	@ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
	public boolean isAcceptableItem(boolean original, ItemStack stack) {
		Enchantment enchantment = (Enchantment) (Object) this;
		// TRIDENT
		if (stack.getItem().getName().getString().contains(Items.TRIDENT.getName().getString())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.tridentEnchantments)) {
				return true;
			}
			return original;
		}
		// MACE
		if (stack.getItem().getName().getString().contains(Items.MACE.getName().getString())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.maceEnchantments)) {
				return true;
			}
			return original;
		}
		// SWORD
		if (ModFunctions.isSword(stack.getItem())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.swordEnchantments)) {
				return true;
			}
			return original;
		}
		// AXE
		if (ModFunctions.isAxe(stack.getItem())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.axeEnchantments)) {
				return true;
			}
			return original;
		}
		// CROSSBOW
		if (stack.getItem().getName().getString().contains(Items.CROSSBOW.getName().getString())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.crossbowEnchantments)) {
				return true;
			}
			return original;
		}
		// BOW
		if (stack.getItem().getName().getString().contains(Items.BOW.getName().getString())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.bowEnchantments)) {
				return true;
			}
			return original;
		}
		// SHIELD
		if (stack.getItem().getName().getString().contains(Items.SHIELD.getName().getString())) {
			if (ModFunctions.containsEnchanment(enchantment, ModConstants.shieldEnchantments)) {
				return true;
			}
			return original;
		}
		return original;
	}

	

	@ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second){
		if(ModFunctions.containsEnchanment(first.value(), ModConstants.protectionEnchantments) && ModFunctions.containsEnchanment(second.value(), ModConstants.protectionEnchantments)){
			return true;
		}
		if((ModFunctions.isSameEnchanment(first.value(), Enchantments.INFINITY) && ModFunctions.isSameEnchanment(second.value(), Enchantments.MENDING))||(ModFunctions.isSameEnchanment(first.value(), Enchantments.MENDING) && ModFunctions.isSameEnchanment(second.value(), Enchantments.INFINITY))){
			return true;
		}
		return original;
	}

	
}