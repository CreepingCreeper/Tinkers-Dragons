package com.creeping_creeper.tinkersdragons.data.provider.tags;


import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class ModFluidTagProvider extends FluidTagsProvider {
     public ModFluidTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TinkersDragons.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        //common
        //tconstruct
        tag(TinkerTags.Fluids.LARGE_GEM_TOOLTIPS).addTag(ModFluids.MoltenAncientDragonite.getTag());
        tag(TinkerTags.Fluids.METAL_TOOLTIPS).addTags(ModFluids.MoltenWorldroot.getTag(), ModFluids.MoltenDragonheart.getTag(), ModFluids.MoltenDragonheartAlloy.getTag());
        //self
        fluidTag(ModFluids.MoltenWorldroot);
        fluidTag(ModFluids.MoltenAncientDragonite);
        fluidTag(ModFluids.MoltenDragonheart);
        fluidTag(ModFluids.MoltenDragonheartAlloy);
        fluidTag(ModFluids.DragonBreath);
        fluidTag(ModFluids.IgnivorusBlood);
    }

    private void fluidTag(FlowingFluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
        TagKey<Fluid> tag = fluid.getCommonTag();
        if (tag != null) {
            tag(tag).addTag(fluid.getLocalTag());
        }
    }
}
