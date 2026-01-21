package revilo.reach.loaders;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.OM;
import revilo.reach.api.data.RCMT;

public class MaterialLoader implements Runnable {

    @Override
    public void run() {
    	// Sr2Ru04 line //
        RM.Mixer.addRecipe1( T, 512, 512, OM.dust(MT.OREMATS.Celestine), FL.Water.make(100), FL.CarbonDioxide.make(100), OM.dust(RCMT.SrCO3)); // too lazy to find h2s probs add later
        RM.Smelter.addRecipe1(T, 512, 2048, 10000, OM.dust(MT.Ru), FL.make("chlorine", 100), NF, OM.dust(RCMT.RuCl3));
        RM.Smelter.addRecipe1(T, 512, 2048, 10000, OM.dust(RCMT.RuCl3), FL.Water.make(250), NF, OM.dust(RCMT.RuO2));
        RM.Smelter.addRecipe2(T, 2048, 1024, 10000, OM.dust(RCMT.SrCO3), OM.dust(RCMT.RuO2), FL.Helium.make(1000), FL.Helium.make(1000), OM.dust(RCMT.Sr2RuO4));
    }

}
