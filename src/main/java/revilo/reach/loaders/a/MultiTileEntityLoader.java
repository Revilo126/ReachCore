package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
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

        wire(aRegistry, aMetalWires);
        machines(aRegistry, aMachine, CreativeTabLoader.basicMachinesID);
        multiblocks(aRegistry, aMachine, CreativeTabLoader.basicMachinesID);
        unsorted(aRegistry);

    }

    // Use 0 - 9 999
    private static void wire(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetalWires) {

        aClass = MultiTileEntityWireElectric.class;

        // ZPM //
        MultiTileEntityWireElectric
            .addElectricWires(50, 28366, V[7], 4, 6, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Sr2RuO4);

        // UV //

        // PUV1 //

        // PUV2 //
        MultiTileEntityWireElectric
            .addElectricWires(100, 28366, V[10], 8, 8, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Ubn);

        // PUV3 //

        // PUV4 //

        // PUV5 //

        // MAX //

        // Use Below when creating wires from gt materials (Testing other methods)
        /**
         * MultiTileEntityRegistry aGTRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity"); // i know
         * its
         * // GT6's
         * // registry but
         * // hopefully
         * // this works!
         * 
         * MultiTileEntityBlock aMetalWiresGT = MultiTileEntityBlock.getOrCreate(
         * MD.GT.mID,
         * "machine",
         * MaterialMachines.instance,
         * Block.soundTypeMetal,
         * TOOL_cutter,
         * 0,
         * 0,
         * 15,
         * F,
         * F);
         */

        // ZPM // TODO: Fix meta issue
        MultiTileEntityWireElectric
            .addElectricWires(9900, 28366, VMAX[7], 4, 4, 2, T, F, T, aRegistry, aMetalWires, aClass, MT.Nq_528);
    }

    // Use 10 000 - 19 999
    private static void machines(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine, short aCreativeTab) {
        aClass = MultiTileEntityBasicMachine.class;
        // PUV1 //
        aMat = MT.Trinaquadalloy;
        aRegistry.add(
            "Neutron Collector",
            "Multiblock Machine",
            10000,
            aCreativeTab,
            aClass,
            aMat.mToolQuality,
            16,
            aMachine,
            UT.NBT.make(
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                6.0F,
                NBT_RESISTANCE,
                6.0F,
                NBT_INPUT,
                1,
                NBT_TEXTURE,
                "neutroncollector",
                NBT_ENERGY_ACCEPTED,
                TD.Energy.EU,
                NBT_RECIPEMAP,
                RCRM.NeutronCollector,
                NBT_INV_SIDE_OUT,
                SBIT_B | SBIT_R,
                NBT_INV_SIDE_AUTO_OUT,
                SIDE_RIGHT,
                NBT_TANK_SIDE_IN,
                SBIT_U | SBIT_L,
                NBT_TANK_SIDE_AUTO_IN,
                SIDE_LEFT,
                NBT_TANK_SIDE_OUT,
                SBIT_B | SBIT_R,
                NBT_TANK_SIDE_AUTO_OUT,
                SIDE_BACK,
                NBT_ENERGY_ACCEPTED_SIDES,
                63,
                NBT_INPUT,
                1,
                NBT_INPUT_MIN,
                1,
                NBT_INPUT_MAX,
                16));
    }

    // Use 20 000 - 29 999
    private static void multiblocks(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine,
        short aCreativeTab) {
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
    }

    private static void unsorted(MultiTileEntityRegistry aRegistry) {}
}
