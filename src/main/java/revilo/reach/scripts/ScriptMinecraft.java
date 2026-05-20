package revilo.reach.scripts;

import static gregapi.data.OP.*;
import static gregapi.util.CR.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregapi.data.CS.ModIDs;
import gregapi.data.MT;
import revilo.reach.recipes.RecipeUtil;

public class ScriptMinecraft implements IScriptLoader {

    ItemStack bed = make("bed", 1, 0);

    @Override
    public void loadRecipes() {
        shaped(
            bed,
            DEF_REM_REV,
            "WWW",
            "RPR",
            "SdS",
            'W',
            make(Blocks.wool, 1, 0),
            'R',
            stick.mat(MT.Pb, 1),
            'P',
            "plankWood",
            'S',
            screw.mat(MT.Pb, 1));

        String[] tiers = { "iron", "wooden", "stone", "golden", "diamond" };
        for (byte i = 0; i < 5; i++) {
            RecipeUtil.nuke(make(tiers[i] + "_sword", 1, 0));
            RecipeUtil.nuke(make(tiers[i] + "_pickaxe", 1, 0));
            RecipeUtil.nuke(make(tiers[i] + "_axe", 1, 0));
            RecipeUtil.nuke(make(tiers[i] + "_shovel", 1, 0));
            RecipeUtil.nuke(make(tiers[i] + "_hoe", 1, 0));
        }
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Minecraft Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GT); // This doesn't need dependencies as it is the game.
    }

}
