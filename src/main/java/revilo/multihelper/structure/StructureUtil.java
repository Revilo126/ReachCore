package revilo.multihelper.structure;

import static gregapi.data.CS.*;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;
import gregapi.util.ST;
import revilo.multihelper.structure.elements.IStructureElement;
import revilo.multihelper.structure.elements.StructureElementPart;

public class StructureUtil {

    public static short getRegistryID(MultiTileEntityRegistry aRegistry) {
        return ST.id(aRegistry.mBlock); // TODO
    }

    public static short getGTRegistryID() {
        return getRegistryID(MultiTileEntityRegistry.getRegistry("gt.multitileentity"));
    }

    public static class Definition<T extends ITileEntityMultiBlockController> {

        private String[][] structure;
        private Map<Character, IStructureElement<T>> elements;
        public int offsetX, offsetY, offsetZ;

        public int getSizeX() {
            int max = 0;
            for (String[] layer : structure) for (String row : layer) max = Math.max(max, row.length());
            return max;
        }

        public int getSizeY() {
            int max = 0;
            for (String[] layer : structure) max = Math.max(max, layer.length);
            return max;
        }

        public int getSizeZ() {
            return structure.length;
        }

        public boolean isInside(int worldX, int worldY, int worldZ, int baseX, int baseY, int baseZ) {

            int minX = baseX - offsetX;
            int minY = baseY - offsetY;
            int minZ = baseZ - offsetZ;

            int maxX = minX + getSizeX() - 1;
            int maxY = minY + getSizeY() - 1;
            int maxZ = minZ + getSizeZ() - 1;

            return worldX >= minX && worldX <= maxX
                && worldY >= minY
                && worldY <= maxY
                && worldZ >= minZ
                && worldZ <= maxZ;
        }

        public static <T extends ITileEntityMultiBlockController> Builder<T> builder(String[][] structure) {
            return new Builder<>(structure);
        }

        public Definition(String[][] structure, Map<Character, IStructureElement<T>> elements) {
            this.structure = structure;
            this.elements = elements;
            findOffsets('-');
        }

        public int[] getOffsets() {
            return new int[] { offsetX, offsetY, offsetZ };
        }

        private void findOffsets(char anchor) {
            for (byte z = 0; z < structure.length; z++)
                for (byte y = 0; y < structure[z].length; y++) for (byte x = 0; x < structure[z][y].length(); x++) {
                    if (structure[z][y].charAt(x) == anchor) {
                        this.offsetZ = z;
                        this.offsetY = y;
                        this.offsetX = x;
                    }
                }
        }

        public static class Builder<T extends ITileEntityMultiBlockController> {

            private String[][] structure;
            private Map<Character, IStructureElement<T>> elements;

            public Builder(String[][] structure) {
                this.structure = structure;
                this.elements = new HashMap<>();
            }

            public Builder<T> addElement(char symbol, StructureElementPart<T> part) {
                elements.putIfAbsent(symbol, part);
                return this;
            }

            public Definition<T> build() {
                Definition<T> def = new Definition<>(structure, elements);
                return def;
            }
        }

        public boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int tX, int tY,
            int tZ) {
            for (byte z = 0; z < structure.length; z++)
                for (byte y = 0; y < structure[z].length; y++) for (byte x = 0; x < structure[x][y].length(); x++) {
                    char symbol = structure[z][y].charAt(x);
                    if (symbol == '-' || symbol == ' ') continue;
                    IStructureElement<T> element = elements.get(symbol);
                    if (element == null) {
                        ERR.println(String.format("MultiHelper: Symbol '%s' is not defined!", symbol));
                        continue;
                    }

                    int worldX = tX + (x - offsetX);
                    int worldY = tY + (y - offsetY);
                    int worldZ = tZ + (z - offsetZ);

                    if (!element.check(t, aCoordinates, aPlayer, aInventory, worldX, worldY, worldZ)) return F;
                }
            return T;
        }
    }

}
