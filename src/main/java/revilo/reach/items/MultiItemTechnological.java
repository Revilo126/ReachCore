package revilo.reach.items;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import revilo.reach.api.data.RCIL;

@SuppressWarnings("unused")
public class MultiItemTechnological extends MultiItemRandomWithCompat {

    public MultiItemTechnological(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "Reach: Technology", this, (short) 23006));
    }

    @Override
    public void addItems() {
        RCIL.Circuit_CPU_Basic.set(addItem(1000, "Circuit CPU (Basic)", "The brains of a T1 Circuit"));
        RCIL.Circuit_CPU_Good.set(addItem(1001, "Circuit CPU (Good)", "The brains of a T2 Circuit"));
        RCIL.Circuit_CPU_Advanced.set(addItem(1002, "Circuit CPU (Advanced)", "The brains of a T3 Circuit"));
        RCIL.Circuit_CPU_Elite.set(addItem(1003, "Circuit CPU (Elite)", "The brains of a T4 Circuit"));
        RCIL.Circuit_CPU_Master.set(addItem(1004, "Circuit CPU (Master)", "The brains of a T5 Circuit"));
        RCIL.Circuit_CPU_Ultimate.set(addItem(1005, "Circuit CPU (Ultimate)", "The brains of a T6 Circuit"));

        RCIL.Transistor_Basic.set(addItem(1010, "Transistor (Basic)", "The most basic T1 Circuit component."));
        RCIL.Transistor_Basic.set(addItem(1011, "Transistor (Good)", "The most basic T2 Circuit component."));
        RCIL.Transistor_Basic.set(addItem(1012, "Transistor (Advanced)", "The most basic T3 Circuit component."));
        RCIL.Transistor_Basic.set(addItem(1013, "Transistor (Elite)", "The most basic T4 Circuit component."));
        RCIL.Transistor_Basic.set(addItem(1014, "Transistor (Master)", "The most basic T5 Circuit component."));
        RCIL.Transistor_Basic.set(addItem(1015, "Transistor (Ultimate)", "The most basic T6 Circuit component."));

        /*
         * for (OreDictMaterial tMat : ANY.Cu.mToThis) { // Recipes after fully implemented
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 9), dust .mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.Si , 9)), RCIL.Transistor_Basic .get(9));
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 9), dust .mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.Ge , 9)), RCIL.Transistor_Basic .get(9));
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 9), dust .mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.RedstoneAlloy, 9)), RCIL.Transistor_Basic .get(9));
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 1), dustTiny.mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.Si , 1)), RCIL.Transistor_Basic .get(1));
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 1), dustTiny.mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.Ge , 1)), RCIL.Transistor_Basic .get(1));
         * RM.Press.addRecipeX(T, F, F, F, T, 16, 16, ST.array(wireFine.mat(tMat , 1), dustTiny.mat(MT.Redstone, 1),
         * plateGemTiny.mat(MT.RedstoneAlloy, 1)), RCIL.Transistor_Basic .get(1));
         * }
         */
    }

}
