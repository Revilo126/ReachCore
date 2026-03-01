package revilo.rcplanets.world.domini;

import cr0s.warpdrive.world.AbstractWorldProvider;
import revilo.rcplanets.RCPlanets;

public class DominiWorldProvider extends AbstractWorldProvider {

    DominiWorldProvider() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getDimensionName() {
        return RCPlanets.dominiName;
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }
}
