package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.IL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.tileentity.connectors.MultiTileEntityWireElectric;
import gregapi.tileentity.machines.MultiTileEntityBasicMachine;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.UT;
import revilo.reach.api.data.CS;
import revilo.reach.api.data.RCMT;
import revilo.reach.api.data.RCRM;
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
        unsorted(aRegistry);

    }

    // Use 0 - 9 999
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

    // Use 10 000 - 19 999
    private static void machines(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine, short aCreativeTab) {
        aClass = MultiTileEntityBasicMachine.class;

    }

    // Use 20 000 - 29 999
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

    private static void unsorted(MultiTileEntityRegistry aRegistry) {}
}
