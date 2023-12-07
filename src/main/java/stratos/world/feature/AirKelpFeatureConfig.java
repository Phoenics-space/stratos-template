package stratos.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

public record AirKelpFeatureConfig(int spreadWidth, int spreadHeight, int maxHeight) implements FeatureConfig {

    public static final Codec<AirKelpFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codecs.POSITIVE_INT.fieldOf("spread_width")
                .forGetter(AirKelpFeatureConfig::spreadWidth), Codecs.POSITIVE_INT.fieldOf("spread_height")
                .forGetter(AirKelpFeatureConfig::spreadHeight), Codecs.POSITIVE_INT.fieldOf("max_height")
                .forGetter(AirKelpFeatureConfig::maxHeight)).apply(instance, AirKelpFeatureConfig::new);
    });

    public AirKelpFeatureConfig(int spreadWidth, int spreadHeight, int maxHeight) {
        this.spreadWidth = spreadWidth;
        this.spreadHeight = spreadHeight;
        this.maxHeight = maxHeight;
    }

    public int spreadWidth() {
        return this.spreadWidth;
    }

    public int spreadHeight() {
        return this.spreadHeight;
    }

    public int maxHeight() {
        return this.maxHeight;
    }
}