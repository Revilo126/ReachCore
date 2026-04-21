package revilo.reach.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.Atomic.*;
import static gregapi.data.TD.Compounds.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Processing.*;
import static gregapi.data.TD.Properties.*;
import static gregapi.render.TextureSet.*;

import gregapi.code.HashSetNoNulls;
import gregapi.data.ANY;
import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

/**
 * Reach Materials
 */
@SuppressWarnings("unused")
public class RCMT { // Use id range 23000 - 23499 (i haven't asked Greg yet)

    /*
     * To ease making materials, I have this so I don't need to make sure there is no id conflicts.
     */
    public static int id = 23000;

    public static final HashSetNoNulls<OreDictMaterial> ALL_MATERIALS_REGISTERED_HERE = new HashSetNoNulls<>();

    public static OreDictMaterial create(String aNameOreDict, String aSymbol) {
        OreDictMaterial aMaterial = create(aNameOreDict).tooltip(aSymbol);
        return aMaterial;
    }

    public static OreDictMaterial create(String aNameOreDict) {
        OreDictMaterial aMaterial = OreDictMaterial.createMaterial(id++, aNameOreDict, aNameOreDict)
            .setOriginalMod(RCMD.RC);
        ALL_MATERIALS_REGISTERED_HERE.add(aMaterial);
        return aMaterial;
    }

    /*
     * For materials that require special ids.
     * E.g: Tiers
     */
    public static OreDictMaterial create(int aID, String aNameOreDict) {
        OreDictMaterial aMaterial = OreDictMaterial.createMaterial(aID, aNameOreDict, aNameOreDict)
            .setOriginalMod(RCMD.RC);
        ALL_MATERIALS_REGISTERED_HERE.add(aMaterial);
        return aMaterial;
    }

    static OreDictMaterial tier(String aNameOreDict) {
        return create(-1, aNameOreDict).put(UNUSED_MATERIAL, DONT_SHOW_THIS_COMPONENT, IGNORE_IN_COLOR_LOG)
            .setAllToTheOutputOf(null, 0, 1);
    }

    // Unused
    static OreDictMaterial stone(String aNameOreDict, long aR, long aG, long aB, long aA, Object... aRandomData) {
        return create(aNameOreDict).setRGBa(aR, aG, aB, aA)
            .setTextures(SET_STONE)
            .put(aRandomData);
    }

    static OreDictMaterial element(String aNameOreDict, String aSymbol, long aProtonsAndElectrons, long aNeutrons,
        long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets, long aR, long aG,
        long aB, Object... aTags) {
        return create(aNameOreDict, aSymbol)
            .setStats(aProtonsAndElectrons, aNeutrons, aMeltingPoint, aBoilingPoint, aGramPerCubicCentimeter)
            .setTextures(aSets)
            .setRGBa(aR, aG, aB, 255)
            .put(aTags);
    }

    // Note it is decomposable
    static OreDictMaterial gas(String aNameOreDict, String aSymbol) {
        return create(aNameOreDict, aSymbol).setTextures(SET_GAS)
            .put(DECOMPOSABLE, GASES, G_CONTAINERS, CONTAINERS_GAS);
    }

    // Note it is decomposable
    static OreDictMaterial liquid(String aNameOreDict, String aSymbol) {
        return create(aNameOreDict, aSymbol).setTextures(SET_GAS)
            .put(DECOMPOSABLE, LIQUID);
    }

    // Note it is decomposable
    static OreDictMaterial dust(String aNameOreDict, String aSymbol) {
        return create(aNameOreDict, aSymbol).setTextures(SET_SHARDS)
            .put(G_DUST, MORTAR, DECOMPOSABLE);
    }

    // Periodic Table 23010 - 23099

    // Tiers (not including base GT's)

    public static OreDictMaterial Nano = tier("Nano"), Atomic = tier("Atomic"), QuantumT1 = tier("QuantumT1"),
        QuantumT2 = tier("QuantumT2"), QuantumT3 = tier("QuantumT3"), QuantumT4 = tier("QuantumT4"),
        QuantumT5 = tier("QuantumT5"), QuantumT6 = tier("QuantumT6"), QuantumT7 = tier("QuantumT7");

