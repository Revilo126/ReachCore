package revilo.multihelper.tile.multiblock;

import static revilo.multihelper.structure.StructureUtil.*;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockBase;

public abstract class TileEntityBase10MultiBlockBaseMH<T extends TileEntityBase10MultiBlockBaseMH<T>>
    extends TileEntityBase10MultiBlockBase {

    public abstract Definition<T> getStructure();

    @SuppressWarnings("unchecked")
    @Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        return getStructure().check((T) this, aCoordinates, aPlayer, aInventory, getX(), getY(), getZ(), mFacing);
    }

    @Override
    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int baseX = getOffsetXN(mFacing);
        int baseY = yCoord;
        int baseZ = getOffsetZN(mFacing);

        return getStructure().isInside(aX, aY, aZ, baseX, baseY, baseZ);
    }
}
