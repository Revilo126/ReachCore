package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.util.ST;

@SuppressWarnings("unused")
public class ScriptAE2 implements IScriptLoader {

    @Override
    public void loadRecipes() {
        ItemStack Controller = make(AE, "tile.BlockController", 1, 0), // Blocks
            Drive = make(AE, "tile.BlockDrive", 1, 0), CraftingUnit = make(AE, "tile.BlockCraftingUnit", 1, 0),
            CraftingUnit1 = make(AE, "tile.BlockCraftingUnit", 1, 1),
            CraftingUnit4 = make(MD.AE, "tile.BlockCraftingUnit", 1, 2),
            CraftingUnit16 = make(MD.AE, "tile.BlockCraftingUnit", 1, 3),
            CraftingUnit64 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 0),
            CraftingUnit256 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 1),
            CraftingUnit1024 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 2),
            CraftingUnit4096 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 3);

        shaped(
            Controller,
            DEF_REM_REV,
            "wSd",
            "ECE",
            "PSP",
            'S',
            screw.dat(MT.Ir),
            'C',
            casingMachine.dat(MT.Ir),
            'E',
            OD_CIRCUITS[6],
            'P',
            IL.Processor_Crystal_Emerald);
        shaped(
            Drive,
            DEF_REM_REV,
            "wLd",
            "PHE",
            "SCS",
            'S',
            screw.dat(MT.Ir),
            'C',
            casingMachine.dat(MT.Ir),
            'E',
            OD_CIRCUITS[6],
            'P',
            IL.Processor_Crystal_Emerald,
            'L',
            IL.EMITTERS[6],
            'H',
            ST.make(AE, "item.ItemMultiMaterial", 1, 39));

        shaped(
            CraftingUnit,
            DEF_REM_REV,
            "w d",
            "FCF",
            "SES",
            'C',
            casingMachine.dat(MT.Ir),
            'F',
            ST.make(AE, "item.ItemMultiPart", 1, 16),
            'E',
            OD_CIRCUITS[6],
            'S',
            screw.dat(MT.Ir));
        shaped(
            CraftingUnit1,
            DEF_REM_REV,
            "UP",
            "wd",
            'U',
            CraftingUnit,
            'P',
            ST.make(MD.GT, "gt.multitileentity", 1, 18203));
        shaped(
            CraftingUnit4,
            DEF_REM_REV,
            "QNQ",
            "NON",
            "QNQ",
            'Q',
            CraftingUnit1,
            'N',
            OD_CIRCUITS[6],
            'O',
            casingMachine.dat(MT.Ir));
        shaped(
            CraftingUnit16,
            DEF_REM_REV,
            "QNQ",
            "NON",
            "QNQ",
            'Q',
            CraftingUnit4,
            'N',
            OD_CIRCUITS[6],
            'O',
            casingMachine.dat(MT.Ir));
        shaped(
            CraftingUnit64,
            DEF_REM_REV,
            "QNQ",
            "NON",
            "QNQ",
            'Q',
            CraftingUnit16,
            'N',
            OD_CIRCUITS[7],
            'O',
            casingMachine.dat(MT.Os));
        shaped(
            CraftingUnit256,
            DEF_REM_REV,
            "QNQ",
            "NTN",
            "QNQ",
            'Q',
            CraftingUnit64,
            'N',
            OD_CIRCUITS[8],
            'T',
            casingMachine.dat(MT.Trinitanium));
        shaped(
            CraftingUnit1024,
            DEF_REM_REV,
            "QNQ",
            "NTN",
            "QNQ",
            'Q',
            CraftingUnit256,
            'N',
            OD_CIRCUITS[8],
            'T',
            casingMachine.dat(MT.Trinitanium));
        shaped(
            CraftingUnit4096,
            DEF_REM_REV,
            "QNQ",
            "NTN",
            "QNQ",
            'Q',
            CraftingUnit1024,
            'N',
            OD_CIRCUITS[9],
            'T',
            casingMachine.dat(MT.Trinaquadalloy));

    }

    @Override
    public String getScriptName() {
        return "Applied Energistics 2 Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.AE);
    }

}
