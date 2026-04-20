package revilo.reach.loaders.b;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;
import revilo.reach.loaders.b.lines.LineLoader;

public class GregTechLoader implements Runnable {

    @Override
    public void run() {
        ArrayListNoNulls<Runnable> tList = new ArrayListNoNulls<>(
            F,
            new FusionLoader(),
            new LineLoader(),
            new OreProcLoader());
        for (Runnable tRunnable : tList) try {
            tRunnable.run();
        } catch (Throwable e) {
            e.printStackTrace(ERR);
        }
    }

}
