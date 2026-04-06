package revilo.multihelper.structure.elements;

import static gregapi.data.CS.*;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;

public class StructureElementAir<T extends ITileEntityMultiBlockController> implements IStructureElement<T> {

    public StructureElementAir() {

    }

    @Override
    public boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int tX, int tY,
        int tZ) {
        if (t.getAir(tX, tY, tZ)) return T;
        return F;
    }

}
