package revilo.reach.data;

import static gregapi.data.CS.*;

import gregapi.recipes.Recipe.RecipeMap;
import revilo.reach.recipes.RecipeMapBuilder;

/**
 * Reach Recipe Maps
 */
public class RCRM {

    public static final RecipeMap Polymerization = RecipeMapBuilder
        .builder("reach.recipe.polymerization", "Polymerization Tank")
        .setGuiPath(RCCS.RES_PATH_GUI + "machines/Polymerization")
        .itemIO(1, 2, 0)
        .fluidIO(6, 3, 0)
        .minimumInputs(1)
        .useBucketsIn(F)
        .useBucketsOut(F)
        .build();

    public static final RecipeMap FusionT2 = RecipeMapBuilder
        .builder("reach.recipe.fusionreactor.2", "Fusion Reactor T2")
        .setGuiPath(RES_PATH_GUI + "machines/Fusion")
        .itemIO(2, 6, 1)
        .fluidIO(2, 6, 0)
        .minimumInputs(2)
        .NEISpecial("Start: ", 1, " LU")
        .build();

    public static final RecipeMap GasCentrifuge = RecipeMapBuilder
        .builder("reach.recipe.gascentrifuge", "Gas Centrifuge")
        .setGuiPath(RES_PATH_GUI + "machines/GasCentrifuge")
        .fluidIO(1, 3, 1)
        .minimumInputs(1)
        .useBucketsIn(F)
        .useBucketsOut(F)
        .build();
}
