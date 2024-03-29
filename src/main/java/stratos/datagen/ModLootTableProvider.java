package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import stratos.item.ModItems;
import stratos.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.COBBLED_STRATOS_STONE);
        addDrop(ModBlocks.SKY_SEDIMENT);
        addDrop(ModBlocks.SKY_SEDIMENT_BRICKS);
        addDrop(ModBlocks.STRATOS_STONE, drops(ModBlocks.COBBLED_STRATOS_STONE));

        addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));

        addDrop(ModBlocks.AIR_MAHOE_LOG);
        addDrop(ModBlocks.AIR_MAHOE_WOOD);
        addDrop(ModBlocks.STRIPPED_AIR_MAHOE_LOG);
        addDrop(ModBlocks.STRIPPED_AIR_MAHOE_WOOD);
        addDrop(ModBlocks.AIR_MAHOE_PLANKS);
        //shingle logs and woods
        addDrop(ModBlocks.SHINGLE_LOG);
        addDrop(ModBlocks.SHINGLE_WOOD);
        addDrop(ModBlocks.STRIPPED_SHINGLE_LOG);
        addDrop(ModBlocks.STRIPPED_SHINGLE_WOOD);
        addDrop(ModBlocks.SHINGLE_PLANKS);

        addDrop(ModBlocks.AIR_MAHOE_STAIRS);
        addDrop(ModBlocks.AIR_MAHOE_TRAPDOOR);
        addDrop(ModBlocks.STRATOS_STONE_WALL);
        addDrop(ModBlocks.AIR_MAHOE_FENCE);
        addDrop(ModBlocks.AIR_MAHOE_FENCE_GATE);
        addDrop(ModBlocks.AIR_MAHOE_BUTTON);
        addDrop(ModBlocks.AIR_MAHOE_PRESSURE_PLATE);
        //shingle stairs n stuff
        addDrop(ModBlocks.SHINGLE_STAIRS);
        addDrop(ModBlocks.SHINGLE_TRAPDOOR);
        addDrop(ModBlocks.SHINGLE_FENCE);
        addDrop(ModBlocks.SHINGLE_FENCE_GATE);
        addDrop(ModBlocks.SHINGLE_BUTTON);
        addDrop(ModBlocks.SHINGLE_PRESSURE_PLATE);


        addDrop(ModBlocks.AIR_MAHOE_DOOR, doorDrops(ModBlocks.AIR_MAHOE_DOOR));
        addDrop(ModBlocks.AIR_MAHOE_SLAB, slabDrops(ModBlocks.AIR_MAHOE_SLAB));
        //shingle
        addDrop(ModBlocks.SHINGLE_DOOR, doorDrops(ModBlocks.SHINGLE_DOOR));
        addDrop(ModBlocks.SHINGLE_SLAB, slabDrops(ModBlocks.SHINGLE_SLAB));

        addDrop(ModBlocks.LICHEN_GROWTH, drops(ModBlocks.COBBLED_STRATOS_STONE));

        addDrop(ModBlocks.LICHEN_GRASS);
        addDrop(ModBlocks.AIR_KELP);

        addDrop(ModBlocks.AIR_MAHOE_LICHEN, leavesDrops(ModBlocks.AIR_MAHOE_LICHEN, ModBlocks.AIR_MAHOE_SAPLING, 0.025f)); // TODO
        //shingle
        addDrop(ModBlocks.SHINGLE_MYOZYT, leavesDrops(ModBlocks.SHINGLE_MYOZYT, ModBlocks.SHINGLE_SAPLING, 0.025f)); // TODO
    }

    //public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
    //    return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
    //            ((LeafEntry.Builder)
    //                    ItemEntry.builder(item)
    //                            .apply(SetCountLootFunction
    //                                    .builder(UniformLootNumberProvider
    //                                            .create(2.0f, 5.0f))))
    //                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    //}
}

