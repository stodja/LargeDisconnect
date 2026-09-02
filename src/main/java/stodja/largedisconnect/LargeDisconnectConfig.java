package stodja.largedisconnect;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

public class LargeDisconnectConfig {
    public static ConfigClassHandler<LargeDisconnectConfig> HANDLER = ConfigClassHandler.createBuilder(LargeDisconnectConfig.class)
            .id(Identifier.fromNamespaceAndPath("largedisconnect", "largedisconnectconfig"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("largedisconnect.json5"))
                    .setJson5(true)
                    .build())
            .build();

    @SerialEntry
    public boolean enabledConfig = true;

    @SerialEntry
    public int buttonHeightConfig = 60;
}