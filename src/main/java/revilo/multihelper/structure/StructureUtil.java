package revilo.multihelper.structure;

import static gregapi.data.CS.*;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ChunkCoordinates;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;

public class StructureUtil {

    public static int getRegistryID(MultiTileEntityRegistry aRegistry) {
        return 0; // TODO
    }

    public static class Definition<T extends ITileEntityMultiBlockController> {

        private String[][] structure;
        private Map<Character, StructureElementPart<T>> elements;
        public int offsetX, offsetY, offsetZ;

        public int[] getOffsets() {
            return new int[] { offsetX, offsetY, offsetZ };
        }

        public static <T extends ITileEntityMultiBlockController> Builder<T> builder(String[][] structure) {
            return new Builder<>(structure);
        }

        public Definition(String[][] structure, Map<Character, StructureElementPart<T>> elements) {
            this.structure = structure;
            this.elements = elements;
            findAnchor('-');
        }

        private void findAnchor(char anchor) {
            for (int y = 0; y < structure.length; y++) {
                for (int z = 0; z < structure[y].length; z++) {
                    int x = structure[y][z].indexOf(anchor);
                    if (x != -1) {
                        this.offsetX = x;
                        this.offsetY = y;
                        this.offsetZ = z;
                        return;
                    }
                }
            }
        }

        public static class Builder<T extends ITileEntityMultiBlockController> {

            private String[][] structure;
            private Map<Character, StructureElementPart<T>> elements;

            public Builder(String[][] structure) {
                this.structure = structure;
                this.elements = new HashMap<>();
            }

            public Builder<T> addElement(char symbol, StructureElementPart<T> part) {
                elements.putIfAbsent(symbol, part);
                return this;
            }

            public Definition<T> build() {
                return new Definition<>(structure, elements);
            }
        }

        public boolean check(T t, ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory, int tX, int tY,
            int tZ) {
            for (int y = 0; y < structure.length; y++) {
                for (int z = 0; z < structure[y].length; z++) {
                    String row = structure[y][z];
                    for (int x = 0; x < row.length(); x++) {
                        char symbol = row.charAt(x);
                        // Checks if its the controller
                        if (symbol == '-') continue;
                        StructureElementPart<T> part = elements.get(symbol);
                        // Checks if its air. This means if you forget to add a block to the map it will consider it
                        // air!
                        if (part == null) continue;

                        int worldX = tX + (x - offsetX);
                        int worldY = tY + (y - offsetY);
                        int worldZ = tZ + (z - offsetZ);

                        if (!part.check(t, aCoordinates, aPlayer, aInventory, worldX, worldY, worldZ)) return F;

                    }
                }
            }
            return T;
        }
    }

}
