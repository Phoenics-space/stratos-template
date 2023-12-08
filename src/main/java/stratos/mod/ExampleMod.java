package stratos.mod;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratos.Items.ModItemGroups;
import stratos.Items.ModItems;
import stratos.block.ModBlocks;
import stratos.particle.ModParticles;
public class ExampleMod implements ModInitializer {

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
        }
    }
