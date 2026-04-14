package revilo.reach.blocks.stone;

import static gregapi.data.CS.*;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.IBlockAccess;

import gregapi.block.metatype.BlockMetaType;
import gregapi.block.metatype.BlockStones;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.IIconContainer;

public class BlockStoneRC extends BlockStones {

    public final boolean mWitherProof;

    public BlockStoneRC(String aName, OreDictMaterial aMaterial, float aResistanceMultiplier, float aHardnessMultiplier,
        int aHarvestLevel, boolean aWitherProof) {
        super(
            null,
            null,
            null,
            aName,
            aMaterial.getLocal(),
            aMaterial,
            aResistanceMultiplier,
            aHardnessMultiplier,
            aHarvestLevel,
            null);
        mWitherProof = aWitherProof;
    }

    @Override
    protected BlockMetaType makeSlab(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial,
        SoundType aVanillaSoundType, String aName, String aDefaultLocalised, OreDictMaterial aMaterial,
        float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons,
        byte aSlabType, BlockMetaType aBlock) {
        return new BlockStoneRC(
            aItemClass,
            aVanillaMaterial,
            aVanillaSoundType,
            aName,
            aDefaultLocalised,
            aMaterial,
            aResistanceMultiplier,
            aHardnessMultiplier,
            aHarvestLevel,
            aCount,
            aIcons,
            aSlabType,
            aBlock);
    }

    protected BlockStoneRC(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial,
        SoundType aVanillaSoundType, String aName, String aDefaultLocalised, OreDictMaterial aMaterial,
        float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons,
        byte aSlabType, BlockMetaType aBlock) {
        super(
            aItemClass,
            aVanillaMaterial,
            aVanillaSoundType,
            aName,
            aDefaultLocalised,
            aMaterial,
            aResistanceMultiplier,
            aHardnessMultiplier,
            aHarvestLevel,
            aCount,
            aIcons,
            aSlabType,
            aBlock);
        mWitherProof = ((BlockStoneRC) aBlock).mWitherProof;
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess aWorld, int aX, int aY, int aZ, Entity aEntity) {
        return (mWitherProof && aEntity instanceof EntityWither) ? F
            : super.canEntityDestroy(aWorld, aX, aY, aZ, aEntity);
    }
}
