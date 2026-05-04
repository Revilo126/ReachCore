package revilo.reach.items;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.data.MT;
import gregapi.data.TC;
import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
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

        RCIL.Crude_Silicon_Wafer
            .set(addItem(850, "Crude Silicon Wafer", "Must be doped", new OreDictItemData(MT.Si, U)));
        RCIL.Polished_Silicon_Wafer
            .set(addItem(851, "Polished Silicon Wafer", "Must be doped", new OreDictItemData(MT.Si, U)));

        RCIL.Crude_Silicon_Wafer_ID_Doped.set(
            addItem(
                860,
                "Crude Phosphorus Ion-Diffusion Doped Wafer",
                "Must be Etched",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.Crude_Silicon_Wafer_II_Doped.set(
            addItem(
                861,
                "Crude Phosphorus Ion-Implantation Doped Wafer",
                "Must be Etched",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.Polished_Silicon_Wafer_ID_Doped.set(
            addItem(
                862,
                "Polished Phosphorus Ion-Diffusion Doped Wafer",
                "Must be Etched",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.Polished_Silicon_Wafer_II_Doped.set(
            addItem(
                863,
                "Polished Phosphorus Ion-Implantation Doped Wafer",
                "Must be Etched",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));

        RCIL.HV_Silicon_Wafer_Printed.set(
            addItem(
                870,
                "Printed Silicon Wafer (HV)",
                "To be traced",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.EV_Silicon_Wafer_Printed.set(
            addItem(
                871,
                "Printed Silicon Wafer (EV)",
                "To be traced",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.IV_Silicon_Wafer_Printed.set(
            addItem(
                872,
                "Printed Silicon Wafer (IV)",
                "To be traced",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.LuV_Silicon_Wafer_Printed.set(
            addItem(
                873,
                "Printed Silicon Wafer (LuV)",
                "To be traced",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));

        RCIL.HV_Silicon_Wafer_Traced.set(
            addItem(
                880,
                "Traced Silicon Wafer (HV)",
                "Needs to be cut",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.EV_Silicon_Wafer_Traced.set(
            addItem(
                881,
                "Traced Silicon Wafer (EV)",
                "Needs to be cut",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.IV_Silicon_Wafer_Traced.set(
            addItem(
                882,
                "Traced Silicon Wafer (IV)",
                "Needs to be cut",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));
        RCIL.LuV_Silicon_Wafer_Traced.set(
            addItem(
                883,
                "Traced Silicon Wafer (LuV)",
                "Needs to be cut",
                new OreDictItemData(OM.stack(MT.Si, U), OM.stack(MT.P, U9))));

        RCIL.HV_Chip.set(addItem(890, "HV Chip", "To be encased", new OreDictItemData(OM.stack(MT.Si, U9))));
        RCIL.EV_Chip.set(addItem(891, "EV Chip", "To be encased", new OreDictItemData(OM.stack(MT.Si, U9))));
        RCIL.IV_Chip.set(addItem(892, "IV Chip", "To be encased", new OreDictItemData(OM.stack(MT.Si, U9))));
        RCIL.LuV_Chip.set(addItem(893, "LuV Chip", "To be encased", new OreDictItemData(OM.stack(MT.Si, U9))));

        // Tech Tools //

        // RCIL.Laptop_Tool.set(addItem(1100, "Laptop", "", new Behaviour_Laptop(), EnergyStat.makeTool(TD.Energy.EU,
        // V[5]*8000, V[5], 64, next())));
        // CR.shaped(RCIL.Laptop_Tool.get(1), CR.DEF_REV, "CSC", "NUE", "BUB", 'C', OD_CIRCUITS[5], 'S',
        // IL.Tool_Scanner.get(1), 'N', IL.SENSORS[5], 'U', OD_USB_STICKS[3], 'E', IL.EMITTERS[5], 'B',
        // IL.Battery_Alkaline_EV, 'U', OD_USB_CABLES[3]);
    }

}
