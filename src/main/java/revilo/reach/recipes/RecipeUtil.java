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
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ArrayListNoNulls;
import gregapi.code.ModData;
import gregapi.recipes.Recipe;
import gregapi.util.ST;

public class RecipeUtil implements Runnable {

    public static ArrayListNoNulls<ItemStack> toNuke = new ArrayListNoNulls<>(F);

    // If Scripts need it refer from here!
    public static MultiTileEntityRegistry rRegistry = MultiTileEntityRegistry.getRegistry("reach.multitileentity");
    public static MultiTileEntityRegistry gtRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity");

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

    // Inspired by Astroineers Implementation
    public static boolean removeGTRecipe(Recipe mRecipe, Recipe.RecipeMap mRecipeMap) {
        if (mRecipeMap.mRecipeList.contains(mRecipe))
            OUT.println("Reach: Removed Recipe from " + mRecipeMap.mNameInternal);
        boolean ret = mRecipeMap.mRecipeList.remove(mRecipe);
        if (!ret)
            ERR.println(String.format("Reach: Recipe was not remove from %s RecipeMap!", mRecipeMap.mNameInternal));
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

    // Don't overruse!
    public static void removeGTRecipeFromOutputs(ItemStack[] mOutputs, Recipe.RecipeMap mRecipeMap) {
        Iterator<Recipe> it = mRecipeMap.mRecipeList.iterator();

        while (it.hasNext()) {
            if (it.next().mOutputs.equals(mOutputs)) {
                removeGTRecipe(it.next(), mRecipeMap);
            }
        }
        OUT.println(String.format("Reach: Removed all recipes from %s resulting in:", mRecipeMap.mNameInternal));
        for (ItemStack res : mOutputs) {
            OUT.println(res.getDisplayName());
        }
    }

    // Don't overruse!
    public static void removeGTRecipeFromInputs(ItemStack[] mInputs, Recipe.RecipeMap mRecipeMap) {
        Iterator<Recipe> it = mRecipeMap.mRecipeList.iterator();

        while (it.hasNext()) {
            if (it.next().mInputs.equals(mInputs)) {
                removeGTRecipe(it.next(), mRecipeMap);
            }
        }
        OUT.println(String.format("Reach: Removed all recipes from %s with inputs:", mRecipeMap.mNameInternal));
        for (ItemStack in : mInputs) {
            OUT.println(in.getDisplayName());
        }
    }

    /*
     * To replace the need to get the registry
     */
    public static ItemStack getTile(ModData aModData, int aID) {
        ItemStack i = make(aModData, aModData.mID + ".multitileentity", 1, aID);
        if (valid(i)) {
            return i;
        }
        return NI;
    }

    /*
     * If you have the registry
     */
    public static ItemStack getTile(MultiTileEntityRegistry aRegistry, int aID) {
        ItemStack i = aRegistry.getItem(aID);
        if (valid(i)) {
            return i;
        }
        return NI;
    }

    public static class AvaritiaHelp {

        // Copied from GTNH.
        @SuppressWarnings("unchecked")
        public static void removeExtremeCraftingRecipe(ItemStack output) {
            ExtremeCraftingManager.getInstance()
                .getRecipeList()
                .removeIf(r -> r instanceof IRecipe && equal(((IRecipe) r).getRecipeOutput(), output, T));
        }

        public static void addExtremeRecipe(ItemStack aItem, Object... args) {
            if (!(aItem == null)) {
                removeExtremeCraftingRecipe(aItem);
                ExtremeCraftingManager.getInstance()
                    .addRecipe(aItem, args);
            } else {
                ERR.println("Reach: Skipping Extreme Recipe: Output is null!");
            }
        }
    }
}
