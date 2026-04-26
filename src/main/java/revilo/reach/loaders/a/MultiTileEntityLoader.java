package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.ANY;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.tileentity.connectors.MultiTileEntityPipeFluid;
import gregapi.tileentity.connectors.MultiTileEntityPipeItem;
import gregapi.tileentity.connectors.MultiTileEntityWireElectric;
import gregapi.tileentity.machines.MultiTileEntityBasicMachine;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import gregtech.tileentity.energy.converters.MultiTileEntityEngineElectric;
import gregtech.tileentity.energy.converters.MultiTileEntityHeaterElectric;
import gregtech.tileentity.energy.converters.MultiTileEntityMotorElectric;
import revilo.reach.data.RCCS;
import revilo.reach.data.RCMT;
import revilo.reach.data.RCRM;
import revilo.reach.tile.multiblock.MultiTileEntityPolymerizationChamber;
import revilo.reach.tile.multiblock.MultiTileEntityPyrolyseOven;
import revilo.reach.tile.multiblock.fusion.MultiTileEntityFusionReactorTier2;

public class MultiTileEntityLoader implements Runnable {

    static Class<? extends TileEntity> aClass;
    static OreDictMaterial aMat = MT.NULL;

    // Multiblock Parts
    public static int solarPart;

    public static int naqCoils;

    public static int iridiumWall;
    public static int osmiumWall;

    @Override
    public void run() {
        MultiTileEntityBlock aMetalWires = MultiTileEntityBlock.getOrCreate(
            RCCS.ModIds.REACH,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_cutter,
            0,
            0,
            15,
            F,
            F),
            aMachine = MultiTileEntityBlock.getOrCreate(
                RCCS.ModIds.REACH,
                "machine",
                MaterialMachines.instance,
                Block.soundTypeMetal,
                TOOL_wrench,
                0,
                0,
                15,
                F,
                F),
            aWooden = MultiTileEntityBlock
                .getOrCreate(RCCS.ModIds.REACH, "wood", Material.wood, Block.soundTypeWood, TOOL_axe, 0, 0, 15, F, F);

        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("reach.multitileentity");
        MultiTileEntityRegistry aRegistryGT = MultiTileEntityRegistry.getRegistry("gt.multitileentity");

        cables(aRegistry, aMetalWires, aWooden);
        machines(aRegistry, aMachine);
        multiblocks(aRegistry, aRegistryGT, aMachine);
        unsorted(aRegistry, aMachine);

    }

    // Use 0 - 4 999
    private static void cables(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetalWires,
        MultiTileEntityBlock aWooden) {

        int wireID = 0;

        aClass = MultiTileEntityWireElectric.class;

        // ZPM //

        MultiTileEntityWireElectric // Distrontium Ruthenate
            .addElectricWires(wireID += 50, 0, V[7], 4, 6, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Sr2RuO4);

        MultiTileEntityWireElectric // Enriched Naquadah
            .addElectricWires(wireID += 50, 0, VMAX[7], 4, 4, 2, T, F, T, aRegistry, aMetalWires, aClass, MT.Nq_528);

        // UV //

        MultiTileEntityWireElectric // Unbinillium
            .addElectricWires(wireID += 50, 0, V[8], 8, 8, 2, T, F, T, aRegistry, aMetalWires, aClass, MT.Ubn);

        // PUV1 //

        MultiTileEntityWireElectric // Naquadria
            .addElectricWires(wireID += 50, 0, V[9], 16, 16, 8, T, F, T, aRegistry, aMetalWires, aClass, MT.Nq_522);

        // PUV2 //

        // PUV3 //

        // PUV4 //

        // PUV5 //

        // MAX //

        // MAX+ //

        // Fluid //

        int pipeID = 2000;

        aClass = MultiTileEntityPipeFluid.class;

        MultiTileEntityPipeFluid
            .addFluidPipes(pipeID += 20, 2500, 100, T, F, F, F, T, F, F, T, aRegistry, aWooden, aClass, 370, RCMT.PVC);

        // Item //

        @SuppressWarnings("unused")
        int itemID = 4000;

        aClass = MultiTileEntityPipeItem.class;
    }

    // Use 5 000 - 5 999
    private static void machines(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine) {
        @SuppressWarnings("unused")
        int machineID = 5000;

        aClass = MultiTileEntityBasicMachine.class;

    }

    // Use 10 000 - 14 999
    private static void multiblocks(MultiTileEntityRegistry aRegistry, MultiTileEntityRegistry aRegistryGT,
        MultiTileEntityBlock aMachine) {

        int multiblockID = 10000;

        aClass = MultiTileEntityMultiBlockPart.class;
        aMat = MT.StainlessSteel;
        solarPart = multiblockID;
        aRegistry.add(
            "Large Solar Panel Part",
            "MultiblockMachines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                6.0F,
                NBT_RESISTANCE,
                6.0F,
                NBT_TEXTURE,
                "solarpanelpart",
                NBT_DESIGNS,
                2));

