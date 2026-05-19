package revilo.reach.tile.multiblock;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;
import revilo.reach.loaders.a.MultiTileEntityLoader;

public class MultiTileEntityLargeWelder extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityLargeWelder> {

    private String[][] STRUCTURE = { { "WWW", "L-R", "WWW" }, { "WWW", "PPP", "WIW" }, { "WWW", "PPP", "WWW" } };

    @Override
    public Definition<MultiTileEntityLargeWelder> getStructure() {
        return Definition.<MultiTileEntityLargeWelder>builder(STRUCTURE)
            .addElement(
                'P',
                StructureUtil.ofPart(
                    MultiTileEntityLoader.welderPart,
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
            .build();
    }

    @Override
    public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        return null;
    }

    @Override
    public String getTileEntityName() {
        return "reach.multitileentity.multiblock.welder";
    }

}
