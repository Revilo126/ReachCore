package revilo.reach.scripts;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.Loader;
import gregapi.code.ModData;
import gregapi.data.MD;
import gregapi.util.ST;

/**
 * Base Interface for Recipe Scripts.
 * 
 * @author Revilo12
 */
public interface IScriptLoader {

    /**
     * Acquire the script name for logging purposes
     * 
     * @return the name of the script
     */
    String getScriptName();

    /**
     * Generally is the mod the script was made for. E.g AE2.
     * 
     * @return a list of dependencies required to load the script
     */
    List<String> getDependencies();

    /*
     * Get the default ModData for use in ItemStacks.
     */
    default ModData getModData() {
        return MD.MC;
    }

    /**
     * Method to override in order to load the recipes. Runs in Post-Init.
     */
    void loadRecipes();

    /*
     * Load the recipes of Machines. Runs in Pre-Init.
     */
    void loadMachines();

    /**
     * Method to know if a script is loadable.
     * 
     * @return a boolean if the script is loadable
     */
    default boolean isScriptLoadable() {
        for (String dep : getDependencies()) {
            if (!Loader.isModLoaded(dep)) {
                return false;
            }
        }
        return true;
    }

    // Utility functions //

    /*
     * Creates an itemstack with NBT.
     */
    default ItemStack make(ModData mModData, String aName, long aSize, long aMeta, NBTTagCompound aNBT) {
        ItemStack aStack = ST.make(mModData, aName, aSize, aMeta);
        ItemStack aStackNBT = null;
        if (ST.valid(aStack)) aStackNBT = ST.nbt(aStack, aNBT);
        if (ST.valid(aStackNBT)) return aStackNBT;
        return null;
    }

    default ItemStack make(String aName, long aSize, long aMeta, NBTTagCompound aNBT) {
        ItemStack aStack = make(getModData(), aName, aSize, aMeta, aNBT);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(String aName, long aSize, long aMeta) {
        ItemStack aStack = ST.make(getModData(), aName, aSize, aMeta);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(String aName, long aSize) {
        ItemStack aStack = make(aName, aSize, 0);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(String aName) {
        ItemStack aStack = make(aName, 1);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(ModData aModData, String aName, long aSize, long aMeta) {
        ItemStack aStack = ST.make(aModData, aName, aSize, aMeta);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(ModData aModData, String aName, long aSize) {
        ItemStack aStack = make(aModData, aName, aSize, 0);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(ModData aModData, String aName) {
        ItemStack aStack = make(aModData, aName, 1);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(Item aItem, long aSize, long aMeta) {
        ItemStack aStack = make(aItem, aSize, aMeta);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

    default ItemStack make(Block aBlock, long aSize, long aMeta) {
        ItemStack aStack = make(aBlock, aSize, aMeta);
        if (ST.valid(aStack)) return aStack;
        return null;
    }

}
