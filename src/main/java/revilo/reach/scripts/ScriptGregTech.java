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

import gregapi.block.multitileentity.MultiTileEntityRegistry;

@SuppressWarnings("unused")
public class ScriptGregTech implements IScriptLoader {

    @Override
    public void loadRecipes() {
        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity"); // Needed for
                                                                                                       // accessing gt
                                                                                                       // tiles

        machines(aRegistry);
        cables(aRegistry);
        zpm(aRegistry);
    }

    private void machines(MultiTileEntityRegistry aRegistry) {
        // TODO
    }

    private void cables(MultiTileEntityRegistry aRegistry) {
        /*
         * ItemStack fiberCable = aRegistry.getItem(24900);
         * postDelate(fiberCable);
         * shaped(
         * fiberCable,
         * DEF_REM_NCC,
         * "GCG",
         * "RSD",
         * "w x",
         * 'G',
         * blockGlassColorless,
         * 'C',
         * OD_CIRCUITS[3],
         * 'R',
         * gemFlawless.dat(MT.Redstone),
         * 'S',
         * plateDouble.dat(MT.Ag),
         * 'D',
         * gemFlawless.dat(ANY.Diamond));
         */
    }

    private void zpm(MultiTileEntityRegistry aRegistry) {
        /*
         * AvaritiaHelp.addExtremeRecipe(
         * getTile(MD.GT, 18044),
         * "CCMAOAMCC",
         * "CMAOPOAMC",
         * "MAOUWUOAM",
         * "AOUWNWUOA",
         * "OPWNDNWPO",
         * "AOUWNWUOA",
         * "MAOUWUOAM",
         * "CMAOPOAMC",
         * "CCMAOAMCC",
         * 'C',
         * plateCurved.mat(MT.Os, 1),
         * 'M',
         * casingMachine.mat(MT.Os, 1),
         * 'A',
         * OD_CIRCUITS[8],
         * 'O',
         * getTile(MD.GT, 18044),
         * 'P',
         * plateDense.mat(MT.Pu_243, 1),
         * 'U',
         * plateDense.mat(MT.U_235, 1),
         * 'W',
         * getTile(MD.GT, 29515),
         * 'N',
         * plateDense.mat(MT.Nq_528, 1),
         * 'D',
         * plateDense.mat(MT.Nq_522, 1));
         */
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Gregtech Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GT, ModIDs.AV);
    }
}
