package revilo.reach.scripts;

import java.util.Arrays;
import java.util.List;

import gregapi.data.CS.ModIDs;

public class ScriptAdvRocketry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Advanced Rocketry Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GC_ADV_ROCKETRY, ModIDs.VULPES);
    }

    @Override
    public void loadRecipes() {}

    @Override
    public void loadMachines() {}

}
