package revilo.reach.api.data;

import static gregapi.data.CS.*;

import gregapi.recipes.Recipe.RecipeMap;

/**
 * All Planned Machines!
 */
public class RCRM {
    // public static final RecipeMap Sequencer = new RecipeMap(null, "rc.recipe.sequencer", "Sequencer", null, ),
    // Splicer = new RecipeMap(),
    // FusionT2 = new RecipeMap(); // Yes I'm adding a tier 2 :) (Theoretical elements; e.g Ununellium)
    // FusionT3 = new RecipeMap(); // Might not add :( (no ideas for uses)

    @SuppressWarnings("deprecation")
    public static final RecipeMap NeutronCollector = new RecipeMap(
        null,
        "rc.recipe.neutron",
        "Neutron Collector",
        null,
        0,
        1,
        RES_PATH_GUI + "machines/Autoclave",
        0,
        1,
        0,
        1,
        0,
        1,
        1,
        1,
        "",
        1,
        "",
        T,
        T,
        T,
        T,
        F,
        T,
        T);
}
