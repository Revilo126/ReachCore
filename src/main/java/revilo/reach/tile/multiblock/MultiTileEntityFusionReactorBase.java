package revilo.reach.tile.multiblock;

import static gregapi.data.CS.*;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockMachine;
import gregapi.util.WD;

/*
 * This file is used as base for Custom Reactors not gt6's own!
 */

public abstract class MultiTileEntityFusionReactorBase extends TileEntityBase10MultiBlockMachine {

    public abstract int setWall1();

    // public abstract short setWall1RegistryID();
    public abstract int setWall2();

    // public abstract short setWall2RegistryID();
    public abstract int setWall3();

    // public abstract short setWall3RegistryID();
    public abstract int setCoil();
    // public abstract short setCoilRegistryID();

    private int getWall1() {
        return setWall1();
    }

    private int getWall2() {
        return setWall2();
    }

    private int getWall3() {
        return setWall3();
    }

    private int getCoil() {
        return setCoil();
    }

    @Override
    public boolean checkStructure2(ChunkCoordinates aCoordinates, Entity aPlayer, IInventory aInventory) {
        int tX = getOffsetXN(mFacing, 2), tY = yCoord, tZ = getOffsetZN(mFacing, 2);
        if (worldObj.blockExists(tX - 9, tY, tZ - 9) && worldObj.blockExists(tX + 9, tY, tZ - 9)
            && worldObj.blockExists(tX - 9, tY, tZ + 9)
            && worldObj.blockExists(tX + 9, tY, tZ + 9)) {
            boolean tSuccess = T;

            int tVersatile = 3, tLogic = 12, tControl = 12;

            for (int i = -2; i <= 2; i++) for (int j = -2; j <= 2; j++) for (int k = -2; k <= 2; k++) {
                if (i * i + j * j + k * k < 4) {
                    if (ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + j,
                        tZ + k,
                        18200,
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) {
                        tVersatile--;
                    } else if (ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + j,
                        tZ + k,
                        18201,
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) {
                            tLogic--;
                        } else if (ITileEntityMultiBlockController.Util.checkAndSetTarget(
                            this,
                            tX + i,
                            tY + j,
                            tZ + k,
                            18202,
                            getMultiTileEntityRegistryID(),
                            0,
                            MultiTileEntityMultiBlockPart.NOTHING,
                            aCoordinates,
                            aPlayer,
                            aInventory)) {
                                tControl--;
                            } else {
                                tSuccess = F;
                            }
                } else if (i * i + j * j + k * k > 6
                    || (j == 0 && (((i == -2 || i == 2) && k == 0) || (((k == -2 || k == 2) && i == 0))))) {
                        if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                            this,
                            tX + i,
                            tY + j,
                            tZ + k,
                            getWall1(),
                            getMultiTileEntityRegistryID(),
                            0,
                            MultiTileEntityMultiBlockPart.NOTHING,
                            aCoordinates,
                            aPlayer,
                            aInventory)) tSuccess = F;
                    } else {
                        if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                            this,
                            tX + i,
                            tY + j,
                            tZ + k,
                            18299,
                            getMultiTileEntityRegistryID(),
                            0,
                            MultiTileEntityMultiBlockPart.NOTHING,
                            aCoordinates,
                            aPlayer,
                            aInventory)) tSuccess = F;
                    }
            }

            if (tVersatile > 0 || tLogic > 0 || tControl > 0) tSuccess = F;

            if (mFacing != SIDE_X_NEG) {
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX - 3,
                    tY,
                    tZ,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX - 4,
                    tY,
                    tZ,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
            }
            if (mFacing != SIDE_X_POS) {
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX + 3,
                    tY,
                    tZ,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX + 4,
                    tY,
                    tZ,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
            }
            if (mFacing != SIDE_Z_NEG) {
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX,
                    tY,
                    tZ - 3,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX,
                    tY,
                    tZ - 4,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
            }
            if (mFacing != SIDE_Z_POS) {
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX,
                    tY,
                    tZ + 3,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
                if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                    this,
                    tX,
                    tY,
                    tZ + 4,
                    getWall1(),
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING,
                    aCoordinates,
                    aPlayer,
                    aInventory)) tSuccess = F;
            }

            tX -= 9;
            tZ -= 9;

            for (int i = 0; i < 19; i++) for (int j = 0; j < 19; j++) {
                if (OCTAGONS[0][i][j]) {
                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY - 1,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;
                    if ((i == 9 && (j == 0 || j == 18)) || (j == 9 && (i == 0 || i == 18))) {
                        if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                            this,
                            tX + i,
                            tY,
                            tZ + j,
                            getWall2(),
                            getMultiTileEntityRegistryID(),
                            2,
                            MultiTileEntityMultiBlockPart.ONLY_ENERGY_OUT,
                            aCoordinates,
                            aPlayer,
                            aInventory)) tSuccess = F;
                    } else {
                        if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                            this,
                            tX + i,
                            tY,
                            tZ + j,
                            getWall2(),
                            getMultiTileEntityRegistryID(),
                            mActive ? 6 : 5,
                            MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN,
                            aCoordinates,
                            aPlayer,
                            aInventory)) tSuccess = F;
                    }
                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + 1,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;
                }
                if (OCTAGONS[1][i][j]) {
                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY - 2,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY - 1,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY,
                        tZ + j,
                        getCoil(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + 1,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + 2,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;
                }
                if (OCTAGONS[2][i][j]) {
                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY - 2,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY - 1,
                        tZ + j,
                        getCoil(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY,
                        tZ + j,
                        getWall3(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + 1,
                        tZ + j,
                        getCoil(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;

                    if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(
                        this,
                        tX + i,
                        tY + 2,
                        tZ + j,
                        getWall2(),
                        getMultiTileEntityRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID,
                        aCoordinates,
                        aPlayer,
                        aInventory)) tSuccess = F;
                }
            }
            return tSuccess;
        }
        return mStructureOkay;
    }

    public static boolean[][][] OCTAGONS = {
        { { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F },
            { F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F },
            { F, F, F, T, F, F, F, T, T, T, T, T, F, F, F, T, F, F, F },
            { F, F, T, F, F, F, T, F, F, F, F, F, T, F, F, F, T, F, F },
            { F, T, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, T, F },
            { T, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, T },
            { T, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, T },
            { T, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, T },
            { T, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, T },
            { T, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, T },
            { F, T, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, T, F },
            { F, F, T, F, F, F, T, F, F, F, F, F, T, F, F, F, T, F, F },
            { F, F, F, T, F, F, F, T, T, T, T, T, F, F, F, T, F, F, F },
            { F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F },
            { F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F }, },
        { { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, T, F, T, T, T, T, T, F, T, F, F, F, F, F },
            { F, F, F, F, T, F, T, F, F, F, F, F, T, F, T, F, F, F, F },
            { F, F, F, T, F, T, F, F, F, F, F, F, F, T, F, T, F, F, F },
            { F, F, T, F, T, F, F, F, F, F, F, F, F, F, T, F, T, F, F },
            { F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F },
            { F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F },
            { F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F },
            { F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F },
            { F, T, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F },
            { F, F, T, F, T, F, F, F, F, F, F, F, F, F, T, F, T, F, F },
            { F, F, F, T, F, T, F, F, F, F, F, F, F, T, F, T, F, F, F },
            { F, F, F, F, T, F, T, F, F, F, F, F, T, F, T, F, F, F, F },
            { F, F, F, F, F, T, F, T, T, T, T, T, F, T, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F }, },
        { { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F },
            { F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F },
            { F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F },
            { F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F },
            { F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F },
            { F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F },
            { F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F },
            { F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F },
            { F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F },
            { F, F, F, F, T, F, F, F, F, F, F, F, F, F, T, F, F, F, F },
            { F, F, F, F, F, T, F, F, F, F, F, F, F, T, F, F, F, F, F },
            { F, F, F, F, F, F, T, F, F, F, F, F, T, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, T, T, T, T, T, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F },
            { F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F }, } };

    @Override
    public boolean isInsideStructure(int aX, int aY, int aZ) {
        int tX = getOffsetXN(mFacing, 2), tY = yCoord - 2, tZ = getOffsetZN(mFacing, 2);
        return aX >= tX - 9 && aY >= tY && aZ >= tZ - 9 && aX <= tX + 9 && aY <= tY + 5 && aZ <= tZ + 9;
    }

    @Override
    public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
        return null;
    }

    @Override
    public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
        return null;
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
    public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {
        return null;
    }

    @Override
    public boolean refreshStructureOnActiveStateChange() {
        return T;
    }
}