    // Theoretical elements 23100 - 23199
    /*
     * public static OreDictMaterial Uue = element(
     * "Ununennium",
     * "Uue",
     * 119,
     * 183,
     * 303,
     * 903,
     * 3,
     * SET_METALLIC,
     * 195,
     * 170,
     * 250,
     * G_INGOT_MACHINE,
     * MOLTEN,
     * ALKALI_METAL,
     * FUSION,
     * NEVER_FURNACE,
     * EXTRUDER,
     * MELTING),
     * Ubn = element(
     * "Unbinilium",
     * "Ubn",
     * 120,
     * 179,
     * 953,
     * 1973,
     * 7,
     * SET_METALLIC,
     * 250,
     * 170,
     * 217,
     * G_INGOT_ORES,
     * MOLTEN,
     * ALKALINE_EARTH_METAL,
     * FUSION,
     * NEVER_FURNACE,
     * EXTRUDER,
     * MELTING),
     * Ubu = element(
     * "Unbiunium",
     * "Ubu",
     * 121,
     * 182,
     * 950,
     * 1985,
     * 7,
     * SET_METALLIC,
     * 250,
     * 243,
     * 170,
     * G_INGOT_ORES,
     * MOLTEN,
     * ALKALINE_EARTH_METAL,
     * FUSION,
     * NEVER_FURNACE,
     * EXTRUDER,
     * MELTING);
     */

    // Alloys 23200 - 23299
    public static OreDictMaterial AdUue = create("Adamennium").setRGBa(255, 133, 233, 255)
        .setTextures(SET_SHINY)
        .put(
            G_INGOT_MACHINE,
            SMITHABLE,
            MELTING,
            MOLTEN,
            EXTRUDER,
            MAGICAL,
            MAGNETIC_PASSIVE,
            UNBURNABLE,
            WITHER_PROOF,
            ENDER_DRAGON_PROOF,
            ALLOY,
            CRUCIBLE_ALLOY)
        .qual(3, 12.0, 6128, 6)
        .setAloy(0, MT.Ad, 1 * U, MT.Uue, 1 * U)
        .heat(6225, 16768);

    public static final OreDictMaterial RUTAlloy = create("RUT-Alloy", "Revilo's Useful Tool-Alloy")
        .setTextures(SET_SHINY)
        .setRGBa(150, 0, 30, 255)
        .put(G_INGOT, SMITHABLE, MOLTEN, ALLOY, CRUCIBLE_ALLOY)
        .qual(9, 10240, 4)
        .handle(ANY.WoodPlastic)
        .heat(MT.Redstone.mMeltingPoint, MT.Redstone.mBoilingPoint)
        .setAloy(0, MT.Redstone, 2 * U, MT.U_238, 1 * U, MT.Ti, 1 * U);

    // Distrontium Ruthenate line
    public static final OreDictMaterial Sr2RuO4 = create("Distrontium Ruthenate", "Sr2RuO4").setTextures(SET_METALLIC)
        .setRGBa(50, 50, 50, 255)
        .put(G_INGOT, ALLOY, MELTING, EXTRUDER)
        .heat(2270, 4420)
        .setMcfg(0, MT.Sr, 2 * U, MT.Ru, 1 * U, MT.O, 4 * U),
        SrCO3 = create("Strontium Carbonate", "SrCO3").setTextures(SET_CUBE) // Textures aren't used
            .setRGBa(240, 240, 240, 255)
            .put(G_DUST)
            .setMcfg(0, MT.Sr, 1 * U, MT.CO3, 1 * U),
        RuO2 = create("Ruthenium Dioxide", "RuO2").setRGBa(90, 90, 90, 255)
            .setTextures(SET_CUBE) // not seen
            .put(G_DUST)
            .setMcfg(0, MT.Ru, 1 * U, MT.O, 2 * U),
        RuCl3 = create("Ruthenium Chloride", "RuCl3").setTextures(SET_CUBE) // not seen
            .setRGBa(20, 20, 20, 255)
            .put(G_DUST)
            .setMcfg(0, MT.Ru, 1 * U, MT.Cl, 3 * U);

