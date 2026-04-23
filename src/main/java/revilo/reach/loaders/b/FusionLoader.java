package revilo.reach.loaders.b;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.util.ST;
import revilo.reach.data.RCRM;

// TODO: Add more fusion uses (power focused)
@SuppressWarnings("unused")
public class FusionLoader implements Runnable {

    @Override
    public void run() {
        /*
         * Special Number is the LU required to start the reaction, determining this goes as this.
         * Tier 1: Time * EU/t * 16
         * Tier 2: Time * EU/t * 32
         * Tier 3: Time * EU/t * 64
         * More to come!
         */

        // Theoretical Elements - Fusion only
        RCRM.FusionT2
            .addRecipe1(
                F,
                -32768,
                4352,
                ST.tag(3),
                FL.array(MT.U_238.liquid(U, T), MT.Ni.liquid(U, T)),
                FL.array(MT.Ubn.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4352L * 32768L * 32L);
        RCRM.FusionT2
            .addRecipe1(
                F,
                -32768,
                4766,
                ST.tag(4),
                FL.array(MT.Am.liquid(U, T), MT.Cr.liquid(U, T)),
                FL.array(MT.Uue.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4096L * 8192L * 64L);
        RCRM.FusionT2
            .addRecipe1(
                F,
                -32768,
                4202,
                ST.tag(4),
                FL.array(MT.U_238.liquid(U, T), MT.Cu.liquid(U, T)),
                FL.array(MT.Ubu.liquid(U, F)),
                ZL_IS)
            .setSpecialNumber(4608L * 8192L * 64L);
    }

}
