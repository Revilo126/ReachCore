package revilo.reach.scripts;

import gregapi.code.ModData;

import java.util.List;

import cpw.mods.fml.common.Loader;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
    default ModData getModData() {}

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

    /*
    * Creates an itemstack with NBT.
    */
    default ItemStack make(ModData mModData, String aName, long aSize, long aMeta, NBTTagCompound aNBT) {
        ItemStack aStack = ST.make(mModData, aName, aSize, aMeta);
        if (aStack != null) ItemStack aStackNBT = ST.nbt(aStack, aNBT);
        if (aStackNBT != null) return aStackNBT;
        return null;
    }

     default ItemStack make(String aName, long aSize, long aMeta, NBTTagCompound aNBT) {
         ItemStack aStack = make(getModData(), aName, aSize, aMeta, aNBT);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(String aName, long aSize, long aMeta) {
         ItemStack aStack = make(aName, aSize, aMeta, null);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(String aName, long aSize) {
         ItemStack aStack = make(aName, aSize, 0);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(String aName) {
         ItemStack aStack = make(aName, 1);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(ModData aModData, String aName, long aSize, long aMeta) {
         ItemStack aStack = make(aModData, aName, aSize, aMeta, null);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(ModData aModData, String aName, long aSize) {
         ItemStack aStack = make(aModData, aName, aSize, 0);
        if (aStack != null) return aStack;
        return null;
     }

    default ItemStack make(ModData aModData, String aName) {
         ItemStack aStack = make(aModData, aName, 1);
        if (aStack != null) return aStack;
        return null;
     }
}
