package com.sg.mods.events;

import java.util.Optional;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.VaultBlockEntity;
import net.minecraft.block.vault.VaultConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Direction;

public class VaultEvents {
    public static void registerVaultEvent(){
		UseBlockCallback.EVENT.register((player, world, hand, result) -> {
			ItemStack itemInHand = player.getStackInHand(hand);
			String interactingBlockName = world.getBlockState(result.getBlockPos()).getBlock().getName().getString();
			boolean isUsingtrialKey = itemInHand.getItem().getName().getString()
					.equals(Items.TRIAL_KEY.getName().getString());
			boolean isInteractingWithVault = interactingBlockName.equals(Blocks.VAULT.getName().getString());
			BlockEntity block = world.getBlockEntity(result.getBlockPos());
			if (!(block instanceof VaultBlockEntity)) {
				return ActionResult.PASS;
			}
			VaultBlockEntity vaultBlock = (VaultBlockEntity) block;
			if (!isInteractingWithVault) {
				return ActionResult.PASS;
			}
			if (!isUsingtrialKey) {
				return ActionResult.PASS;
			}
			if (!vaultBlock.getCachedState().toString().contains("vault_state=inactive")) {
				return ActionResult.PASS;
			}
			// getting block data
			RegistryKey<LootTable> lootTable = vaultBlock.getConfig().lootTable();
			double activationRange = vaultBlock.getConfig().activationRange();
			double deactivationRange = vaultBlock.getConfig().deactivationRange();
			ItemStack keyItem = vaultBlock.getConfig().keyItem();
			Direction facing = vaultBlock.getCachedState().get(Properties.HORIZONTAL_FACING);
			boolean isOminous = vaultBlock.getCachedState().get(Properties.OMINOUS);

			// creating new block
			world.breakBlock(result.getBlockPos(), false);
			BlockState s = Blocks.VAULT.getDefaultState().with(Properties.OMINOUS, isOminous)
					.with(Properties.HORIZONTAL_FACING, facing);
			world.setBlockState(result.getBlockPos(), s);
			player.increaseStat(Stats.USED.getOrCreateStat(keyItem.getItem()), 1);
			itemInHand.setCount(itemInHand.getCount() - 1);
			VaultBlockEntity newVault = (VaultBlockEntity) world.getBlockEntity(result.getBlockPos());
			Optional<RegistryKey<LootTable>> optionalLootTable = Optional.of(lootTable);
			newVault.setConfig(
					new VaultConfig(lootTable, activationRange, deactivationRange, keyItem, optionalLootTable));
			return ActionResult.PASS;
		});
	}
}
