package revilo.reach.api.data;

import gregapi.code.HashSetNoNulls;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

public class RCMT { // Use id range 23000 - 23499 (i haven't asked Greg yet)

    public static final HashSetNoNulls<OreDictMaterial> ALL_MATERIALS_REGISTERED_HERE = new HashSetNoNulls<>();

    @SuppressWarnings("deprecation")
    public static OreDictMaterial create(int aID, String aNameOreDict, String aSymbol) {
        OreDictMaterial aMaterial = OreDictMaterial.createMaterial(aID, aNameOreDict, aNameOreDict)
            .setOriginalMod(RCMD.RC)
            .setTooltip(aSymbol);
        ALL_MATERIALS_REGISTERED_HERE.add(aMaterial);
        return aMaterial;
    }

    public static final OreDictMaterial Sr2RuO4 = create(23000, "Distrontium Ruthenate", "Sr2RuO4")
        .setTextures(TextureSet.SET_METALLIC)
        .setRGBa(50, 50, 50, 255)
        .put(TD.ItemGenerator.G_INGOT, TD.Compounds.ALLOY)
        .heat(2270, 4420)
        .setMcfg(0, MT.Sr, CS.U2, MT.Ru, CS.U, MT.O, CS.U2),
        SrCO3 = create(23001, "Strontium Carbonate", "SrCO3").setTextures(TextureSet.SET_CUBE) // Textures aren't used
            .setRGBa(240, 240, 240, 255)
            .put(TD.ItemGenerator.G_DUST)
            .setMcfg(0, MT.Sr, CS.U, MT.CO3, CS.U),
        RuO2 = create(23002, "Ruthenium Dioxide", "RuO2").setRGBa(90, 90, 90, 255)
            .setTextures(TextureSet.SET_CUBE) // not seen
            .put(TD.ItemGenerator.G_DUST)
            .setMcfg(CS.U, MT.Ru, CS.U, MT.O, CS.U2),
        RuCl3 = create(23003, "Ruthenium Chloride", "RuCl3").setTextures(TextureSet.SET_CUBE)
            .setRGBa(20, 20, 20, 255)
            .put(TD.ItemGenerator.G_DUST)
            .setMcfg(0, MT.Ru, CS.U, MT.Cl, CS.U);

}
