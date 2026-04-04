package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import gregapi.data.MT;
import gregapi.util.ST;
import revilo.reach.data.RCCS.ModIds;
import revilo.reach.data.RCMD;

@SuppressWarnings("unused")
public class ScriptBackpacks implements IScriptLoader {

    @Override
    public void loadRecipes() {

    }

    @Override
    public void loadMachines() {
        delate(ST.make(RCMD.BP, "backpack", 1, 0));
        Loom.addRecipe2(T, 16, 128, ST.tag(0), ST.make(Items.leather, 4, 0), ST.make(RCMD.BP, "backpack", 1, 0));
        delate(ST.make(RCMD.BP, "backpack", 1, 100));
        Loom.addRecipeX(
            T,
            16,
            256,
            ST.array(ST.tag(1), ST.make(Items.leather, 8, 0), ring.mat(MT.Al, 4)),
            ST.make(RCMD.BP, "backpack", 1, 100));
        delate(ST.make(RCMD.BP, "backpack", 1, 200));
        Loom.addRecipeX(
            T,
            16,
            512,
            ST.array(ST.tag(2), ST.make(Items.leather, 16, 0), ring.mat(MT.Cr, 4)),
            ST.make(RCMD.BP, "backpack", 1, 200));

        delate(ST.make(RCMD.BP, "workbenchbackpack", 1, 17));
        Loom.addRecipeX(
            T,
            16,
            128,
            ST.array(ST.tag(3), ST.make(RCMD.BP, "backpack", 1, 0), ST.make(Blocks.crafting_table, 1, 0)),
            ST.make(RCMD.BP, "workbenchbackpack", 1, 17));

        delate(ST.make(RCMD.BP, "workbenchbackpack", 1, 17));
        Loom.addRecipeX(
            T,
            16,
            128,
            ST.array(ST.tag(3), ST.make(RCMD.BP, "backpack", 1, 200), ST.make(Blocks.crafting_table, 1, 0)),
            ST.make(RCMD.BP, "workbenchbackpack", 1, 217));

        delate(ST.make(RCMD.BP, "backpack", 1, 31999));
        Loom.addRecipeX(
            T,
            16,
            128,
            ST.array(ST.tag(4), ST.make(RCMD.BP, "backpack", 1, 0), ST.make(Blocks.ender_chest, 1, 0)),
            ST.make(RCMD.BP, "backpack", 1, 31999));

        for (byte i = 0; i < 16; i++) {
            delate(ST.make(RCMD.BP, "backpack", 1, i + 1));
            Bath.addRecipe1(
                T,
                0,
                16,
                ST.make(RCMD.BP, "backpack", 1, 0),
                DYE_FLUIDS_WATER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 1));
            Bath.addRecipe1(
                T,
                0,
                16,
                ST.make(RCMD.BP, "backpack", 1, 0),
                DYE_FLUIDS_FLOWER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 1));
            Bath.addRecipe1(
                T,
                0,
                16,
                ST.make(RCMD.BP, "backpack", 1, 0),
                DYE_FLUIDS_CHEMICAL[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 1));

            delate(ST.make(RCMD.BP, "backpack", 1, i + 100));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 100),
                DYE_FLUIDS_WATER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 100));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 100),
                DYE_FLUIDS_FLOWER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 100));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 100),
                DYE_FLUIDS_CHEMICAL[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 100));

            delate(ST.make(RCMD.BP, "backpack", 1, i + 200));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 200),
                DYE_FLUIDS_WATER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 200));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 200),
                DYE_FLUIDS_FLOWER[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 200));
            Bath.addRecipe1(
                T,
                0,
                64,
                ST.make(RCMD.BP, "backpack", 1, 200),
                DYE_FLUIDS_CHEMICAL[i],
                NF,
                ST.make(RCMD.BP, "backpack", 1, i + 200));
        }
    }

    @Override
    public String getScriptName() {
        return "Adventure Backpacks Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIds.BP);
    }

}
