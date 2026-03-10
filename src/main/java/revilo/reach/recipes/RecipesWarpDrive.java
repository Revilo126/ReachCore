package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.IL.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;
import static revilo.reach.api.data.RCMD.*;
import static revilo.reach.recipes.RecipeUtil.*;

import net.minecraft.init.Items;

import gregapi.data.MT;

@SuppressWarnings("unused")
public class RecipesWarpDrive implements Runnable {

    @Override
    public void run() {
        // Nuke Warpdrives reactor (Only gt's)
        nuke(make(WD, "blockEnanReactorCore", 1, 0));
        nuke(make(WD, "blockEnanReactorLaser", 1, 0));

        shaped(
            make(WD, "blockShipCore", 1),
            DEF_REM_REV_NCC,
            "TFC",
            "SRE",
            "NBN",
            'T',
            make(WD, "itemComponent", 1, 1),
            'C',
            OD_CIRCUITS[3],
            'F',
            FIELD_GENERATORS[3],
            'S',
            SENSORS[3],
            'R',
            casingMachineDouble.dat(MT.StainlessSteel),
            'E',
            EMITTERS[3],
            'N',
            make(Items.ender_eye, 1, 0),
            'B',
            "gt:re-battery3");

        shaped(
            make(WD, "blockShipController", 1),
            DEF_REM_REV_NCC,
            "SCE",
            "WTA",
            'S',
            SENSORS[3],
            'C',
            make(WD, "itemComponent", 1, 5),
            'E',
            EMITTERS[3],
            'W',
            make(WD, "itemComponent", 1, 0),
            'A',
            OD_CIRCUITS[3],
            'T',
            make(OC, "case1", 1, 0));

        delate(make(WD, "itemComponent", 1, 0));
        delate(make(WD, "itemComponent", 1, 1));
        delate(make(WD, "itemComponent", 1, 2));
        delate(make(WD, "itemComponent", 1, 7));
        delate(make(WD, "itemComponent", 1, 13));
        Lightning.addRecipeX(F, 16, 256, array(gem.mat(MT.Emerald, 1), tag(0)), make(WD, "itemComponent", 1, 0));
        Lightning.addRecipeX(F, 16, 256, array(make(Items.ender_pearl, 1, 0), tag(0)), make(WD, "itemComponent", 1, 1));
        Lightning.addRecipeX(F, 16, 256, array(gem.mat(MT.Diamond, 1), tag(0)), make(WD, "itemComponent", 1, 2));
        Lightning.addRecipeX(F, 16, 256, array(Battery_Alkaline_MV.get(1), tag(0)), make(WD, "itemComponent", 1, 7));
        Lightning.addRecipeX(F, 16, 256, array(make(OC, "item", 1, 2), tag(0)), make(WD, "itemComponent", 1, 13));
    }

}
