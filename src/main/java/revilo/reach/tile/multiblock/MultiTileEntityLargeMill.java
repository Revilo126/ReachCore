package revilo.reach.tile.multiblock;

import static revilo.multihelper.structure.StructureUtil.*;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityLargeMill extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityLargeMill> {

    private String[][] STRUCTURE = { { "WWW", "W-W", "WWW" }, { "WWW", "W W", "WWW" }, { "WWW", "W W", "WWW" },
        { "WWW", "WPW", "WWW" } };

    @Override
    public Definition<MultiTileEntityLargeMill> getStructure() {
        return Definition.<MultiTileEntityLargeMill>builder(STRUCTURE)
            .addElement('W', ofPart(18002, getGTRegistryID(), 0, MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
            .addElement('P', ofPart(18002, getGTRegistryID(), 2, MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN))
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
        return "reach.multitileentity.multiblock.multimill";
    }

}
