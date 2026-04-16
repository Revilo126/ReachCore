package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;
import static revilo.reach.recipes.RecipeUtil.*;

import java.util.Arrays;
import java.util.List;

import gregapi.data.MD;
import revilo.reach.recipes.RecipeUtil;

@SuppressWarnings("unused")
public class ScriptMinecraft implements IScriptLoader {

    @Override
    public void loadRecipes() {
        String[] tiers = { "iron", "wooden", "stone", "golden", "diamond" };
        for (byte i = 0; i < 5; i++) {
            RecipeUtil.nuke(make(MD.MC, tiers[i] + "_sword", 1, 0));
            RecipeUtil.nuke(make(MD.MC, tiers[i] + "_pickaxe", 1, 0));
            RecipeUtil.nuke(make(MD.MC, tiers[i] + "_axe", 1, 0));
            RecipeUtil.nuke(make(MD.MC, tiers[i] + "_shovel", 1, 0));
            RecipeUtil.nuke(make(MD.MC, tiers[i] + "_hoe", 1, 0));
        }
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Minecraft Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GT); // This doesn't need dependencies as it is the game.
    }

}
