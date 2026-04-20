package revilo.reach.loaders.b.lines;

import static gregapi.data.CS.ERR;
import static gregapi.data.CS.F;

import gregapi.code.ArrayListNoNulls;

public class LineLoader implements Runnable {

    @Override
    public void run() {
        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(F);
        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
