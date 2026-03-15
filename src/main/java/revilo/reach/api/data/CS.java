package revilo.reach.api.data;

import java.util.Set;

import gregapi.code.BiomeNameSet;
import gregapi.item.multiitem.MultiItemRandom;

/**
 * Constants
 */
public class CS {

    public static final Set<String> BIOMES_HOTDRYROCK = new BiomeNameSet("Hot Dry Rock"),
        BIOMES_MOONDARK = new BiomeNameSet("MoonDark"), BIOMES_MOONFULL = new BiomeNameSet("Moon", "MoonDark");

    public static class Chat {

        public static String specialChar = "\u00a7";
    }

    public static class ModIds {

        public static final String REACH = "reach";
        public static final String RCPLANETS = "rcplanets";
    }

    public static class ItemsReach {

        public static MultiItemRandom TECH;
        public static MultiItemRandom[] ALL_MULTI_ITEMS = new MultiItemRandom[] { TECH };
    }
}
