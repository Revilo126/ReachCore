package revilo.reach.data;

import static gregapi.data.CS.*;

import java.util.ArrayList;
import java.util.List;

import gregapi.recipes.Recipe.RecipeMap;
import revilo.multihelper.recipe.RecipeMapBuilder;

/**
 * Reach's Recipe Maps
 */
public class RCRM {

    public static final List<RecipeMap> REACH_RECIPEMAPS = new ArrayList<>();

    public static final RecipeMap Polymerization = RecipeMapBuilder
        .builder("reach.recipe.polymerization", "Polymerization Tank")
        .setGuiPath(RCCS.RES_PATH_GUI + "machines/Polymerization")
        .itemIO(1, 2, 0)
        .fluidIO(6, 3, 0)
        .minimumInputs(1)
        .useBuckets(F)
        .build();

    public static final RecipeMap FusionT2 = RecipeMapBuilder
        .builder("reach.recipe.fusionreactor.2", "Fusion Reactor T2")
        .setGuiPath(RES_PATH_GUI + "machines/Fusion")
        .itemIO(2, 6, 1)
        .fluidIO(2, 6, 0)
        .minimumInputs(2)
        .NEISpecial("Start: ", 1, " LU")
        .build();

    public static final RecipeMap InterPlanetarySiphon = RecipeMapBuilder
        .builder("reach.recipe.planetarysyphon", "Inter-Planetary Siphon")
        .setGuiPath(RCCS.RES_PATH_GUI + "machines/PlanetarySiphon")
        .itemIO(2, 6, 0)
        .fluidIO(1, 6, 0)
        .minimumInputs(1)
        .useBuckets(F)
        .build();

    public static RecipeMap MultiMill = RecipeMapBuilder.builder("reach.recipe.multimill", "Multi Mill")
        .setGuiPath(RES_PATH_GUI + "machines/Wiremill")
        .itemIO(2, 1, 1)
        .minimumInputs(1)
        .build();

    public static RecipeMap Lithography = RecipeMapBuilder.builder("reach.recipe.lithography", "Lithography")
        .setGuiPath(RCCS.RES_PATH_GUI + "machines/Lithography")
        .itemIO(2, 1, 1)
        .fluidIO(1, 0, 0)
        .minimumInputs(1)
        .build();

    public static RecipeMap ComponentAssembly = RecipeMapBuilder.builder("reach.recipe.component", "Component Assembly")
        .setGuiPath(RCCS.RES_PATH_GUI + "machines/ComponentAssembly")
        .itemIO(6, 1, 1)
        .fluidIO(2, 0, 0)
        .minimumInputs(1)
        .build();

    /*
     * static {
     * REACH_RECIPEMAPS.add(Polymerization);
     * REACH_RECIPEMAPS.add(FusionT2);
     * REACH_RECIPEMAPS.add(InterPlanetarySiphon);
     * REACH_RECIPEMAPS.add(MultiMill);
     * }
     */
}
