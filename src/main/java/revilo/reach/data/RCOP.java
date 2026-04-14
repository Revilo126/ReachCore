package revilo.reach.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Prefix.*;
import static gregapi.data.TD.Properties.*;

import gregapi.data.TC;
import gregapi.oredict.OreDictPrefix;

@SuppressWarnings("unused")
public class RCOP {

    private static OreDictPrefix create(String aName, String aCategory, String aPreMaterial, String aPostMaterial) {
        return OreDictPrefix.createPrefix(aName)
            .setCategoryName(aCategory)
            .setLocalPrefixName(aCategory)
            .setLocalItemName(aPreMaterial, aPostMaterial);
    }

    private static OreDictPrefix create(String aName, String aCategory) {
        return OreDictPrefix.createPrefix(aName)
            .setCategoryName(aCategory)
            .setLocalPrefixName(aCategory);
    }

    private static OreDictPrefix unused(String aName) {
        return OreDictPrefix.createPrefix(aName)
            .add(PREFIX_UNUSED);
    }

    public static final OreDictPrefix oreAlkalai = create("oreAlkalai", "Alkalai Ores", "Alkalai ", " Ore")
        .setOreStats(2 * U)
        .add(BLOCK_BASED, STANDARD_ORE)
        .aspects(TC.ALIENIS, 1)
        .setTextureSetName("ore"),
        oreTungle = create("oreTungle", "Tungle Ores", "Tungle ", " Ore").setOreStats(2 * U)
            .add(BLOCK_BASED, STANDARD_ORE)
            .aspects(TC.ALIENIS, 1)
            .setTextureSetName("ore"),
        oreVita = create("oreVita", "Vita Ores", "Vita ", " Ore").setOreStats(2 * U)
            .add(BLOCK_BASED, STANDARD_ORE)
            .aspects(TC.ALIENIS, 1)
            .setTextureSetName("ore"),
        oreSulf = create("oreSulf", "Sulf Ores", "Sulf ", " Ore").setOreStats(2 * U)
            .add(BLOCK_BASED, STANDARD_ORE)
            .aspects(TC.ALIENIS, 1)
            .setTextureSetName("ore"),
        oreAdam = create("oreAdam", "Adam Ores", "Adam ", " Ore").setOreStats(2 * U)
            .add(BLOCK_BASED, STANDARD_ORE)
            .aspects(TC.ALIENIS, 1)
            .setTextureSetName("ore");
}
