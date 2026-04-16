package revilo.multihelper.structure;

import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

public interface IStructured<T extends ITileEntityMultiBlockController>  {
	
	public Definition<T> getStructure();
	
	default boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int x, int y, int z, byte mFacing) {
		return getStructure().check(t, aCoordinates, aPlayer, aInventory, x, y, z, mFacing);
	}
}
