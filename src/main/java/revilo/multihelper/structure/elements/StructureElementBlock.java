package revilo.multihelper.structure.elements;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;

public class StructureElementBlock<T extends ITileEntityMultiBlockController> implements IStructureElement<T> {

    private Block element;

    public StructureElementBlock(Block element) {
        this.element = element;
    }

    @Override
    public boolean check(ITileEntityMultiBlockController t, ChunkCoordinates aCoordinates, Entity aPlayer,
        IInventory aInventory, int tX, int tY, int tZ) {
        if (t.getBlock(tX, tY, tZ) == element) return T;
        return F;
    }

}
