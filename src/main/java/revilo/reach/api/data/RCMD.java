package revilo.reach.api.data;

import gregapi.code.ModData;

/**
 * Reach Mod Data
 */
public class RCMD {

    public static final ModData RC = new ModData(CS.ModIds.REACH, "Reach");
    public static final ModData BP = new ModData("Backpack", "Backpack Edited for ModdedNetwork");
    public static final ModData PerDim = new ModData("personalspace", "Personal Space");

    public static final ModData WD = new ModData("WarpDrive", "Warp Drive"); // GT6's implementation's modid is
                                                                             // warpdrivecore not warpdrive. TODO: Tell
                                                                             // greg
}
