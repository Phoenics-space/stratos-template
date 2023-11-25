package stratos.mod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stratos.block.ModBlocks;
import stratos.Items.ModItemGroups;
import stratos.Items.ModItems;

public class Stratos implements ModInitializer {

    public static final String MOD_ID = "stratos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
    }

    @NotNull
    public static Identifier identifier(@NotNull String path) {
        return new Identifier(MOD_ID, path);
    }
}
