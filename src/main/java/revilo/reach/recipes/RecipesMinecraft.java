package revilo.reach.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import gregapi.util.CR;

public class RecipesMinecraft {

    public void postInit(FMLPostInitializationEvent aEvent) {
        CR.delate(new ItemStack(Blocks.crafting_table));
    };

}
