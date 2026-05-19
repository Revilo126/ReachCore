package revilo.reach.tile.multiblock.fusion;

import static gregapi.data.CS.ALL_SIDES_HORIZONTAL;
import static gregapi.data.CS.F;
import static gregapi.data.CS.OFFX;
import static gregapi.data.CS.OFFZ;
import static gregapi.data.CS.OPOS;
import static gregapi.data.CS.T;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.util.WD;
import revilo.multihelper.structure.logic.ICountedStructure;
import revilo.multihelper.tile.multiblock.TileEntityBase10MultiBlockMachineMH;

/*
 * This is the same as the GT6 Fusion Reactor but with the MultiHelper Library.
 */
public abstract class MultiTileEntityFusionReactorBase<T extends TileEntityBase10MultiBlockMachineMH<T>>
    extends TileEntityBase10MultiBlockMachineMH<T> implements ICountedStructure {

    // spotless:off
    public static String[][] STRUCTURE = {
        { 
        	"                   ", 
        	"       WWWWW       ", 
        	"       RRPRR       ", 
        	"       WWWWW       ",
            "                   " 
        },
        { 
        	"       WWWWW       ", 
        	"      WWWWWWW      ", 
        	"      RCCCCCR      ", 
        	"      WWWWWWW      ",
            "       WWWWW       " 
        },
        { 
        	"      WWWWWWW      ", 
        	"     WWCCCCCWW     ", 
        	"     RCSSSSSCR     ", 
        	"     WWCCCCCWW     ",
            "      WWWWWWW      "
        },
        { 
        	"     WWWWWWWWW     ", 
        	"    WWCWWWWWCWW    ", 
        	"    RCSCCCCCSCR    ", 
        	"    WWCWWWWWCWW    ",
            "     WWWWWWWWW     " 
        },
        { 
        	"    WWW     WWW    ", 
        	"   WWCWWWWWWWCWW   ", 
        	"   RCSCRRRRRCSCR   ", 
        	"   WWCWWWWWWWCWW   ",
            "    WWW     WWW    " 
        },
        {
            "   WWW       WWW   ", 
            "  WWCWW     WWCWW  ", 
            "  RCSCR     RCSCR  ", 
            "  WWCWW     WWCWW  ",
            "   WWW       WWW   " 
        },
        { 
        	"  WWW         WWW  ", 
        	" WWCWW       WWCWW ", 
        	" RCSCR       RCSCR ", 
        	" WWCWW       WWCWW ",
            "  WWW         WWW  " 
        },
        {
            " WWW   GGGGG   WWW ", 
            "WWCWW  GVVVG  WWCWW", 
            "RCSCR  GV-VG  RCSCR", 
            "WWCWW  GVVVG  WWCWW",
            " WWW   GGGGG   WWW " 
        },
        {
            " WWW   GVVVG   WWW ", 
            "WWCWW  VLLLV  WWCWW", 
            "RCSCR  VLLLV  RCSCR", 
            "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " 
        },
        {
            " WWW   GVVVG   WWW ", 
            "WWCWW  VLLLV  WWCWW", 
            "PCSCRGGGLLLGGGRCSCP", 
            "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " 
        },
        {
            " WWW   GVVVG   WWW ", 
            "WWCWW  VLLLV  WWCWW", 
            "RCSCR  VLLLV  RCSCR",
            "WWCWW  VLLLV  WWCWW",
            " WWW   GVVVG   WWW " 
        },
        {
            " WWW   GGGGG   WWW ",
            "WWCWW  GVVVG  WWCWW",
            "RCSCR  GVGVG  RCSCR",
            "WWCWW  GVVVG  WWCWW",
            " WWW   GGGGG   WWW " 
        },
        { 
        	"  WWW         WWW  ", 
        	" WWCWW       WWCWW ", 
        	" RCSCR   G   RCSCR ", 
        	" WWCWW       WWCWW ",
            "  WWW         WWW  " 
        },
        {
            "   WWW       WWW   ", 
            "  WWCWW     WWCWW  ", 
            "  RCSCR  G  RCSCR  ", 
            "  WWCWW     WWCWW  ",
            "   WWW       WWW   " 
        },
        { 
        	"    WWW     WWW    ", 
        	"   WWCWWWWWWWCWW   ", 
        	"   RCSCRRRRRCSCR   ", 
        	"   WWCWWWWWWWCWW   ",
            "    WWW     WWW    " 
        },
        { 
        	"     WWWWWWWWW     ", 
        	"    WWCWWWWWCWW    ", 
        	"    RCSCCCCCSCR    ", 
        	"    WWCWWWWWCWW    ",
            "     WWWWWWWWW     " 
        },
        { 
        	"      WWWWWWW      ", 
        	"     WWCCCCCWW     ", 
        	"     RCSSSSSCR     ", 
        	"     WWCCCCCWW     ",
            "      WWWWWWW      " 
        },
        { 
        	"       WWWWW       ", 
        	"      WWWWWWW      ", 
        	"      RCCCCCR      ", 
        	"      WWWWWWW      ",
            "       WWWWW       " 
        },
        { 
        	"                   ",
        	"       WWWWW       ",
        	"       RRPRR       ",
        	"       WWWWW       ",
            "                   " 
        }
    };
    //spotless:on

    private final Map<String, Integer> counts = new HashMap<String, Integer>();

    @SuppressWarnings("unchecked")
    @Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        counts.clear();

        setCount("versatile", 3);
        setCount("logic", 12);
        setCount("control", 12);

        tSuccess = check((T) this, aCoordinates, aPlayer, aInventory, getX(), getY(), getZ(), mFacing);

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