        aMat = MT.Nq;
        naqCoils = multiblockID;
        aRegistry.add(
            "Large Naquadah Coil",
            "Multiblock Machines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                6.0F,
                NBT_RESISTANCE,
                6.0F,
                NBT_TEXTURE,
                "coil",
                NBT_DESIGNS,
                1),
            "WWW",
            "WxW",
            "WWW",
            'W',
            OP.wireGt04.dat(aMat));

        aMat = MT.Ir;
        iridiumWall = multiblockID;
        aRegistry.add(
            "Iridium Wall",
            "Multiblock Machines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                8.0F,
                NBT_RESISTANCE,
                8.0F,
                NBT_TEXTURE,
                "metalwall",
                NBT_DESIGNS,
                7),
            "wPP",
            "hPP",
            'P',
            OP.plate.dat(aMat));
        RM.Welder.addRecipe2(F, 16, 256, OP.plate.mat(aMat, 4), ST.tag(10), aRegistry.getItem());
        aRegistry.add(
            "Dense Iridium Wall",
            "Multiblock Machines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                8.0F,
                NBT_RESISTANCE,
                8.0F,
                NBT_TEXTURE,
                "metalwalldense",
                NBT_DESIGNS,
                7));
        OM.data(aRegistry.getItem(), aMat, U * 36);
        RM.Welder.addRecipe2(F, 64, 512, OP.plateDense.mat(aMat, 4), ST.tag(10), aRegistry.getItem());

        aMat = MT.Os;
        osmiumWall = multiblockID;
        aRegistry.add(
            "Osmium Wall",
            "Multiblock Machines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                8.0F,
                NBT_RESISTANCE,
                8.0F,
                NBT_TEXTURE,
                "metalwall",
                NBT_DESIGNS,
                7),
            "wPP",
            "hPP",
            'P',
            OP.plate.dat(aMat));
        RM.Welder.addRecipe2(F, 16, 256, OP.plate.mat(aMat, 4), ST.tag(10), aRegistry.getItem());
        aRegistry.add(
            "Dense Osmium Wall",
            "Multiblock Machines",
            multiblockID++,
            10000,
            aClass,
            aMat.mToolQuality,
            64,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                8.0F,
                NBT_RESISTANCE,
                8.0F,
                NBT_TEXTURE,
                "metalwalldense",
                NBT_DESIGNS,
                7));
        OM.data(aRegistry.getItem(), aMat, U * 36);
        RM.Welder.addRecipe2(F, 64, 512, OP.plateDense.mat(aMat, 4), ST.tag(10), aRegistry.getItem());

        aMat = MT.StainlessSteel;
        aRegistry.add(
            "Pyrolyse Oven",
            "Multiblock Machines",
            multiblockID++,
            10000,
            MultiTileEntityPyrolyseOven.class,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                5.0F,
                NBT_RESISTANCE,
                5.0F,
                NBT_COLOR,
                UT.Code.getRGBInt(aMat.fRGBaSolid),
                NBT_TEXTURE,
                "largeoven",
                NBT_INPUT,
                64,
                NBT_INPUT_MIN,
                64,
                NBT_INPUT_MAX,
                4096,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_RECIPEMAP,
                RM.CokeOven,
                NBT_INV_SIDE_AUTO_OUT,
                SIDE_BOTTOM,
                NBT_TANK_SIDE_AUTO_OUT,
                SIDE_BOTTOM,
                NBT_CHEAP_OVERCLOCKING,
                T,
                NBT_PARALLEL,
                64,
                NBT_PARALLEL_DURATION,
                T),
            "SPS",
            "PwP",
            "CMC",
            'M',
            aRegistry.getItem(18002),
            'C',
            OD_CIRCUITS[3],
            'P',
            OP.plateDense.dat(aMat),
            'S',
            OP.screw.dat(aMat));
        aMat = MT.StainlessSteel;
        aRegistry.add(
            "Polymerization Chamber",
            "Multiblock Machine",
            multiblockID++,
            10000,
            MultiTileEntityPolymerizationChamber.class,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                6.0F,
                NBT_TEXTURE,
                "polymerizationchamber",
                NBT_INPUT,
                512,
                NBT_INPUT_MIN,
                1,
                NBT_INPUT_MAX,
                1024,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.HU,
                NBT_RECIPEMAP,
                RCRM.Polymerization,
                NBT_INV_SIDE_AUTO_OUT,
                SIDE_BACK,
                NBT_TANK_SIDE_AUTO_OUT,
                SIDE_BACK,
                NBT_CHEAP_OVERCLOCKING,
                T),
            "PPP",
            "PMP",
            "PPP",
            'M',
            aRegistryGT.getItem(18102),
            'P',
            OP.pipeNonuple.dat(MT.Steel));
        /*
         * aClass = MultiTileEntityLargeSolarPanelElectric.class;
         * aMat = MT.StainlessSteel;
         * aRegistry.add(
         * "Large Solar Panel (Silicon)",
         * "Solar Panels",
         * multiblockID++,
         * 10000,
         * aClass,
         * aMat.mToolQuality,
         * 16,
         * aMachine,
         * UT.NBT.make(
         * NBT_MATERIAL,
         * aMat,
         * NBT_HARDNESS,
         * 6.0F,
         * NBT_RESISTANCE,
         * 6.0F,
         * NBT_OUTPUT,
         * 256,
         * NBT_ENERGY_EMITTED,
         * TD.Energy.EU));
         * aRegistry.add(
         * "Large Solar Panel (Germanium)",
         * "Solar Panels",
         * multiblockID++,
         * 10000,
         * aClass,
         * aMat.mToolQuality,
         * 16,
         * aMachine,
         * UT.NBT.make(
         * NBT_MATERIAL,
         * aMat,
         * NBT_HARDNESS,
         * 6.0F,
         * NBT_RESISTANCE,
         * 6.0F,
         * NBT_OUTPUT,
         * 512,
         * NBT_ENERGY_EMITTED,
         * TD.Energy.EU));
         */
        aMat = MT.Os;
        aRegistry.add(
            "Fusion Reactor T2",
            "Multiblock Machines",
            multiblockID++,
            10000,
            MultiTileEntityFusionReactorTier2.class,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                16.0F,
                NBT_RESISTANCE,
                16.0F,
                NBT_TEXTURE,
                "fusionreactor",
                NBT_INPUT,
                32768,
                NBT_INPUT_MIN,
                1,
                NBT_INPUT_MAX,
                65536,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.TU,
                NBT_RECIPEMAP,
                RCRM.FusionT2,
                NBT_ENERGY_ACCEPTED_2,
                TD.Energy.LU,
                NBT_ENERGY_EMITTED,
                TD.Energy.EU,
                NBT_SPECIAL_IS_START_ENERGY,
                T,
                NBT_NO_CONSTANT_POWER,
                T));

        /**
         * aMat = MT.Ad;
         * aRegistry.add(
         * "Fusion Reactor Tier 2",
         * "Multiblock Machines",
         * 22000,
         * 20000,
         * MultiTileEntityFusionReactor2.class,
         * aMat.mToolQuality,
         * 16,
         * aMachine,
         * UT.NBT.make(
         * NBT_MATERIAL,
         * aMat,
         * NBT_HARDNESS,
         * 16.5F,
         * NBT_RESISTANCE,
         * 16.5F,
         * NBT_TEXTURE,
         * "fusionreactor",
         * NBT_INPUT,
         * 32768,
         * NBT_INPUT_MIN,
         * 1,
         * NBT_INPUT_MAX,
         * 65536,
         * NBT_ENERGY_ACCEPTED,
         * TD.Energy.TU,
         * NBT_RECIPEMAP,
         * RCRM.FusionT2,
         * NBT_ENERGY_ACCEPTED_2,
         * TD.Energy.LU,
         * NBT_ENERGY_EMITTED,
         * TD.Energy.EU,
         * NBT_SPECIAL_IS_START_ENERGY,
         * T,
         * NBT_NO_CONSTANT_POWER,
         * T),
         * "FFF",
         * "FMF",
         * "FFF",
         * 'M',
         * aRegistryGT.getItem(18005),
         * 'F',
         * IL.FIELD_GENERATORS[6]);
         */
    }

    // Use 15 000 - 19 999
    private static void unsorted(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine) {
        int unsortedID = 15000;

        // TODO: Adjust recipes!
        aClass = MultiTileEntityHeaterElectric.class;
        aMat = MT.DATA.Electric_T[6];
        aRegistry.add(
            "Electric Heater (" + VN[6] + ")",
            "Heaters",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[6],
                NBT_OUTPUT,
                V[6] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.HU),
            "TCT",
            "CMC",
            "TCd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'C',
            OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[7];
        aRegistry.add(
            "Electric Heater (" + VN[7] + ")",
            "Heaters",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[7],
                NBT_OUTPUT,
                V[7] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.HU),
            "TCT",
            "CMC",
            "TCd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'C',
            OP.wireGt02.dat(MT.Constantan));
        aMat = MT.DATA.Electric_T[8];
        aRegistry.add(
            "Electric Heater (" + VN[8] + ")",
            "Heaters",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[8],
                NBT_OUTPUT,
                V[8] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.HU),
            "TCT",
            "CMC",
            "TCd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'C',
            OP.wireGt04.dat(MT.Kanthal));
        aMat = MT.DATA.Electric_T[9];
        aRegistry.add(
            "Electric Heater (" + VN[9] + ")",
            "Heaters",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[9],
                NBT_OUTPUT,
                V[9] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.HU),
            "TCT",
            "CMC",
            "TCd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'C',
            OP.wireGt08.dat(MT.Nichrome));
        aMat = MT.DATA.Electric_T[10];
        aRegistry.add(
            "Electric Heater (" + VN[10] + ")",
            "Heaters",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[10],
                NBT_OUTPUT,
                V[10] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.HU),
            "TCT",
            "CMC",
            "TCd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'C',
            OP.wireGt16.dat(MT.SiC));

        aClass = MultiTileEntityEngineElectric.class;
        aMat = MT.DATA.Electric_T[6];
        aRegistry.add(
            "Electric Engine (" + VN[6] + ")",
            "Engines",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[6],
                NBT_OUTPUT,
                V[6] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.KU),
            "PhP",
            "CIC",
            "PwP",
            'P',
            OP.plateTriple.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt01.dat(ANY.Cu)); // TODO: Temp Recipes
        aMat = MT.DATA.Electric_T[7];
        aRegistry.add(
            "Electric Engine (" + VN[7] + ")",
            "Engines",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[7],
                NBT_OUTPUT,
                V[7] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.KU),
            "PhP",
            "CIC",
            "PwP",
            'P',
            OP.plateTriple.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt02.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[8];
        aRegistry.add(
            "Electric Engine (" + VN[8] + ")",
            "Engines",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[8],
                NBT_OUTPUT,
                V[8] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.KU),
            "PhP",
            "CIC",
            "PwP",
            'P',
            OP.plateTriple.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt04.dat(MT.AnnealedCopper));
        aMat = MT.DATA.Electric_T[9];
        aRegistry.add(
            "Electric Engine (" + VN[9] + ")",
            "Engines",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[9],
                NBT_OUTPUT,
                V[9] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.KU),
            "PhP",
            "CIC",
            "PwP",
            'P',
            OP.plateTriple.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt08.dat(MT.AnnealedCopper));
        aMat = MT.DATA.Electric_T[10];
        aRegistry.add(
            "Electric Engine (" + VN[10] + ")",
            "Engines",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[10],
                NBT_OUTPUT,
                V[10] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.KU),
            "PhP",
            "CIC",
            "PwP",
            'P',
            OP.plateTriple.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt16.dat(MT.AnnealedCopper));

        aClass = MultiTileEntityMotorElectric.class;
        aMat = MT.DATA.Electric_T[6];
        aRegistry.add(
            "Electric Motor (" + VN[6] + ")",
            "Motors",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[6],
                NBT_OUTPUT,
                V[6] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.RU),
            "TIT",
            "CMC",
            "TGd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt01.dat(ANY.Cu)); // TODO: Temp Recipes
        aMat = MT.DATA.Electric_T[7];
        aRegistry.add(
            "Electric Motor (" + VN[7] + ")",
            "Motors",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[7],
                NBT_OUTPUT,
                V[8],
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.RU),
            "TIT",
            "CMC",
            "TGd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt02.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[8];
        aRegistry.add(
            "Electric Motor (" + VN[8] + ")",
            "Motors",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[8],
                NBT_OUTPUT,
                V[8] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.RU),
            "TIT",
            "CMC",
            "TGd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt04.dat(MT.AnnealedCopper));
        aMat = MT.DATA.Electric_T[9];
        aRegistry.add(
            "Electric Motor (" + VN[9] + ")",
            "Motors",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[9],
                NBT_OUTPUT,
                V[9] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.RU),
            "TIT",
            "CMC",
            "TGd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt08.dat(MT.AnnealedCopper));
        aMat = MT.DATA.Electric_T[10];
        aRegistry.add(
            "Electric Motor (" + VN[10] + ")",
            "Motors",
            unsortedID++,
            15000,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                V[10],
                NBT_OUTPUT,
                V[10] / 2,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_ENERGY_EMITTED,
                TD.Energy.RU),
            "TIT",
            "CMC",
            "TGd",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'I',
            OP.stickLong.dat(MT.NeodymiumMagnetic),
            'C',
            OP.wireGt16.dat(MT.AnnealedCopper));

    }
}
