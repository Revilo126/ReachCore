package revilo.reach.api.data;

import java.util.Set;

import gregapi.code.BiomeNameSet;

/**
 * Constants
 */
public class CS {

    public static final Set<String> BIOMES_HOTDRYROCK = new BiomeNameSet("Hot Dry Rock"),
        BIOMES_MOONDARK = new BiomeNameSet("MoonDark"), BIOMES_MOONFULL = new BiomeNameSet("Moon", "MoonDark");
}
