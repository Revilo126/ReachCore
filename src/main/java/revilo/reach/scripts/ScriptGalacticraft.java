package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;
import static revilo.reach.recipes.RecipeUtil.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

@SuppressWarnings("unused")
public class ScriptGalacticraft implements IScriptLoader {

    /*
     * Rocket Tiers - GT Tier
     * Tier 1 - HV
     * Tier 2 - EV
     * Tier 3 - IV
     * Tier 4 - LuV
     * Tier 5 - ZPM
     * Tier 6 - UV
     */

    private ItemStack[] toNuke = {
        // Remove base GC machines
        make(GC, "tile.machine", 1, 0), make(GC, "tile.machine", 1, 12), make(GC, "tile.machine2", 1, 0),
        make(GC, "tile.machine2", 1, 4), make(GC, "tile.machine2", 1, 8), make(GC, "tile.machineTiered", 1, 0),
        make(GC, "tile.machineTiered", 1, 4), make(GC, "tile.machineTiered", 1, 8),
        make(GC, "tile.machineTiered", 1, 12) };

    @Override
    public String getScriptName() {
        return "Galacticraft Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GC, ModIDs.GC_PLANETS);
    }

    @Override
    public void loadRecipes() {

    }

    @Override
    public void loadMachines() {
        // Parachutes
        for (byte i = 0; i < 15; i++) {
            delate(make(GC, "item.parachute", 1, i + 1));
            Bath.addRecipe1(
                T,
                0,
                32,
                make(GC, "item.parachute", 1, 0),
                DYE_FLUIDS_CHEMICAL[i],
                NF,
                make(GC, "item.parachute", 1, i + 1));
            Bath.addRecipe1(
                T,
                0,
                64,
                make(GC, "item.parachute", 1, i + 1),
                DYE_FLUIDS_CHEMICAL[15],
                NF,
                make(GC, "item.parachute", 1, 0));
        }
        Loom.addRecipeX(
            T,
            16,
            64,
            array(tag(0), make(MC, "wool", 2, 0), make(MC, "String", 3, 0)),
            make(GC, "item.parachute", 1, 0));
    }
}
