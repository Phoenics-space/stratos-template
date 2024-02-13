package stratos.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AncientPortalIgniterItem extends Item {
    public AncientPortalIgniterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        BlockState blockState = world.getBlockState(pos);

        if (blockState.isOf(Blocks.REINFORCED_DEEPSLATE) && world instanceof ServerWorld serverWorld) {
            checkAndRemoveSculkVeins(serverWorld, pos);
            summonLightning(world, player, pos);
            player.getItemCooldownManager().set(this, 40);
            return ActionResult.success(true);
        }

        return ActionResult.success(true);
    }


    private void summonLightning(World world, PlayerEntity player, BlockPos pos) {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
        if (lightningEntity != null) {
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightningEntity);

            if (player instanceof ServerPlayerEntity serverPlayer) {
                lightningEntity.setChanneler(serverPlayer);
            }
        }
    }

    private void checkAndRemoveSculkVeins(ServerWorld world, BlockPos centerPos) {
        int radiusX = 22;
        int radiusY = 8;

        for (BlockPos pos : BlockPos.iterate(centerPos.add(-radiusX, -radiusY, -radiusX), centerPos.add(radiusX, radiusY, radiusX))) {
            BlockState state = world.getBlockState(pos);
            if (state.isOf(Blocks.SCULK_VEIN)) {

                world.breakBlock(pos, true);
            }
        }
    }
}
