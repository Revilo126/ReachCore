package revilo.multihelper.structure;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.util.ST;

public class StructureUtil {

    public static short getRegistryID(MultiTileEntityRegistry aRegistry) {
        return ST.id(aRegistry.mBlock); // TODO
    }

    public static short getGTRegistryID() {
        return getRegistryID(MultiTileEntityRegistry.getRegistry("gt.multitileentity"));
    }
    
    //public static boolean iterate(IIteratorAction uponEachIteration) {
    //	
    //}

    /*
     * Checking functions for use with multiblocks that have basic blocks/fluids (E.g Fish farm).
     */
    public static class CheckUtils {

        public static void check() {

        }
    }
}
