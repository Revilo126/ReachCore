package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.IL.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregapi.data.MT;
import revilo.reach.recipes.RecipeUtil;

@SuppressWarnings("unused")
public class ScriptMatterOverdrive implements IScriptLoader {

    ItemStack androidHead = make(MO, "rouge_android_part", 1, 0), androidArm = make(MO, "rouge_android_part", 1, 1),
        androidLeg = make(MO, "rouge_android_part", 1, 2), androidChest = make(MO, "rouge_android_part", 1, 3),
        tritaniumSpine = make(MO, "tritainum_spine", 1, 0);

    @Override
    public void loadRecipes() {
        for (byte i = 0; i < 16; i++) {
            RecipeUtil.nuke(make(MO, "tritanium_crate." + DYE_NAMES[i].toLowerCase(), 1, 0));
        }

        shaped(
            androidHead,
            DEF_REM_REV_NCC,
            "LFC",
            "SKE",
            "TAO",
            'L',
            Processor_Crystal_Diamond.get(1),
            'F',
            Field_Generator_IV.get(1),
            'C',
            Processor_Crystal_Ruby.get(1),
            'S',
            Sensor_IV.get(1),
            'K',
            make(Items.skull, 1, 0),
            'E',
            Emitter_IV.get(1),
            'T',
            Processor_Crystal_Emerald.get(1),
            'A',
            plateCurved.mat(MT.Trinitanium, 1),
            'O',
            Processor_Crystal_Sapphire.get(1));
    }

    @Override
    public void loadMachines() {

    }

    @Override
    public String getScriptName() {
        return "Matter Overdrive Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.MO);
    }

}
