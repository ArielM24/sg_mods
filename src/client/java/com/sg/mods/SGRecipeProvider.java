package com.sg.mods;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class SGRecipeProvider extends FabricRecipeProvider {

    public SGRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "SGRecipeProvider";
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate(){
                // stone cutter
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.GRAVEL, Items.COBBLESTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SAND,Items.GRAVEL);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_WOOD, Items.PALE_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_PALE_OAK_LOG, Items.PALE_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_PALE_OAK_WOOD, Items.PALE_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_STAIRS, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_SLAB, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_FENCE, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_FENCE_GATE, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_DOOR, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_TRAPDOOR, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_PRESSURE_PLATE, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_BUTTON, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_SIGN, Items.PALE_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.PALE_OAK_HANGING_SIGN, Items.PALE_OAK_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_WOOD, Items.SPRUCE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_STAIRS, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE_GATE, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_DOOR, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_TRAPDOOR, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_PRESSURE_PLATE, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_BUTTON, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SIGN, Items.SPRUCE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_HANGING_SIGN, Items.SPRUCE_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_WOOD, Items.BIRCH_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_STAIRS, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SLAB, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE_GATE, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_DOOR, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_TRAPDOOR, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_PRESSURE_PLATE, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_BUTTON, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SIGN, Items.BIRCH_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_HANGING_SIGN, Items.BIRCH_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_WOOD, Items.JUNGLE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_STAIRS, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE_GATE, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_DOOR, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_TRAPDOOR, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_PRESSURE_PLATE, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_BUTTON, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SIGN, Items.JUNGLE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_HANGING_SIGN, Items.JUNGLE_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_WOOD, Items.ACACIA_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_STAIRS, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SLAB, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE_GATE, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_DOOR, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_TRAPDOOR, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_PRESSURE_PLATE, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_BUTTON, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SIGN, Items.ACACIA_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_HANGING_SIGN, Items.ACACIA_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_WOOD, Items.DARK_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_STAIRS, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE_GATE, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_DOOR, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_TRAPDOOR, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_PRESSURE_PLATE, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_BUTTON, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SIGN, Items.DARK_OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_HANGING_SIGN, Items.DARK_OAK_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_WOOD, Items.MANGROVE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_MANGROVE_LOG, Items.MANGROVE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_MANGROVE_WOOD, Items.MANGROVE_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_STAIRS, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SLAB, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_FENCE_GATE, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_DOOR, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_TRAPDOOR, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_PRESSURE_PLATE, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_BUTTON, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_SIGN, Items.MANGROVE_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.MANGROVE_HANGING_SIGN, Items.MANGROVE_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_WOOD, Items.CHERRY_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_CHERRY_LOG, Items.CHERRY_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_CHERRY_WOOD, Items.CHERRY_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_STAIRS, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SLAB, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_FENCE_GATE, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_DOOR, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_TRAPDOOR, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_PRESSURE_PLATE, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_BUTTON, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_SIGN, Items.CHERRY_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CHERRY_HANGING_SIGN, Items.CHERRY_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_HYPHAE, Items.CRIMSON_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_STAIRS, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE_GATE, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_DOOR, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_TRAPDOOR, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_PRESSURE_PLATE, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_BUTTON, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SIGN, Items.CRIMSON_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_HANGING_SIGN, Items.CRIMSON_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_HYPHAE, Items.WARPED_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_WARPED_STEM, Items.WARPED_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_STEM);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_STAIRS, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SLAB, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE_GATE, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_DOOR, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_TRAPDOOR, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_PRESSURE_PLATE, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_BUTTON, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SIGN, Items.WARPED_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.WARPED_HANGING_SIGN, Items.WARPED_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_BAMBOO_BLOCK, Items.BAMBOO_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_STAIRS, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_FENCE, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_FENCE_GATE, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_DOOR, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_TRAPDOOR, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PRESSURE_PLATE, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_BUTTON, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SIGN, Items.BAMBOO_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_HANGING_SIGN, Items.BAMBOO_PLANKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_WOOD, Items.OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_OAK_LOG, Items.OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_OAK_WOOD, Items.OAK_LOG);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_STAIRS, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_SLAB, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE_GATE, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_DOOR, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_TRAPDOOR, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_PRESSURE_PLATE, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_BUTTON, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_SIGN, Items.OAK_PLANKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Items.OAK_HANGING_SIGN, Items.OAK_PLANKS);
                // furnace
                offerSmelting(List.of(Items.DIORITE), RecipeCategory.BUILDING_BLOCKS, Items.CALCITE, 0.1f, 200, "diote");
                offerSmelting(List.of(Items.BASALT), RecipeCategory.BUILDING_BLOCKS, Items.TUFF, 0.1f, 200, "basalt");
                // blast furnace
                offerBlasting(List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.GOLD_BLOCK, 1f, 900, "gold");
                offerBlasting(List.of(Items.RAW_IRON_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.IRON_BLOCK, 1f, 900, "iron");
                offerBlasting(List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, Items.COPPER_BLOCK, 1f, 900, "copper");
                // crafting table
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.END_STONE, 4).pattern("lw").pattern("wl").input('l', Items.COBBLESTONE).input('w', Items.SANDSTONE).group("end stone").criterion(hasItem(Items.SANDSTONE), conditionsFromItem(Items.SANDSTONE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.RED_SAND, 2).pattern("lw").pattern("wl").input('l', Items.SAND).input('w', Items.IRON_NUGGET).group("red sand").criterion(hasItem(Items.SAND), conditionsFromItem(Items.SAND)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SOIL, 4).pattern("lw").pattern("wl").input('l', Items.SOUL_SAND).input('w', Items.BONE_BLOCK).group("soul soil").criterion(hasItem(Items.SOUL_SAND), conditionsFromItem(Items.SOUL_SAND)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.DEEPSLATE, 4).pattern("lll").pattern("lll").pattern("lll").input('l', Items.STONE).group("deepslate").criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.COBWEB, 1).pattern("l l").pattern(" l ").pattern("l l").input('l', Items.STRING).group("cobweb").criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.POWDER_SNOW_BUCKET, 1).pattern("wl").input('l', Items.SNOW_BLOCK).input('w', Items.BUCKET).group("poweder snow").criterion(hasItem(Items.SNOW_BLOCK), conditionsFromItem(Items.SNOW_BLOCK)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.HONEYCOMB, 4).input(Items.HONEYCOMB_BLOCK).group("honey comb").criterion(hasItem(Items.HONEYCOMB_BLOCK), conditionsFromItem(Items.HONEYCOMB_BLOCK)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.AMETHYST_SHARD, 4).input(Items.AMETHYST_BLOCK).group("amethyst shard").criterion(hasItem(Items.AMETHYST_BLOCK), conditionsFromItem(Items.AMETHYST_BLOCK)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.GLOWSTONE_DUST, 4).input(Items.GLOWSTONE).group("glowstone").criterion(hasItem(Items.GLOWSTONE), conditionsFromItem(Items.GLOWSTONE)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.QUARTZ, 4).input(Items.QUARTZ_BLOCK).group("quartz").criterion(hasItem(Items.QUARTZ_BLOCK), conditionsFromItem(Items.QUARTZ_BLOCK)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.ICE, 9).input(Items.PACKED_ICE).group("packet ice").criterion(hasItem(Items.PACKED_ICE), conditionsFromItem(Items.PACKED_ICE)).offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_ICE, 9).input(Items.BLUE_ICE).group("blue ice").criterion(hasItem(Items.BLUE_ICE), conditionsFromItem(Items.BLUE_ICE)).offerTo(exporter);
            }
        };
    }
    
}
