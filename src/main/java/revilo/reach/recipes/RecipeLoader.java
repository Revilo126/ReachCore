package revilo.reach.recipes;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;

public class RecipeLoader implements Runnable {

    @Override
    public void run() {
        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(
            F,
            new RecipesMinecraft(),
            new RecipesAE2(),
            new RecipesBackpacks(),
            new RecipesAdvRocketry(),
            new RecipesMO(),
            new RecipesGregTech());
        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
