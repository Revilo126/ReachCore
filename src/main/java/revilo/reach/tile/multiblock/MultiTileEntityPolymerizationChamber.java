package revilo.reach.tile.multiblock;

import static gregapi.data.CS.*;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.WD;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.StructureUtil.Definition;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityPolymerizationChamber
    extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityPolymerizationChamber> {

    static String[][] STRUCTURE = { { "WWW", "WWW", "W-W", "HHH" }, { "WWW", "W W", "WWW", "HHH" },
        { "WWW", "WWW", "WWW", "HHH" } };

    private static Definition<MultiTileEntityPolymerizationChamber> DEFINITION;

    @Override
    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int tX = getOffsetXN(mFacing), tY = yCoord, tZ = getOffsetZN(mFacing);
        return aX >= -1 && aY >= tY - 1 && aZ >= tZ - 1 && aX <= tX + 1 && aY <= tY + 2 && aZ <= tZ + 1;
    }

    // Should i change to Polymerization Chamber Part?
    @Override
    public Definition<MultiTileEntityPolymerizationChamber> getStructure() {
        if (DEFINITION == null) {
            DEFINITION = Definition.<MultiTileEntityPolymerizationChamber>builder(STRUCTURE)
                .addElement(
                    'W',
                    new StructureElementPart<>(
                        this,
                        18002,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
                .addElement(
                    'H',
                    new StructureElementPart<>(
                        this,
                        18101,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN))
                .build();
        }
        return DEFINITION;
    }

    @Override
    public void updateAdjacentToggleableEnergySources() {
        int tX = getOffsetXN(mFacing) - 1, tZ = getOffsetZN(mFacing) - 1;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) {
            DelegatorTileEntity<TileEntity> tDelegator = WD.te(worldObj, tX + i, yCoord - 2, tZ + j, SIDE_TOP, F);
            if (tDelegator.mTileEntity instanceof ITileEntityAdjacentOnOff
                && tDelegator.mTileEntity instanceof ITileEntityEnergy
                && ((ITileEntityEnergy) tDelegator.mTileEntity)
                    .isEnergyEmittingTo(mEnergyTypeAccepted, tDelegator.mSideOfTileEntity, T)) {
                ((ITileEntityAdjacentOnOff) tDelegator.mTileEntity).setAdjacentOnOff(getStateOnOff());
            }
        }
    }

    @Override
    public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        // return getAdjacentTileEntity(SIDE_TOP);
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        // return getAdjacentTank(SIDE_TOP);
        return null;
    }

    @Override
    public String getTileEntityName() {
        return "reach.multitileentity.multiblock.polymerization";
    }

}
