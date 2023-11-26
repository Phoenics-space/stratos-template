package stratos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import stratos.Items.ModItems;
import stratos.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.COBBLED_STRATOS_STONE);
        addDrop(ModBlocks.STRATOS_STONE);
        addDrop(ModBlocks.RUBY_ORE);




        addDrop(ModBlocks.AIR_MAHOE_LOG);
        addDrop(ModBlocks.AIR_MAHOE_WOOD);
        addDrop(ModBlocks.STRIPPED_AIR_MAHOE_LOG);
        addDrop(ModBlocks.STRIPPED_AIR_MAHOE_WOOD);
        addDrop(ModBlocks.AIR_MAHOE_PLANKS);

        addDrop(ModBlocks.AIR_MAHOE_LICHEN, leavesDrops(ModBlocks.AIR_MAHOE_LICHEN, ModBlocks.AIR_MAHOE_LICHEN, 0.0025f)); // TODO
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}

