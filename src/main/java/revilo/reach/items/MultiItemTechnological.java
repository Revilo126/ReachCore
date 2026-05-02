package revilo.reach.items;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.data.MT;
import gregapi.data.TC;
import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import revilo.reach.data.RCIL;

@SuppressWarnings("unused")
public class MultiItemTechnological extends MultiItemRandomWithCompat {

    public MultiItemTechnological(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "Reach: Technology", this, (short) 1000));
    }

    @Override
    public void addItems() {

        // Circuit Parts //

        /**
         * RCIL.Circuit_CPU_Basic.set(addItem(1000, "Circuit CPU (Basic)", "The brains of a T1 Circuit"));
         * RCIL.Circuit_CPU_Good.set(addItem(1001, "Circuit CPU (Good)", "The brains of a T2 Circuit"));
         * RCIL.Circuit_CPU_Advanced.set(addItem(1002, "Circuit CPU (Advanced)", "The brains of a T3 Circuit"));
         * RCIL.Circuit_CPU_Elite.set(addItem(1003, "Circuit CPU (Elite)", "The brains of a T4 Circuit"));
         * RCIL.Circuit_CPU_Master.set(addItem(1004, "Circuit CPU (Master)", "The brains of a T5 Circuit"));
         * RCIL.Circuit_CPU_Ultimate.set(addItem(1005, "Circuit CPU (Ultimate)", "The brains of a T6 Circuit"));
         * 
         * RCIL.Transistor_Basic.set(addItem(1010, "Transistor (Basic)", "The most basic T1 Circuit component."));
         * RCIL.Transistor_Basic.set(addItem(1011, "Transistor (Good)", "The most basic T2 Circuit component."));
         * RCIL.Transistor_Basic.set(addItem(1012, "Transistor (Advanced)", "The most basic T3 Circuit component."));
         * RCIL.Transistor_Basic.set(addItem(1013, "Transistor (Elite)", "The most basic T4 Circuit component."));
         * RCIL.Transistor_Basic.set(addItem(1014, "Transistor (Master)", "The most basic T5 Circuit component."));
         * RCIL.Transistor_Basic.set(addItem(1015, "Transistor (Ultimate)", "The most basic T6 Circuit component."));
         */ // TODO: Implement new circuit system!

        RCIL.Circuit_Nano.set(
            addItem(
                1000,
                "Circuit T7 (Nano)",
                "Computes simple Data extremely efficiently",
                MT.DATA.CIRCUITS[7],
                OD_CIRCUITS[7],
                TC.stack(TC.COGNITIO, 8)));
        RCIL.Circuit_Atomic.set(
            addItem(
                1001,
                "Circuit T8 (Atomic)",
                "Computes simple Data as fast as you type",
                MT.DATA.CIRCUITS[8],
                OD_CIRCUITS[8],
                TC.stack(TC.COGNITIO, 9)));
        RCIL.Circuit_Quantum_T1.set(
            addItem(
                1002,
                "Circuit T9 (Quantum T1)",
                "Computes simple Data with the power of a galaxy",
                MT.DATA.CIRCUITS[9],
                OD_CIRCUITS[9],
                TC.stack(TC.COGNITIO, 10)));

        // Tech Tools //

        // RCIL.Laptop_Tool.set(addItem(1100, "Laptop", "", new Behaviour_Laptop(), EnergyStat.makeTool(TD.Energy.EU,
        // V[5]*8000, V[5], 64, next())));
        // CR.shaped(RCIL.Laptop_Tool.get(1), CR.DEF_REV, "CSC", "NUE", "BUB", 'C', OD_CIRCUITS[5], 'S',
        // IL.Tool_Scanner.get(1), 'N', IL.SENSORS[5], 'U', OD_USB_STICKS[3], 'E', IL.EMITTERS[5], 'B',
        // IL.Battery_Alkaline_EV, 'U', OD_USB_CABLES[3]);
    }

}
