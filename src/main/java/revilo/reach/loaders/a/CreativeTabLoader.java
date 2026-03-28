package revilo.reach.loaders.a;

import gregapi.data.OP;
import gregapi.item.CreativeTab;
import gregapi.util.ST;
import revilo.reach.data.RCMT;

public class CreativeTabLoader implements Runnable {

    public static CreativeTab basicMachines;
    public static final short basicMachinesID = (short) 1300;

    @Override
    public void run() {
        basicMachines = new CreativeTab(
            "basicmachines",
            "Basic Machines",
            ST.item(
                OP.casingMachine.dat(RCMT.AdUue)
                    .getStack(1)),
            basicMachinesID);
    }

}
