package revilo.reach.loaders.b.gt;

import static gregapi.data.CS.T;
import static gregapi.data.OP.blockDust;
import static gregapi.data.OP.dust;
import static gregapi.data.OP.dustTiny;
import static gregapi.data.RM.Centrifuge;

import gregapi.data.MT;
import gregapi.data.MT.OREMATS;
import revilo.reach.api.data.RCMT;

public class OreProcLoader implements Runnable {

    @Override
    public void run() {
        Centrifuge.addRecipe1(
            T,
            64,
            144,
            new long[] { 8000, 2000, 400, 300, 100, 50 },
            blockDust.mat(RCMT.SeleneTurf, 1),
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
            new long[] { 8000, 2000, 400, 300, 100, 50 },
            dust.mat(RCMT.SeleneTurf, 1),
            dust.mat(MT.STONES.Basalt, 1),
            dustTiny.mat(MT.SiO2, 1),
            dustTiny.mat(MT.Al2O3, 1),
            dustTiny.mat(OREMATS.Ilmenite, 1),
            dustTiny.mat(MT.RareEarth, 1),
            dustTiny.mat(MT.Pt, 1));
    }

}
