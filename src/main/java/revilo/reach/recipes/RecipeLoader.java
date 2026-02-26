package revilo.reach.recipes;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;

/*
 * @author Revilo
 * Although most mods are not compiled in this core mod, you should directly try to access Items, this is due to the
 * fact you should only test by adding to modpack!
 */

public class RecipeLoader implements Runnable {

    @Override
    public void run() {
        // Make sure Recipe util is always last!
        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(
            F,
            new RecipesMinecraft(),
            new RecipesAE2(),
            new RecipesBackpacks(),
            new RecipesMO(),
            new RecipesPersonalDim(),
            new RecipesAvaritia(),
            new RecipesWarpDrive(),
            new RecipesGregTech(),
            new RecipeUtil());
        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
