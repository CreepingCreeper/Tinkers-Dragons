package com.creeping_creeper.tinkersdragons.data.provider.assets;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.TConstruct;

import static slimeknights.tconstruct.fluids.TinkerFluids.withoutMolten;

@SuppressWarnings({"UnusedReturnValue", "SameParameterValue"})
public class ModFluidTextureProvider extends AbstractFluidTextureProvider {

    public ModFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, TinkersDragons.MODID);
    }

    @Override
    public void addTextures() {
        moltenFolder(ModFluids.MoltenWorldroot, "metal");
        moltenFolder(ModFluids.MoltenDragonheart, "metal");
        alloy(ModFluids.MoltenDragonheartAlloy);
        moltenFolder(ModFluids.MoltenAncientDragonite, "gem");
        tinted(ModFluids.DragonBreath, "fluid/liquid/", 0xFFde9dc5);
        tinted(ModFluids.IgnivorusBlood, "fluid/liquid/", 0xFF8c270a);
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return texture(fluid).root(TinkersDragons.getResource("fluid/" + name + "/"))
                .still().flowing().camera().calculateFogColor(true).fog(FogShape.SPHERE, 0.25f, 2);
    }

    private FluidTexture.Builder moltenFolder(FluidObject<?> fluid, String folder) {
        return named(fluid, "molten/" + folder + "/" + withoutMolten(fluid));
    }

    private FluidTexture.Builder alloy(FluidObject<?> fluid) {
        return moltenFolder(fluid, "alloy");
    }

    private FluidTexture.Builder tinted(FluidObject<?> fluid, String location, int color){
        return texture(fluid).root(TConstruct.getResource(location)).still().flowing().calculateFogColor(true).fog(FogShape.SPHERE, 0.25f, 2).color(color);

    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Fluid Texture Providers";
    }
}
