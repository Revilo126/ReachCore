package revilo.reach.data;

import static gregapi.data.CS.*;

import gregapi.recipes.Recipe.RecipeMap;

/**
 * Reach Recipe Maps
 */
@SuppressWarnings("deprecation")
public class RCRM {

    public static final RecipeMap Polymerization = new RecipeMap(
        null,
        "reach.recipe.polymerization",
        "Polymerization Tank",
        null,
        0,
        1,
        RCCS.RES_PATH_GUI + "machines/Polymerization",
        /* IN-OUT-MIN-ITEM */
        1,
        2,
        0,
        /* IN-OUT-MIN-FLUID */
        6,
        3,
        0,
        2,
        1,
        "",
        1,
        "",
        T,
        T,
        T,
        T,
        F,
        F,
        F);

    public static final RecipeMap FusionT2 = new RecipeMap(
        null,
        "reach.recipe.fusionreactor.2",
        "Fusion Reactor T2",
        null,
        0,
        1,
        RES_PATH_GUI + "machines/Fusion",
        /* IN-OUT-MIN-ITEM= */ 2,
        6,
        1,
        /* IN-OUT-MIN-FLUID= */ 2,
        6,
        0,
        /* MIN */ 2,
        /* AMP= */ 1,
        "Start: ",
        1,
        " LU",
        T,
        T,
        T,
        T,
        F,
        T,
        T); // Use 64 special *
}
