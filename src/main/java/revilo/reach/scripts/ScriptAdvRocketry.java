package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;
import static revilo.reach.recipes.RecipeUtil.*;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ScriptAdvRocketry implements IScriptLoader {

    // Why is it so long?
    private static String product = "advancedRocketryproduct";

    @Override
    public String getScriptName() {
        return "Advanced Rocketry Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GC_ADV_ROCKETRY);
    }

    @Override
    public void loadRecipes() {
        spaceShipParts();
        machines();
        misc();
        deleteOreDicts();
    }

    private void spaceShipParts() {
        // TODO //
    }

    private void machines() {
        // TODO //
    }

    private void misc() {
        // TODO //
    }

    private void deleteOreDicts() {
        // TODO: FIX
        /*
         * String[] types = { "dust", "ingot", "nugget", "plate", "rod", "sheet", "gear" };
         * for (byte i = 0; i < 7; i++) {
         * OreDictionary.getOres(types[i] + "TitaniumAluminide")
         * .remove(make(MD.GC_ADV_ROCKETRY, product + types[i], 1, 0));
         * OreDictionary.getOres(types[i] + "TitaniumIridium")
         * .remove(make(MD.GC_ADV_ROCKETRY, product + types[i], 1, 1));
         * }
         */
    }
}
