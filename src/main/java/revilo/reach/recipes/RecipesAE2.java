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
        delate(ST.make(MD.AE, "tile.BlockController", 1, 0));
        shaped(
            ST.make(MD.AE, "tile.BlockController", 1, 0),
            DEF_NCC,
            "wSs",
            "ECE",
            'w',
            wrench,
            's',
            screwdriver,
            'S',
            screw.dat(MT.Cr),
            'C',
            casingMachine.dat(MT.Cr),
            'E',
            OD_CIRCUITS[4]);

        delate(ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 0));
        shaped(
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 0),
            DEF_NCC,
            "w s",
            "FCF",
            "SES",
            'w',
            wrench,
            's',
            screwdriver,
            'S',
            screw.dat(MT.Ir),
            'C',
            casingMachine.dat(MT.Ir),
            'F',
            ST.make(MD.AE, "item.ItemMultiPart", 1, 16),
            'E',
            OD_CIRCUITS[6]);

        delate(ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 1));
        shaped(
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 1),
            DEF_NCC,
            "UP",
            "ws",
            'U',
            ST.make(MD.AE, "tile.BlockCraftingUnit", 1, 0),
            'P',
            IL.Processor_Crystal_Emerald,
            'w',
            wrench,
            's',
            screwdriver);

    }

}
