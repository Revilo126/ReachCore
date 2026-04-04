package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import gregapi.data.IL;
import gregapi.data.MT;
import revilo.reach.data.RCCS.ModIds;
import revilo.reach.data.RCMD;

public class ScriptPersonalDim implements IScriptLoader {

    @Override
    public void loadRecipes() {
        shaped(
            make(RCMD.PerDim, "personalPortal", 1),
            DEF_REV,
            "PFP",
            "CIC",
            "RFR",
            'P',
            IL.Processor_Crystal_Sapphire,
            'F',
            IL.Field_Generator_LuV,
            'C',
            OD_CIRCUITS[6],
            'I',
            casingMachine.dat(MT.Ir),
            'R',
            IL.Processor_Crystal_Ruby);
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Personal Dimensions Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIds.PerDim);
    }

}
