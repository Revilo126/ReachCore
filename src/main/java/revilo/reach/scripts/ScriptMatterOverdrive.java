package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.IL.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import gregapi.data.CS.ModIDs;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.util.ST;
import revilo.reach.recipes.RecipeUtil;

// Basically just leave Android stuff //
@SuppressWarnings("unused")
public class ScriptMatterOverdrive implements IScriptLoader {

    @Override
    public void loadRecipes() {
        // Crates
        for (byte i = 0; i < 16; i++) {
            RecipeUtil.nuke(ST.make(MD.MO, "tritanium_crate." + DYE_NAMES[i], 1, 0));
        }

        // Weapons

        delate(ST.make(MD.MO, "omni_tool", 1)); // Omni Tool doesn't work well + OP
        hide(ST.make(MD.MO, "omni_tool", 1));

        shaped(
            ST.make(MD.MO, "phaser_rifle", 1),
            DEF_REM_REV_NCC,
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
            DEF_REM_REV_NCC,
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
            DEF_REM_REV_NCC,
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
            DEF_REM_REV_NCC,
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
            DEF_REM_REV_NCC,
            " C ",
            "PBP",
            "dCw",
            'C',
            gem.dat(MT.Dilithium),
            'P',
            plateCurved.dat(MT.TritaniumAlloy),
            'B',
            "gt:re-battery3");

        // Android parts

        shaped(
            make(MD.MO, "tritanium_spine", 1, 0),
            DEF_REM_REV_NCC,
            "hTw",
            "CEC",
            " T ",
            'T',
            plateCurved.dat(MT.TritaniumAlloy),
            'C',
            OD_CIRCUITS[6],
            'E',
            FIELD_GENERATORS[5]);
        shaped(
            make(MD.MO, "rouge_android_part", 1, 0),
            DEF_REM_REV_NCC,
            "LEC",
            "ITM",
            "RUS",
            'L',
            Processor_Crystal_Diamond,
            'E',
            FIELD_GENERATORS[5],
            'C',
            Processor_Crystal_Sapphire,
            'I',
            IL.SENSORS[5],
            'T',
            plateCurved.dat(MT.TritaniumAlloy),
            'M',
            IL.EMITTERS[5],
            'R',
            IL.Processor_Crystal_Ruby,
            'U',
            OD_CIRCUITS[6],
            'S',
            IL.Processor_Crystal_Emerald);
        shaped(
            make(MD.MO, "rouge_android_part", 1, 1),
            DEF_REM_REV_NCC,
            "CAC",
            "TUT",
            'C',
            IL.Circuit_Crystal_Ruby,
            'A',
            IL.ROBOT_ARMS[5],
            'T',
            plateCurved.dat(MT.TritaniumAlloy),
            'U',
            OD_CIRCUITS[6]);
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Matter Overdrive Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.MO);
    }

}
