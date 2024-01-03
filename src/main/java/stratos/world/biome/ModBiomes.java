package stratos.world.biome;

import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import stratos.mod.ExampleMod;
import stratos.world.biome.biomes.LichenValleyBiome;
import stratos.world.biome.biomes.TestBiome;

public class ModBiomes {
    public static final RegistryKey<Biome> LICHEN_VALLEY = register("lichen_valley");
    public static final RegistryKey<Biome> TEST_BIOME = register("test_biome");


    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(ExampleMod.MOD_ID, name));
    }
    public static void bootstrap(Registerable<Biome> context) {
        context.register(LICHEN_VALLEY, LichenValleyBiome.lichenValleyBiome(context));
        context.register(TEST_BIOME, TestBiome.testBiome(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }


}