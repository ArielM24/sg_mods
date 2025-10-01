package com.sg.mods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.enums.Orientation;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
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
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Difficulty;
import net.minecraft.state.property.Properties;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sg.mods.events.RecoverExpEvent;
import com.sg.mods.events.SpawnEvents;
import com.sg.mods.events.StoreExpEvent;
import com.sg.mods.interfaces.IEntityDataSaver;

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
	public static ArrayList<Direction> verticalFacings = new ArrayList<>();
	public static ArrayList<Direction> horizontalFacings = new ArrayList<>();
	public static ArrayList<Block> horizontalFacingBlocks = new ArrayList<>();
	public static ArrayList<Block> verticalFacingBlocks = new ArrayList<>();
	public static ArrayList<Orientation> crafterOrientations = new ArrayList<>();
	public static ArrayList<Direction> hopperFacings = new ArrayList<>();
	public static final Item[] itemsTo64 = new Item[] {
			Items.ENDER_PEARL,
			Items.EGG,
			Items.SNOWBALL,
			Items.BIRCH_BOAT,
			Items.OAK_BOAT,
			Items.SPRUCE_BOAT,
			Items.JUNGLE_BOAT,
			Items.ACACIA_BOAT,
			Items.DARK_OAK_BOAT,
			Items.MANGROVE_BOAT,
			Items.CHERRY_BOAT,
			Items.BAMBOO_RAFT,
			Items.BIRCH_CHEST_BOAT,
			Items.OAK_CHEST_BOAT,
			Items.SPRUCE_CHEST_BOAT,
			Items.JUNGLE_CHEST_BOAT,
			Items.ACACIA_CHEST_BOAT,
			Items.DARK_OAK_CHEST_BOAT,
			Items.MANGROVE_CHEST_BOAT,
			Items.CHERRY_CHEST_BOAT,
			Items.BAMBOO_CHEST_RAFT,
			Items.MINECART,
			Items.HOPPER_MINECART,
			Items.CHEST_MINECART,
			Items.FURNACE_MINECART,
			Items.TNT_MINECART,
			Items.SADDLE,
			Items.OAK_SIGN,
			Items.DARK_OAK_SIGN,
			Items.BIRCH_SIGN,
			Items.JUNGLE_SIGN,
			Items.ACACIA_SIGN,
			Items.SPRUCE_SIGN,
			Items.MANGROVE_SIGN,
			Items.CHERRY_SIGN,
			Items.BAMBOO_SIGN,
			Items.CRIMSON_SIGN,
			Items.WARPED_SIGN,
			Items.OAK_HANGING_SIGN,
			Items.DARK_OAK_HANGING_SIGN,
			Items.BIRCH_HANGING_SIGN,
			Items.JUNGLE_HANGING_SIGN,
			Items.ACACIA_HANGING_SIGN,
			Items.SPRUCE_HANGING_SIGN,
			Items.MANGROVE_HANGING_SIGN,
			Items.CHERRY_HANGING_SIGN,
			Items.BAMBOO_HANGING_SIGN,
			Items.CRIMSON_HANGING_SIGN,
			Items.WARPED_HANGING_SIGN,
			Items.WHITE_BED,
			Items.LIGHT_GRAY_BED,
			Items.GRAY_BED,
			Items.BLACK_BED,
			Items.BROWN_BED,
			Items.RED_BED,
			Items.ORANGE_BED,
			Items.YELLOW_BED,
			Items.LIME_BED,
			Items.GREEN_BED,
			Items.CYAN_BED,
			Items.LIGHT_BLUE_BED,
			Items.BLUE_BED,
			Items.PURPLE_BED,
			Items.MAGENTA_BED,
			Items.PINK_BED,
			Items.WHITE_BANNER,
			Items.LIGHT_GRAY_BANNER,
			Items.GRAY_BANNER,
			Items.BLACK_BANNER,
			Items.BROWN_BANNER,
			Items.RED_BANNER,
			Items.ORANGE_BANNER,
			Items.YELLOW_BANNER,
			Items.LIME_BANNER,
			Items.GREEN_BANNER,
			Items.CYAN_BANNER,
			Items.LIGHT_BLUE_BANNER,
			Items.BLUE_BANNER,
			Items.PURPLE_BANNER,
			Items.MAGENTA_BANNER,
			Items.PINK_BANNER,
			Items.BUCKET,
			Items.LAVA_BUCKET,
			Items.WATER_BUCKET,
			Items.MUSIC_DISC_13,
			Items.MUSIC_DISC_CAT,
			Items.MUSIC_DISC_BLOCKS,
			Items.MUSIC_DISC_CHIRP,
			Items.MUSIC_DISC_FAR,
			Items.MUSIC_DISC_MALL,
			Items.MUSIC_DISC_MELLOHI,
			Items.MUSIC_DISC_STAL,
			Items.MUSIC_DISC_STRAD,
			Items.MUSIC_DISC_WARD,
			Items.MUSIC_DISC_11,
			Items.MUSIC_DISC_CREATOR_MUSIC_BOX,
			Items.MUSIC_DISC_WAIT,
			Items.MUSIC_DISC_CREATOR,
			Items.MUSIC_DISC_PRECIPICE,
			Items.MUSIC_DISC_OTHERSIDE,
			Items.MUSIC_DISC_RELIC,
			Items.MUSIC_DISC_5,
			Items.MUSIC_DISC_PIGSTEP,
			Items.MUSIC_DISC_TEARS,
			Items.MUSIC_DISC_LAVA_CHICKEN,
			Items.HONEY_BOTTLE,
			Items.SUSPICIOUS_STEW,
			Items.RABBIT_STEW,
			Items.BEETROOT_SOUP,
			Items.MUSHROOM_STEW,
			Items.FIELD_MASONED_BANNER_PATTERN,
			Items.BORDURE_INDENTED_BANNER_PATTERN,
			Items.FLOWER_BANNER_PATTERN,
			Items.CREEPER_BANNER_PATTERN,
			Items.SKULL_BANNER_PATTERN,
			Items.MOJANG_BANNER_PATTERN,
			Items.GLOBE_BANNER_PATTERN,
			Items.PIGLIN_BANNER_PATTERN,
			Items.FLOW_BANNER_PATTERN,
			Items.GUSTER_BANNER_PATTERN,
			Items.ENCHANTED_BOOK,
			Items.SHULKER_BOX,
			Items.WHITE_SHULKER_BOX,
			Items.LIGHT_GRAY_SHULKER_BOX,
			Items.GRAY_SHULKER_BOX,
			Items.BLACK_SHULKER_BOX,
			Items.BROWN_SHULKER_BOX,
			Items.RED_SHULKER_BOX,
			Items.ORANGE_SHULKER_BOX,
			Items.YELLOW_SHULKER_BOX,
			Items.LIME_SHULKER_BOX,
			Items.GREEN_SHULKER_BOX,
			Items.CYAN_SHULKER_BOX,
			Items.LIGHT_BLUE_SHULKER_BOX,
			Items.BLUE_SHULKER_BOX,
			Items.PURPLE_SHULKER_BOX,
			Items.MAGENTA_SHULKER_BOX,
			Items.PINK_SHULKER_BOX,
			Items.ARMOR_STAND,
			Items.MILK_BUCKET,
			Items.RED_HARNESS,
			Items.BLUE_HARNESS,
			Items.GREEN_HARNESS,
			Items.CYAN_HARNESS,
			Items.YELLOW_HARNESS,
			Items.BROWN_HARNESS,
			Items.PURPLE_HARNESS,
			Items.BLACK_HARNESS,
			Items.WHITE_HARNESS,
			Items.LIME_HARNESS,
			Items.PINK_HARNESS,
			Items.ORANGE_HARNESS,
			Items.GRAY_HARNESS,
			Items.LIGHT_GRAY_HARNESS,
			Items.LIGHT_BLUE_HARNESS,
			Items.MAGENTA_HARNESS,
			Items.CAKE,
			Items.COD_BUCKET,
			Items.SALMON_BUCKET,
			Items.TADPOLE_BUCKET,
			Items.PUFFERFISH_BUCKET,
			Items.AXOLOTL_BUCKET,
			Items.TROPICAL_FISH_BUCKET
	};
	
	public static final Item[] itemsTo16 = new Item[]{
		Items.LINGERING_POTION,
		Items.SPLASH_POTION,
		Items.POTION,
	};

	@Override
	public void onInitialize() {
		initBedrock();
		initEchantments();
		initXPStore();
		initSpawns();
		initTrims();
		initRotation();
		initStacks();
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
			LOGGER.info(ex.toString());
		}
	}

	public static void initTrims(){
		ServerEntityEvents.ENTITY_LOAD.register((entity, world)->{
			if(!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)){
				return;
			}
			boolean isZombie = (entity instanceof ZombieEntity);
			boolean isSkeleton = (entity instanceof SkeletonEntity);
			if(!isZombie && !isSkeleton){
				return;
			}
			
			if(((IEntityDataSaver)entity).getTrimChecked()){
				return;
			}
			((IEntityDataSaver)entity).setTrimChecked(true);

			ItemStack head = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.HEAD);
			ItemStack chest = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.CHEST);
			ItemStack legs = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.LEGS);
			ItemStack feet = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.FEET);
			boolean hasArmorTrim = head.get(DataComponentTypes.TRIM) != null || chest.get(DataComponentTypes.TRIM) != null ||legs.get(DataComponentTypes.TRIM) != null ||feet.get(DataComponentTypes.TRIM) != null;
			if(hasArmorTrim){
				return;
			}
			if(world.random.nextBoolean()){
				return;
			}
			applyTrim(entity, world);
		});	
	}
	public static void initRotation(){
		if (verticalFacings.isEmpty()) {
			verticalFacings.add(Direction.NORTH);
			verticalFacings.add(Direction.EAST);
			verticalFacings.add(Direction.SOUTH);
			verticalFacings.add(Direction.WEST);
			verticalFacings.add(Direction.UP);
			verticalFacings.add(Direction.DOWN);
		}
		if (hopperFacings.isEmpty()) {
			hopperFacings.add(Direction.NORTH);
			hopperFacings.add(Direction.EAST);
			hopperFacings.add(Direction.SOUTH);
			hopperFacings.add(Direction.WEST);
			hopperFacings.add(Direction.DOWN);
		}
		if (horizontalFacings.isEmpty()) {
			horizontalFacings.add(Direction.NORTH);
			horizontalFacings.add(Direction.EAST);
			horizontalFacings.add(Direction.SOUTH);
			horizontalFacings.add(Direction.WEST);
		}
		if (horizontalFacingBlocks.isEmpty()) {
			horizontalFacingBlocks.add(Blocks.COMPARATOR);
			horizontalFacingBlocks.add(Blocks.REPEATER);
		}
		if (verticalFacingBlocks.isEmpty()) {
			verticalFacingBlocks.add(Blocks.DISPENSER);
			verticalFacingBlocks.add(Blocks.DROPPER);
			verticalFacingBlocks.add(Blocks.PISTON);
			verticalFacingBlocks.add(Blocks.STICKY_PISTON);
			verticalFacingBlocks.add(Blocks.OBSERVER);
			verticalFacingBlocks.add(Blocks.BARREL);
		}
		if (crafterOrientations.isEmpty()) {
			crafterOrientations.add(Orientation.EAST_UP);
			crafterOrientations.add(Orientation.NORTH_UP);
			crafterOrientations.add(Orientation.SOUTH_UP);
			crafterOrientations.add(Orientation.WEST_UP);
				
			crafterOrientations.add(Orientation.UP_EAST);
			crafterOrientations.add(Orientation.UP_NORTH);
			crafterOrientations.add(Orientation.UP_SOUTH);
			crafterOrientations.add(Orientation.UP_WEST);

			crafterOrientations.add(Orientation.DOWN_EAST);
			crafterOrientations.add(Orientation.DOWN_NORTH);
			crafterOrientations.add(Orientation.DOWN_SOUTH);
			crafterOrientations.add(Orientation.DOWN_WEST);
		
		}
		UseBlockCallback.EVENT.register((player, world, hand, result) -> {
			ItemStack itemInHand = player.getStackInHand(hand);
			boolean isUsingtrialShield = itemInHand.getItem().getName().getString()
					.equals(Items.SHIELD.getName().getString());
			BlockState blockState = world.getBlockState(result.getBlockPos());
			final Block block = blockState.getBlock();

			boolean isInteractingWithVerticalFacing = verticalFacingBlocks.stream()
					.anyMatch(b -> b.getName().getString().equals(block.getName().getString()));

			boolean isInteractingWithHorizontalFacing = horizontalFacingBlocks.stream()
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
				nextFacing = verticalFacings.indexOf(facing) + 1;
				if (nextFacing > 5) {
					nextFacing = 0;
				}
				facing = verticalFacings.get(nextFacing);
				blockState = blockState.with(FacingBlock.FACING, facing);

			} else if (isInteractingWithHorizontalFacing) {
				facing = blockState.get(Properties.HORIZONTAL_FACING);
				nextFacing = horizontalFacings.indexOf(facing) + 1;
				if (nextFacing > 3) {
					nextFacing = 0;
				}
				facing = horizontalFacings.get(nextFacing);
				blockState = blockState.with(Properties.HORIZONTAL_FACING, facing);
			} else if (isInteractingWithCrafter) {
				Orientation orientation = blockState.get(Properties.ORIENTATION);
				nextFacing = crafterOrientations.indexOf(orientation) + 1;
				if (nextFacing > 11) {
					nextFacing = 0;
				}
				orientation = crafterOrientations.get(nextFacing);
				blockState = blockState.with(Properties.ORIENTATION, orientation);
			}else if(isInteractingWithHopper){
				facing = blockState.get(Properties.HOPPER_FACING);
				nextFacing = hopperFacings.indexOf(facing) + 1;
				if (nextFacing > 4) {
					nextFacing = 0;
				}
				facing = hopperFacings.get(nextFacing);
				blockState = blockState.with(Properties.HOPPER_FACING, facing);
			}else {
				return ActionResult.PASS;
			}
			world.setBlockState(result.getBlockPos(), blockState);
			return ActionResult.SUCCESS;
		});
	}
	public static void initStacks(){
		DefaultItemComponentEvents.MODIFY.register(context -> {
			for (int i = 0; i < itemsTo64.length; i++) {
				context.modify(itemsTo64[i], builder -> {
					builder.add(DataComponentTypes.MAX_STACK_SIZE, 64);
				});
			}
			for (int i = 0; i < itemsTo16.length; i++) {
				context.modify(itemsTo16[i], builder -> {
					builder.add(DataComponentTypes.MAX_STACK_SIZE, 16);
				});
			}
		});
	}
}