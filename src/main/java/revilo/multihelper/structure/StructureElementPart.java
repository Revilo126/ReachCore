package revilo.multihelper.structure;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;

public class StructureElementPart<T extends ITileEntityMultiBlockController> {

    private final int aRegistryMeta, aRegistryID, aDesign, aMode;

    public StructureElementPart(T t, int tRegistryMeta, int tRegistryID, int tDesign, int tMode) {
        this.aRegistryMeta = tRegistryMeta;
        this.aRegistryID = tRegistryID;
        this.aDesign = tDesign;
        this.aMode = tMode;
    }

    public boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int tX, int tY,
        int tZ) {
        return ITileEntityMultiBlockController.Util.checkAndSetTarget(
            t,
            tX,
            tY,
            tZ,
            aRegistryMeta,
            aRegistryID,
            aDesign,
            aMode,
            aCoordinates,
            aPlayer,
            aInventory);
    }

}
