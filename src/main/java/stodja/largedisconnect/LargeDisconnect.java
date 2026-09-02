package stodja.largedisconnect;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.components.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LargeDisconnect implements ModInitializer {
	public static final String MOD_ID = "large-disconnect";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Button currentDisconnectButton = null;

	@Override
	public void onInitialize() {
		LOGGER.info("Thicc disconnect");
		LargeDisconnectConfig.HANDLER.load();
	}

	public static void updateButtonHeight() {
		if (currentDisconnectButton != null) {
			LargeDisconnectConfig config = LargeDisconnectConfig.HANDLER.instance();

			// Check if the mod is enabled
			if (config.enabledConfig) {
				// Apply the configured height
				currentDisconnectButton.setHeight(config.buttonHeightConfig);
			} else {
				// Reset to default Minecraft button height (20)
				currentDisconnectButton.setHeight(20);
			}
		}
	}
}