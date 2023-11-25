package stratos.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stratos.block.ModBlocks;
import stratos.mod.Stratos;

import java.util.ArrayList;
import java.util.List;

import static stratos.mod.Stratos.identifier;

public class ModItems {
    static final List<Item> ITEMS = new ArrayList<>();

    public static final BlockItem FRAME = new BlockItem(ModBlocks.FRAME, new FabricItemSettings());
    public static final BlockItem STRATOS_STONE = new BlockItem(ModBlocks.STRATOS_STONE, new FabricItemSettings());
    public static final BlockItem FRAME_FILLED = new BlockItem(ModBlocks.FRAME_FILLED, new FabricItemSettings());
    public static final BlockItem FRAME_PORTAL = new BlockItem(ModBlocks.FRAME_PORTAL, new FabricItemSettings());
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new FabricItemSettings());
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new FabricItemSettings());
    public static final BlockItem COBBLED_STRATOS_STONE = new BlockItem(ModBlocks.COBBLED_STRATOS_STONE, new FabricItemSettings());

    public static final Item RUBY = new Item(new FabricItemSettings());

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }

    private static void register(String name, Item item) {
        ITEMS.add(item);
        Registry.register(Registries.ITEM, identifier(name), item);
    }

    private static void register(BlockItem item) {
        ITEMS.add(item);
        Registry.register(Registries.ITEM, Registries.BLOCK.getId(item.getBlock()), item);
    }

    public static void registerModItems() {
        Stratos.LOGGER.info("registering the mod items for" + Stratos.MOD_ID);

        register(FRAME);
        register(STRATOS_STONE);
        register(FRAME_FILLED);
        register(FRAME_PORTAL);
        register(RUBY_ORE);
        register(RUBY_BLOCK);
        register(COBBLED_STRATOS_STONE);

        register("ruby", RUBY);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
