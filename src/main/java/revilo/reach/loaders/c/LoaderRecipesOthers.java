package revilo.reach.loaders.c;

import static gregapi.data.CS.*;
import static gregapi.data.OP.*;

import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.oredict.event.IOreDictListenerEvent;
import gregapi.oredict.event.OreDictListenerEvent_Names;
import gregapi.util.ST;
import revilo.reach.data.RCIL;
import revilo.reach.data.RCMT;

public class LoaderRecipesOthers implements Runnable {

    @Override
    public void run() {
        OUT.println("Reach: Loading Other Recipes.");
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
                        RM.LaserEngraver.addRecipe2(
                            T,
                            16,
                            64,
                            foil.mat(RCMT.Ubn, 4),
                            ST.amount(0, aEvent.mStack),
                            RCIL.Circuit_Wiring_Quantum_T1.get(1));
                    }
                });
            }
        };
    }

}
