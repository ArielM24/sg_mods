package com.sg.mods.events;

import com.sg.mods.util.ModConstants;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.enums.Orientation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Direction;

public class RotationEvents {
    public static void initRotation(){
		UseBlockCallback.EVENT.register((player, world, hand, result) -> {
			ItemStack itemInHand = player.getStackInHand(hand);
			boolean isUsingtrialShield = itemInHand.getItem().getName().getString()
					.equals(Items.SHIELD.getName().getString());
			BlockState blockState = world.getBlockState(result.getBlockPos());
			final Block block = blockState.getBlock();

			boolean isInteractingWithVerticalFacing = ModConstants.verticalFacingBlocks.stream()
					.anyMatch(b -> b.getName().getString().equals(block.getName().getString()));

			boolean isInteractingWithHorizontalFacing = ModConstants.horizontalFacingBlocks.stream()
					.anyMatch(b -> b.getName().getString().equals(block.getName().getString()));

			boolean isInteractingWithCrafter = block.getName().getString()
					.equals(Blocks.CRAFTER.getName().getString());
			boolean isInteractingWithHopper = block.getName().getString()
					.equals(Blocks.HOPPER.getName().getString());

			if (!isUsingtrialShield) {
				return ActionResult.PASS;
			}
			if (!player.isInSneakingPose()) {
				return ActionResult.PASS;
			}
			if (!(isInteractingWithHorizontalFacing || isInteractingWithVerticalFacing || isInteractingWithCrafter || isInteractingWithHopper)) {
				return ActionResult.PASS;
			}
			Direction facing = Direction.DOWN;
			int nextFacing = 0;
			if (isInteractingWithVerticalFacing) {
				facing = blockState.get(FacingBlock.FACING);
				nextFacing = ModConstants.verticalFacings.indexOf(facing) + 1;
				if (nextFacing > 5) {
					nextFacing = 0;
				}
				facing = ModConstants.verticalFacings.get(nextFacing);
				blockState = blockState.with(FacingBlock.FACING, facing);

			} else if (isInteractingWithHorizontalFacing) {
				facing = blockState.get(Properties.HORIZONTAL_FACING);
				nextFacing = ModConstants.horizontalFacings.indexOf(facing) + 1;
				if (nextFacing > 3) {
					nextFacing = 0;
				}
				facing = ModConstants.horizontalFacings.get(nextFacing);
				blockState = blockState.with(Properties.HORIZONTAL_FACING, facing);
			} else if (isInteractingWithCrafter) {
				Orientation orientation = blockState.get(Properties.ORIENTATION);
				nextFacing = ModConstants.crafterOrientations.indexOf(orientation) + 1;
				if (nextFacing > 11) {
					nextFacing = 0;
				}
				orientation = ModConstants.crafterOrientations.get(nextFacing);
				blockState = blockState.with(Properties.ORIENTATION, orientation);
			}else if(isInteractingWithHopper){
				facing = blockState.get(Properties.HOPPER_FACING);
				nextFacing = ModConstants.hopperFacings.indexOf(facing) + 1;
				if (nextFacing > 4) {
					nextFacing = 0;
				}
				facing = ModConstants.hopperFacings.get(nextFacing);
				blockState = blockState.with(Properties.HOPPER_FACING, facing);
			}else {
				return ActionResult.PASS;
			}
			world.setBlockState(result.getBlockPos(), blockState);
			return ActionResult.SUCCESS;
		});
	}
    
}
