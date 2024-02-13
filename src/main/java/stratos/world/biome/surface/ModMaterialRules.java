package stratos.world.biome.surface;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import stratos.block.ModBlocks;
import stratos.world.biome.ModBiomes;

public class ModMaterialRules {

    //Stratos
    public static final MaterialRules.MaterialRule LICHEN_GROWTH = makeStateRule(ModBlocks.LICHEN_GROWTH);
    public static final MaterialRules.MaterialRule STRATOS_STONE = makeStateRule(ModBlocks.STRATOS_STONE);


    public static MaterialRules.MaterialRule makeLichenValleyRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, LICHEN_GROWTH), STRATOS_STONE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LICHEN_VALLEY),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, LICHEN_GROWTH)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STRATOS_STONE)),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, STRATOS_STONE),/*Defines the material above the Ceiling*/
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_30, STRATOS_STONE),
                MaterialRules.condition(MaterialRules.aboveYWithStoneDepth(YOffset.BOTTOM, 2), STRATOS_STONE),


                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }


    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}