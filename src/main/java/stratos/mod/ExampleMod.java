package stratos.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratos.block.ModBlocks;
import stratos.Items.ModItemGroups;
import stratos.Items.ModItems;

public class ExampleMod implements ModInitializer {

    public static final String MOD_ID = "stratos";
    public static final Logger LOGGER = LoggerFactory.getLogger("ExampleMod");

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack heldItem = player.getStackInHand(hand);
            if (heldItem.getItem() == ModItems.RUBY) {
                BlockPos frameBlockPos = hitResult.getBlockPos();
                BlockPos blockAbovePos = frameBlockPos.up();
                BlockState blockAboveState = world.getBlockState(blockAbovePos);
                BlockState frameBlock = ModBlocks.FRAME_PORTAL.getDefaultState(); // Replace "FRAME_PORTAL" with the actual block name

                if (blockAboveState.isAir() && world.getBlockState(frameBlockPos) == frameBlock) {
                    player.setGlowing(true);
                    heldItem.decrement(1);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
