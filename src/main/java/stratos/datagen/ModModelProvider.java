package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import stratos.fluid.ModFluids;
import stratos.item.ModItems;
import stratos.block.ModBlocks;
import stratos.util.ModTextureMap;

import java.util.function.BiFunction;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool airMahoeTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AIR_MAHOE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool shingleTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SHINGLE_PLANKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRAME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STRATOS_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLED_STRATOS_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_SEDIMENT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKY_SEDIMENT_BRICKS);

        blockStateModelGenerator.registerLog(ModBlocks.AIR_MAHOE_LOG).log(ModBlocks.AIR_MAHOE_LOG).wood(ModBlocks.AIR_MAHOE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_AIR_MAHOE_LOG).log(ModBlocks.STRIPPED_AIR_MAHOE_LOG).wood(ModBlocks.STRIPPED_AIR_MAHOE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AIR_MAHOE_LICHEN);
        //shingle
        blockStateModelGenerator.registerLog(ModBlocks.SHINGLE_LOG).log(ModBlocks.SHINGLE_LOG).wood(ModBlocks.SHINGLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SHINGLE_LOG).log(ModBlocks.STRIPPED_SHINGLE_LOG).wood(ModBlocks.STRIPPED_SHINGLE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHINGLE_MYOZYT);

        registerNonStandardCube(blockStateModelGenerator, ModBlocks.LICHEN_GROWTH, "stratos:block/stratos_stone", ModTextureMap::grassBlock);



        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LICHEN_GRASS, ModBlocks.LICHEN_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AIR_SHROOM, ModBlocks.SHROOM_POT, BlockStateModelGenerator.TintType.NOT_TINTED);

        //blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AIR_KELP_TOP, ModBlocks.AIR_KELP_POT, BlockStateModelGenerator.TintType.NOT_TINTED);
        //blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.AIR_KELP_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerPlantPart(ModBlocks.AIR_KELP, ModBlocks.AIR_KELP_PLANT, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerItemModel(ModItems.AIR_KELP);
        //blockStateModelGenerator.excludeFromSimpleItemModelGeneration(ModBlocks.AIR_KELP_PLANT);


        blockStateModelGenerator.registerWallPlant(ModBlocks.SHROOM_MYOZYT);


        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.AIR_MAHOE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.SHINGLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        airMahoeTexturePool.stairs(ModBlocks.AIR_MAHOE_STAIRS);
        airMahoeTexturePool.slab(ModBlocks.AIR_MAHOE_SLAB);
        airMahoeTexturePool.button(ModBlocks.AIR_MAHOE_BUTTON);
        airMahoeTexturePool.pressurePlate(ModBlocks.AIR_MAHOE_PRESSURE_PLATE);
        airMahoeTexturePool.fence(ModBlocks.AIR_MAHOE_FENCE);
        airMahoeTexturePool.fenceGate(ModBlocks.AIR_MAHOE_FENCE_GATE);
        airMahoeTexturePool.wall(ModBlocks.STRATOS_STONE_WALL);
        //shingle
        shingleTexturePool.stairs(ModBlocks.SHINGLE_STAIRS);
        shingleTexturePool.slab(ModBlocks.SHINGLE_SLAB);
        shingleTexturePool.button(ModBlocks.SHINGLE_BUTTON);
        shingleTexturePool.pressurePlate(ModBlocks.SHINGLE_PRESSURE_PLATE);
        shingleTexturePool.fence(ModBlocks.SHINGLE_FENCE);
        shingleTexturePool.fenceGate(ModBlocks.SHINGLE_FENCE_GATE);



        blockStateModelGenerator.registerDoor(ModBlocks.AIR_MAHOE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.AIR_MAHOE_TRAPDOOR);
        //shingle
        blockStateModelGenerator.registerDoor(ModBlocks.SHINGLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SHINGLE_TRAPDOOR);
    }
    public final void registerNonStandardCube(BlockStateModelGenerator blockStateModelGenerator, Block block, String bottomTexture,
                                              BiFunction<Block, String, TextureMap> texturesFactory) {
        TextureMap textureMap = texturesFactory.apply(block, bottomTexture);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE.upload(block, textureMap, blockStateModelGenerator.modelCollector)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        //itemModelGenerator.register(ModItems.AIR_KELP, Models.GENERATED);
        itemModelGenerator.register(ModFluids.BOILING_MUD_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANCIENT_PORTAL_IGNITER, Models.HANDHELD);
    }
}

