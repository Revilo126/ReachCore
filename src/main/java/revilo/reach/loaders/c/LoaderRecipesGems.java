package revilo.reach.loaders.c;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;
import static gregapi.data.TD.Atomic.*;
import static gregapi.data.TD.Processing.*;

import gregapi.code.ICondition.And;
import gregapi.data.RM;
import gregapi.recipes.handlers.RecipeMapHandlerPrefix;
import gregapi.util.ST;

public class LoaderRecipesGems implements Runnable {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void run() {
        OUT.println("Reach: Loading Gem Recipes.");
        // Autoclave can take long so now you can use engraver, mainly here so it's easier to make fiber cable.
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                1,
                NF,
                16,
                64,
                0,
                NF,
                gemChipped,
                1,
                ST.tag(0),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                2,
                NF,
                16,
                128,
                0,
                NF,
                gemFlawed,
                1,
                ST.tag(1),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                4,
                NF,
                16,
                256,
                0,
                NF,
                gem,
                1,
                ST.tag(2),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                8,
                NF,
                16,
                512,
                0,
                NF,
                gemFlawless,
                1,
                ST.tag(3),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                16,
                NF,
                16,
                1024,
                0,
                NF,
                gemExquisite,
                1,
                ST.tag(4),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dustSmall,
                32,
                NF,
                16,
                2048,
                0,
                NF,
                gemLegendary,
                1,
                ST.tag(5),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));

        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                1,
                NF,
                16,
                64,
                0,
                NF,
                gemChipped,
                4,
                ST.tag(0),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                1,
                NF,
                16,
                128,
                0,
                NF,
                gemFlawed,
                2,
                ST.tag(1),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                1,
                NF,
                16,
                256,
                0,
                NF,
                gem,
                1,
                ST.tag(2),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                2,
                NF,
                16,
                512,
                0,
                NF,
                gemFlawless,
                1,
                ST.tag(3),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                4,
                NF,
                16,
                1024,
                0,
                NF,
                gemExquisite,
                1,
                ST.tag(4),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                dust,
                8,
                NF,
                16,
                2048,
                0,
                NF,
                gemLegendary,
                1,
                ST.tag(5),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));

        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                1,
                NF,
                16,
                64,
                0,
                NF,
                gemChipped,
                4,
                ST.tag(0),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                1,
                NF,
                16,
                128,
                0,
                NF,
                gemFlawed,
                2,
                ST.tag(1),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                1,
                NF,
                16,
                256,
                0,
                NF,
                gem,
                1,
                ST.tag(2),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                2,
                NF,
                16,
                512,
                0,
                NF,
                gemFlawless,
                1,
                ST.tag(3),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                4,
                NF,
                16,
                1024,
                0,
                NF,
                gemExquisite,
                1,
                ST.tag(4),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
        RM.LaserEngraver.add(
            new RecipeMapHandlerPrefix(
                gem,
                8,
                NF,
                16,
                2048,
                0,
                NF,
                gemLegendary,
                1,
                ST.tag(5),
                NI,
                T,
                F,
                F,
                new And(ANTIMATTER.NOT, CRYSTALLISABLE)));
    }

}
