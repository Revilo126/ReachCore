package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.MD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregapi.data.ANY;
import gregapi.data.CS.ModIDs;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
import gregapi.util.ST;

public class ScriptAE2 implements IScriptLoader {

    ItemStack Controller = make(AE, "tile.BlockController", 1, 0), Drive = make(AE, "tile.BlockDrive", 1, 0),

        CraftingUnit = make(AE, "tile.BlockCraftingUnit", 1, 0),
        CraftingUnit1 = make(AE, "tile.BlockCraftingUnit", 1, 1),
        CraftingUnit4 = make(MD.AE, "tile.BlockCraftingUnit", 1, 2),
        CraftingUnit16 = make(MD.AE, "tile.BlockCraftingUnit", 1, 3),
        CraftingUnit64 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 0),
        CraftingUnit256 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 1),
        CraftingUnit1024 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 2),
        CraftingUnit4096 = make(MD.AE, "tile.BlockAdvancedCraftingUnit", 1, 3),

        CraftingStorage1 = make(MD.AE, "tile.BlockCraftingStorage", 1, 0),
        CraftingStorage4 = make(MD.AE, "tile.BlockCraftingStorage", 1, 1),
        CraftingStorage16 = make(MD.AE, "tile.BlockCraftingStorage", 1, 2),
        CraftingStorage64 = make(MD.AE, "tile.BlockCraftingStorage", 1, 3),
        CraftingStorage256 = make(MD.AE, "tile.BlockAdvancedCraftingStorage", 1, 0),
        CraftingStorage1024 = make(MD.AE, "tile.BlockAdvancedCraftingStorage", 1, 1),
        CraftingStorage4096 = make(MD.AE, "tile.BlockAdvancedCraftingStorage", 1, 2),
        CraftingStorage16384 = make(MD.AE, "tile.BlockAdvancedCraftingStorage", 1, 3),
        CraftingStorageSingularity = make(MD.AE, "tile.BlockSingularityCraftingStorage", 1, 0),

        Storage1 = make(MD.AE, "item.ItemMultiMaterial", 1, 35),
        Storage4 = make(MD.AE, "item.ItemMultiMaterial", 1, 36),
        Storage16 = make(MD.AE, "item.ItemMultiMaterial", 1, 37),
        Storage64 = make(MD.AE, "item.ItemMultiMaterial", 1, 38),
        Storage256 = make(MD.AE, "item.ItemMultiMaterial", 1, 57),
        Storage1024 = make(MD.AE, "item.ItemMultiMaterial", 1, 58),
        Storage4096 = make(MD.AE, "item.ItemMultiMaterial", 1, 59),
        Storage16384 = make(MD.AE, "item.ItemMultiMaterial", 1, 60),

        BrightPanel = make(MD.AE, "item.ItemMultiPart", 1, 160),
        IlluminatedPanel = make(MD.AE, "item.ItemMultiPart", 1, 180),
        DarkPanel = make(MD.AE, "item.ItemMultiPart", 1, 200),

        StorageHousing = make(MD.AE, "item.ItemMultiMaterial", 1, 39),
        AdvStorageHousing = make(MD.AE, "item.ItemMultiMaterial", 1, 61),

        QuartzFiber = make(MD.AE, "item.ItemMultiPart", 1, 140), FluixCable = make(MD.AE, "item.ItemMultiPart", 1, 16),
        FluixCoveredCable = make(MD.AE, "item.ItemMultiPart", 1, 36),
        FluixDenseCoveredCable = make(MD.AE, "item.ItemMultiPart", 1, 536),
        FluixSmartCable = make(MD.AE, "item.ItemMultiPart", 1, 56),
        FluixDenseSmartCable = make(MD.AE, "item.ItemMultiPart", 1, 76),

        BasicCard = make(MD.AE, "item.ItemMultiMaterial", 1, 25),
        RedstoneCard = make(MD.AE, "item.ItemMultiMaterial", 1, 26),
        CapacityCard = make(MD.AE, "item.ItemMultiMaterial", 1, 27),
        CraftingCard = make(MD.AE, "item.ItemMultiMaterial", 1, 53),
        StickyCard = make(MD.AE, "item.ItemMultiMaterial", 1, 64),
        VoidCard = make(MD.AE, "item.ItemMultiMaterial", 1, 68),

        AdvCard = make(MD.AE, "item.ItemMultiMaterial", 1, 28),
        FuzzyCard = make(MD.AE, "item.ItemMultiMaterial", 1, 29),
        AccelCard = make(MD.AE, "item.ItemMultiMaterial", 1, 30),
        InverterCard = make(MD.AE, "item.ItemMultiMaterial", 1, 31);

    @Override
    public void loadRecipes() {
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
            StorageHousing);

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

        shaped(CraftingStorage1, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage1);
        shaped(CraftingStorage4, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage4);
        shaped(CraftingStorage16, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage16);
        shaped(CraftingStorage64, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage64);
        shaped(CraftingStorage256, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage256);
        shaped(CraftingStorage1024, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage1024);
        shaped(CraftingStorage4096, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage4096);
        shaped(CraftingStorage16384, DEF_REM_REV, "US", "wd", 'U', CraftingUnit, 'S', Storage16384);

        shaped(
            Storage1,
            DEF_REM_REV,
            "TNT",
            "CPC",
            "TNT",
            'T',
            plate.mat(MT.Ti, 1),
            'N',
            plateTiny.mat(MT.NiobiumTitanium, 1),
            'C',
            OD_CIRCUITS[5],
            'P',
            make(MD.AE, "item.ItemMultiMaterial", 1, 10));
        shaped(
            Storage4,
            DEF_REM_REV,
            "NCN",
            "SPS",
            "NSN",
            'N',
            plateTiny.mat(MT.NiobiumTitanium, 1),
            'C',
            OD_CIRCUITS[5],
            'S',
            Storage1,
            'P',
            make(MD.AE, "item.ItemMultiMaterial", 1, 10));
        shaped(
            Storage16,
            DEF_REM_REV,
            "NCN",
            "SPS",
            "NSN",
            'N',
            plateTiny.mat(MT.Ir, 1),
            'C',
            OD_CIRCUITS[6],
            'S',
            Storage4,
            'P',
            IL.Processor_Crystal_Emerald.get(1));
        shaped(
            Storage64,
            DEF_REM_REV,
            "NCN",
            "SPS",
            "NSN",
            'N',
            plateTiny.mat(MT.Ir, 1),
            'C',
            OD_CIRCUITS[6],
            'S',
            Storage16,
            'P',
            IL.Processor_Crystal_Emerald.get(1));

        shapeless(BrightPanel, array(IlluminatedPanel, make(Items.glowstone_dust, 1, 0)));
        shapeless(DarkPanel, array(IlluminatedPanel, dust.mat(MT.OREMATS.Magnetite, 1)));
        shaped(
            IlluminatedPanel,
            DEF_REM_REV,
            " G ",
            "CLC",
            "TPT",
            'G',
            make(Items.glowstone_dust, 1, 0),
            'C',
            OD_CIRCUITS[6],
            'L',
            lens.mat(MT.PurpleSapphire, 1),
            'T',
            plate.mat(MT.Ti, 1));
        shapeless(IlluminatedPanel, array(BrightPanel));
        shapeless(IlluminatedPanel, array(DarkPanel));

        shaped(
            StorageHousing,
            DEF_REM_REV,
            "dNh",
            "TCT",
            'N',
            plateTiny.mat(MT.NiobiumTitanium, 1),
            'T',
            plate.mat(MT.Ti, 1),
            'C',
            OD_CIRCUITS[5]);

        shaped(
            AdvStorageHousing,
            DEF_REM_REV,
            "dNh",
            "TCT",
            'N',
            plateTiny.mat(MT.Ir, 1),
            'T',
            plate.mat(MT.Os, 1),
            'C',
            OD_CIRCUITS[7]);

        shaped(
            FluixSmartCable,
            DEF_REM_REV,
            "FMF",
            "RCR",
            "FMF",
            'F',
            wireFine.mat(MT.RedAlloy, 1),
            'M',
            OD_CIRCUITS[5],
            'R',
            dust.mat(MT.CertusQuartz, 1),
            'C',
            FluixCoveredCable);
        shaped(
            FluixDenseSmartCable,
            DEF_REM_REV,
            "FMF",
            "RCR",
            "FMF",
            'F',
            wireFine.mat(MT.RedAlloy, 1),
            'M',
            OD_CIRCUITS[6],
            'R',
            dust.mat(MT.ChargedCertusQuartz, 1),
            'C',
            FluixDenseCoveredCable);

        shaped(
            BasicCard,
            DEF_REM_REV,
            "GIS",
            "RCT",
            "GIS",
            'G',
            wireFine.mat(MT.Au, 1),
            'I',
            plateCurved.mat(MT.Ir, 1),
            'R',
            wireFine.mat(MT.RedAlloy, 1),
            'C',
            OD_CIRCUITS[5],
            'T',
            plate.mat(MT.Ti, 1),
            'S',
            screw.mat(MT.Ti, 1));
        shaped(
            RedstoneCard,
            DEF_REM_REV,
            "RS ",
            "BPd",
            "RS ",
            'B',
            BasicCard,
            'R',
            wireFine.mat(MT.RedAlloy, 1),
            'S',
            screw.mat(MT.Ir, 1),
            'P',
            plate.mat(MT.Ir, 1));
        shaped(
            CapacityCard,
            DEF_REM_REV,
            "CS ",
            "BPd",
            "CS ",
            'B',
            BasicCard,
            'C',
            make(MD.AE, "item.ItemMultiMaterial", 1, 36),
            'S',
            screw.mat(MT.Ir, 1),
            'P',
            plate.mat(MT.Ir, 1));
        shaped(
            CraftingCard,
            DEF_REM_REV,
            "CS ",
            "BPd",
            "CS ",
            'B',
            BasicCard,
            'C',
            make(Blocks.crafting_table, 1, 0),
            'S',
            screw.mat(MT.Ir, 1),
            'P',
            plate.mat(MT.Ir, 1));
        shaped(
            StickyCard,
            DEF_REM_REV,
            "AS ",
            "BPd",
            "AS ",
            'B',
            BasicCard,
            'A',
            make(Items.slime_ball, 1, 0),
            'S',
            screw.mat(MT.Ir, 1),
            'P',
            plate.mat(MT.Ir, 1));
        shaped(
            VoidCard,
            DEF_REM_REV,
            "ES ",
            "BPd",
            "ES ",
            'B',
            BasicCard,
            'E',
            make(Items.ender_pearl, 1, 0),
            'S',
            screw.mat(MT.Ir, 1),
            'P',
            plate.mat(MT.Ir, 1));

        shaped(
            AdvCard,
            DEF_REM_REV,
            "POS",
            "CUI",
            "POS",
            'P',
            wireFine.mat(MT.Pt, 1),
            'O',
            plateCurved.mat(MT.Os, 1),
            'S',
            screw.mat(MT.Ir, 1),
            'C',
            wireFine.mat(MT.Co, 1),
            'U',
            OD_CIRCUITS[6],
            'I',
            plate.mat(MT.Ir, 1));

    }

    @Override
    public void loadMachines() {
        delate(QuartzFiber);
        RM.RollBender.addRecipe1(T, 256, 128, plateGem.mat(MT.CertusQuartz, 1), QuartzFiber);
        OM.data(QuartzFiber, new OreDictItemData(MT.CertusQuartz, U));
        delate(FluixCable);
        RM.Injector.addRecipe2(T, 1024, 64, QuartzFiber, crystal.mat(MT.Fluix, 1), FluixCable);
        OM.data(FluixCable, new OreDictItemData(MT.CertusQuartz, U, MT.Fluix, U));
        delate(FluixCoveredCable);
        RM.Laminator.addRecipe2(T, 256, 128, plate.mat(ANY.Rubber, 1), FluixCable, FluixCoveredCable);
        OM.data(FluixCable, new OreDictItemData(MT.CertusQuartz, U, MT.Fluix, U, ANY.Rubber, U));
        delate(FluixDenseCoveredCable);
        RM.Compressor.addRecipe1(T, 256, 64, amount(4, FluixCoveredCable), FluixDenseCoveredCable);
        OM.data(FluixCable, new OreDictItemData(MT.CertusQuartz, U * 4, MT.Fluix, U * 4, ANY.Rubber, U * 4));

        for (byte i = 0; i < 16; i++) {
            delate(make(MD.AE, "item.ItemMultiPart", 1, i));
            RM.Bath.addRecipe1(
                T,
                0,
                128,
                FluixCable,
                DYE_FLUIDS_CHEMICAL[15 - i],
                NF,
                make(MD.AE, "item.ItemMultiPart", 1, i));
            OM.data(make(MD.AE, "item.ItemMultiPart", 1, i), new OreDictItemData());
            delate(make(MD.AE, "item.ItemMultiPart", 1, i + 20));
            RM.Bath.addRecipe1(
                T,
                0,
                128,
                FluixCoveredCable,
                DYE_FLUIDS_CHEMICAL[15 - i],
                NF,
                make(MD.AE, "item.ItemMultiPart", 1, i + 20));
            delate(make(MD.AE, "item.ItemMultiPart", 1, i + 520));
            RM.Bath.addRecipe1(
                T,
                0,
                128,
                FluixDenseCoveredCable,
                DYE_FLUIDS_CHEMICAL[15 - i],
                NF,
                make(MD.AE, "item.ItemMultiPart", 1, i + 520));
            delate(make(MD.AE, "item.ItemMultiPart", 1, i + 40));
            RM.Bath.addRecipe1(
                T,
                0,
                128,
                FluixSmartCable,
                DYE_FLUIDS_CHEMICAL[15 - i],
                NF,
                make(MD.AE, "item.ItemMultiPart", 1, i + 40));
            delate(make(MD.AE, "item.ItemMultiPart", 1, i + 60));
            RM.Bath.addRecipe1(
                T,
                0,
                128,
                FluixDenseSmartCable,
                DYE_FLUIDS_CHEMICAL[15 - i],
                NF,
                make(MD.AE, "item.ItemMultiPart", 1, i + 60));
        }
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
