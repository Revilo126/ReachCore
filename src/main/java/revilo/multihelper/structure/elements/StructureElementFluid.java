package revilo.multihelper.structure.elements;

import static gregapi.data.CS.*;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.fluids.BlockFluidBase;

import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;

public class StructureElementFluid<T extends ITileEntityMultiBlockController> implements IStructureElement<T> {

    private BlockFluidBase fluid;

    public StructureElementFluid(BlockFluidBase fluid) {
        this.fluid = fluid;
    }

    @Override
    public boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int tX, int tY,
        int tZ) {
        if (t.getBlock(tX, tY, tZ) == fluid) return T;
        return F;
    }

}
