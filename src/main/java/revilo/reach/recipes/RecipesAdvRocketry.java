package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import net.minecraft.item.ItemStack;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.MT;
import gregapi.util.ST;

@SuppressWarnings("unused")
public class RecipesAdvRocketry implements Runnable {

    private static ItemStack itemAR(String aItem) {
        return itemAR(aItem, 1, 0);
    }

    private static ItemStack itemAR(String aItem, long aAmount, long aMeta) {
        return ST.make(GC_ADV_ROCKETRY, aItem, aAmount, aMeta);
    }

    ArrayListNoNulls<ItemStack> toRemove = new ArrayListNoNulls<>(
        F,
        itemAR("tile.solarPanel"),
        itemAR("tile.solarGenerator"));

    @Override
    public void run() {
        for (ItemStack i : toRemove) {
            delate(i);
            hide(i);
        }

        shaped(
            itemAR("rocketBuilder"),
            DEF_REM_REV,
            "RUR",
            "CAC",
            "GwG",
            'R',
            rod.dat(MT.Al),
            'U',
            rod.dat(MT.Al), // put user interface
            'C',
            OD_CIRCUITS[2],
            'A',
            casingMachine.dat(MT.Al),
            'G',
            gearGtSmall.dat(MT.Al));
        shaped(
            itemAR("rocketBuilder"),
            DEF_REM_REV,
            "RUR",
            "CAC",
            "GwG",
            'R',
            rod.dat(MT.Cr),
            'U',
            rod.dat(MT.Al), // put user interface
            'C',
            OD_CIRCUITS[4],
            'A',
            casingMachine.dat(MT.Cr),
            'G',
            gearGtSmall.dat(MT.Cr));

    }

}
