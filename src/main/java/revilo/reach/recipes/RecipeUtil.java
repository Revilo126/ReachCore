package revilo.reach.recipes;

import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.recipes.Recipe;

public class RecipeUtil {

    public static void removeAllRecipes(Recipe.RecipeMap map, ItemStack... output) {
        final List<Recipe> recipes = map.getNEIRecipes(output);
        if (recipes != null && !recipes.isEmpty()) {
            map.mRecipeList.removeAll(recipes);
        }
    }

}
