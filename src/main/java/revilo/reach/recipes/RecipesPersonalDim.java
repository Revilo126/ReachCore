package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import gregapi.data.IL;
import gregapi.data.MT;
import revilo.reach.api.data.RCMD;

public class RecipesPersonalDim implements Runnable {

    @Override
    public void run() {
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

}
