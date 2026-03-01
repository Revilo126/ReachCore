package revilo.reach.loaders.c;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.event.IOreDictListenerEvent;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.util.ST;
import revilo.reach.api.data.RCIL;

public class LoaderRecipeOthers implements Runnable {

    @Override
    public void run() {
        new OreDictListenerEvent_Names() {

            @Override
            public void addAllListeners() {
                addListener(DYE_OREDICTS_LENS[DYE_INDEX_Red], new IOreDictListenerEvent() {

                    @Override
                    public void onOreRegistration(OreDictRegistrationContainer aEvent) {
                        RM.LaserEngraver.addRecipe2(
                            T,
                            16,
                            64,
                            foil.mat(MT.Nq, 4),
                            ST.amount(0, aEvent.mStack),
                            RCIL.Circuit_Wiring_Nano.get(1));
                    }
                });
            }
        };
    }

}
