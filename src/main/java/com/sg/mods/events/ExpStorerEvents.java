package com.sg.mods.events;

import com.sg.mods.util.ModConstants;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class ExpStorerEvents {
    public static void registerStoreExpEvent() {
		UseBlockCallback.EVENT.register((player, world, hand, result)->{
			ItemStack itemInHand = player.getStackInHand(hand);
			String interactingBlockName = world.getBlockState(result.getBlockPos()).getBlock().getName().getString();
			boolean isUsingEmptyBlottle = itemInHand.getItem().getName().getString().equals(Items.GLASS_BOTTLE.getName().getString());
			boolean isInteractingWithEnchantingTable = interactingBlockName.equals(Blocks.ENCHANTING_TABLE.getName().getString());
			boolean hasEnoughExperience = (player.totalExperience >= ModConstants.EXPERIENCE_PER_BOTTLE);
			if(isUsingEmptyBlottle && isInteractingWithEnchantingTable && hasEnoughExperience){
				player.getStackInHand(hand).setCount(itemInHand.getCount() - 1);
				player.addExperience(-ModConstants.EXPERIENCE_PER_BOTTLE);
				ItemStack experienceBottle = new ItemStack(Items.EXPERIENCE_BOTTLE);
				player.giveOrDropStack(experienceBottle);
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}

    public static void registerRecoverExpEvent(){
		UseItemCallback.EVENT.register((player, world, hand)-> {
			ItemStack stack = player.getStackInHand(hand);
			if(player.getStackInHand(hand).getItemName().getString().equals(Items.EXPERIENCE_BOTTLE.getName().getString()) ){
				ExperienceOrbEntity exp = new ExperienceOrbEntity(world,player.getX(), player.getY(), player.getZ(),ModConstants.EXPERIENCE_PER_BOTTLE);
				world.spawnEntity(exp);
				player.getStackInHand(hand).setCount(stack.getCount() - 1);
				ItemStack experienceBottle = new ItemStack(Items.GLASS_BOTTLE);
				player.giveOrDropStack(experienceBottle);
				return ActionResult.SUCCESS;
			}
			return ActionResult.PASS;
		});
	}
}
