package revilo.reach.loaders.c;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import java.util.Collection;

import net.minecraft.item.ItemStack;

import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.event.IOreDictListenerEvent;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.recipes.Recipe;
import gregapi.util.ST;
import revilo.reach.data.RCIL;
import revilo.reach.data.RCMT;
import revilo.reach.data.RCRM;

public class LoaderRecipesOthers implements Runnable {

    @Override
    public void run() {
        OUT.println("Reach: Loading Other Recipes.");
        new OreDictListenerEvent_Names() {

            @Override
            public void addAllListeners() {
                addListener(DYE_OREDICTS_LENS[DYE_INDEX_Red], new IOreDictListenerEvent() {

                    @Override
                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
                        RM.LaserEngraver.addRecipe2(
                            T,
                            16,
                            64,
                            foil.mat(MT.Nq, 4),
                            ST.amount(0, aEvent.mStack),
                            RCIL.Circuit_Wiring_Nano.get(1));
                        RM.LaserEngraver.addRecipe2(
                            T,
                            16,
                            64,
                            foil.mat(MT.Ubn, 4),
                            ST.amount(0, aEvent.mStack),
                            RCIL.Circuit_Wiring_Quantum_T1.get(1));
                    }
                });
            }
        };

        // Space Rocks
        RM.Centrifuge.addRecipe1(
            T,
            64,
            144,
            new long[] { 8000, 450, 450, 150 },
            blockDust.mat(RCMT.STONES.Alkalai, 1),
            dust.mat(MT.STONES.GraniteRed, 9),
            dustTiny.mat(MT.Be, 9),
            dustTiny.mat(MT.Mg, 9),
            dustTiny.mat(MT.Sr, 9));
        RM.Centrifuge.addRecipe1(
            T,
            64,
            16,
            new long[] { 8000, 450, 450, 150 },
            dust.mat(RCMT.STONES.Alkalai, 1),
            dust.mat(MT.STONES.GraniteRed, 1),
            dustTiny.mat(MT.Be, 1),
            dustTiny.mat(MT.Mg, 1),
            dustTiny.mat(MT.Sr, 1));
        RM.Centrifuge.addRecipe1(
            T,
            64,
            144,
            new long[] { 8000, 800, 100, 100 },
            blockDust.mat(RCMT.STONES.Tungle, 1),
            dust.mat(MT.STONES.Basalt, 9),
            dustTiny.mat(MT.C, 9),
            dustTiny.mat(MT.RareEarth, 9),
            dustTiny.mat(MT.Pt, 9));
        RM.Centrifuge.addRecipe1(
            T,
            64,
            16,
            new long[] { 8000, 800, 100, 100 },
            dust.mat(RCMT.STONES.Tungle, 1),
            dust.mat(MT.STONES.Basalt, 1),
            dustTiny.mat(MT.C, 1),
            dustTiny.mat(MT.RareEarth, 1),
            dustTiny.mat(MT.Pt, 1));

        // MultiMill copies
        Collection<Recipe> tRecipes = RM.Wiremill.mRecipeList;
        for (Recipe tRecipe : tRecipes) {
            Recipe tCopy = tRecipe.copy();
            tCopy.mInputs = new ItemStack[] { ST.tag(0), tRecipe.mInputs[0] };
            RCRM.MultiMill.add(tCopy);
        }

        tRecipes = RM.ClusterMill.mRecipeList;
        for (Recipe tRecipe : tRecipes) {
            Recipe tCopy = tRecipe.copy();
            tCopy.mInputs = new ItemStack[] { ST.tag(1), tRecipe.mInputs[0] };
            RCRM.MultiMill.add(tCopy);
        }

        tRecipes = RM.RollingMill.mRecipeList;
        for (Recipe tRecipe : tRecipes) {
            Recipe tCopy = tRecipe.copy();
            tCopy.mInputs = new ItemStack[] { ST.tag(2), tRecipe.mInputs[0] };
            RCRM.MultiMill.add(tCopy);
        }
    }
}
