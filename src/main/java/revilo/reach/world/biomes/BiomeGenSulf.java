package revilo.reach.world.biomes;

import static revilo.reach.data.RCCS.BlocksReach.*;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSulf extends BiomeGenBase {

    public BiomeGenSulf(int biomeId, boolean register) {
        super(biomeId, register);

        // cold and dry

        enableRain = false;
        enableSnow = false;
        rootHeight = 1f;
        heightVariation = 0.2f;
        rainfall = 0f;
        temperature = 0.3f;
        this.theBiomeDecorator.generateLakes = false;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.fillerBlock = this.topBlock = Sulf;
        this.biomeName = "Sulf";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List getSpawnableList(EnumCreatureType p_76747_1_) {
        return new LinkedList<>();
    }

    @Override
    public float getSpawningChance() {
        return 0f; // Nothing spawns
    }
}
