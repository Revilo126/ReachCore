package revilo.reach.loaders.a;

import revilo.reach.data.CS;
import revilo.reach.data.RCMD;
import revilo.reach.items.MultiItemTechnological;

public class ItemLoader implements Runnable {

    @Override
    public void run() {
        CS.ItemsReach.TECH = new MultiItemTechnological(RCMD.RC.mID, "reach.multiitem.technological");

        CS.ItemsReach.ALL_MULTI_ITEMS[0] = CS.ItemsReach.TECH;
    }
}
