package revilo.multihelper.tile.multiblock;

import gregapi.tileentity.multiblocks.TileEntityBase11MultiBlockConverter;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;
import revilo.multihelper.structure.IStructured;
	
public abstract class TileEntityBase10MultiBlockConverterMH<T extends TileEntityBase10MultiBlockConverterMH<T>>
	extends TileEntityBase11MultiBlockConverter implements IStructured<T> {
	
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
