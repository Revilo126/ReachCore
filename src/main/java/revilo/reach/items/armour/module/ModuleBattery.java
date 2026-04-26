package revilo.reach.items.armour.module;

import net.minecraft.item.ItemStack;

public class ModuleBattery implements IArmorModule {

    @Override
    public String getID() {
        return "battery";
    }

    @Override
    public long modifyCapacity(long base, int level, ItemStack stack) {
        return base * (1L << (level - 1));
    }
}
