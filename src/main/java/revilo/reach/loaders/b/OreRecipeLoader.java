package revilo.reach.loaders.b;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;

import gregapi.data.MT;
import gregapi.data.MT.OREMATS;
import revilo.reach.api.data.RCMT;

public class OreRecipeLoader implements Runnable {

    @Override
    public void run() {
        Centrifuge.addRecipe1(
            T,
            64,
            144,
            new long[] { 8000, 2500, 400, 300, 100, 50 },
            blockDust.mat(RCMT.STONES.SeleneTurf, 1),
            dust.mat(MT.STONES.Basalt, 9),
            dustTiny.mat(MT.SiO2, 9),
            dustTiny.mat(MT.Al2O3, 9),
            dustTiny.mat(OREMATS.Ilmenite, 9),
            dustTiny.mat(MT.RareEarth, 9),
            dustTiny.mat(MT.Pt, 9));
        Centrifuge.addRecipe1(
            T,
            64,
            144,
            new long[] { 8000, 2500, 400, 300, 100, 50 },
            dust.mat(RCMT.STONES.SeleneTurf, 1),
            dust.mat(MT.STONES.Basalt, 1),
            dustTiny.mat(MT.SiO2, 1),
            dustTiny.mat(MT.Al2O3, 1),
            dustTiny.mat(OREMATS.Ilmenite, 1),
            dustTiny.mat(MT.RareEarth, 1),
            dustTiny.mat(MT.Pt, 1));
    }

}
