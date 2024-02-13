package stratos.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import stratos.mod.ExampleMod;

public class ModFluids {
    public static FlowableFluid STILL_BOILING_MUD;
    public static FlowableFluid FLOWING_BOUILING_MUD;
    public static Block BOILING_MUD_BLOCK;
    public static Item BOILING_MUD_BUCKET;

    public static void register() {
        STILL_BOILING_MUD = Registry.register(Registries.FLUID, new Identifier(ExampleMod.MOD_ID, "boiling_mud"), new BoilingMudFluid.Still());

        FLOWING_BOUILING_MUD = Registry.register(Registries.FLUID, new Identifier(ExampleMod.MOD_ID, "flowing_boiling_mud"), new BoilingMudFluid.Flowing());

        BOILING_MUD_BLOCK = Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, "boiling_mud_block"),
                new FluidBlock(ModFluids.STILL_BOILING_MUD, FabricBlockSettings.copyOf(Blocks.LAVA)) {
                });

        BOILING_MUD_BUCKET = Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, "boiling_mud_bucket"),
                new BucketItem(ModFluids.STILL_BOILING_MUD, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
