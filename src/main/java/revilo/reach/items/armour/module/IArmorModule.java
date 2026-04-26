package revilo.reach.items.armour.module;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import revilo.reach.items.armour.ItemElectricArmor;

public interface IArmorModule {

    /**
     * Unique ID used in NBT E.g Battery
     */
    String getID();

    default void onArmorTick(ItemStack stack, EntityPlayer player, ItemElectricArmor armor, int level) {}

    default float modifySprintBoost(float base, int level, ItemStack stack) {
        return base;
    }

    default long modifyEnergyUse(long base, int level, ItemStack stack) {
        return base;
    }

    default float modifyFallCost(float base, int level, ItemStack stack) {
        return base;
    }

    default long modifyCapacity(long base, int level, ItemStack stack) {
        return base;
    }

    default long modifyPacket(long base, int level, ItemStack stack) {
        return base;
    }
}
