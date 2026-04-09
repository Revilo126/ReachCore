package revilo.reach.tile.multiblock.fusion;

import static gregapi.data.CS.*;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.util.WD;
import revilo.multihelper.structure.StructureUtil.Definition;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityFusionReactorTier2
    extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityFusionReactorTier2> {

    @Override
    public Definition<MultiTileEntityFusionReactorTier2> getStructure() {
        return null;
    }

    @Override
    public void doOutputEnergy() {
        int tX = getOffsetXN(mFacing, 2), tY = yCoord, tZ = getOffsetZN(mFacing, 2);
        for (byte tSide : ALL_SIDES_HORIZONTAL) if (ITileEntityEnergy.Util.insertEnergyInto(
            mEnergyTypeEmitted,
            mOutputEnergy,
            1,
            this,
            WD.te(worldObj, tX + OFFX[tSide] * 10, tY, tZ + OFFZ[tSide] * 10, OPOS[tSide], F)) > 0) return;
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
        return "reach.multitileenetity.multiblock.fusionreactor.2";
    }

}
