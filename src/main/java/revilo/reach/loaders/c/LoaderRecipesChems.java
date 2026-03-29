package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.RM;
import gregapi.util.ST;

public class LoaderRecipesChems implements Runnable {

    @Override
    public void run() {
        RM.Distillery.addRecipe1(T, 16, 128, ST.tag(1), FL.Kerosine.make(25), FL.make("rocketpropellant", 25), NI);

        RM.CryoMixer.addRecipe1(
            T,
            16,
            16,
            ST.tag(0),
            FL.array(FL.make("rocketpropellant", 8), FL.Liquid_Oxygen.make(8)),
            FL.make("rocketfuelmix", 16),
            NI);
        RM.Freezer.addRecipe1(T, 8192, 2048, ST.tag(0), FL.Helium.make(6), FL.make("superfluidhelium", 6), NI);
    }
}
