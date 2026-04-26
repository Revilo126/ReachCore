package revilo.reach.loaders.a;

import static gregapi.data.CS.*;
import static revilo.reach.data.RCCS.*;

import gregapi.util.ST;
import revilo.reach.data.RCMD;
import revilo.reach.items.armour.ItemElectricArmor;

public class ToolsLoader implements Runnable {

    @Override
    public void run() {
        ArmorsRC.HAZMAT_ELECTRIC[0] = new ItemElectricArmor(
            RCMD.RC.mID,
            "rc.armor.hazmat.electric.head",
            "Modular Helmet (HV)",
            "Full set protects against (almost) all hazards.",
            "hazards_electric",
            0,
            V[3] * 100,
            1,
            new int[] { 1, 1, 1, 1 },
            0,
            "AAA",
            "AAA",
            "AAA",
            'A',
            ST.make(ArmorsGT.HAZMAT_BIOCHEMGAS[3], 1, 0));
        ArmorsRC.HAZMAT_ELECTRIC[1] = new ItemElectricArmor(
            RCMD.RC.mID,
            "rc.armor.hazmat.electric.chest",
            "Modular Chestplate (HV)",
            "Full set protects against (almost) all hazards.",
            "hazards_electric",
            0,
            V[3] * 100,
            1,
            new int[] { 1, 1, 1, 1 },
            0,
            "AAA",
            "AAA",
            "AAA",
            'A',
            ST.make(ArmorsGT.HAZMAT_BIOCHEMGAS[3], 1, 0));
        ArmorsRC.HAZMAT_ELECTRIC[2] = new ItemElectricArmor(
            RCMD.RC.mID,
            "rc.armor.hazmat.electric.legs",
            "Modular Leggings (HV)",
            "Full set protects against (almost) all hazards.",
            "hazards_electric",
            0,
            V[3] * 100,
            1,
            new int[] { 1, 1, 1, 1 },
            0,
            "AAA",
            "AAA",
            "AAA",
            'A',
            ST.make(ArmorsGT.HAZMAT_BIOCHEMGAS[3], 1, 0));
        ArmorsRC.HAZMAT_ELECTRIC[3] = new ItemElectricArmor(
            RCMD.RC.mID,
            "rc.armor.hazmat.electric.boots",
            "Modular Boots (HV)",
            "Full set protects against (almost) all hazards.",
            "hazards_electric",
            0,
            V[3] * 100,
            1,
            new int[] { 1, 1, 1, 1 },
            0,
            "AAA",
            "AAA",
            "AAA",
            'A',
            ST.make(ArmorsGT.HAZMAT_BIOCHEMGAS[3], 1, 0));
    }

}
