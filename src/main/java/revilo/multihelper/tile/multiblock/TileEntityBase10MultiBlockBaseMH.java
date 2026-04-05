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
        int tX = getOffsetXN(mFacing), tY = yCoord, tZ = getOffsetZN(mFacing);
        return getStructure().check((T) this, aCoordinates, aPlayer, aInventory, tX, tY, tZ);
    }

    /**
     * @Override TODO: Add aut isInsideStructure
     *           public boolean isInsideStructure(int aX, int aY, int aZ) {
     *           }
     */
}