    // Naquadah refining TODO
    public static final OreDictMaterial NqGe2F4 = dust("Naquadah Digermanium Tetrafluoride", "NqGe2F4")
        .setRGBa(40, 40, 40, 255)
        .setMcfg(0, MT.Nq, 1 * U, MT.Ge, 2 * U, MT.F, 4 * U)
        .put(MELTING, MOLTEN),
        NqGe2F6 = gas("Naquadah Digermanium Hexafluoride", "NqGe2F6").setRGBa(48, 48, 48, 255)
            .setMcfg(0, MT.Nq, 1 * U, MT.Ge, 2 * U, MT.F, 6 * U),
        Nq528Ge2F4 = dust("Naquadah-Enriched Digermanium Tetrafluoride", "Nq528Ge2F4").setRGBa(30, 30, 30, 255)
            .setMcfg(0, MT.Nq_528, 1 * U, MT.Ge, 2 * U, MT.F, 4 * U)
            .put(MELTING, MOLTEN),
        Nq528Ge2F6 = gas("Naquadah-Enriched Digermanium Hexafluoride", "Nq528Ge2F6").setRGBa(38, 38, 38, 255)
            .setMcfg(0, MT.Nq_528, 1 * U, MT.Ge, 2 * U, MT.F, 6 * U),
        Nq522Ge2F4 = dust("Naquadria Digermanium Tetrafluoride", "Nq522Ge2F4").setRGBa(20, 20, 20, 255)
            .setMcfg(0, MT.Nq_522, 1 * U, MT.Ge, 2 * U, MT.F, 4 * U)
            .put(MELTING, MOLTEN),
        Nq522Ge2F6 = gas("Naquadria Digermanium Hexafluoride", "Nq522Ge2F6").setRGBa(28, 28, 28, 255)
            .setMcfg(0, MT.Nq_522, 1 * U, MT.Ge, 2 * U, MT.F, 6 * U);

    // Plastics

    // PVC
    public static final OreDictMaterial PVC = create("Polyvinal Chloride Plastic", "C2H3Cl").setTextures(SET_DULL)
        .setRGBa(245, 245, 245, 255)
        .put(
            G_INGOT_MACHINE,
            APPROXIMATE,
            FLAMMABLE,
            EXTRUDER,
            EXTRUDER_SIMPLE,
            WIRES,
            MORTAR,
            BOUNCY,
            BRITTLE,
            FURNACE)
        .uumMcfg(0, MT.C, 2 * U, MT.H, 3 * U, MT.Cl, U)
        .heat(443)
        .setBurning(MT.Ash, U9),
        VCM = gas("Vinal Chloride Monomer", "C2H3Cl").setRGBa(255, 255, 255, 45)
            .uumMcfg(0, MT.C, 2 * U, MT.H, 3 * U, MT.Cl, U)
            .heat(119, 259),
        EDC = liquid("Ethylene Dichloride", "C2H3Cl2").setRGBa(255, 255, 255, 255)
            .uumMcfg(0, MT.C, 2 * U, MT.H, 3 * U, MT.Cl, U * 2)
            .heat(238, 356);

    // Synthetic Rubber
    public static final OreDictMaterial SBR = create("Styrene-Butadiene Rubber", "C20H26").setTextures(SET_RUBBER)
        .setRGBa(35, 35, 35, 255)
        .put(
            G_INGOT_MACHINE,
            APPROXIMATE,
            FLAMMABLE,
            EXTRUDER,
            EXTRUDER_SIMPLE,
            WIRES,
            MORTAR,
            BOUNCY,
            STRETCHY,
            FURNACE)
        .uumMcfg(0, MT.C, 20 * U, MT.H, 26 * U)
        .heat(708)
        .setBurning(MT.Ash, U9)
        .setSmelting(null, 2 * U3)
        .qual(1, 3.0, 256, 0);

    public static class STONES {

        public static final OreDictMaterial Alkalai = stone("Alkalai", 173, 52, 16, 255).qual(1, 5.0, 128, 1)
            .setGenerifying(ANY.Stone)
            .addSourceOf(MT.Be, MT.Mg, MT.Sr),
            Tungle = stone("Tungle", 46, 46, 46, 255).qual(1, 5.0, 128, 1)
                .setGenerifying(ANY.Stone)
                .addSourceOf(MT.C),
            Vita = stone("Vita", 115, 0, 0, 255).qual(1, 5.0, 128, 1)
                .setGenerifying(ANY.Stone)
                .addSourceOf(MT.Ti),
            Sulf = stone("Sulf", 20, 20, 20, 255).qual(1, 5.0, 128, 1)
                .setGenerifying(ANY.Stone)
                .addSourceOf(MT.Nq),
            Adam = stone("Adam", 125, 149, 173, 255).qual(1, 5.0, 128, 1)
                .setGenerifying(ANY.Stone);
    }

}
