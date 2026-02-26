package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregapi.code.ArrayListNoNulls;
import gregapi.recipes.Recipe;
import gregapi.util.ST;

public class RecipeUtil implements Runnable {

    public static ArrayListNoNulls<ItemStack> toNuke = new ArrayListNoNulls<>(F);

    public static void removeAllRecipes(Recipe.RecipeMap map, ItemStack... output) { // WIP doesn't work!
        final List<Recipe> recipes = map.getNEIRecipes(output);
        if (recipes != null && !recipes.isEmpty()) {
            map.mRecipeList.removeAll(recipes);
        }
    }

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

}
