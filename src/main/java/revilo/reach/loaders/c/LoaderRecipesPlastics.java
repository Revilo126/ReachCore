package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.data.RCMT;
import revilo.reach.data.RCRM;

public class LoaderRecipesPlastics implements Runnable {

    @Override
    public void run() {
        OUT.println("Reach: Loading Plastic Recipes.");

        // PVC //
        RCRM.Polymerization.addRecipe1(T, 16, 4096, ST.tag(0), RCMT.VCM.gas(144, F), NF, OP.dust.mat(RCMT.PVC, 1));
        RM.BurnMixer
            .addRecipe0(T, 16, 128, FL.array(FL.Ethylene.make(30), MT.Cl.gas(10, F)), RCMT.EDC.liquid(56, F), ZL_IS);
        RM.CatalyticCracking.addRecipe1(
            T,
            16,
            512,
            ST.tag(0),
            FL.array(FL.Hydrogen.make(56), RCMT.EDC.liquid(56, F)),
            FL.array(RCMT.VCM.gas(36, F), MT.HCl.gas(20, F)),
            ZL_IS);

        // SBR // TODO: Make Styrene and Benzene
        // RM.Mixer.addRecipe0(T, 16, 128, FL.array(MT.Sty), );
    }

}
