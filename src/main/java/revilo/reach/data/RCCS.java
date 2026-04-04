package revilo.reach.data;

import java.util.Set;

import gregapi.code.BiomeNameSet;
import gregapi.item.multiitem.MultiItemRandom;

/**
 * Constants
 */
public class RCCS {

    // Alpha Centauri System
    public static final Set<String> GEN_PROXIMA_B = new BiomeNameSet(
        "proxima_b_beach",
        "proxima_b_forest",
        "proxima_b_ice_plains",
        "proxima_b_mountains",
        "proxima_b_ocean",
        "proxima_b_plains");

    // Bernards System
    public static final Set<String> GEN_BERNARDA_C = new BiomeNameSet("barnard_c_dunes");
    // GEN_BERNARDA_E = new BiomeNameSet("") // Can't find name

    // Solar System TODO
    // public static final Set<String> GEN_

    public static class Chat {

        public static String specialChar = "\u00a7";
    }

    public static class ModIds {

        public static final String REACH = "reach", BP = "Backpack", PerDim = "personalspace", AE2FC = "ae2fc";
    }

    public static class ItemsReach {

        public static MultiItemRandom TECH;
        public static MultiItemRandom[] ALL_MULTI_ITEMS = new MultiItemRandom[] { TECH };
    }
}
