package revilo.reach.data;

import static gregapi.data.CS.*;

import gregapi.data.ANY;

public class RCANY {

    private static boolean INITIALISED = F;

    protected static void init() {
        if (INITIALISED) return;
        INITIALISED = T;

        ANY.Rubber.addReRegistrationToThis(RCMT.SBR);
        ANY.PlasticHard.addReRegistrationToThis(RCMT.PVC);
        ANY.Plastic.addReRegistrationToThis(RCMT.PVC);
    }
}
