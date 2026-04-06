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
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.StructureUtil.Definition;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityPyrolyseOven extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityPyrolyseOven> {

    static String[][] STRUCTURE = { { "WWWWW", "WW-WW", "WWWWW" }, { "WCCCW", "WCCCW", "WWWWW" },
        { "WCCCW", "WCCCW", "WWWWW" }, { "WCCCW", "WCCCW", "WWWWW" }, { "WWWWW", "WWWWW", "WWWWW" } };

    private static Definition<MultiTileEntityPyrolyseOven> DEFINITION;

    @Override
    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int tX = getOffsetXN(mFacing, 2), tY = yCoord, tZ = getOffsetZN(mFacing, 2);
        return aX >= tX - 2 && aY >= tY && aZ >= tZ - 2 && aX <= tX + 2 && aY <= tY + 6 && aZ <= tZ + 2;
    }

    @Override
    public Definition<MultiTileEntityPyrolyseOven> getStructure() {
        if (DEFINITION == null) {
            DEFINITION = Definition.<MultiTileEntityPyrolyseOven>builder(STRUCTURE)
                .addElement(
                    'W',
                    new StructureElementPart<>(
                        this,
                        18002,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
                .addElement(
                    'C',
                    new StructureElementPart<>(
                        this,
                        18042,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
                .build();
        }
        return DEFINITION;
    }

    static {
        LH.add("reach.tooltip.multiblock.pyrolyseoven.1", "5x5x3 'Basin' of 72 Stainless Steel Walls");
        LH.add("reach.tooltip.multiblock.pyrolyseoven.2", "3x3x2 with 27 Nichrome Coils inside the 5x5x4");
        LH.add("reach.tooltip.multiblock.pyrolyseoven.3", "Main Block centered on Side-Bottom and facing outwards");
        LH.add(
            "reach.tooltip.multiblock.pyrolyseoven.4",
            "Stuff can go in and out on any of the Stainless Steel Walls, Energy input at bottom layer");
    }

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get(LH.STRUCTURE) + ":");
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.pyrolyseoven.1"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.pyrolyseoven.2"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.pyrolyseoven.3"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.pyrolyseoven.4"));
        super.addToolTips(aList, aStack, aF3_H);
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        return getAdjacentTank(SIDE_BOTTOM);
    }

    @Override
    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        return getAdjacentTileEntity(SIDE_BOTTOM);
    }

    @Override
    public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;
    }

    @Override
    public String getTileEntityName() {
        return "reach.multitileentity.multiblock.pyrolyseoven";
    }

}
