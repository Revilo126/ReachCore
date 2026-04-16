package revilo.reach.loaders.a;

import static revilo.reach.data.RCCS.*;
import static gregapi.data.CS.*;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import revilo.reach.config.ConfigCatagories;
import revilo.reach.world.biomes.BiomeGenAdam;
import revilo.reach.world.biomes.BiomeGenAlkalai;
import revilo.reach.world.biomes.BiomeGenSulf;
import revilo.reach.world.biomes.BiomeGenTungle;
import revilo.reach.world.biomes.BiomeGenVita;

public class BiomeLoader implements Runnable {
	public static BiomeGenBase adam, alkalai, sulf, tungle, vita;

	@Override
	public void run() {
		adam = new BiomeGenAdam(ConfigsRC.BIOME.get(ConfigCatagories.biomeIds, "adamId", 240), T).setBiomeName("Adam");
		alkalai = new BiomeGenAlkalai(ConfigsRC.BIOME.get(ConfigCatagories.biomeIds, "alkalaiId", 241), T).setBiomeName("Alkalai");
		sulf = new BiomeGenSulf(ConfigsRC.BIOME.get(ConfigCatagories.biomeIds, "sulfId", 242), T).setBiomeName("Sulf");
		tungle = new BiomeGenTungle(ConfigsRC.BIOME.get(ConfigCatagories.biomeIds, "tungleId", 243), T).setBiomeName("Tungle");
		vita = new BiomeGenVita(ConfigsRC.BIOME.get(ConfigCatagories.biomeIds, "vitaId", 244), T).setBiomeName("Vita");
		
		BiomeDictionary.registerBiomeType(adam, Type.WASTELAND, Type.COLD, Type.DRY);
		BiomeDictionary.registerBiomeType(alkalai, Type.WASTELAND, Type.HOT, Type.DRY);
		BiomeDictionary.registerBiomeType(sulf, Type.WASTELAND, Type.COLD, Type.DRY);
		BiomeDictionary.registerBiomeType(tungle, Type.WASTELAND, Type.COLD, Type.DRY);
		BiomeDictionary.registerBiomeType(vita, Type.WASTELAND, Type.HOT, Type.DRY);
	}

}
