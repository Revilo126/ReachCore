package revilo.reach.loaders;

import static gregapi.data.CS.*;

import gregapi.data.MT;
import gregapi.worldgen.WorldgenOresBedrock;
import gregapi.worldgen.WorldgenOresSmall;

public class WorldGenLoader implements Runnable {

    @Override
    public void run() {

        // Bedrock Ores
        new WorldgenOresBedrock("ore.bedrock.netherstar", T, T, 10000, MT.NetherStar, GEN_NETHER);

        // Small Ores
        new WorldgenOresSmall("ore.small.netherstar", T, 10, 80, 6, MT.NetherStar, GEN_END);

    }

}
