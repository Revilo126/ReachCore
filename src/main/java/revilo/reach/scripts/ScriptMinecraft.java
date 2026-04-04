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

import gregapi.data.ANY;
import gregapi.data.MD;
import gregapi.data.MT;
import revilo.reach.recipes.RecipeUtil;

public class ScriptMinecraft implements IScriptLoader {

    @Override
    public void loadRecipes() {
        delate(make(MC, "crafting_table", 1));
        shaped(make(MC, "crafting_table", 1), DEF_REM_REV, "Xk", "La", 'X', make(MC, "flint", 1), 'L', logWood);

        shaped(make(MC, "chest", 1), DEF_REM_REV, "LPL", "PaP", "LPL", 'L', logWood, 'P', plankWood);

        shaped(make(MC, "furnace", 1), DEF_REM_REV, " S ", "SFS", " Sh", 'S', cobblestone, 'F', craftingFirestarter);
        shaped(
            make(MC, "furnace", 1),
            DEF_REM_REV,
            " S ",
            "SFS",
            " Sh",
            'S',
            stone.dat(MT.STONES.Basalt),
            'F',
            craftingFirestarter);
        shaped(
            make(MC, "furnace", 1),
            DEF_REM_REV,
            " S ",
            "SFS",
            " Sh",
            'S',
            rockGt.dat(ANY.Stone),
            'F',
            craftingFirestarter);

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
