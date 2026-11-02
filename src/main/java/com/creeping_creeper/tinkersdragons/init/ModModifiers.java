package com.creeping_creeper.tinkersdragons.init;

import com.creeping_creeper.slimeworld.init.modifiers.*;
import com.creeping_creeper.tinkersdragons.modfier.RaevyxianWrathModule;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegisterEvent;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;

import static com.creeping_creeper.tinkersdragons.TinkersDragons.getResource;

public class ModModifiers {
    @SubscribeEvent
    static void registerSerializers(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
            ModifierModule.LOADER.register(getResource("affix"), RaevyxianWrathModule.INSTANCE.getLoader());
        }
    }
}
