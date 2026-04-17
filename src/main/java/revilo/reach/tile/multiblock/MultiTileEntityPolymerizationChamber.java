package revilo.reach.tile.multiblock;

import static gregapi.data.CS.*;

import java.util.List;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.WD;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityPolymerizationChamber
    extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityPolymerizationChamber> {

    static String[][] STRUCTURE = { { "WWW", "WWW", "W-W", "HHH" }, { "WWW", "W W", "WWW", "HHH" },
        { "WWW", "WWW", "WWW", "HHH" } };

    @Override
    public Definition<MultiTileEntityPolymerizationChamber> getStructure() {
        return Definition.<MultiTileEntityPolymerizationChamber>builder(STRUCTURE)
            .addElement(
                'W',
                new StructureElementPart<>(
                    18002,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
            .addElement(
                'H',
                new StructureElementPart<>(
                    18101,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN))
            .build();
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

    static {
        LH.add("reach.tooltip.multiblock.polymerization.1", "3x3 base of Heat Transmitter");
        LH.add("reach.tooltip.multiblock.polymerization.2", "Hollow 3x3x3 cube of Stainless Steel Walls");
        LH.add("reach.tooltip.multiblock.polymerization.3", "Main block centered on Side-Bottom facing outwards");
        LH.add("reach.tooltip.multiblock.polymerization.4", "Input and output at any Wall");
    }

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get(LH.STRUCTURE) + ":");
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.polymerization.1"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.polymerization.2"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.polymerization.3"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.polymerization.4"));
        super.addToolTips(aList, aStack, aF3_H);
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
