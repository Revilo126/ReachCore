package revilo.reach.scripts;

import java.util.List;

import cpw.mods.fml.common.Loader;

/**
 * Base Interface for Recipe Scripts.
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

    /**
     * Method to override in order to load the recipes
     */
    void loadRecipes();

    /*
     * Machine Recipes to run in PostInit
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
}
