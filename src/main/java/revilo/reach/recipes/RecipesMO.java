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

// Basically just leave Android stuff //
@SuppressWarnings("unused")
public class RecipesMO implements Runnable {

    @Override
    public void run() {
        // Crates
        for (byte i = 0; i < 16; i++) {
            delate(ST.make(MD.MO, "tritanium_crate." + DYE_NAMES[i], 1, 0));
            hide(ST.make(MD.MO, "tritanium_crate." + DYE_NAMES[i], 1, 0)); // NEI
        }

        // Weapons

        delate(ST.make(MD.MO, "omni_tool", 1)); // Omni Tool doesn't work well + OP
        hide(ST.make(MD.MO, "omni_tool", 1));

        shaped(
            ST.make(MD.MO, "phaser_rifle", 1),
            DEF_REM_REV,
            "PPP",
            "RRL",
            "dwB",
            'P',
            plateCurved.dat(MT.Al),
            'R',
            rod.dat(MT.Al),
            'L',
            IL.Comp_Laser_Gas_CO2,
            'B',
            "gt:re-battery2");
        shaped(
            ST.make(MD.MO, "plasma_shotgun", 1),
            DEF_REM_REV,
            "Pdw",
            "RRL",
            "PBL",
            'P',
            plateCurved.dat(MT.Al),
            'R',
            rod.dat(MT.Al),
            'L',
            IL.Comp_Laser_Gas_CO2,
            'B',
            "gt:re-battery2");
        shaped(
            ST.make(MD.MO, "ion_sniper", 1),
            DEF_REM_REV,
            "PPP",
            "RLL",
            "dwB",
            'P',
            plateCurved.dat(MT.Al),
            'R',
            rod.dat(MT.Al),
            'L',
            IL.Comp_Laser_Gas_CO2,
            'B',
            "gt:re-battery2");

        // Batteries

        shaped(
            ST.make(MD.MO, "battery", 1),
            DEF_REM_REV,
            " C ",
            "PBP",
            "dCw",
            'C',
            gem.dat(MT.Dilithium),
            'P',
            plateCurved.dat(MT.TritaniumAlloy),
            'B',
            "gt:re-battery2");
        shaped(
            ST.make(MD.MO, "hc_battery", 1),
            DEF_REM_REV,
            " C ",
            "PBP",
            "dCw",
            'C',
            gem.dat(MT.Dilithium),
            'P',
            plateCurved.dat(MT.TritaniumAlloy),
            'B',
            "gt:re-battery3");

    }

}
