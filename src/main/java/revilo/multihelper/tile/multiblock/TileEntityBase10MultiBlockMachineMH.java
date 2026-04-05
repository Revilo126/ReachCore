package revilo.multihelper.tile.multiblock;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockMachine;
import revilo.multihelper.structure.StructureUtil.Definition;

public abstract class TileEntityBase10MultiBlockMachineMH<T extends TileEntityBase10MultiBlockMachineMH<T>> extends TileEntityBase10MultiBlockMachine {

    public abstract Definition<T> getStructure();

    @SuppressWarnings("unchecked")
	@Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        int tX = getOffsetXN(mFacing), tY = yCoord, tZ = getOffsetZN(mFacing);
        return getStructure().check((T) this, aCoordinates, aPlayer, aInventory, tX, tY, tZ);
    }

}
