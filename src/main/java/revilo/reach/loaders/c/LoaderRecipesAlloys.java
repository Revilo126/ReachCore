package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.ANY;
import gregapi.data.FL;
import gregapi.data.RM;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.ST;

public class LoaderRecipesAlloys implements Runnable {

    @Override
    public void run() {
        for (OreDictMaterial tMat : ANY.Iron.mToThis) {
            mix("molten." + tMat.mNameInternal.toLowerCase(), 3, "molten.aluminium", 1, "molten.thermite", 4); // yes
                                                                                                               // molten
                                                                                                               // thermite.
                                                                                                               // TODO:
                                                                                                               // Remove
        }

        mix("molten.ununennium", 1, "molten.adamantium", 1, "molten.adamennium", 1);
    }

    private static void mix(String aInput1, int aIn1Amount, String aInput2, int aIn2Amount, String aOutput,
        int aOutAmount) {
        RM.Mixer.addRecipe1(
            T,
            16,
            Math.max(aOutAmount, aIn1Amount + aIn2Amount),
            ST.tag(2),
            FL.array(FL.make_(aInput1, aIn1Amount), FL.make_(aInput2, aIn2Amount)),
            FL.make_(aOutput, aOutAmount),
            ZL_IS);
    }

    @SuppressWarnings("unused")
    private static void mix(String aInput1, int aIn1Amount, String aInput2, int aIn2Amount, String aInput3,
        int aIn3Amount, String aOutput, int aOutAmount) {
        RM.Mixer.addRecipe1(
            T,
            16,
            Math.max(aOutAmount, aIn1Amount + aIn2Amount + aIn3Amount),
            ST.tag(3),
            FL.array(FL.make_(aInput1, aIn1Amount), FL.make_(aInput2, aIn2Amount), FL.make_(aInput3, aIn3Amount)),
            FL.make_(aOutput, aOutAmount),
            ZL_IS);
    }

    @SuppressWarnings("unused")
    private static void mix(String aInput1, int aIn1Amount, String aInput2, int aIn2Amount, String aInput3,
        int aIn3Amount, String aInput4, int aIn4Amount, String aOutput, int aOutAmount) {
        RM.Mixer.addRecipe1(
            T,
            16,
            Math.max(aOutAmount, aIn1Amount + aIn2Amount + aIn3Amount + aIn4Amount),
            ST.tag(4),
            FL.array(
                FL.make_(aInput1, aIn1Amount),
                FL.make_(aInput2, aIn2Amount),
                FL.make_(aInput3, aIn3Amount),
                FL.make_(aInput4, aIn4Amount)),
            FL.make_(aOutput, aOutAmount),
            ZL_IS);
    }

}
