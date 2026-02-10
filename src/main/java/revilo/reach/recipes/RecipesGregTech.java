package revilo.reach.recipes;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import net.minecraft.item.ItemStack;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.ANY;
import gregapi.data.MT;

@SuppressWarnings("unused")
public class RecipesGregTech implements Runnable {

    @Override
    public void run() {
        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity"); // Needed for
                                                                                                       // accessing gt
                                                                                                       // tiles

        machines(aRegistry);
        cables(aRegistry);
    }

    private void machines(MultiTileEntityRegistry aRegistry) {
        // TODO
    }

    private void cables(MultiTileEntityRegistry aRegistry) {
        ItemStack fiberCable = aRegistry.getItem(24900);
        delate(fiberCable);
        shaped(
            fiberCable,
            DEF,
            "GCG",
            "RSD",
            "w x",
            'G',
            blockGlassColorless,
            'C',
            OD_CIRCUITS[3],
            'R',
            gemFlawless.dat(MT.Redstone),
            'S',
            dust.dat(MT.Ag),
            'D',
            gemFlawless.dat(ANY.Diamond));

    }

}
