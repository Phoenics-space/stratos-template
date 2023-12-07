package stratos.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item AIR_KELP = registerItem("air_kelp", new AliasedBlockItem(ModBlocks.AIR_KELP, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }

    private static Item registerItem(String name, Item Item) {
        return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), Item);
    }
    public static void registerModItems() {
        ExampleMod.LOGGER.info("registering the mod items for" + ExampleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}