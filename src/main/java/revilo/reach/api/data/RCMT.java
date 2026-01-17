package revilo.reach.api.data;

import static gregapi.data.TD.ItemGenerator;
import static gregapi.data.TD.Properties;

import gregapi.data.TC;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

public class RCMT { // Use id range 23000 - 23499 (i haven't asked Greg yet)

    public OreDictMaterial Bs = OreDictMaterial.createMaterial(23000, "Beskar", "Bs")
        .setTextures(TextureSet.SET_METALLIC)
        .setRGBa(145, 145, 145, 255)
        .heat(6250)
        .aspects(TC.METALLUM, 2)
        .put(Properties.UNBURNABLE, ItemGenerator.G_INGOT_ORES)
        .setOriginalMod(RCMD.RC);
}
