package revilo.reach.api.data;

import static gregapi.data.CS.*;

import revilo.reach.Reach;

public class LogUtil {

    public static void out(Object aOut, boolean useGT) {
        if (useGT) {
            OUT.print("Reach: " + aOut);
        } else {
            Reach.LOG.info(aOut);
        }
    }

    public static void out(Object aOut) {
        Reach.LOG.info(aOut);
    }

}
