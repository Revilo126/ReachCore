package revilo.reach.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import gregapi.data.OD;
import gregapi.data.RM;
import gregapi.util.CR;

public class RecipesMinecraft {

    public void postInit() {
        CR.delate(new ItemStack(Blocks.crafting_table));
        //CR.shaped(new ItemStack(Blocks.crafting_table), CR.DEF_REV_NCC | CR.DEL_OTHER_SHAPED_RECIPES, "FK", "LA", "F", Items.flint, "K", OreDictionary.getOres("craftingToolKnife"), "L", OD.logWood, "A", OreDictionary.getOres("craftingToolAxe"));

        //RecipeUtil.removeAllRecipes(RM.Unboxinator, new ItemStack(Items.stick));
    };

}
