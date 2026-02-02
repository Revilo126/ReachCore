package revilo.reach.oredict;

import static gregapi.util.ST.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import gregapi.code.ModData;

public class OreDictUnification implements Runnable {

    @Override
    public void run() {
        // TODO: Advanced Rocketry

        // TODO: Matter Overdrive
    }

    public static void removeEntry(String aOreDict, ModData aModData, String aItem) {
        removeEntry(aOreDict, aModData, aItem, 0);
    }

    public static void removeEntry(String aOreDict, ModData aModData, String aItem, long aMeta) {
        removeEntry(aOreDict, make(aModData, aItem, 1, aMeta));
    }

    public static void removeEntry(String aOreDict, ItemStack aItem) {
        OreDictionary.getOres(aOreDict)
            .remove(aItem);
    }

}
