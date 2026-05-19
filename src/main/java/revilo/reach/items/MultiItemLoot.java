package revilo.reach.items;

import static revilo.reach.data.RCIL.*;

import gregapi.item.CreativeTab;
import gregapi.item.multiitem.MultiItemRandomWithCompat;
import gregapi.item.multiitem.behaviors.Behavior_Drop_Loot;

public class MultiItemLoot extends MultiItemRandomWithCompat {

    public MultiItemLoot(String aModID, String aUnlocalized) {
        super(aModID, aUnlocalized);
        setCreativeTab(new CreativeTab(getUnlocalizedName(), "Reach: Loot", this, (short) 1));
    }

    @Override
    public void addItems() {
        Bag_Loot_Steam.set(addItem(0, "Loot Pouch", "Loot: Steam Age Items", new Behavior_Drop_Loot("reach.steam")));
        Bag_Loot_LV.set(addItem(1, "Loot Pouch", "Loot: Low Voltage Items", new Behavior_Drop_Loot("reach.lv")));
    }
}
