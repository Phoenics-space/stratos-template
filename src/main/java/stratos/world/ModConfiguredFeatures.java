package stratos.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;
import stratos.world.tree.custom.AirMahoeFoliagePlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> AIR_MAHOE_KEY = registerKey("air_mahoe");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHINGLE_KEY = registerKey("shingle");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AIR_SHROOM_KEY = registerKey("air_shroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LICHEN_GRASS_KEY = registerKey("lichen_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AIR_KELP_KEY = registerKey("air_kelp");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AIR_KELP_BONEMEAL_KEY = ConfiguredFeatures.of("air_kelp_bonemeal");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, AIR_MAHOE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.AIR_MAHOE_LOG),
                new StraightTrunkPlacer(6, 2, 2),
                BlockStateProvider.of(ModBlocks.AIR_MAHOE_LICHEN),
                new AirMahoeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 3),
                new TwoLayersFeatureSize(1, 2, 2)).build());

        register(context, SHINGLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SHINGLE_LOG),
                new StraightTrunkPlacer(6, 2, 2),
                BlockStateProvider.of(ModBlocks.SHINGLE_MYOZYT),
                new AirMahoeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 3),
                new TwoLayersFeatureSize(1, 2, 2)).build());



        //register(context, AIR_SHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(5/*tries*/, 4/*xzSpread*/,  8/*ySpread*/, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
        //        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.AIR_SHROOM)))));
//
        //register(context, LICHEN_GRASS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(5, 4,  6, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
        //        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LICHEN_GRASS)))));



        register(context, AIR_SHROOM_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(5, 4, 8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.AIR_SHROOM)))));

        register(context, LICHEN_GRASS_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(5, 4, 6, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LICHEN_GRASS)))));


        register(context, AIR_KELP_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(10, 4, 4,
                PlacedFeatures.createEntry(Feature.BLOCK_COLUMN, BlockColumnFeatureConfig.create(BiasedToBottomIntProvider.create(2, 4),
                        BlockStateProvider.of(ModBlocks.AIR_KELP)), BlockFilterPlacementModifier.of(BlockPredicate.allOf(BlockPredicate.IS_AIR,
                        BlockPredicate.wouldSurvive(ModBlocks.AIR_KELP_PLANT.getDefaultState(), BlockPos.ORIGIN))))));


        //register(context, AIR_KELP_KEY, Feature.TWISTING_VINES, new TwistingVinesFeatureConfig(8, 4, 8));





    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ExampleMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
