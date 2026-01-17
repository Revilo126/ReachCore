package revilo.reach.api.data;

import gregapi.code.HashSetNoNulls;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

public class RCMT { // Use id range 23000 - 23499 (i haven't asked Greg yet)

    public static final HashSetNoNulls<OreDictMaterial> ALL_MATERIALS_REGISTERED_HERE = new HashSetNoNulls<>();

    public static OreDictMaterial create(int aID, String aNameOreDict, String localName) {
        OreDictMaterial aMaterial = OreDictMaterial.createMaterial(aID, aNameOreDict, localName);
        ALL_MATERIALS_REGISTERED_HERE.add(aMaterial);
        aMaterial.setOriginalMod(RCMD.RC);
        return aMaterial;
    }

    public static final OreDictMaterial test = create(23000, "test", "test").setTextures(TextureSet.SET_METALLIC)
        .setRGBa(200, 100, 100, 255)
        .put(TD.ItemGenerator.G_INGOT_ORES);

}
