package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.util.ST;

@SuppressWarnings("unused")
public class RecipesAE2 implements Runnable {

    @Override
    public void run() {
        shaped(
            ST.make(AE, "tile.BlockController", 1, 0),
            DEF_REM_REV,
            "wSd",
            "ECE",
            "PSP",
            'S',
            screw.dat(MT.Ir),
            'C',
            casingMachine.dat(MT.Ir),
            'E',
            OD_CIRCUITS[6],
            'P',
            IL.Processor_Crystal_Emerald);
        shaped(
            ST.make(AE, "tile.BlockDrive", 1, 0),
            DEF_REM_REV,
            "wLd",
            "PHE",
            "SCS",
            'S',
            screw.dat(MT.Ir),
            'C',
            casingMachine.dat(MT.Ir),
            'E',
            OD_CIRCUITS[6],
            'P',
            IL.Processor_Crystal_Emerald,
            'L',
            IL.EMITTERS[6],
            'H',
            ST.make(AE, "item.ItemMultiMaterial", 1, 39));
        shaped(
            ST.make(AE, "tile.BlockCraftingUnit", 1, 0),
            DEF_REM_REV,
            "w d",
            "FCF",
            "SES",
            'C',
            casingMachine.dat(MT.Ir),
            'F',
            ST.make(AE, "item.ItemMultiPart", 1, 16),
            'E',
            OD_CIRCUITS[6],
            'S',
            screw.dat(MT.Ir));

        shaped(
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 1),
            DEF_REM_REV,
            "UP",
            "wd",
            'U',
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 0), // storage quad core
            'P',
            ST.make(MD.GT, "gt.multitileentity", 1, 18203)); // storage quad core
        shaped(
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 2),
            DEF_REM_REV,
            "PCP",
            "CUC",
            "PCP",
            'P',
            ST.make(MD.GT, "gt.multitileentity", 1, 18203), // storage quad core
            'C',
            OD_CIRCUITS[6],
            'U',
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 1));

    }

}
