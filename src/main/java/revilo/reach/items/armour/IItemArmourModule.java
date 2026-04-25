package revilo.reach.items.armour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IItemArmourModule {

    /*
     * Requirements for said module.
     */
    public int getRequiredSlot();

    public long getRequiredEnergy();

    /*
     * Runs on the Armour's tick.
     */
    public void onModuleTick(EntityPlayer player, ItemStack armour, ItemArmourModular container);;

    /*
     * Extra states.
     */
    default void onInstalled(ItemStack armour) {}

    default void onRemoved(ItemStack armour) {}

}
