package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.oredict.OreDictMaterial;
import gregapi.tileentity.connectors.MultiTileEntityWireElectric;
import revilo.reach.Reach;
import revilo.reach.api.data.RCMT;

public class MultiTileEntityLoader implements Runnable {

    static Class<? extends TileEntity> aClass;
    static OreDictMaterial aMat = MT.NULL;

    @Override
    public void run() {
        MultiTileEntityBlock aMetalWires = MultiTileEntityBlock.getOrCreate(
            Reach.MODID,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_cutter,
            0,
            0,
            15,
            F,
            F);

        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("reach.multitileentity");

        wire(aRegistry, aMetalWires);
        unsorted(aRegistry);

    }

    private static void wire(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetalWires) {

        aClass = MultiTileEntityWireElectric.class;

        // ZPM //
        MultiTileEntityWireElectric
            .addElectricWires(50, 28366, V[7], 4, 6, 2, T, F, T, aRegistry, aMetalWires, aClass, RCMT.Sr2RuO4);

        // Use Below when creating wires from gt materials
        MultiTileEntityRegistry aGTRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity"); // i know its
                                                                                                         // GT6's
                                                                                                         // registry but
                                                                                                         // hopefully
                                                                                                         // this works!

        MultiTileEntityBlock aMetalWiresGT = MultiTileEntityBlock.getOrCreate(
            MD.GT.mID,
            "machine",
            MaterialMachines.instance,
            Block.soundTypeMetal,
            TOOL_cutter,
            0,
            0,
            15,
            F,
            F);

        // ZPM //
        MultiTileEntityWireElectric
            .addElectricWires(32800, 28366, VMAX[7], 4, 4, 2, T, F, T, aGTRegistry, aMetalWiresGT, aClass, MT.Nq_528);
    }

    private static void unsorted(MultiTileEntityRegistry aRegistry) {}
}
