package revilo.reach.loaders.a;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import revilo.reach.data.RCMT;

public class FluidLoader implements Runnable {

    @Override
    public void run() {
        for (OreDictMaterial tMaterial : RCMT.ALL_MATERIALS_REGISTERED_HERE) {
            if (tMaterial.contains(TD.ItemGenerator.LIQUID)) FL.createLiquid(tMaterial);
            if (tMaterial.contains(TD.ItemGenerator.MOLTEN)) FL.createMolten(tMaterial);
            if (tMaterial.contains(TD.ItemGenerator.GASES)) FL.createGas(tMaterial);
            if (tMaterial.contains(TD.ItemGenerator.VAPORS)) FL.createVapour(tMaterial);
            if (tMaterial.contains(TD.ItemGenerator.PLASMA)) FL.createPlasma(tMaterial);
        }
        // Needed for fusion
        FL.createMolten(MT.Am);

        // Antimatter
        // FL.createGas(AM.H);

        // Rocket Fuel
        FL.create("rocketpropellant", "Rocket Propellant-1", null, 1);
        FL.create("rocketfuelmix", "Rocket Fuel Mixture", null, 1);

        // Superfluids
        FL.create("superfluidhelium", "Superfluid Helium", null, 1, 144, 2);
    }
}
