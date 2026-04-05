package revilo.reach.tile.multiblock;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;
import revilo.multihelper.structure.StructureElementPart;
import revilo.multihelper.structure.StructureUtil.Definition;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

public class MultiTileEntityPyrolyseOven extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityPyrolyseOven> {

	static String[][] STRUCTURE = {
			{
				"WWWWW",
				"WW-WW",
				"WWWWW"
			 },
			 {
				"WCCCW",
				"WCCCW",
				"WWWWW"
			 },
			 {
				"WCCCW",
				"WCCCW",
				"WWWWW"
			 },
			 {
				"WCCCW",
				"WCCCW",
				"WWWWW"
			 },
			 {
				"WWWWW",
				"WWWWW",
				"WWWWW"
			 }
	};
	
	private static Definition<MultiTileEntityPyrolyseOven> DEFINITION;
	
	@Override
	public boolean isInsideStructure(int aX, int aY, int aZ) {
		int tX = getOffsetXN(mFacing, 2), tY = yCoord, tZ = getOffsetZN(mFacing, 2);
		return aX >= tX - 2 && aY >= tY && aZ >= tZ - 2 && aX <= tX + 2 && aY <= tY + 6 && aZ <= tZ + 2;
	}

	@Override
	public Definition<MultiTileEntityPyrolyseOven> getStructure() {
		if (DEFINITION == null) {
	        // We use the instance 'this' and the ID from the registry here
	        DEFINITION = Definition.<MultiTileEntityPyrolyseOven>builder(STRUCTURE)
	            .addElement('W', new StructureElementPart<>(this, 18002, getMultiTileEntityRegistryID(), 0, MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
	            .addElement('C', new StructureElementPart<>(this, 18042, getMultiTileEntityRegistryID(), 0, MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
	            .build();
	    }
	    return DEFINITION;
	}

	@Override
	public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTileEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

}
