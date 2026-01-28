package revilo.reach.api.tileentity.energy;

import static gregapi.data.CS.*;

import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.data.TD;
import gregapi.tileentity.energy.TileEntityBase10EnergyConverter;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import gregapi.util.UT;

public abstract class TileEntityBase11TimeAccelerator extends TileEntityBase10EnergyConverter
    implements ITileEntityAdjacentOnOff {

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        super.addToolTips(aList, aStack, aF3_H);
        aList.add(Chat.BLINKING_GRAY + LH.get(LH.TOOLTIP_REMINDER_EXTENDERS));
    }

    @Override
    public void addToolTipsEfficiency(List<String> aList, ItemStack aStack, boolean aF3_H) {
        if (TD.Energy.ALL_EU.contains(mConverter.mEnergyIN.mType)) {
            if (TD.Energy.ALL_EU.contains(mConverter.mEnergyOUT.mType)) {
                aList.add(
                    LH.getToolTipEfficiency(
                        UT.Code.units(10000, mConverter.mEnergyIN.mRec, mConverter.mEnergyOUT.mRec * 2, F)));
            } else {
                if (mConverter.mEnergyOUT.mType == TD.Energy.RF) aList.add(
                    LH.getToolTipEfficiency(
                        UT.Code.units(10000, mConverter.mEnergyIN.mRec * 4, mConverter.mEnergyOUT.mRec * 2, F)));
            }
        } else {
            if (TD.Energy.ALL_EU.contains(mConverter.mEnergyOUT.mType) && mConverter.mEnergyIN.mType == TD.Energy.RF)
                aList.add(
                    LH.getToolTipEfficiency(
                        UT.Code.units(10000, mConverter.mEnergyIN.mRec, mConverter.mEnergyOUT.mRec * 8, F)));
        }
    }

    @Override
    public void doConversion(long aTimer) {
        mActivity.mActive = mConverter.doBipolar(aTimer, this, mFacing, OPOS[mFacing], mMode);
        if (mConverter.mOverloaded) {
            overload(mStorage.mEnergy, mConverter.mEnergyOUT.mType);
            mConverter.mOverloaded = F;
            mStorage.mEnergy = 0;
        }
    }

    @Override
    public boolean isInput(byte aSide) {
        return !ALONG_AXIS[aSide][mFacing];
    }

    @Override
    public boolean isOutput(byte aSide) {
        return ALONG_AXIS[aSide][mFacing];
    }

    @Override
    public String getLocalisedInputSide() {
        return LH.get(LH.FACE_ANYBUT_FRONT_BACK);
    }

    @Override
    public String getLocalisedOutputSide() {
        return LH.get(LH.FACE_FRONT_BACK);
    }
}
