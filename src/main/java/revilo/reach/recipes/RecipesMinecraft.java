package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.ANY;
import gregapi.data.MT;

public class RecipesMinecraft implements Runnable {

    @Override
    public void run() {
        shaped(make(MC, "crafting_table", 1), DEF_REM_REV, "Xk", "La", 'X', make(MC, "flint", 1), 'L', logWood);

        shaped(make(MC, "chest", 1), DEF_REM_REV, "LPL", "PaP", "LPL", 'L', logWood, 'P', plankWood);

        shaped(make(MC, "furnace", 1), DEF_REM_REV, " S ", "SfS", " Sh", 'S', cobblestone, 'f', craftingFirestarter);
        shaped(
            make(MC, "furnace", 1),
            DEF_NCC,
            " S ",
            "SfS",
            " Sh",
            'S',
            stone.dat(MT.STONES.Basalt),
            'f',
            craftingFirestarter);
        shaped(
            make(MC, "furnace", 1),
            DEF_NCC,
            " S ",
            "SfS",
            " Sh",
            'S',
            rockGt.dat(ANY.Stone),
            'f',
            craftingFirestarter);

        ArrayListNoNulls<Item> tTools = new ArrayListNoNulls<>(
            F,
            Items.iron_sword,
            Items.iron_pickaxe,
            Items.iron_axe,
            Items.iron_shovel,
            Items.iron_hoe,
            Items.wooden_sword,
            Items.wooden_pickaxe,
            Items.wooden_axe,
            Items.wooden_shovel,
            Items.wooden_hoe,
            Items.stone_sword,
            Items.stone_pickaxe,
            Items.stone_axe,
            Items.stone_shovel,
            Items.stone_hoe,
            Items.golden_sword,
            Items.golden_pickaxe,
            Items.golden_axe,
            Items.golden_shovel,
            Items.golden_hoe,
            Items.diamond_sword,
            Items.diamond_pickaxe,
            Items.diamond_axe,
            Items.diamond_shovel,
            Items.diamond_hoe);

        for (Item i : tTools) {
            remout(new ItemStack(i));
            hide(i);
        } // TODO: (un)boxinator
    };

}
