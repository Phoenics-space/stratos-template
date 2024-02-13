package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import stratos.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LICHEN_GROWTH)
                .add(ModBlocks.COBBLED_STRATOS_STONE)
                .add(ModBlocks.STRATOS_STONE)
                .add(ModBlocks.FRAME)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.SKY_SEDIMENT)
                .add(ModBlocks.RUBY_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_BLOCK,
                        ModBlocks.RUBY_ORE);






        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.AIR_MAHOE_LOG)
                .add(ModBlocks.AIR_MAHOE_WOOD)
                .add(ModBlocks.STRIPPED_AIR_MAHOE_LOG)
                .add(ModBlocks.STRIPPED_AIR_MAHOE_WOOD)
                //shingle logs and woods
                .add(ModBlocks.SHINGLE_LOG)
                .add(ModBlocks.SHINGLE_WOOD)
                .add(ModBlocks.STRIPPED_SHINGLE_LOG)
                .add(ModBlocks.STRIPPED_SHINGLE_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.AIR_MAHOE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.AIR_MAHOE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.STRATOS_STONE_WALL);
        //shingle fences and gates
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SHINGLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SHINGLE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.LICHEN_GROWTH);

    }
}


