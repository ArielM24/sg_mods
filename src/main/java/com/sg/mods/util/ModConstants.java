package com.sg.mods.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Orientation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.Direction;

public class ModConstants {
    public static DynamicRegistryManager dynamicRegistryManager;

	public static final int EXPERIENCE_PER_BOTTLE = 30;
   
    public static final List<RegistryKey<Enchantment>> tridentEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.BREACH, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> maceEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.IMPALING, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> swordEnchantments = List.of(Enchantments.BREACH, Enchantments.IMPALING);
	public static final List<RegistryKey<Enchantment>> axeEnchantments = List.of(Enchantments.FIRE_ASPECT, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.LOOTING, Enchantments.BREACH, Enchantments.KNOCKBACK);
	public static final List<RegistryKey<Enchantment>> crossbowEnchantments = List.of(Enchantments.FLAME, Enchantments.POWER, Enchantments.PUNCH, Enchantments.INFINITY);
	public static final List<RegistryKey<Enchantment>> bowEnchantments = List.of(Enchantments.PIERCING, Enchantments.MULTISHOT);
	public static final List<RegistryKey<Enchantment>> protectionEnchantments = List.of(Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION);
	public static final List<RegistryKey<Enchantment>> shieldEnchantments = List.of(Enchantments.THORNS);

    public static final int illusionerSpawnRatio = 30;
    public static final int breezeSpawnRatio = 70;
    public static final int caveSpiderSpawnRatio = 85;
    public static final int silverfishSpiderSpawnRatio = 50;
    public static final int zombieHorseSpawnRatio = 5;

    public static List<Direction> verticalFacings = List.of(Direction.NORTH,Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
	public static List<Direction> horizontalFacings = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
	public static List<Block> horizontalFacingBlocks = List.of(Blocks.COMPARATOR, Blocks.REPEATER);
	public static List<Block> verticalFacingBlocks = List.of(Blocks.DISPENSER, Blocks.DROPPER, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.OBSERVER, Blocks.BARREL);
	public static List<Orientation> crafterOrientations = List.of(Orientation.EAST_UP, Orientation.NORTH_UP, Orientation.SOUTH_UP, Orientation.WEST_UP, Orientation.UP_EAST, Orientation.UP_NORTH, Orientation.UP_SOUTH, Orientation.UP_WEST, Orientation.DOWN_EAST, Orientation.DOWN_NORTH, Orientation.DOWN_SOUTH, Orientation.DOWN_WEST);
	public static List<Direction> hopperFacings = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN);

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
}
