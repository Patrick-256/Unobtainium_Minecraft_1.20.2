package net.pata_data.unobtainium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pata_data.unobtainium.Unobtainium;
import net.pata_data.unobtainium.block.ModBlocks;
import net.pata_data.unobtainium.item.ModItems;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> UNOBTAINIUM_SMELTABLES = List.of(ModItems.UNOBTAINIUM_ORE.get(),
            ModBlocks.UNOBTAINIUM_RAW.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput,UNOBTAINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.UNOBTAINIUM_INGOT.get(), 0.25f,200,"unobtainium_ingot");
        oreBlasting(recipeOutput,UNOBTAINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.UNOBTAINIUM_INGOT.get(), 0.25f,100,"unobtainium_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.UNOBTAINIUM_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.UNOBTAINIUM_INGOT.get(),9)
                .requires(ModBlocks.UNOBTAINIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.UNOBTAINIUM_BLOCK.get()), has(ModBlocks.UNOBTAINIUM_BLOCK.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.UNOBTAINIUM_SWORD.get())
                .pattern("III")
                .pattern("ISI")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .define('S', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.UNOBTAINIUM_PICKAXE.get())
                .pattern("III")
                .pattern("INI")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .define('N', Items.NETHERITE_PICKAXE)
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.UNOBTAINIUM_AXE.get())
                .pattern("III")
                .pattern("INI")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .define('N', Items.NETHERITE_AXE)
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.UNOBTAINIUM_SHOVEL.get())
                .pattern("III")
                .pattern("INI")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .define('N', Items.NETHERITE_SHOVEL)
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItems.UNOBTAINIUM_HOE.get())
                .pattern("III")
                .pattern("INI")
                .pattern("III")
                .define('I',ModItems.UNOBTAINIUM_INGOT.get())
                .define('N', Items.NETHERITE_HOE)
                .unlockedBy(getHasName(ModItems.UNOBTAINIUM_INGOT.get()),has(ModItems.UNOBTAINIUM_INGOT.get()))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, Unobtainium.MODID + ":" + (pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
