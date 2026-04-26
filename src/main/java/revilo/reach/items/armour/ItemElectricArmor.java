package revilo.reach.items.armour;

import static gregapi.data.CS.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import gregapi.code.TagData;
import gregapi.data.TD;
import gregapi.item.IItemEnergy;
import gregapi.item.ItemArmorBase;
import revilo.reach.items.armour.module.ArmorModuleRegistry;
import revilo.reach.items.armour.module.IArmorModule;

public class ItemElectricArmor extends ItemArmorBase implements IItemEnergy {

    private static final String NBT_ENERGY = "energy";
    private static final String NBT_MODULES = "modules";

    private final int tier;
    public final long capacity;

    public ItemElectricArmor(String aModID, String aUnlocalized, String aEnglish, String aEnglishTooltip,
        String aArmorName, int aSlot, long capacity, int tier, int[] aShields, int aDamageReduction,
        Object... aRecipe) {

        super(
            aModID,
            aUnlocalized,
            aEnglish,
            aEnglishTooltip,
            aArmorName,
            aSlot,
            aShields,
            128,
            aDamageReduction,
            0,
            T,
            T,
            aRecipe);

        this.capacity = capacity;
        this.tier = tier;
    }

    @Override
    public boolean isDamageable() {
        return F;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return F;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) return;

        float sprintBoost = 0.02F * tier;
        int sprintCost = 2 * getCostMultiplier();

        float fallCostMult = getCostMultiplier();

        for (String id : getModules(stack)) {
            IArmorModule mod = ArmorModuleRegistry.get(id);
            int lvl = getModuleLevel(stack, id);

            if (mod != null) {
                sprintBoost = mod.modifySprintBoost(sprintBoost, lvl, stack);
                sprintCost = (int) mod.modifyEnergyUse(sprintCost, lvl, stack);
                fallCostMult = mod.modifyFallCost(fallCostMult, lvl, stack);
            }
        }

        if (player.isSprinting()) {
            if (useEnergy(stack, sprintCost, world)) {

                player.motionX += player.getLookVec().xCoord * sprintBoost * 0.5;
                player.motionZ += player.getLookVec().zCoord * sprintBoost * 0.5;
            }
        }

        if (player.onGround && player.fallDistance > 3.0F && !player.isInWater()) {

            int cost = (int) (player.fallDistance * 5 * fallCostMult);

            if (useEnergy(stack, cost, world)) {
                player.fallDistance = 0;
                player.motionY = -0.1;
            }
        }
    }

    private boolean useEnergy(ItemStack stack, long amount, World world) {
        long stored = getEnergyStored(TD.Energy.EU, stack);

        if (stored < amount) return F;

        setEnergyStored(TD.Energy.EU, stack, stored - amount);
        return T;
    }

    @Override
    public boolean isEnergyType(TagData type, ItemStack stack, boolean emitting) {
        return type == TD.Energy.EU;
    }

    @Override
    public Collection<TagData> getEnergyTypes(ItemStack stack) {
        return TD.Energy.ALL_EU;
    }

    @Override
    public long getEnergyCapacity(TagData type, ItemStack stack) {
        return capacity * tierMultiplier();
    }

    @Override
    public long doEnergyInjection(TagData type, ItemStack stack, long size, long amount, IInventory inv, World world,
        int x, int y, int z, boolean doInject) {

        long stored = getEnergyStored(type, stack);
        long cap = getEnergyCapacity(type, stack);

        long accepted = Math.min(amount, cap - stored);

        if (doInject && accepted > 0) {
            setEnergyStored(type, stack, stored + accepted);
        }

        return accepted;
    }

    @Override
    public long doEnergyExtraction(TagData type, ItemStack stack, long size, long amount, IInventory inv, World world,
        int x, int y, int z, boolean doExtract) {

        long stored = getEnergyStored(type, stack);
        long taken = Math.min(amount, stored);

        if (doExtract && taken > 0) {
            setEnergyStored(type, stack, stored - taken);
        }

        return taken;
    }

    @Override
    public boolean canEnergyInjection(TagData type, ItemStack stack, long size) {
        return type == TD.Energy.EU;
    }

    @Override
    public boolean canEnergyExtraction(TagData type, ItemStack stack, long size) {
        return type == TD.Energy.EU;
    }

    @Override
    public boolean useEnergy(TagData type, ItemStack stack, long amount, EntityLivingBase entity, IInventory inv,
        World world, int x, int y, int z, boolean doUse) {

        if (type != TD.Energy.EU) return F;

        long stored = getEnergyStored(type, stack);

        if (stored < amount) return F;

        if (doUse) {
            setEnergyStored(type, stack, stored - amount);
        }

        return T;
    }

    @Override
    public ItemStack setEnergyStored(TagData type, ItemStack stack, long amount) {
        if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());

        stack.getTagCompound()
            .setLong(NBT_ENERGY, Math.max(0, amount));
        return stack;
    }

    @Override
    public long getEnergyStored(TagData type, ItemStack stack) {
        return stack.hasTagCompound() ? stack.getTagCompound()
            .getLong(NBT_ENERGY) : 0;
    }

    @Override
    public long getEnergySizeInputMin(TagData type, ItemStack stack) {
        return 8;
    }

    @Override
    public long getEnergySizeOutputMin(TagData type, ItemStack stack) {
        return 8;
    }

    @Override
    public long getEnergySizeInputRecommended(TagData type, ItemStack stack) {
        return getRecPacket();
    }

    @Override
    public long getEnergySizeOutputRecommended(TagData type, ItemStack stack) {
        return getRecPacket();
    }

    @Override
    public long getEnergySizeInputMax(TagData type, ItemStack stack) {
        return getMaxPacket();
    }

    @Override
    public long getEnergySizeOutputMax(TagData type, ItemStack stack) {
        return getMaxPacket();
    }

    private long tierMultiplier() {
        switch (tier) {
            case 1:
                return 1; // HV
            case 2:
                return 4; // EV
            case 3:
                return 16; // IV
            default:
                return 1;
        }
    }

    private long getRecPacket() {
        switch (tier) {
            case 1:
                return 128;
            case 2:
                return 512;
            case 3:
                return 2048;
            default:
                return 128;
        }
    }

    private long getMaxPacket() {
        switch (tier) {
            case 1:
                return 512;
            case 2:
                return 2048;
            case 3:
                return 8192;
            default:
                return 512;
        }
    }

    private int getCostMultiplier() {
        switch (tier) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default:
                return 1;
        }
    }

    private NBTTagCompound getModuleTag(ItemStack stack) {
        if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());

        NBTTagCompound tag = stack.getTagCompound();

        if (!tag.hasKey(NBT_MODULES)) {
            tag.setTag(NBT_MODULES, new NBTTagCompound());
        }

        return tag.getCompoundTag(NBT_MODULES);
    }

    private Set<String> getModuleKeys(NBTTagCompound tag) {
        return (Set<String>) tag.func_150296_c();
    }

    private Set<String> getModules(ItemStack stack) {
        NBTTagCompound modules = getModuleTag(stack);
        Set<String> keys = new HashSet<String>();

        for (Object keyObj : getModuleKeys(modules)) {
            keys.add((String) keyObj);
        }

        return keys;
    }

    public int getModuleLevel(ItemStack stack, String id) {
        return getModuleTag(stack).getInteger(id);
    }

    public void setModule(ItemStack stack, String id, int level) {
        getModuleTag(stack).setInteger(id, level);
    }

    public void removeModule(ItemStack stack, String id) {
        getModuleTag(stack).removeTag(id);
    }
}
