package stratos.world.biome;

import net.minecraft.util.Identifier;
import stratos.mod.ExampleMod;
import stratos.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(ExampleMod.MOD_ID, "overworld"), 1));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ExampleMod.MOD_ID, ModMaterialRules.makeLichenValleyRules());
    }
}