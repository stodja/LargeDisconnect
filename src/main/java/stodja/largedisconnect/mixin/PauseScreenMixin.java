package stodja.largedisconnect.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import stodja.largedisconnect.LargeDisconnect;
import stodja.largedisconnect.LargeDisconnectConfig;

@Mixin(PauseScreen.class)
public class PauseScreenMixin {

	@Shadow
	private Button disconnectButton;

	@Inject(method = "createPauseMenu", at = @At("TAIL"))
	private void adjustLayoutAndMakeTaller(CallbackInfo ci) {
		if (this.disconnectButton != null) {
			LargeDisconnectConfig config = LargeDisconnectConfig.HANDLER.instance();

			if (config.enabledConfig) {
				LargeDisconnect.currentDisconnectButton = this.disconnectButton;

				int buttonHeightConfig = config.buttonHeightConfig;
				this.disconnectButton.setHeight(buttonHeightConfig);
			}
		}
	}
}