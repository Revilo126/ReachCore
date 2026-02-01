package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import net.minecraft.init.Items;

import gregapi.data.MT;
import gregapi.util.ST;
import revilo.reach.api.data.RCMD;

@SuppressWarnings("unused")
public class RecipesBackpacks implements Runnable {

    @Override
    public void run() {
        Loom.addRecipe2(T, 16, 128, ST.tag(0), ST.make(Items.leather, 4, 0), ST.make(RCMD.BP, "backpack", 1, 0));
        Loom.addRecipeX(
            T,
            16,
            128,
            ST.array(ST.tag(1), ST.make(Items.leather, 8, 0), ring.mat(MT.Al, 4)),
            ST.make(RCMD.BP, "backpack", 1, 100));
        Loom.addRecipeX(
            T,
            16,
            128,
            ST.array(ST.tag(2), ST.make(Items.leather, 16, 0), ring.mat(MT.Cr, 4)),
            ST.make(RCMD.BP, "backpack", 1, 200));

        for (byte i = 0; i < 16; i++) {
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
        }

    }

}
