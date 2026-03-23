package revilo.reach.scripts;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;
import revilo.reach.recipes.RecipeUtil;

/*
 * Although most mods are not compiled in this core mod, you should directly try to access Items, this is due to the
 * fact you should normally test by adding to modpack!
 * If needed it is possible to run from Dev Env.
 */

public class ScriptLoader implements Runnable {

    @Override
    public void run() {
        ArrayListNoNulls<IScriptLoader> tScriptList = new ArrayListNoNulls<>(
            F,
            new ScriptMinecraft(),
            new ScriptAdvRocketry(),
            new ScriptAE2(),
            new ScriptAE2FC(),
            new ScriptAvaritia(),
            new ScriptBackpacks(),
            new ScriptMatterOverdrive(),
            new ScriptPersonalDim(),
            new ScriptGregTech());
        for (IScriptLoader tScript : tScriptList) try {
            if (tScript.isScriptLoadable()) {
                tScript.loadRecipes();
                OUT.println(String.format("Reach: Script \"%s\" was loaded properly.", tScript.getScriptName()));
            } else {
                ERR.println(
                    String.format(
                        "Reach: Script \"%s\" could not be loaded as it's dependencies are missing!",
                        tScript.getScriptName()));
            }
        } catch (Throwable e) {
            ERR.println(String.format("Reach: Script \"%s\" failed to load due to errors!", tScript.getScriptName()));
            e.printStackTrace(ERR);
        }

        try {
            OUT.println(String.format("Reach: Nuking %s amount of items.", RecipeUtil.toNuke.toArray().length));
            new RecipeUtil().run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
