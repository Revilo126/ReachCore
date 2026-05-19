package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.util.ST;
import revilo.reach.data.RCRM;
import revilo.reach.loaders.helper.Loader;

@Loader.Init(priority = 1)
public class LoaderRecipesComponents implements Runnable {

    @Override
    public void run() {
        RCRM.ComponentAssembly.addRecipeX(
            T,
            32768,
            512,
            ST.array(
                OP.stickLong.mat(MT.NeodymiumMagnetic, 8),
                OP.plateCurved.mat(MT.DATA.Electric_T[7], 2),
                OP.stick.mat(MT.DATA.Electric_T[7], 2),
                OP.wireGt07.mat(MT.AnnealedCopper, 1),
                OP.cableGt01.mat(MT.DATA.CABLES_01[7].mMaterial.mMaterial, 2)),
            FL.array(FL.Lubricant.make(72), MT.Rubber.liquid(144, F)),
            NF,
            IL.MOTORS[7].get(1));
    }

}
