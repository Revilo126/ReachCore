package revilo.reach.loaders.c;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static revilo.reach.data.RCRM.*;

import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.oredict.event.IOreDictListenerEvent;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.util.ST;
import revilo.reach.data.RCIL;
import revilo.reach.data.RCMT;
import revilo.reach.loaders.helper.Loader;

@Loader.Init(priority = 1)
public class LoaderRecipesSemiconductors implements Runnable {

    /*
     * Semiconductor (Circuit Parts) recipes will go as follows:
     * Circuit parts and boards will no longer be compatible to all. (Will keep higher tier circuits usable for lower
     * one uses)
     * Tier 1 and 2: The same as base GT6 with some tweaks and complexity.
     * Plastic board as base.
     * Transistors done by hand and with Germanium, silicon can be used for tier 2 however requires engraver.
     * Wiring is the same.
     * Tier 3 and 4:
     * Lithography machine required for this tier.
     * Basic Silicon wafer as Base (Will tweak crystalline silicon to be harder).
     * Transitors built into base.
     * Traced using injector and gold. (No wiring).
     * Tier 5 and 6:
     * Requires EUV Lithography multiblock. (Complex machine)
     * Need Purified Silicon Wafer (Complex preparation)
     */

    @Override
    public void run() {

        // Wafers
        Mixer.addRecipe1(T, 64, 512, plateGem.mat(MT.Si, 1), MT.HF.gas(1 * U, T), NF, RCIL.Crude_Silicon_Wafer.get(1));
        Mixer.addRecipe1(
            T,
            1024,
            1024,
            RCIL.Crude_Silicon_Wafer.get(1),
            MT.HCl.gas(4 * U, T),
            NF,
            RCIL.Polished_Silicon_Wafer.get(1));

        // In-Diffusion (HV-EV)
        BurnMixer.addRecipe1(
            T,
            64,
            256,
            RCIL.Crude_Silicon_Wafer.get(1),
            RCMT.POCL3.liquid(1 * U9, T),
            NF,
            RCIL.Crude_Silicon_Wafer_ID_Doped.get(1));
        BurnMixer.addRecipe1(
            T,
            256,
            128,
            RCIL.Crude_Silicon_Wafer.get(1),
            RCMT.POCL3.liquid(1 * U9, T),
            NF,
            RCIL.Crude_Silicon_Wafer_II_Doped.get(1));

        // Ion Implantation (IV-LuV)
        Injector.addRecipe1(
            T,
            1024,
            256,
            RCIL.Polished_Silicon_Wafer.get(1),
            RCMT.POCL3.liquid(1 * U9, T),
            NF,
            RCIL.Polished_Silicon_Wafer_ID_Doped.get(1));
        Injector.addRecipe1(
            T,
            4096,
            128,
            RCIL.Polished_Silicon_Wafer.get(1),
            RCMT.POCL3.liquid(1 * U9, T),
            NF,
            RCIL.Polished_Silicon_Wafer_II_Doped.get(1));

        // Lithography HV-EV-IV-LuV
        new OreDictListenerEvent_Names() {

            @Override
            public void addAllListeners() {
                addListener(DYE_OREDICTS_LENS[DYE_INDEX_Red], new IOreDictListenerEvent() {

                    @Override
                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
                        Lithography.addRecipe2(
                            T,
                            64,
                            1024,
                            RCIL.Crude_Silicon_Wafer_ID_Doped.get(1),
                            ST.amount(0, aEvent.mStack),
                            RCIL.HV_Silicon_Wafer_Printed.get(1));
                        Lithography.addRecipe2(
                            T,
                            256,
                            1024,
                            RCIL.Crude_Silicon_Wafer_II_Doped.get(1),
                            ST.amount(0, aEvent.mStack),
                            RCIL.EV_Silicon_Wafer_Printed.get(1));
                        Lithography.addRecipe2(
                            T,
                            1024,
                            1024,
                            RCIL.Polished_Silicon_Wafer_ID_Doped.get(1),
                            ST.amount(0, aEvent.mStack),
                            RCIL.IV_Silicon_Wafer_Printed.get(1));
                        Lithography.addRecipe2(
                            T,
                            4096,
                            1024,
                            RCIL.Polished_Silicon_Wafer_II_Doped.get(1),
                            ST.amount(0, aEvent.mStack),
                            RCIL.LuV_Silicon_Wafer_Printed.get(1));
                    }
                });
            }
        };

