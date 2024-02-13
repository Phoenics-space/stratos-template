package stratos.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import stratos.item.ModItems;
import stratos.block.ModBlocks;
import stratos.mod.ExampleMod;

public class ModRegistries {
    public static void registerModRegistries() {
        registerStrippables();
        registerFlammables();
        registerPortal();
    }





    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.AIR_MAHOE_LOG, ModBlocks.STRIPPED_AIR_MAHOE_LOG);
        StrippableBlockRegistry.register(ModBlocks.AIR_MAHOE_WOOD, ModBlocks.STRIPPED_AIR_MAHOE_WOOD);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_AIR_MAHOE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_AIR_MAHOE_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.AIR_MAHOE_LICHEN, 30, 60);
    }

    private static void registerPortal() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .lightWithItem(ModItems.ANCIENT_PORTAL_IGNITER)
                .destDimID(new Identifier(ExampleMod.MOD_ID,"stratosdim"))
                .tintColor(0x7d, 0x93, 0xac)
                .registerPortal();
    }
}