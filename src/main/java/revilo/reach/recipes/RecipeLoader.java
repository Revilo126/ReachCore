package revilo.reach.recipes;

public class RecipeLoader implements Runnable {

    @Override
    public void run() {

        RecipesMinecraft recipesMinecraft = new RecipesMinecraft();
        recipesMinecraft.postInit();

    }

}
