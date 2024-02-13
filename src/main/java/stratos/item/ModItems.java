package stratos.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stratos.block.ModBlocks;
import stratos.item.custom.AncientPortalIgniterItem;
import stratos.mod.ExampleMod;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item ANCIENT_PORTAL_IGNITER = registerItem("ancient_portal_igniter", new AncientPortalIgniterItem(new FabricItemSettings().maxCount(1)));
    public static final Item AIR_KELP = registerItem("air_kelp", new AliasedBlockItem(ModBlocks.AIR_KELP, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering ModItems for " + ExampleMod.MOD_ID);
    }
}
