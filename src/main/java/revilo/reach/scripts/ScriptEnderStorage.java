package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import revilo.reach.data.RCCS.ModIds;
import revilo.reach.data.RCMD;

@SuppressWarnings("unused")
public class ScriptEnderStorage implements IScriptLoader {

    ItemStack enderchest = make(RCMD.ES, "enderchest", 1, 0);

    @Override
    public String getScriptName() {
        return "EnderStorage Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIds.ES);
    }

    @Override
    public void loadRecipes() {}

    @Override
    public void loadMachines() {}

}
