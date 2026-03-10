package revilo.rcplanets.world.domini;

import net.minecraft.world.biome.BiomeGenBase;

import gregapi.data.OP;
import gregapi.util.ST;
import revilo.reach.api.data.RCMT;

public class BiomeDomini extends BiomeGenBase {

    public BiomeDomini(int p_i1971_1_) {
        super(p_i1971_1_);

        this.spawnableCreatureList.clear();
        this.heightVariation = 0.2f;
        this.rainfall = 0f;
        this.temperature = 0.9f;
        this.enableRain = false;
        this.enableSnow = false;
        this.theBiomeDecorator.generateLakes = false;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.treesPerChunk = 0;

        this.topBlock = this.fillerBlock = ST.block(
            OP.blockDust.dat(RCMT.DominiTurf)
                .getStack(1));

        this.biomeName = "Domini";

    }

}
