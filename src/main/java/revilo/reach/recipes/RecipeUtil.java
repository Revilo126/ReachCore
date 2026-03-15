package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregapi.code.ArrayListNoNulls;
import gregapi.recipes.Recipe;
import gregapi.util.ST;

public class RecipeUtil implements Runnable {

    public static ArrayListNoNulls<ItemStack> toNuke = new ArrayListNoNulls<>(F);

    public static void nuke(ItemStack aItem) {
        toNuke.add(aItem);
    }

    public static void nuke(Item aItem) {
        toNuke.add(ST.make(aItem, 1, 0));
    }

    public static void nuke(Block aItem) {
        toNuke.add(ST.make(aItem, 1, 0));
    }

    @Override
    public void run() {
        for (ItemStack tItem : toNuke) try {
            hide(tItem);
            delate(tItem);
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

    public static boolean removeGTRecipe(Recipe mRecipe, Recipe.RecipeMap mRecipeMap) { // Inspired by Bioastroneers
                                                                                        // implementation.
        if (mRecipeMap.mRecipeList.contains(mRecipe)) OUT.println("Removed Recipe from " + mRecipeMap.mNameInternal);
        boolean ret = mRecipeMap.mRecipeList.remove(mRecipe);
        if (!ret) ERR.println(String.format("Recipe was not remove from %s RecipeMap!", mRecipeMap.mNameInternal));
        else {
            mRecipeMap.mRecipeItemMap.entrySet()
                .stream()
                .filter(
                    e -> e.getValue()
                        .removeIf(r -> r == mRecipe)
                        && e.getValue()
                            .isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .forEach(mRecipeMap.mRecipeItemMap::remove);
            mRecipeMap.mRecipeFluidMap.entrySet()
                .stream()
                .filter(
                    e -> e.getValue()
                        .removeIf(r -> r == mRecipe)
                        && e.getValue()
                            .isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .forEach(mRecipeMap.mRecipeFluidMap::remove);
        }
        return ret;
    }

    public static void removeGTRecipeFromOutputs(ItemStack[] mOutputs, Recipe.RecipeMap mRecipeMap) { // Use mostly for
                                                                                                      // multiple
                                                                                                      // recipes to make
                                                                                                      // 1 item!
        Iterator<Recipe> it = mRecipeMap.mRecipeList.iterator();

        while (it.hasNext()) {
            if (it.next().mOutputs.equals(mOutputs)) {
                removeGTRecipe(it.next(), mRecipeMap);
            }
        }
        OUT.println(String.format("Removed all recipes from %s resulting in:", mRecipeMap.mNameInternal));
        for (ItemStack res : mOutputs) {
            OUT.println(res.getDisplayName());
        }
    }

    public static class AvaritiaHelp {

        @SuppressWarnings("unchecked")
        public static void removeExtremeCraftingRecipe(ItemStack output) { // Copied from GTNH.
            ExtremeCraftingManager.getInstance()
                .getRecipeList()
                .removeIf(r -> r instanceof IRecipe && equal(((IRecipe) r).getRecipeOutput(), output, T));
        }

        public static void addExtremeRecipe(ItemStack aItem, Object... args) {
            removeExtremeCraftingRecipe(aItem);
            ExtremeCraftingManager.getInstance()
                .addRecipe(aItem, args);
        }
    }

}
