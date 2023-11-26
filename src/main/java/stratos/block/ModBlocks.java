package stratos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import stratos.mod.ExampleMod;

public class ModBlocks{


        public static final Block FRAME = registerBlock("frame",new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));
        public static final Block STRATOS_STONE = registerBlock("stratos_stone",
                new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block FRAME_FILLED = registerBlock("frame_filled",
            new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));


    public static final Block FRAME_PORTAL = registerBlock("frame_portal",
            new Block(FabricBlockSettings.copyOf(Blocks.END_PORTAL_FRAME)));

        public static final Block RUBY_ORE = registerBlock("ruby_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));

        public static final Block RUBY_BLOCK = registerBlock("ruby_block",
                new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));

        public static final Block COBBLED_STRATOS_STONE = registerBlock("cobbled_stratos_stone",
                new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));

    public static final Block AIR_MAHOE_LOG = registerBlock("air_mahoe_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block AIR_MAHOE_WOOD = registerBlock("air_mahoe_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_AIR_MAHOE_LOG = registerBlock("stripped_air_mahoe_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_AIR_MAHOE_WOOD = registerBlock("stripped_air_mahoe_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block AIR_MAHOE_PLANKS = registerBlock("air_mahoe_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block AIR_MAHOE_LICHEN = registerBlock("air_mahoe_lichen",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));




        private static Block registerBlock(String name, Block block) {
            registerBlockItem(name, block);
            return Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
        }

        private static Item registerBlockItem(String name, Block block) {
            return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name),
                    new BlockItem(block, new FabricItemSettings()));
        }

        public static void registerModBlocks() {
            ExampleMod.LOGGER.info("Registering ModBlocks for " + ExampleMod.MOD_ID);



        }
}

