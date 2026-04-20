package revilo.reach.loaders.b;

import static gregapi.data.CS.F;
import static gregapi.data.CS.T;
import static gregapi.data.CS.U;
import static gregapi.data.CS.ZL_IS;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.data.RCRM;

// TODO: Add more fusion uses (power focused)
public class FusionLoader implements Runnable {

    @Override
    public void run() {

        // Theoretical Elements - Fusion only
        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4352,
                ST.tag(3),
                FL.array(MT.U_238.liquid(U, T), MT.Ni.liquid(U, T)),
                FL.array(MT.Ubn.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4352L * 8192L * 32L);
        RCRM.FusionT2
            .addRecipe1(
                F,
                -32768,
                4766,
                ST.tag(3),
                FL.array(MT.Am.liquid(U, T), MT.Cr.liquid(U, T)),
                FL.array(MT.Uue.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4096L * 8192L * 64L);
        RCRM.FusionT2
            .addRecipe1(
                F,
                -32768,
                4202,
                ST.tag(3),
                FL.array(MT.U_238.liquid(U, T), MT.Cu.liquid(U, T)),
                FL.array(MT.Ubu.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4608L * 8192L * 64L);
    }

}
