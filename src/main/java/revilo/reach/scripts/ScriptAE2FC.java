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

import net.minecraft.item.ItemStack;

import gregapi.data.FL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.data.RCMD;
import revilo.reach.data.CS.ModIds;
import revilo.reach.recipes.RecipeUtil;

@SuppressWarnings("unused")
public class ScriptAE2FC implements IScriptLoader {

    private int[] baseSizes = { 1, 4, 16, 64, 256, 1024, 4096, 16384 };

    private ItemStack bufItem;

    @Override
    public String getScriptName() {
        return "AE2 Fluid Crafting Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIds.AE2FC);
    }

    @Override
    public void loadRecipes() {
        for (byte i = 0; i < 8; i++) { // Storage Cells
            if (baseSizes[i] > 64) {
                bufItem = ST.make(MD.AE, String.format("item.ItemAdvancedStorageCell.%sk", baseSizes[i]), 1, 0);
            } else {
                bufItem = ST.make(MD.AE, String.format("item.ItemBasicStorageCell.%sk", baseSizes[i]), 1, 0);
            }
            // Remove need for fluid crafting components.
            delate(make(RCMD.AE2FC, "fluid_storage" + baseSizes[i], 1, 0));
            RM.Bath.addRecipe1(
                T,
                0,
                64,
                bufItem,
                FL.make("martianvitriol", 1),
                NF,
                make(RCMD.AE2FC, "fluid_storage" + baseSizes[i], 1, 0)); // Due to fact martian vitriol is unobtainable
                                                                         // without galacticraft I will need to make a
                                                                         // new line.
            delate(make(RCMD.AE2FC, "multi_fluid_storage" + baseSizes[i], 1, 0));
            RM.Bath.addRecipe1(
                T,
                0,
                64,
                make(RCMD.AE2FC, "fluid_storage" + baseSizes[i], 1, 0),
                FL.make("bluevitriol", 1),
                NF,
                make(RCMD.AE2FC, "multi_fluid_storage" + baseSizes[i], 1, 0));

            RecipeUtil.nuke(ST.make(RCMD.AE2FC, "fluid_part", 1, i));
        }
        for (byte i = 0; i < 4; i++) { // Storage Housings
            RecipeUtil.nuke(make(RCMD.AE2FC, "fluid_storage_housing", 1, i));
        }

        ItemStack quartzTank = make(RCMD.AE2FC, "certus_quartz_tank", 1, 0),
            fluidAutoFiller = make(RCMD.AE2FC, "fluid_auto_filler", 1, 0), // Delete? As the fluid canner aint exist.
            levelMaintainer = make(RCMD.AE2FC, "level_maintainer", 1, 0),
            patternEncoder = make(RCMD.AE2FC, "fluid_pattern_encoder", 1, 0),
            packetDecoder = make(RCMD.AE2FC, "fluid_packet_decoder", 1, 0),
            dualInterface = make(RCMD.AE2FC, "fluid_interface", 1, 0),
            ingrediantBuffer = make(RCMD.AE2FC, "ingrediant_buffer", 1, 0);

        delate(quartzTank);
        RM.RollBender.addRecipe1(T, 16, 128, make(MD.AE, "tile.BlockQuartzGlass", 1, 0), quartzTank);

        RecipeUtil.nuke(fluidAutoFiller);

        shaped(
            levelMaintainer,
            DEF_REM_REV,
            "CP",
            "TI",
            "CD",
            'C',
            OD_CIRCUITS[6],
            'P',
            make(MD.AE, "item.ItemMultiMaterial", 1, 52),
            'T',
            make(MD.AE, "item.ItemMultiPart", 1, 340),
            'I',
            casingMachine.dat(MT.Ir),
            'D',
            gtRegistry.getItem(32718));
    }
}
