package revilo.reach.loaders.b.gt.lines;

import static gregapi.data.CS.NF;
import static gregapi.data.CS.T;

import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.OM;
import revilo.reach.api.data.RCMT;

public class MiscLines implements Runnable {

    @Override
    public void run() {
        RM.Mixer.addRecipe2(T, 16L, 1024L, OM.dust(MT.Al, 1), OM.dust(MT.Fe, 3), NF, NF, OM.dust(RCMT.Thermite, 4)); // Thermite
    }

}
