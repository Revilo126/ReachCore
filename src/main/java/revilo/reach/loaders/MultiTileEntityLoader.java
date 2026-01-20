package revilo.reach.loaders;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.tileentity.connectors.MultiTileEntityWireElectric;

public class MultiTileEntityLoader implements Runnable {

    @Override
    public void run() {
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

        Class<? extends TileEntity> aClass = MultiTileEntityWireElectric.class;

        MultiTileEntityWireElectric
            .addElectricWires(30000, 28366, V[7], 4, 4, 2, T, F, T, aGTRegistry, aMetalWiresGT, aClass, MT.Nq_528);

    }

}
