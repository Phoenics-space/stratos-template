package stratos.world.biome.surface;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import stratos.block.ModBlocks;
import stratos.world.biome.ModBiomes;

public class ModMaterialRules {


    private static final MaterialRules.MaterialRule AIR = makeStateRule(Blocks.AIR);
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule LIGHT_BLUE_TERRACOTTA = makeStateRule(Blocks.LIGHT_BLUE_TERRACOTTA);
    private static final MaterialRules.MaterialRule CYAN_TERRACOTTA = makeStateRule(Blocks.CYAN_TERRACOTTA);
    private static final MaterialRules.MaterialRule LIGHT_GRAY_TERRACOTTA = makeStateRule(Blocks.LIGHT_GRAY_TERRACOTTA);
    private static final MaterialRules.MaterialRule TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule PODZOL = makeStateRule(Blocks.PODZOL);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final MaterialRules.MaterialRule SAND = makeStateRule(Blocks.SAND);
    private static final MaterialRules.MaterialRule SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final MaterialRules.MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final MaterialRules.MaterialRule POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final MaterialRules.MaterialRule WATER = makeStateRule(Blocks.WATER);
    private static final MaterialRules.MaterialRule LAVA = makeStateRule(Blocks.LAVA);
    private static final MaterialRules.MaterialRule MAGMA = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final MaterialRules.MaterialRule OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final MaterialRules.MaterialRule TUFF = makeStateRule(Blocks.TUFF);
    private static final MaterialRules.MaterialRule GLOWSTONE = makeStateRule(Blocks.GLOWSTONE);


    //Stratos
    public static final MaterialRules.MaterialRule LICHEN_GROWTH = makeStateRule(ModBlocks.LICHEN_GROWTH);
    public static final MaterialRules.MaterialRule STRATOS_STONE = makeStateRule(ModBlocks.STRATOS_STONE);


    public static MaterialRules.MaterialRule makeRules() {
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
