package stratos.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import stratos.mod.ExampleMod;
import stratos.mod.mixin.FoliagePlacerTypeInvoker;
import stratos.world.tree.custom.AirMahoeFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> AIR_MAHOE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("air_mahoe_foliage_placer", AirMahoeFoliagePlacer.CODEC);


    public static void register() {
        ExampleMod.LOGGER.info("Registering Foliage Placer for " + ExampleMod.MOD_ID);
    }
}
