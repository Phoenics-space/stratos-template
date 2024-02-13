package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import stratos.item.ModItems;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RUBY,
            ModBlocks.RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        //airmahoe

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AIR_MAHOE_PLANKS, 4)
                .input(ModBlocks.AIR_MAHOE_LOG)
                .criterion(hasItem(ModBlocks.AIR_MAHOE_LOG), conditionsFromItem(ModBlocks.AIR_MAHOE_LOG))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.AIR_MAHOE_PLANKS) + "_from_air_mahoe_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AIR_MAHOE_PLANKS, 4)
                .input(ModBlocks.AIR_MAHOE_WOOD)
                .criterion(hasItem(ModBlocks.AIR_MAHOE_WOOD), conditionsFromItem(ModBlocks.AIR_MAHOE_WOOD))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.AIR_MAHOE_PLANKS) + "_from_air_mahoe_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AIR_MAHOE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_AIR_MAHOE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_AIR_MAHOE_LOG), conditionsFromItem(ModBlocks.STRIPPED_AIR_MAHOE_LOG))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.AIR_MAHOE_PLANKS) + "_from_stripped_air_mahoe_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AIR_MAHOE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_AIR_MAHOE_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_AIR_MAHOE_WOOD), conditionsFromItem(ModBlocks.STRIPPED_AIR_MAHOE_WOOD))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.AIR_MAHOE_PLANKS) + "_from_stripped_air_mahoe_wood"));


//shinglewood

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_PLANKS, 4)
                .input(ModBlocks.SHINGLE_LOG)
                .criterion(hasItem(ModBlocks.SHINGLE_LOG), conditionsFromItem(ModBlocks.SHINGLE_LOG))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.SHINGLE_PLANKS) + "_from_shingle_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_PLANKS, 4)
                .input(ModBlocks.SHINGLE_WOOD)
                .criterion(hasItem(ModBlocks.SHINGLE_WOOD), conditionsFromItem(ModBlocks.SHINGLE_WOOD))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.SHINGLE_PLANKS) + "_from_shingle_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SHINGLE_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_SHINGLE_LOG), conditionsFromItem(ModBlocks.STRIPPED_SHINGLE_LOG))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.SHINGLE_PLANKS) + "_from_stripped_shingle_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHINGLE_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SHINGLE_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_SHINGLE_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SHINGLE_WOOD))
                .offerTo(exporter, new Identifier(ExampleMod.MOD_ID, getItemPath(ModBlocks.SHINGLE_PLANKS) + "_from_stripped_shingle_wood"));


        createTrapdoorRecipe(ModBlocks.AIR_MAHOE_PLANKS, Ingredient.ofItems(ModBlocks.AIR_MAHOE_PLANKS));

        createFenceRecipe(ModBlocks.AIR_MAHOE_PLANKS, Ingredient.ofItems(ModBlocks.AIR_MAHOE_PLANKS));

        createFenceGateRecipe(ModBlocks.AIR_MAHOE_PLANKS, Ingredient.ofItems(ModBlocks.AIR_MAHOE_PLANKS));

        createDoorRecipe(ModBlocks.AIR_MAHOE_PLANKS, Ingredient.ofItems(ModBlocks.AIR_MAHOE_PLANKS));
        //shingle
        createTrapdoorRecipe(ModBlocks.SHINGLE_PLANKS, Ingredient.ofItems(ModBlocks.SHINGLE_PLANKS));

        createFenceRecipe(ModBlocks.SHINGLE_PLANKS, Ingredient.ofItems(ModBlocks.SHINGLE_PLANKS));

        createFenceGateRecipe(ModBlocks.SHINGLE_PLANKS, Ingredient.ofItems(ModBlocks.SHINGLE_PLANKS));

        createDoorRecipe(ModBlocks.SHINGLE_PLANKS, Ingredient.ofItems(ModBlocks.SHINGLE_PLANKS));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .pattern("###")
                .pattern(" | ")
                .pattern(" | ")
                .input('#', ModBlocks.COBBLED_STRATOS_STONE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.COBBLED_STRATOS_STONE), conditionsFromItem(ModBlocks.COBBLED_STRATOS_STONE))
                .offerTo(exporter, new Identifier(getItemPath(Items.STONE_PICKAXE) + "_from_cobbled_stratos_stone"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_AXE)
                .pattern("## ")
                .pattern("#| ")
                .pattern(" | ")
                .input('#', ModBlocks.COBBLED_STRATOS_STONE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.COBBLED_STRATOS_STONE), conditionsFromItem(ModBlocks.COBBLED_STRATOS_STONE))
                .offerTo(exporter, new Identifier(getItemPath(Items.STONE_AXE) + "_from_cobbled_stratos_stone"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SWORD)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" | ")
                .input('#', ModBlocks.COBBLED_STRATOS_STONE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.COBBLED_STRATOS_STONE), conditionsFromItem(ModBlocks.COBBLED_STRATOS_STONE))
                .offerTo(exporter, new Identifier(getItemPath(Items.STONE_SWORD) + "_from_cobbled_stratos_stone"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                .pattern(" # ")
                .pattern(" | ")
                .pattern(" | ")
                .input('#', ModBlocks.COBBLED_STRATOS_STONE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModBlocks.COBBLED_STRATOS_STONE), conditionsFromItem(ModBlocks.COBBLED_STRATOS_STONE))
                .offerTo(exporter, new Identifier(getItemPath(Items.STONE_SHOVEL) + "_from_cobbled_stratos_stone"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ANCIENT_PORTAL_IGNITER)
                .pattern("+#+")
                .pattern("|||")
                .pattern(" | ")
                .input('#', ModItems.RUBY)
                .input('+', Items.ECHO_SHARD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getItemPath(ModItems.ANCIENT_PORTAL_IGNITER)));

    }
}

