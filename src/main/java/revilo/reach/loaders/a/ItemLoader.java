package revilo.reach.loaders.a;

import revilo.reach.data.RCCS;
import revilo.reach.data.RCMD;
import revilo.reach.items.MultiItemTechnological;
import revilo.reach.loaders.helper.Loader;

@Loader.PreInit(priority = 1)
public class ItemLoader implements Runnable {

    @Override
    public void run() {
        RCCS.ItemsReach.TECH = new MultiItemTechnological(RCMD.RC.mID, "reach.multiitem.technological");

        RCCS.ItemsReach.ALL_MULTI_ITEMS[0] = RCCS.ItemsReach.TECH;
    }
}
