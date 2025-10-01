package com.sg.mods.events;

import com.sg.mods.SGMods;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class StoreExpEvent {
    public static void registerStoreXP() {
		UseBlockCallback.EVENT.register((player, world, hand, result)->{
			ItemStack itemInHand = player.getStackInHand(hand);
			String interactingBlockName = world.getBlockState(result.getBlockPos()).getBlock().getName().getString();
			boolean isUsingEmptyBlottle = itemInHand.getItem().getName().getString().equals(Items.GLASS_BOTTLE.getName().getString());
			boolean isInteractingWithEnchantingTable = interactingBlockName.equals(Blocks.ENCHANTING_TABLE.getName().getString());
			boolean hasEnoughExperience = (player.totalExperience >= SGMods.EXPERIENCE_PER_BOTTLE);
			if(isUsingEmptyBlottle && isInteractingWithEnchantingTable && hasEnoughExperience){
				player.getStackInHand(hand).setCount(itemInHand.getCount() - 1);
				player.addExperience(-SGMods.EXPERIENCE_PER_BOTTLE);
				ItemStack experienceBottle = new ItemStack(Items.EXPERIENCE_BOTTLE);
				player.giveOrDropStack(experienceBottle);
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}
}
