package stratos.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import stratos.world.ModPlacedFeatures;
import stratos.world.biome.ModBiomes;

public class LichenBiomeGeneration {
    public static void generateAirShroom() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LICHEN_VALLEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AIR_SHROOM_PLACED_KEY);
    }
    public static void generateLichenGrass() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LICHEN_VALLEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LICHEN_GRASS_PLACED_KEY);
    }

    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LICHEN_VALLEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AIR_MAHOE_PLACED_KEY);
    }
    public static void generateAirKelp() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LICHEN_VALLEY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AIR_KELP_PLACED_KEY);
    }


}
