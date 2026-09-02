package stodja.largedisconnect;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class LargeDisconnectConfigScreen {

    public static Screen createScreen(Screen parentScreen) {
        LargeDisconnectConfig configInstance = LargeDisconnectConfig.HANDLER.instance();

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Mod Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("General"))
                        // Toggle option
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enabled"))
                                .description(OptionDescription.of(Component.literal("Enable or disable the Large Disconnect mod.")))
                                .binding(Binding.generic(
                                        true,  // Default value
                                        () -> configInstance.enabledConfig,
                                        newVal -> configInstance.enabledConfig = newVal
                                ))
                                .controller(TickBoxControllerBuilder::create)  // Creates a checkbox/toggle
                                .build())
                        // Height option
                        .option(Option.<Integer>createBuilder()
                                .name(Component.literal("Height"))
                                .description(OptionDescription.of(Component.literal("Sets the disconnect button height.")))
                                .binding(Binding.generic(
                                        60,
                                        () -> configInstance.buttonHeightConfig,
                                        newVal -> configInstance.buttonHeightConfig = newVal
                                ))
                                .controller(opt -> IntegerFieldControllerBuilder.create(opt)
                                        .range(20, 1000))
                                .build())
                        .build())
                .save(() -> {
                    LargeDisconnectConfig.HANDLER.save();
                    stodja.largedisconnect.LargeDisconnect.updateButtonHeight();
                })
                .build()
                .generateScreen(parentScreen);
    }
}