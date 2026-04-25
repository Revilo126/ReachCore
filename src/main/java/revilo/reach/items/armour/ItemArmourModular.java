package revilo.reach.items.armour;

import static gregapi.data.CS.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.TD;
import gregapi.item.ItemArmorBase;
import gregapi.item.multiitem.energy.EnergyStat;

public class ItemArmourModular extends ItemArmorBase {

    private ArrayListNoNulls<IItemArmourModule> modules;
    public EnergyStat energyStat;

    public ItemArmourModular(String aModID, String aUnlocalized, String aEnglish, String aEnglishTooltip,
        String aArmorName, int aSlot, int[] aShields, int aDurability, int aDamageReduction, int aEnchantability,
        boolean aMetalArmor, boolean aBeeArmor, Object[] aRecipe) {
        super(
            aModID,
            aUnlocalized,
            aEnglish,
            aEnglishTooltip,
            aArmorName,
            aSlot,
            aShields,
            aDurability,
            aDamageReduction,
            aEnchantability,
            aMetalArmor,
            aBeeArmor,
            aRecipe);
        this.modules = new ArrayListNoNulls<>(F);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        for (IItemArmourModule module : modules) {
            module.onModuleTick(player, armor, this);
        }
    }

    public boolean removeEnergy(long aAmount, int tier) {
        return this.energyStat.doEnergyExtraction(
            TD.Energy.EU,
            new ItemStack(this),
            (int) V[tier],
            (int) (aAmount / V[tier]),
            null,
            null,
            0,
            0,
            0,
            T) != 0;
    }

    public boolean addModule(IItemArmourModule module) {
        return modules.add(module);
    }

    public boolean removeModule(IItemArmourModule module) {
        if (modules.contains(module)) modules.remove(module);
        return F;
    }
}
