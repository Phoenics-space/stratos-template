package stratos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import stratos.block.custom.*;
import stratos.mod.ExampleMod;
import stratos.world.tree.AirMahoeSaplingGenerator;
import stratos.world.tree.ShingleSaplingGenerator;


public class ModBlocks {
    public static final Block LICHEN_GROWTH = registerBlock("lichen_growth", new LichenGrothBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_NYLIUM)));
    public static final Block STRATOS_STONE = registerBlock("stratos_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block COBBLED_STRATOS_STONE = registerBlock("cobbled_stratos_stone", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block STRATOS_STONE_WALL = registerBlock("stratos_stone_wall", new WallBlock(FabricBlockSettings.copyOf(ModBlocks.STRATOS_STONE)));
    public static final Block SKY_SEDIMENT = registerBlock("sky_sediment", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block SKY_SEDIMENT_BRICKS = registerBlock("sky_sediment_bricks", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block PETRIFIED_SHINGLE_LOG = registerBlock("petrified_shingle_log", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));


    public static final Block FRAME = registerBlock("frame", new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));


    // Wood Type
    public static final Block AIR_MAHOE_SAPLING = registerBlock("air_mahoe_sapling", new SaplingBlock(new AirMahoeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));
    public static final Block AIR_MAHOE_LICHEN = registerBlock("air_mahoe_lichen", new AirMahoeLichenBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block AIR_MAHOE_LOG = registerBlock("air_mahoe_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block AIR_MAHOE_WOOD = registerBlock("air_mahoe_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_AIR_MAHOE_LOG = registerBlock("stripped_air_mahoe_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_AIR_MAHOE_WOOD = registerBlock("stripped_air_mahoe_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block AIR_MAHOE_PLANKS = registerBlock("air_mahoe_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block AIR_MAHOE_STAIRS = registerBlock("air_mahoe_stairs", new StairsBlock(ModBlocks.AIR_MAHOE_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block AIR_MAHOE_SLAB = registerBlock("air_mahoe_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block AIR_MAHOE_FENCE = registerBlock("air_mahoe_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block AIR_MAHOE_FENCE_GATE = registerBlock("air_mahoe_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE), WoodType.OAK));
    public static final Block AIR_MAHOE_DOOR = registerBlock("air_mahoe_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block AIR_MAHOE_TRAPDOOR = registerBlock("air_mahoe_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block AIR_MAHOE_PRESSURE_PLATE = registerBlock("air_mahoe_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));
    public static final Block AIR_MAHOE_BUTTON = registerBlock("air_mahoe_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));


    //shingle wood

    public static final Block SHINGLE_SAPLING = registerBlock("shingle_sapling", new SaplingBlock(new ShingleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));
    public static final Block SHINGLE_MYOZYT = registerBlock("shingle_myozyt", new AirMahoeLichenBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block SHINGLE_LOG = registerBlock("shingle_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block SHINGLE_WOOD = registerBlock("shingle_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_SHINGLE_LOG = registerBlock("stripped_shingle_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_SHINGLE_WOOD = registerBlock("stripped_shingle_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block SHINGLE_PLANKS = registerBlock("shingle_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SHINGLE_STAIRS = registerBlock("shingle_stairs", new StairsBlock(ModBlocks.AIR_MAHOE_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block SHINGLE_SLAB = registerBlock("shingle_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block SHINGLE_FENCE = registerBlock("shingle_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block SHINGLE_FENCE_GATE = registerBlock("shingle_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE), WoodType.OAK));
    public static final Block SHINGLE_DOOR = registerBlock("shingle_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block SHINGLE_TRAPDOOR = registerBlock("shingle_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.OAK));
    public static final Block SHINGLE_PRESSURE_PLATE = registerBlock("shingle_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.OAK));
    public static final Block SHINGLE_BUTTON = registerBlock("shingle_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));


    //Vegetation
    public static final Block LICHEN_GRASS = registerBlock("lichen_grass", new FernBlock(FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque()) {
    });
    public static final Block AIR_SHROOM = registerBlock("air_shroom", new AirShroomBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_ROOTS).mapColor(MapColor.RED).sounds(BlockSoundGroup.ROOTS)));
    public static final Block LICHEN_POT = registerBlockWithoutItem("lichen_pot", new Block(FabricBlockSettings.copyOf(Blocks.GRASS)));
    public static final Block SHROOM_POT = registerBlockWithoutItem("shroom_pot", new Block(FabricBlockSettings.copyOf(Blocks.GRASS)));
    public static final Block AIR_KELP = registerBlockWithoutItem("air_kelp", new AirKelpBlock(FabricBlockSettings.copyOf(Blocks.TWISTING_VINES).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AIR_KELP_PLANT = Blocks.register("air_kelp_plant", new AirKelpPlantBlock(FabricBlockSettings.copyOf(Blocks.TWISTING_VINES).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.WEEPING_VINES).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AIR_KELP_POT = registerBlockWithoutItem("air_kelp_pot", new Block(FabricBlockSettings.copyOf(Blocks.GRASS)));
    public static final Block SHROOM_MYOZYT = registerBlock("shroom_myozyt", new VineBlock(FabricBlockSettings.copyOf(Blocks.VINE).nonOpaque()));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering ModBlocks for " + ExampleMod.MOD_ID);
    }
}
