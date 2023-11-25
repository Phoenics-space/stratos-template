package stratos.mod;

import net.fabricmc.api.ModInitializer;
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
    }
}
