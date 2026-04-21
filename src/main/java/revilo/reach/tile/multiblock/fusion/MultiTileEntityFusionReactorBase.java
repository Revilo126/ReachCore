package revilo.reach.tile.multiblock.fusion;

import static gregapi.data.CS.ALL_SIDES_HORIZONTAL;
import static gregapi.data.CS.F;
import static gregapi.data.CS.OFFX;
import static gregapi.data.CS.OFFZ;
import static gregapi.data.CS.OPOS;
import static gregapi.data.CS.T;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.util.WD;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.multihelper.structure.logic.ICountedStructure;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

/*
 * This is the same as the GT6 Fusion Reactor but with the MultiHelper Library.
 */
public abstract class MultiTileEntityFusionReactorBase
    extends TileEntityBase10MultiBlockMachineMH<MultiTileEntityFusionReactorBase> implements ICountedStructure {

    public static String[][] STRUCTURE = {
        { "                   ", "       WWWWW       ", "       RRPRR       ", "       WWWWW       ",
            "                   " },
        { "      WWWWWWW      ", "     WWWWWWWWW     ", "     RWCCCCCWR     ", "     WWWWWWWWW     ",
            "      WWWWWWW      " },
        { "     WWWWWWWWW     ", "    WWWCCCCCWWW    ", "    RWCSSSSSCWR    ", "    WWWCCCCCWWW    ",
            "     WWWWWWWWW     " },
        { "    WWWWWWWWWWW    ", "   WWWCWWWWWCWWW   ", "   RWCSCCCCCSCWR   ", "   WWWCWWWWWCWWW   ",
            "    WWWWWWWWWWW    " },
        { "   WWWWWWWWWWWWW   ", "  WWCWWWWWWWWWCWW  ", "  RCSCWWWWWWWCSCR  ", "  WWCWWWWWWWWWCWW  ",
            "   WWWWWWWWWWWWW   " },
        {

            "   WWW       WWW   ", "  WWCWW     WWCWW  ", "  RCSCW     WCSCR  ", "  WWCWW     WWCWW  ",
            "   WWW       WWW   " },
        { "  WWW         WWW  ", " WWCWW       WWCWW ", " RCSCW       WCSCR ", " WWCWW       WWCWW ",
            "  WWW         WWW  " },
        {

            " WWW   GGGGG   WWW ", "WWCWW  GVVVG  WWCWW", "RCSCW  GV-VG  WCSCR", "WWCWW  GVVVG  WWCWW",
            " WWW   GGGGG   WWW " },
        {

            " WWW   GVVVG   WWW ", "WWCWW  VLLLV  WWCWW", "RCSCW  VLLLV  WCSCR", "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " },
        {

            " WWW   GVVVG   WWW ", "WWCWW  VLLLV  WWCWW", "RCSCWGGGLLLGGGWCSCR", "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " },
        {

            " WWW   GVVVG   WWW ", "WWCWW  VLLLV  WWCWW", "RCSCW  VLLLV  WCSCR", "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " },
        {

            " WWW   GGGGG   WWW ", "WWCWW  GVVVG  WWCWW", "RCSCW  GVGVG  WCSCR", "WWCWW  GVVVG  WWCWW",
            " WWW   GGGGG   WWW " },
        { "  WWW         WWW  ", " WWCWW       WWCWW ", " RCSCW   G   WCSCR ", " WWCWW       WWCWW ",
            "  WWW         WWW  " },
        {

            "   WWW       WWW   ", "  WWCWW     WWCWW  ", "  RCSCW  G  WCSCR  ", "  WWCWW     WWCWW  ",
            "   WWW       WWW   " },
        { "   WWWWWWWWWWWWW   ", "  WWCWWWWWWWWWCWW  ", "  RCSCWWWWWWWCSCR  ", "  WWCWWWWWWWWWCWW  ",
            "   WWWWWWWWWWWWW   " },
        { "    WWWWWWWWWWW    ", "   WWWCWWWWWCWWW   ", "   RWCSCCCCCSCWR   ", "   WWWCWWWWWCWWW   ",
            "    WWWWWWWWWWW    " },
        { "     WWWWWWWWW     ", "    WWWCCCCCWWW    ", "    RWCSSSSSCWR    ", "    WWWCCCCCWWW    ",
            "     WWWWWWWWW     " },
        { "      WWWWWWW      ", "     WWWWWWWWW     ", "     RWCCCCCWR     ", "     WWWWWWWWW     ",
            "      WWWWWWW      " },
        { "                   ", "       WWWWW       ", "       RRPRR       ", "       WWWWW       ",
            "                   " } };

    private final Map<String, Integer> counts = new HashMap<String, Integer>();

    @Override
    public Definition<MultiTileEntityFusionReactorBase> getStructure() {
        return Definition.<MultiTileEntityFusionReactorBase>builder(STRUCTURE)
            .addElement(
                'W',
                new StructureElementPart<>(
                    18003,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
            .addElement(
                'R',
                new StructureElementPart<>(
                    18003,
                    StructureUtil.getGTRegistryID(),
                    mActive ? 6 : 5,
                    MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN))
            .addElement(
                'P',
                new StructureElementPart<>(
                    18003,
                    StructureUtil.getGTRegistryID(),
                    2,
                    MultiTileEntityMultiBlockPart.ONLY_ENERGY_OUT))
            .addElement(
                'C',
                new StructureElementPart<>(
                    18045,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'S',
                new StructureElementPart<>(
                    18002,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'G',
                new StructureElementPart<>(
                    18008,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'V',
                new StructureElementPart<>(
                    18299,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'L',
                StructureUtil.counted(
                    "versatile",
                    3,
                    new StructureElementPart<>(
                        18200,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING),
                    "logic",
                    12,
                    new StructureElementPart<>(
                        18201,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING),
                    "control",
                    12,
                    new StructureElementPart<>(
                        18202,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING)))
            .build();
    }

    @Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        counts.clear();

        setCount("versatile", 3);
        setCount("logic", 12);
        setCount("control", 12);

        tSuccess = check(this, aCoordinates, aPlayer, aInventory, getX(), getY(), getZ(), mFacing);

        if (getCount("versatile") != 0 || getCount("logic") != 0 || getCount("control") != 0) tSuccess = F;

        return tSuccess;
    }

    @Override
    public int getCount(String key) {
        Integer v = counts.get(key);
        return v == null ? 0 : v.intValue();
    }

    @Override
    public void setCount(String key, int value) {
        counts.put(key, value);
    }

    @Override
    public void decCount(String key) {
        setCount(key, getCount(key) - 1);
    }

    static {
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.base.1",
            "For Assembly Instructions read the Manual in the GUI.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.base.2",
            "144 Iridium Coils, 576 Regular Tungstensteel Walls, 50 Ventilation Units.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.base.3",
            "36 Regular Stainless Steel Walls, 53 Galvanized Steel Walls.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.base.4",
            "3 Versatile, 12 Logic and 12 Control Quadcore Processing Units.");
        LH.add("reach.tooltip.multiblock.fusionreactor.base.5", "Energy Output at the Electric Interfaces");
        LH.add("reach.tooltip.multiblock.fusionreactor.base.6", "Laser Input at the 'Glass' Ring");
        LH.add("reach.tooltip.multiblock.fusionreactor.base.7", "Items and Fluids are handeled at the normal Walls");
    }

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get(LH.STRUCTURE) + ":");
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.1"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.2"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.3"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.4"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.5"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.6"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.base.7"));
        super.addToolTips(aList, aStack, aF3_H);
    }

    @Override
    public void doOutputEnergy() {
        int tX = getOffsetXN(mFacing, 2), tY = yCoord, tZ = getOffsetZN(mFacing, 2);
        for (byte tSide : ALL_SIDES_HORIZONTAL) if (ITileEntityEnergy.Util.insertEnergyInto(
            mEnergyTypeEmitted,
            mOutputEnergy,
            1,
            this,
            WD.te(worldObj, tX + OFFX[tSide] * 10, tY, tZ + OFFZ[tSide] * 10, OPOS[tSide], F)) > 0) return;
    }

    @Override
    public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        return null;
    }

    @Override
    public boolean refreshStructureOnActiveStateChange() {
        return T;
    }

}