        // Trace
        Injector.addRecipe1(
            T,
            64,
            128,
            RCIL.HV_Silicon_Wafer_Printed.get(1),
            MT.Au.liquid(2 * U, T),
            NF,
            RCIL.HV_Silicon_Wafer_Traced.get(1));
        Injector.addRecipe1(
            T,
            256,
            128,
            RCIL.EV_Silicon_Wafer_Printed.get(1),
            MT.Au.liquid(2 * U, T),
            NF,
            RCIL.EV_Silicon_Wafer_Traced.get(1));
        Injector.addRecipe1(
            T,
            1024,
            128,
            RCIL.IV_Silicon_Wafer_Printed.get(1),
            MT.Au.liquid(2 * U, T),
            NF,
            RCIL.IV_Silicon_Wafer_Traced.get(1));
        Injector.addRecipe1(
            T,
            4096,
            128,
            RCIL.LuV_Silicon_Wafer_Printed.get(1),
            MT.Au.liquid(2 * U, T),
            NF,
            RCIL.LuV_Silicon_Wafer_Traced.get(1));

        // Chips
        Cutter.addRecipe1(T, 16, 128, RCIL.HV_Silicon_Wafer_Traced.get(1), FL.Water.make(U), NF, RCIL.HV_Chip.get(12));
        Cutter.addRecipe1(T, 16, 128, RCIL.EV_Silicon_Wafer_Traced.get(1), FL.Water.make(U), NF, RCIL.EV_Chip.get(12));
        Cutter.addRecipe1(T, 16, 128, RCIL.IV_Silicon_Wafer_Traced.get(1), FL.Water.make(U), NF, RCIL.IV_Chip.get(12));
        Cutter
            .addRecipe1(T, 16, 128, RCIL.LuV_Silicon_Wafer_Traced.get(1), FL.Water.make(U), NF, RCIL.LuV_Chip.get(12));

        // Circuit Parts
        Press.addRecipeX(
            T,
            16,
            64,
            ST.array(RCIL.HV_Chip.get(1), wireFine.mat(MT.Au, 1), plateTiny.mat(MT.Si, 1)),
            IL.Circuit_Part_Advanced.get(1));
        Press.addRecipeX(
            T,
            16,
            64,
            ST.array(RCIL.EV_Chip.get(1), wireFine.mat(MT.Au, 1), plateTiny.mat(MT.Si, 1)),
            IL.Circuit_Part_Elite.get(1));
        Press.addRecipeX(
            T,
            16,
            64,
            ST.array(RCIL.IV_Chip.get(1), wireFine.mat(MT.Pt, 1), plateTiny.mat(MT.Si, 1)),
            IL.Circuit_Part_Master.get(1));
        Press.addRecipeX(
            T,
            16,
            64,
            ST.array(RCIL.LuV_Chip.get(1), wireFine.mat(MT.Pt, 1), plateTiny.mat(MT.Si, 1)),
            IL.Circuit_Part_Ultimate.get(1));

        // Circuit Plates (Bath in solder can stay for now)
        Welder.addRecipe2(
            T,
            16,
            128,
            IL.Circuit_Plate_Gold.get(1),
            IL.Circuit_Part_Advanced.get(4),
            IL.Circuit_Board_Advanced.get(1));
        Welder.addRecipe2(
            T,
            16,
            128,
            IL.Circuit_Plate_Gold.get(1),
            IL.Circuit_Part_Elite.get(4),
            IL.Circuit_Board_Elite.get(1));
        Welder.addRecipe2(
            T,
            16,
            128,
            IL.Circuit_Plate_Platinum.get(1),
            IL.Circuit_Part_Master.get(4),
            IL.Circuit_Board_Master.get(1));
        Welder.addRecipe2(
            T,
            16,
            128,
            IL.Circuit_Plate_Platinum.get(1),
            IL.Circuit_Part_Ultimate.get(4),
            IL.Circuit_Board_Ultimate.get(1));
    }

}
