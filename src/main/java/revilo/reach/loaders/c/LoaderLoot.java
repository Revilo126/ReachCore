package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import gregapi.data.CS.ConfigsGT;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.util.ST;
import gregapi.util.UT;
import revilo.reach.loaders.helper.Loader;

@Loader.Init(priority = 1)
public class LoaderLoot implements Runnable {

    @Override
    public void run() {
        String Steam = "reach.steam";
        ST.LOOT_TABLES.add(Steam);
        ChestGenHooks.getInfo(Steam)
            .setMin(8);
        ChestGenHooks.getInfo(Steam)
            .setMax(24);
        // TODO

        String LV = "reach.lv";
        ST.LOOT_TABLES.add(LV);
        ChestGenHooks.getInfo(LV)
            .setMin(8);
        ChestGenHooks.getInfo(LV)
            .setMax(24);
        addLoot(LV, 144, 1, 2, IL.Electric_Motor_LV.get(1));
        addLoot(LV, 144, 1, 2, IL.Electric_Pump_LV.get(1));
        addLoot(LV, 144, 1, 1, IL.Circuit_Basic.get(1));
        addLoot(LV, 144, 1, 1, OP.casingMachine.mat(MT.SteelGalvanized, 1));

        addLoot(LV, 144, 2, 6, IL.Battery_Alkaline_Cell_Empty.get(1));
    }

    public static boolean addLoot(String aType, WeightedRandomChestContent aLoot) {
        if (ST.invalid(aLoot.theItemId) || UT.Code.stringInvalid(aType)) {
            ERR.println("Failed to add Loot: " + aLoot.theItemId + " to " + aType);
            return F;
        }
        ChestGenHooks.addItem(aType, aLoot);
        return T;
    }

    public static boolean addLoot(String aType, int aChance, int aMin, int aMax, ItemStack aLoot) {
        return addLoot(aType, aChance, aMin, aMax, aLoot, T);
    }

    public static boolean addLoot(String aType, int aChance, int aMin, int aMax, ItemStack aLoot, boolean aLogMissing) {
        if (ST.invalid(aLoot) || aMin <= 0 || aMax <= 0 || UT.Code.stringInvalid(aType)) {
            if (aLogMissing) ERR.println("Failed to add Loot: " + aLoot + " to " + aType);
            return F;
        }
        if (ConfigsGT.WORLDGEN.get("loot." + aType, aLoot, T)) {
            ChestGenHooks.addItem(
                aType,
                new WeightedRandomChestContent(
                    ST.copy(aLoot),
                    Math.min(aMin, aLoot.getMaxStackSize()),
                    Math.min(aMax, aLoot.getMaxStackSize()),
                    aChance));
        }
        return T;
    }

}
