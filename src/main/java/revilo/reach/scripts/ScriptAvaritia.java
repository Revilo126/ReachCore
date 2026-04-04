package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import gregapi.data.CS.ModIDs;

@SuppressWarnings("unused")
public class ScriptAvaritia implements IScriptLoader {

    @Override
    public void loadRecipes() {
        /**
         * Still WIP
         * ExtremeCraftingManager instance = ExtremeCraftingManager.getInstance();
         * ItemStack CrystalMatrix = make(LudicrousItems.resource, 1, 1),
         * NeutroniumIngot = make(LudicrousItems.resource, 1, 4), InfinityIngot = make(LudicrousItems.resource, 1, 6);
         * 
         * remout(make(MD.AV, "avaritia_resource", 1, 0));
         * for (OreDictMaterial tMat : ANY.Diamond.mToThis) {
         * Nanofab.addRecipe1(T, V[6], 2048, tag(1), dust.mat(tMat, 5), make(MD.AV, "avaritia_resource", 1, 0));
         * }
         * remout(make(MD.AV, "avaritia_resource", 1, 1));
         * Press.addRecipe2(
         * T,
         * 2048,
         * 4096,
         * make(MD.AV, "avaritia_resource", 4, 0),
         * make(Items.nether_star, 2, 0),
         * make(MD.AV, "avaritia_resource", 1, 1));
         * remout(make(MD.AV, "compressed_workbench", 1));
         * Press.addRecipe1(T, 32, 64, make(Blocks.crafting_table, 9, 0), make(MD.AV, "compressed_workbench", 1));
         * remout(make(MD.AV, "very_compressed_workbench", 1));
         * Press
         * .addRecipe1(T, 32, 64, make(MD.AV, "compressed_workbench", 9), make(MD.AV, "very_compressed_workbench", 1));
         * 
         * // TODO: multiblock neutron collector
         * removeExtremeCraftingRecipe(make(LudicrousBlocks.neutron_collector, 1, 0));
         * 
         * addExtremeRecipe(
         * InfinityIngot,
         * "UUUUUUUUU",
         * "UCCCCCCCU",
         * "UCXNXNXCU",
         * "UCCCCCCCU",
         * "UUUUUUUUU",
         * 'U',
         * ingot.mat(RCMT.Uue, 1),
         * 'C',
         * CrystalMatrix,
         * 'X',
         * make(LudicrousItems.resource, 1, 5),
         * 'N',
         * NeutroniumIngot);
         */
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Avaritia Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.AV);
    }
}
