package net.prehistoric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.prehistoric.screens.Analyzer.AnalyzerScreen;
import net.prehistoric.screens.ArcheologyWorkbench.ArcheologyWorkbenchScreen;
import net.prehistoric.screens.Sifter.SifterBlockScreen;

@Environment(EnvType.CLIENT)
public class PrehistoricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Prehistoric.SIFTER_BLOCK_SCREEN_HANDLER, SifterBlockScreen::new);
        ScreenRegistry.register(Prehistoric.ANALYZER_SCREEN_HANDLER, AnalyzerScreen::new);
        ScreenRegistry.register(Prehistoric.ARCHEOLOGY_WORKBENCH_SCREEN_HANDLER, ArcheologyWorkbenchScreen::new);
    }
}
