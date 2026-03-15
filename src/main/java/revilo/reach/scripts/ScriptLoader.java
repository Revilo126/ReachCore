package revilo.reach.scripts;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;
import revilo.reach.recipes.RecipeUtil;

/*
 * @author Revilo
 * Although most mods are not compiled in this core mod, you should directly try to access Items, this is due to the
 * fact you should normally test by adding to modpack!
 * 
 * If needed it is possible to run from Dev Env.
 */

public class ScriptLoader implements Runnable {

    @Override
    public void run() {
        // Make sure Recipe util is always last!
        ArrayListNoNulls<IScriptLoader> tScriptList = new ArrayListNoNulls<>(
            F,
            new ScriptMinecraft(),
            new ScriptAE2(),
            new ScriptBackpacks(),
            new ScriptMatterOverdrive(),
            new ScriptPersonalDim(),
            new ScriptAvaritia(),
            new ScriptGregTech());
        for (IScriptLoader tScript : tScriptList) try {
            if (tScript.isScriptLoadable()) {
                tScript.loadRecipes();
                OUT.println(String.format("Script \"%s\" was loaded properly.", tScript.getScriptName()));
            } else {
                ERR.print(
                    String.format(
                        "Script \"%s\" could not be loaded as it's dependencies are missing!",
                        tScript.getScriptName()));
            }
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }

        try {
            new RecipeUtil().run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
