package revilo.reach.loaders.b.gt;

import static gregapi.data.CS.F;
import static gregapi.data.CS.T;
import static gregapi.data.CS.U;
import static gregapi.data.CS.ZL_IS;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.api.data.RCMT;

// TODO: Add more fusion uses (power focused)
public class FusionLoader implements Runnable {

    @Override
    public void run() {
        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4096,
                ST.tag(3),
                FL.array(MT.Am.liquid(U, T), MT.Cr.liquid(U, T)),
                FL.array(RCMT.Uue.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4096L * 8192L * 32L); // Theoretical Elements - Fusion only
        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4352,
                ST.tag(3),
                FL.array(MT.U_238.liquid(U, T), MT.Ni.liquid(U, T)),
                FL.array(RCMT.Ubn.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4352L * 8192L * 32L);
        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4608,
                ST.tag(3),
                FL.array(MT.U_238.liquid(U, T), MT.Cu.liquid(U, T)),
                FL.array(RCMT.Ubu.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4608L * 8192L * 32L);
    }

}
