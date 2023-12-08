package stratos.mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratos.Items.ModItemGroups;
import stratos.Items.ModItems;
import stratos.block.ModBlocks;
import stratos.particle.ModParticles;
import stratos.util.ModRegistries;
import stratos.world.gen.ModWorldGeneration;
import stratos.world.tree.ModFoliagePlacerTypes;

public class ExampleMod
        implements ModInitializer {
    public static final String MOD_ID = "stratos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModRegistries.registerModRegistries();

        ModParticles.registerParticles();

        //ModTrunkPlacerTypes.register();
        ModFoliagePlacerTypes.register();

        ModWorldGeneration.generateModWorldGeneration();

        /* The Portal is now under: 
        * 
        * stratos/util/ModRegistries/registerPortal()
        * 
        * */
    }
}
