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

        ModParticles.registerParticles();

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .lightWithItem(ModItems.RUBY)
                .destDimID(new Identifier(ExampleMod.MOD_ID, "stratosdim"))
                .tintColor(0xc96efa)
                .registerPortal();
        }
    }
