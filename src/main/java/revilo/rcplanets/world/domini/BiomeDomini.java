package revilo.rcplanets.world.domini;

import net.minecraft.world.biome.BiomeGenBase;

import gregapi.data.OP;
import gregapi.util.ST;
import revilo.reach.api.data.RCMT;

public class BiomeDomini extends BiomeGenBase {

    public BiomeDomini(int p_i1971_1_) {
        super(p_i1971_1_);

        this.spawnableCreatureList.clear();

        this.topBlock = ST.block(
            OP.blockDust.dat(RCMT.DominiTurf)
                .getStack(1));
        this.fillerBlock = ST.block(
            OP.blockDust.dat(RCMT.DominiTurf)
                .getStack(1));

    }

}
