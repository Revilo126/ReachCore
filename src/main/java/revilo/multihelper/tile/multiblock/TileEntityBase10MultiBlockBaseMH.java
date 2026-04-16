package revilo.multihelper.tile.multiblock;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;
import revilo.multihelper.structure.IStructured;
import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockBase;

public abstract class TileEntityBase10MultiBlockBaseMH<T extends TileEntityBase10MultiBlockBaseMH<T>>
    extends TileEntityBase10MultiBlockBase implements IStructured<T> {

    @SuppressWarnings("unchecked")
    @Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        return check((T) this, aCoordinates, aPlayer, aInventory, getX(), getY(), getZ(), mFacing);
    }

    @Override
    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int baseX = getOffsetXN(mFacing);
        int baseY = yCoord;
        int baseZ = getOffsetZN(mFacing);

        return getStructure().isInside(aX, aY, aZ, baseX, baseY, baseZ);
    }
}
