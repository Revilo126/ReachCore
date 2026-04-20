package revilo.reach.tile.multiblock;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityGasCentrifuge extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityGasCentrifuge> {

    private String[][] STRUCTURE = { { "WWW", "WIW", "W-W", "WWW" }, { "WOW", "IWI", "WWW", "WPW" },
        { "WWW", "WIW", "WWW", "WWW" } };

    @Override
    public Definition<MultiTileEntityGasCentrifuge> getStructure() {
        return Definition.<MultiTileEntityGasCentrifuge>builder(STRUCTURE)
            .addElement(
                'W',
                new StructureElementPart<>(
                    18026,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'I',
                new StructureElementPart<>(
                    18026,
                    StructureUtil.getGTRegistryID(),
                    1,
                    MultiTileEntityMultiBlockPart.ONLY_FLUID_IN))
            .addElement(
                'O',
                new StructureElementPart<>(
                    18026,
                    StructureUtil.getGTRegistryID(),
                    1,
                    MultiTileEntityMultiBlockPart.ONLY_FLUID_OUT))
            .addElement(
                'P',
                new StructureElementPart<>(
                    18026,
                    StructureUtil.getGTRegistryID(),
                    3,
                    MultiTileEntityMultiBlockPart.ONLY_FLUID_OUT))
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
        return "reach.multitileentity.multiblock.gascentrifuge";
    }

}
