package net.leffy.meteorits.datagen;

import net.leffy.meteorits.block.ModBlocks;
import net.leffy.meteorits.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRIPOD.get())
                .pattern(" A ")
                .pattern("BBB")
                .define('B', ModItems.TRIPOD_LEG.get())
                .define('A', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRIPOD_LEG.get())
                .pattern("F")
                .pattern("J")
                .define('F', Blocks.GRAY_WOOL)
                .define('J', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CAM.get())
                .pattern("TIO")
                .pattern("IGI")
                .pattern("TIT")
                .define('T', Blocks.GRAY_WOOL)
                .define('I', Items.IRON_INGOT)
                .define('O', Items.STONE_BUTTON)
                .define('G', Items.REDSTONE)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRIPODWITHCAM.get())
                .pattern("V")
                .pattern("C")
                .define('V', ModItems.CAM.get())
                .define('C', ModBlocks.TRIPOD.get())
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);


    }
}
