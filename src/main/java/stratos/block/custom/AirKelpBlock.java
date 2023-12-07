package stratos.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import stratos.block.ModBlocks;

public class AirKelpBlock extends AbstractPlantStemBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 15.0, 12.0);

    public AirKelpBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.UP, SHAPE, false, 0.4);
    }

    @Override
    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.AIR_KELP_PLANT;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
}