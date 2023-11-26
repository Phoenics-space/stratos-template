package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import stratos.Items.ModItems;
import stratos.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRAME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRATOS_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_STRATOS_STONE);

        blockStateModelGenerator.registerLog(ModBlocks.AIR_MAHOE_LOG).log(ModBlocks.AIR_MAHOE_LOG).wood(ModBlocks.AIR_MAHOE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_AIR_MAHOE_LOG).log(ModBlocks.STRIPPED_AIR_MAHOE_LOG).wood(ModBlocks.STRIPPED_AIR_MAHOE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AIR_MAHOE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AIR_MAHOE_LICHEN);
    }

    @Override
    public void generateItemModels (ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);

    }
}

