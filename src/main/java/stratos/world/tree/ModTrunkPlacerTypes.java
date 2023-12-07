package stratos.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import stratos.mod.ExampleMod;
import stratos.mod.mixin.TrunkPlacerTypeInvoker;
import stratos.world.tree.custom.AirMahoeTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> AIR_MAHOE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("air_mahoe_trunk_placer", AirMahoeTrunkPlacer.CODEC);

    public static void register() {
        ExampleMod.LOGGER.info("Registering Trunk Placers for " + ExampleMod.MOD_ID);
    }
}
