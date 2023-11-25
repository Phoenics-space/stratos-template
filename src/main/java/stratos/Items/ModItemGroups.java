package stratos.Items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import stratos.block.ModBlocks;
import stratos.mod.Stratos;

import static stratos.mod.Stratos.identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
        .icon(() -> new ItemStack(ModItems.RUBY))
        .entries((displayContext, entries) -> ModItems.ITEMS.forEach(entries::add))
        .build();


    public static void registerItemGroups() {
        Stratos.LOGGER.info("Registering Item Groups for " + Stratos.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, identifier("ruby"), RUBY_GROUP);
    }
}

