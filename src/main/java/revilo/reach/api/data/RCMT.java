package revilo.reach.api.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.Atomic.*;
import static gregapi.data.TD.Compounds.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Processing.*;

import gregapi.code.HashSetNoNulls;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

@SuppressWarnings("unused")
public class RCMT { // Use id range 23000 - 23499 (i haven't asked Greg yet)

    public static final HashSetNoNulls<OreDictMaterial> ALL_MATERIALS_REGISTERED_HERE = new HashSetNoNulls<>();

    @SuppressWarnings("deprecation")
    public static OreDictMaterial create(int aID, String aNameOreDict, String aSymbol) {
        OreDictMaterial aMaterial = create(aID, aNameOreDict).setTooltip(aSymbol);
        return aMaterial;
    }

    public static OreDictMaterial create(int aID, String aNameOreDict) {
        OreDictMaterial aMaterial = OreDictMaterial.createMaterial(aID, aNameOreDict, aNameOreDict)
            .setOriginalMod(RCMD.RC);
        ALL_MATERIALS_REGISTERED_HERE.add(aMaterial);
        return aMaterial;
    }

    static OreDictMaterial stone(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict).setRGBa(aR, aG, aB, aA)
            .setTextures(TextureSet.SET_STONE)
            .put(aRandomData);
    }

    public static final OreDictMaterial Sr2RuO4 = create(23000, "Distrontium Ruthenate", "Sr2RuO4") // Distrontium
                                                                                                    // Ruthenate line
        .setTextures(TextureSet.SET_METALLIC)
        .setRGBa(50, 50, 50, 255)
        .put(G_INGOT, ALLOY, MELTING, EXTRUDER)
        .heat(2270, 4420)
        .setMcfg(0, MT.Sr, 2 * U, MT.Ru, 1 * U, MT.O, 4 * U),
        SrCO3 = create(23001, "Strontium Carbonate", "SrCO3").setTextures(TextureSet.SET_CUBE) // Textures aren't used
                                                                                               // in dusts
            .setRGBa(240, 240, 240, 255)
            .put(G_DUST)
            .setMcfg(0, MT.Sr, 1 * U, MT.CO3, 1 * U),
        RuO2 = create(23002, "Ruthenium Dioxide", "RuO2").setRGBa(90, 90, 90, 255)
            .setTextures(TextureSet.SET_CUBE) // not seen
            .put(G_DUST)
            .setMcfg(0, MT.Ru, 1 * U, MT.O, 2 * U),
        RuCl3 = create(23003, "Ruthenium Chloride", "RuCl3").setTextures(TextureSet.SET_CUBE) // not seen
            .setRGBa(20, 20, 20, 255)
            .put(G_DUST)
            .setMcfg(0, MT.Ru, 1 * U, MT.Cl, 3 * U);

    public static final OreDictMaterial Thermite = create(23004, "Thermite", "AlFe3").setTextures(TextureSet.SET_CUBE) // AdvRocketry
        .setRGBa(125, 42, 14, 255)
        .put(G_DUST, ALLOY, DECOMPOSABLE, CENTRIFUGE)
        .heat(933, MT.Al.mBoilingPoint)
        .setMcfg(0, MT.Al, CS.U, MT.Fe, 3 * U);

    public static class STONES {

        public static OreDictMaterial SeleneTurf = stone(23400, "Selene Turf", 190l, 190l, 190l, 255l),
            DominiTurf = stone(23401, "Domini Turf", 180, 20, 20, 255),
            Alfheim1Turf = stone(23401, "Alfheim-1 Turf", 180, 20, 20, 255);
    }

}
