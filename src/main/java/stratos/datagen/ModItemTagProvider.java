package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import stratos.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.AIR_MAHOE_PLANKS.asItem(),
                        ModBlocks.SHINGLE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.AIR_MAHOE_LOG.asItem(),
                        ModBlocks.AIR_MAHOE_WOOD.asItem(),
                        ModBlocks.STRIPPED_AIR_MAHOE_LOG.asItem(),
                        ModBlocks.STRIPPED_AIR_MAHOE_WOOD.asItem(),
                        //shingle logs and woods
                        ModBlocks.SHINGLE_LOG.asItem(),
                        ModBlocks.SHINGLE_WOOD.asItem(),
                        ModBlocks.STRIPPED_SHINGLE_LOG.asItem(),
                        ModBlocks.STRIPPED_SHINGLE_WOOD.asItem());
    }
}