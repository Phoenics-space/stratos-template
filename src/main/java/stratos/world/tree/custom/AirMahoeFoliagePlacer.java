package stratos.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import stratos.world.tree.ModFoliagePlacerTypes;

public class AirMahoeFoliagePlacer extends FoliagePlacer {
    public static final Codec<AirMahoeFoliagePlacer> CODEC = RecordCodecBuilder.create(airMahoeFoliagePlacerInstance -> fillFoliagePlacerFields(
            airMahoeFoliagePlacerInstance).and(Codec.intRange(0, 8).fieldOf("height").forGetter(instance -> instance.height))
            .apply(airMahoeFoliagePlacerInstance, AirMahoeFoliagePlacer::new));
    private final int height;

    public AirMahoeFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;

    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.AIR_MAHOE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        generateSquareWithHangingLeaves(world, placer, random, config, treeNode.getCenter().up(-1), 2, 0, !treeNode.isGiantTrunk(), 0.5f, 0.5f);
        generateSquareWithHangingLeaves(world, placer, random, config, treeNode.getCenter().up(0), 2, 0, !treeNode.isGiantTrunk(), 0.0f, 0.0f);
        generateSquareWithHangingLeaves(world, placer, random, config, treeNode.getCenter().up(1), 1, 0, !treeNode.isGiantTrunk(), 0.0f, 0.0f);


    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {

        return false;
    }
}
