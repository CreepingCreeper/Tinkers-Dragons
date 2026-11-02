package com.creeping_creeper.tinkersdragons.data.provider.tinkering;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.tinkering.AbstractFluidEffectProvider;

public class ModFluidEffectProvider extends AbstractFluidEffectProvider {
    public ModFluidEffectProvider(PackOutput packOutput) {
        super(packOutput, TinkersDragons.MODID);
    }

    @Override
    protected void addFluids() {

   }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Fluid Provider";
    }
}
