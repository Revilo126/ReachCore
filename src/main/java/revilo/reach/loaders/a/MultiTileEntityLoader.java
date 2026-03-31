package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.ANY;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.tileentity.connectors.MultiTileEntityWireElectric;
import gregapi.tileentity.machines.MultiTileEntityBasicMachine;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.UT;
import gregtech.tileentity.energy.converters.MultiTileEntityEngineElectric;
import gregtech.tileentity.energy.converters.MultiTileEntityHeaterElectric;
import gregtech.tileentity.energy.converters.MultiTileEntityMotorElectric;
import revilo.reach.data.CS;
import revilo.reach.data.RCMT;
import revilo.reach.data.RCRM;
import revilo.reach.tile.multiblock.MultiTileEntityFusionReactor2;

public class MultiTileEntityLoader implements Runnable {

    static Class<? extends TileEntity> aClass;
    static OreDictMaterial aMat = MT.NULL;

    @Override
    public void run() {
        MultiTileEntityBlock aMetalWires = MultiTileEntityBlock.getOrCreate(
            CS.ModIds.REACH,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_cutter,
            0,
            0,
            15,
            F,
            F);
        MultiTileEntityBlock aMachine = MultiTileEntityBlock.getOrCreate(
            CS.ModIds.REACH,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_wrench,
            0,
            0,
            15,
            F,
            F);

        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("reach.multitileentity");
        MultiTileEntityRegistry aRegistryGT = MultiTileEntityRegistry.getRegistry("gt.multitileentity");

        wire(aRegistry, aMetalWires);
        machines(aRegistry, aMachine, CreativeTabLoader.basicMachinesID);
        multiblocks(aRegistry, aRegistryGT, aMachine, CreativeTabLoader.basicMachinesID);
        unsorted(aRegistry, aMachine);

    }

    // Use 0 - 4 999
    private static void wire(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetalWires) {

        aClass = MultiTileEntityWireElectric.class;

        // ZPM //

        MultiTileEntityWireElectric // Distrontium Ruthenate
            .addElectricWires(50, 28366, V[7], 4, 6, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Sr2RuO4);

        MultiTileEntityWireElectric // Enriched Naquadah
            .addElectricWires(150, 28366, VMAX[7], 4, 4, 2, T, F, T, aRegistry, aMetalWires, aClass, MT.Nq_528);

        // UV //

        MultiTileEntityWireElectric // Unbinillium
            .addElectricWires(100, 28366, V[8], 8, 8, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Ubn);

        // PUV1 //

        MultiTileEntityWireElectric // Naquadria
            .addElectricWires(200, 28366, V[9], 16, 16, 8, T, F, T, aRegistry, aMetalWires, aClass, MT.Nq_522);

        // PUV2 //

        // PUV3 //

        // PUV4 //

        // PUV5 //

        // MAX //

        // MAX+ //

    }

    // Use 5 000 - 5 999
    private static void machines(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine, short aCreativeTab) {
        aClass = MultiTileEntityBasicMachine.class;

    }

    // Use 10 000 - 14 999
    private static void multiblocks(MultiTileEntityRegistry aRegistry, MultiTileEntityRegistry aRegistryGT,
        MultiTileEntityBlock aMachine, short aCreativeTab) {
        aClass = MultiTileEntityMultiBlockPart.class;

        aMat = RCMT.Ubn;
        aRegistry.add(
            "Large Unbinilium Coil",
            "Multiblock Machines",
            20000,
            aCreativeTab,
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

        aMat = MT.Ad;
        aRegistry.add(
            "Fusion Reactor Tier 2",
            "Multiblock Machines",
            22000,
            aCreativeTab,
            MultiTileEntityFusionReactor2.class,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                16.5F,
                NBT_RESISTANCE,
                16.5F,
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
                T),
            "FFF",
            "FMF",
            "FFF",
            'M',
            aRegistryGT.getItem(18005),
            'F',
            IL.FIELD_GENERATORS[6]);
    }

    // Use 15 000 - 19 999
    private static void unsorted(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine) {
        // TODO: Adjust recipes!
        aClass = MultiTileEntityHeaterElectric.class;
        aMat = MT.DATA.Electric_T[6];
        aRegistry.add(
            "Electric Heater (" + VN[6] + ")",
            "Heaters",
            15000,
            10001,
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
                32,
                NBT_OUTPUT,
                16,
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
            15001,
            10001,
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
                128,
                NBT_OUTPUT,
                64,
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
            15002,
            10001,
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
                512,
                NBT_OUTPUT,
                256,
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
            15003,
            10001,
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
                2048,
                NBT_OUTPUT,
                1024,
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
            15004,
            10001,
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
                8192,
                NBT_OUTPUT,
                4096,
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
            10011,
            1304,
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
                32,
                NBT_OUTPUT,
                16,
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
            10012,
            1304,
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
                128,
                NBT_OUTPUT,
                64,
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
            10013,
            1304,
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
                512,
                NBT_OUTPUT,
                256,
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
            10014,
            1304,
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
                2048,
                NBT_OUTPUT,
                1024,
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
            10015,
            1304,
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
                8192,
                NBT_OUTPUT,
                4096,
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
            10021,
            10021,
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
                32,
                NBT_OUTPUT,
                16,
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
            10022,
            10021,
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
                128,
                NBT_OUTPUT,
                64,
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
            10023,
            10021,
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
                512,
                NBT_OUTPUT,
                256,
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
            10024,
            10021,
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
                2048,
                NBT_OUTPUT,
                1024,
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
            10025,
            10021,
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
                8192,
                NBT_OUTPUT,
                4096,
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
