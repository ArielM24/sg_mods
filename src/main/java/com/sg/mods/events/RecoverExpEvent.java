package com.sg.mods.events;

import com.sg.mods.SGMods;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class RecoverExpEvent {
    public static void registerUseExperienceBottle(){
		UseItemCallback.EVENT.register((player, world, hand)-> {
			ItemStack stack = player.getStackInHand(hand);
			if(player.getStackInHand(hand).getItemName().getString().equals(Items.EXPERIENCE_BOTTLE.getName().getString()) ){
				ExperienceOrbEntity exp = new ExperienceOrbEntity(world,player.getX(), player.getY(), player.getZ(),SGMods.EXPERIENCE_PER_BOTTLE);
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
