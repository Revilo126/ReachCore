package revilo.reach.loaders.a;

import gregapi.data.FL;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import revilo.reach.api.data.RCMT;

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
    }

}
