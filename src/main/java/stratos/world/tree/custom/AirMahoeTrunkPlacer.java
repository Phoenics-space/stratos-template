package stratos.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import stratos.world.tree.ModTrunkPlacerTypes;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class AirMahoeTrunkPlacer extends TrunkPlacer {

    public static final Codec<AirMahoeTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, AirMahoeTrunkPlacer::new));

    public AirMahoeTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.AIR_MAHOE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);

        int height_ = height + random.nextBetween(firstRandomHeight, firstRandomHeight + 1) + random.nextBetween(secondRandomHeight - 1, secondRandomHeight + 1);

        // Cap the maximum height
        height_ = Math.min(height_, 4); // Adjust the maximum height as needed

        for (int i = 0; i < height_; i++) {
            BlockPos currentPos = startPos.up(i);

            // Ensure a single log block is placed at the center
            if (i == height_ - 1) {
                getAndSetState(world, replacer, random, currentPos, config);
            } else {

                getAndSetState(world, replacer, random, currentPos, config);
            }
        }

        // Generate hanging leaves
        List<FoliagePlacer.TreeNode> foliageList = generateHangingLeaves(world, replacer, random, startPos.up(height_), config);

        return foliageList;
    }


    private List<FoliagePlacer.TreeNode> generateHangingLeaves(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                               Random random, BlockPos startPos, TreeFeatureConfig config) {
        List<FoliagePlacer.TreeNode> foliageList = new ArrayList<>();

        int leafSize = 2; // Adjust leaf size as needed
        int leafCount = 0; // Adjust the number of hanging leaves

        for (int i = 0; i < leafCount; i++) {
            int yOffset = i - leafCount / 2; // Distribute leaves around the trunk

            for (int x = -leafSize; x <= leafSize; x++) {
                for (int z = -leafSize; z <= leafSize; z++) {
                    BlockPos leafPos = startPos.add(x, yOffset, z);

                    // Generate leaves at this position
                    getAndSetState(world, replacer, random, leafPos, config);

                    foliageList.add(new FoliagePlacer.TreeNode(leafPos, 0, false));
                }
            }
        }

        return foliageList;
    }
}
