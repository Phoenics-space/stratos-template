package stratos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import stratos.mod.Stratos;

import static stratos.mod.Stratos.identifier;

public class ModBlocks {
    // Make this into a block with a block state and remove FRAME_FILLED
    public static final Block FRAME = new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE));
    public static final Block STRATOS_STONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Block FRAME_FILLED = new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE));
    // This probably needs to be a portal block of some sort
    public static final Block FRAME_PORTAL = new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE));
    public static final Block RUBY_ORE = new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
        .strength(4f),
        UniformIntProvider.create(2, 5)
    );
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK));
    public static final Block COBBLED_STRATOS_STONE = new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE));

    public static void registerModBlocks() {
        Stratos.LOGGER.info("Registering ModBlocks for " + Stratos.MOD_ID);

        register("frame", FRAME);
        register("stratos_stone", STRATOS_STONE);
        register("frame_filled", FRAME_FILLED);
        register("portal", FRAME_PORTAL);
        register("ruby_ore", RUBY_ORE);
        register("ruby_block", RUBY_BLOCK);
        register("cobbled_stratos_stone", COBBLED_STRATOS_STONE);
    }

    private static void register(String name, Block block) {
        Registry.register(Registries.BLOCK, identifier(name), block);
    }
}

