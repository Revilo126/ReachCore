package revilo.rcplanets;

import static gregapi.data.CS.*;

import cpw.mods.fml.common.Mod;
import revilo.reach.Tags;
import revilo.reach.api.data.CS;

/**
 * Responsible for planet world gen for WarpDrive
 */
@Mod(
    modid = CS.ModIds.RCPLANETS,
    version = Tags.VERSION,
    name = RCPlanets.MODNAME,
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "after:" + ModIDs.WARPDRIVE)
public class RCPlanets {

    public static final String dominiName = "Domini";

    public static final String MODNAME = "RC Planets";
}
