package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.data.RCCS.ModIds;
import revilo.reach.data.RCMD;

@SuppressWarnings("unused")
public class ScriptEnderStorage implements IScriptLoader {

    ItemStack enderChest = make(RCMD.ES, "enderChest", 1, 0), enderTank = make(RCMD.ES, "enderChest", 1, 4096),
        enderBackpack = make(RCMD.ES, "enderPouch", 1, 0);

    @Override
    public String getScriptName() {
        return "EnderStorage Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIds.ES);
    }

    @Override
    public void loadRecipes() {
        shaped(
            enderChest,
            DEF_REM_REV,
            "wSd",
            "CNC",
            "OSO",
            'S',
            plate.mat(MT.ObsidianSteel, 1),
            'C',
            IL.Circuit_Enderium.get(1),
            'N',
            ST.make(MD.GT, "gt.multitileentity", 1, 51),
            'O',
            plate.mat(MT.Obsidian, 1));
        shaped(
            enderChest,
            DEF_REM_REV,
            "wSd",
            "CNC",
            "OSO",
            'S',
            plate.mat(MT.ObsidianSteel, 1),
            'C',
            IL.Circuit_Enderium.get(1),
            'N',
            ST.make(MD.GT, "gt.multitileentity", 1, 32087),
            'O',
            plate.mat(MT.Obsidian, 1));
        delate(enderBackpack);
    }

    @Override
    public void loadMachines() {
        RM.Loom.addRecipe2(T, 128, 256, enderChest, ST.make(RCMD.BP, "backpack", 1, 0), enderBackpack);
    }

}
