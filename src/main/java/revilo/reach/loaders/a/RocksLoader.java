package revilo.reach.loaders.a;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import gregapi.block.behaviors.Drops_SmallOre;
import gregapi.block.metatype.BlockStones;
import gregapi.block.prefixblock.PrefixBlock_;
import gregapi.data.OP;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.BlockTextureDefault;
import revilo.reach.blocks.stone.BlockStoneRC;
import revilo.reach.data.RCCS.BlocksReach;
import revilo.reach.data.RCMD;
import revilo.reach.data.RCMT;
import revilo.reach.data.RCOP;

public class RocksLoader implements Runnable {

    @Override
    public void run() {
        BlockStones tStone;

        int n = 0;
        BlocksReach.stones[n] = BlocksReach.Alkalai = tStone = new BlockStoneRC(
            "reach.stone.alkalai",
            RCMT.STONES.Alkalai,
            0.75F,
            0.50F,
            0,
            F);
        BlocksReach.ores_normal[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.normal.alkalai",
            RCOP.oreAlkalai,
            null,
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            0.50F,
            0.75F,
            0,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_broken[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.broken.alkalai",
            RCOP.oreAlkalai,
            null,
            BlockTextureDefault.get(tStone.mIcons[1]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            0.25F,
            0.37F,
            -1,
            tStone.mHarvestLevel - 1,
            T,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_small[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.small.alkalai",
            OP.oreSmall,
            new Drops_SmallOre(tStone.mMaterial),
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            0.50F,
            0.75F,
            -1,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);

        n++;
        BlocksReach.stones[n] = BlocksReach.Tungle = tStone = new BlockStoneRC(
            "reach.stone.tungle",
            RCMT.STONES.Tungle,
            3.00F,
            2.00F,
            0,
            F);
        BlocksReach.ores_normal[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.normal.tungle",
            RCOP.oreTungle,
            null,
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            0,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_broken[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.broken.tungle",
            RCOP.oreTungle,
            null,
            BlockTextureDefault.get(tStone.mIcons[1]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            1.00F,
            1.50F,
            -1,
            tStone.mHarvestLevel - 1,
            T,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_small[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.small.tungle",
            OP.oreSmall,
            new Drops_SmallOre(tStone.mMaterial),
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            -1,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);

        n++;
        BlocksReach.stones[n] = BlocksReach.Vita = tStone = new BlockStoneRC(
            "reach.stone.vita",
            RCMT.STONES.Vita,
            3.00F,
            2.00F,
            0,
            F);
        BlocksReach.ores_normal[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.normal.vita",
            RCOP.oreVita,
            null,
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            0,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_broken[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.broken.vita",
            RCOP.oreVita,
            null,
            BlockTextureDefault.get(tStone.mIcons[1]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            1.00F,
            1.50F,
            -1,
            tStone.mHarvestLevel - 1,
            T,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_small[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.small.vita",
            OP.oreSmall,
            new Drops_SmallOre(tStone.mMaterial),
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            -1,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);

        n++;
        BlocksReach.stones[n] = BlocksReach.Sulf = tStone = new BlockStoneRC(
            "reach.stone.sulf",
            RCMT.STONES.Sulf,
            3.00F,
            2.00F,
            0,
            F);
        BlocksReach.ores_normal[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.normal.sulf",
            RCOP.oreSulf,
            null,
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            0,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_broken[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.broken.sulf",
            RCOP.oreSulf,
            null,
            BlockTextureDefault.get(tStone.mIcons[1]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            1.00F,
            1.50F,
            -1,
            tStone.mHarvestLevel - 1,
            T,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_small[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.small.sulf",
            OP.oreSmall,
            new Drops_SmallOre(tStone.mMaterial),
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            -1,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);

        n++;
        BlocksReach.stones[n] = BlocksReach.Adam = tStone = new BlockStoneRC(
            "reach.stone.adam",
            RCMT.STONES.Adam,
            3.00F,
            2.00F,
            0,
            F);
        BlocksReach.ores_normal[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.normal.adam",
            RCOP.oreAdam,
            null,
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            0,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_broken[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.broken.adam",
            RCOP.oreAdam,
            null,
            BlockTextureDefault.get(tStone.mIcons[1]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            1.00F,
            1.50F,
            -1,
            tStone.mHarvestLevel - 1,
            T,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
        BlocksReach.ores_small[n] = new PrefixBlock_(
            RCMD.RC,
            "reach.meta.ore.small.adam",
            OP.oreSmall,
            new Drops_SmallOre(tStone.mMaterial),
            BlockTextureDefault.get(tStone.mIcons[0]),
            Material.rock,
            Block.soundTypeStone,
            TOOL_pickaxe,
            2.00F,
            3.00F,
            -1,
            tStone.mHarvestLevel,
            F,
            F,
            OreDictMaterial.MATERIAL_ARRAY);
    }

}
