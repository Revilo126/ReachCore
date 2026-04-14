package revilo.reach.data;

import gregapi.block.BlockBase;
import gregapi.block.IPrefixBlock;
import gregapi.item.multiitem.MultiItemRandom;

/**
 * Constants
 */
public class RCCS {

    public static final String TEX_DIR = "textures/", TEX_DIR_GUI = TEX_DIR + "gui/", TEX_DIR_ITEM = TEX_DIR + "items/",
        TEX_DIR_MODEL = TEX_DIR + "model/", TEX_DIR_BLOCK = TEX_DIR + "blocks/", TEX_DIR_ARMOR = TEX_DIR + "armor/",
        TEX_DIR_ENTITY = TEX_DIR + "entity/", RES_PATH = RCMD.RC.mID + ":" + TEX_DIR,
        RES_PATH_GUI = RCMD.RC.mID + ":" + TEX_DIR_GUI, RES_PATH_ITEM = RCMD.RC.mID + ":",
        RES_PATH_BLOCK = RCMD.RC.mID + ":", RES_PATH_MODEL = RCMD.RC.mID + ":" + TEX_DIR_MODEL,
        RES_PATH_ARMOR = RCMD.RC.mID + ":" + TEX_DIR_ARMOR, RES_PATH_ENTITY = RCMD.RC.mID + ":" + TEX_DIR_ENTITY;

    public static class Chat {

        public static String specialChar = "\u00a7";
    }

    public static class ModIds {

        public static final String REACH = "reach", BP = "Backpack", PerDim = "personalspace", AE2FC = "ae2fc";
    }

    public static class ItemsReach {

        public static MultiItemRandom TECH;
        public static MultiItemRandom[] ALL_MULTI_ITEMS = new MultiItemRandom[] { TECH };
    }

    public static class BlocksReach {

        // Stones (Planets)
        public static BlockBase Alkalai, Tungle, Vita, Sulf, Adam;
        // Contains all Reach stone types
        public static BlockBase[] stones = { Alkalai, Tungle, Vita, Sulf, Adam };
        // Contains the Ore Blocks for all the Reach Type Stones
        public static IPrefixBlock[] ores_normal = new IPrefixBlock[stones.length],
            ores_broken = new IPrefixBlock[stones.length], ores_small = new IPrefixBlock[stones.length];
    }
}
