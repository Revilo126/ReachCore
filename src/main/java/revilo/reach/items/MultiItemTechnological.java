package revilo.reach.items;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.data.ANY;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.data.TC;
import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import gregapi.oredict.OreDictItemData;
import gregapi.util.ST;
import revilo.reach.api.data.RCIL;

@SuppressWarnings("unused")
public class MultiItemTechnological extends MultiItemRandomWithCompat {

    public MultiItemTechnological(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "Reach: Technology", this, (short) 1000));
    }

    @Override
    public void addItems() {
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

        RCIL.Circuit_Wiring_Nano.set(
            addItem(
                850,
                "Circuit Wiring (Naquadah)",
                "Needs to be placed on an empty Circuit Plate",
                new OreDictItemData(MT.Nq, U)));
        RCIL.Circuit_Plate_Nano.set(
            addItem(
                851,
                "Circuit Plate (Naquadah)",
                "Needs Circuit Parts",
                new OreDictItemData(MT.Nq, U, ANY.SiO2, U, ANY.Plastic, U)));

        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            IL.Circuit_Plate_Empty.get(1),
            RCIL.Circuit_Wiring_Nano.get(1),
            RCIL.Circuit_Plate_Nano.get(1));

        RCIL.Circuit_Part_Nano.set(
            addItem(
                900,
                "Circuit Part (Nano)",
                "Needs to be placed on a Naquadah Circuit Plate",
                TC.stack(TC.COGNITIO, 1)));
        RCIL.Circuit_Part_Atomic.set(
            addItem(
                901,
                "Circuit Part (Atomic)",
                "Needs to be placed on a Naquadah Circuit Plate",
                TC.stack(TC.COGNITIO, 1)));

        RM.Press.addRecipeX(
            T,
            F,
            F,
            F,
            T,
            16,
            16,
            ST.array(
                OP.wireFine.mat(MT.Nq, 1),
                OP.wireFine.mat(MT.Signalum, 1),
                OP.plateGemTiny.mat(MT.RedstoneAlloy, 1)),
            RCIL.Circuit_Part_Nano.get(1));

        RM.Press.addRecipeX(
            T,
            F,
            F,
            F,
            T,
            16,
            16,
            ST.array(
                OP.wireFine.mat(MT.Nq_528, 1),
                OP.wireFine.mat(MT.Signalum, 1),
                OP.plateGemTiny.mat(MT.RedstoneAlloy, 1)),
            RCIL.Circuit_Part_Atomic.get(1));

        RCIL.Circuit_Board_Nano
            .set(addItem(950, "Circuit Board (Nano)", "Needs to be soldered properly", TC.stack(TC.FABRICO, 1)));
        RCIL.Circuit_Board_Atomic
            .set(addItem(951, "Circuit Board (Atomic)", "Needs to be soldered properly", TC.stack(TC.FABRICO, 1)));

        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Basic.get(4),
            IL.Circuit_Board_Basic.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Good.get(4),
            IL.Circuit_Board_Good.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Advanced.get(4),
            IL.Circuit_Board_Advanced.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Elite.get(4),
            IL.Circuit_Board_Elite.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Master.get(4),
            IL.Circuit_Board_Master.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            IL.Circuit_Part_Ultimate.get(4),
            IL.Circuit_Board_Ultimate.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            RCIL.Circuit_Part_Nano.get(4),
            RCIL.Circuit_Board_Nano.get(1));
        RM.Press.addRecipe2(
            T,
            F,
            F,
            F,
            T,
            16,
            64,
            RCIL.Circuit_Plate_Nano.get(1),
            RCIL.Circuit_Part_Atomic.get(4),
            RCIL.Circuit_Board_Atomic.get(1));

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

        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Nano.get(1),
            MT.Pb.liquid(U2, T),
            NF,
            IL.Circuit_Master.get(1));
        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Nano.get(1),
            MT.Sn.liquid(U2, T),
            NF,
            IL.Circuit_Ultimate.get(1));
        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Nano.get(1),
            MT.SolderingAlloy.liquid(U2, T),
            NF,
            RCIL.Circuit_Nano.get(1));

        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Atomic.get(1),
            MT.Pb.liquid(U2, T),
            NF,
            IL.Circuit_Ultimate.get(1));
        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Atomic.get(1),
            MT.Sn.liquid(U2, T),
            NF,
            RCIL.Circuit_Nano.get(1));
        RM.Bath.addRecipe1(
            T,
            F,
            F,
            F,
            T,
            0,
            64,
            RCIL.Circuit_Board_Atomic.get(1),
            MT.SolderingAlloy.liquid(U2, T),
            NF,
            RCIL.Circuit_Atomic.get(1));
    }

}
