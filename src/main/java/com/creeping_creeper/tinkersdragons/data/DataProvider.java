package com.creeping_creeper.tinkersdragons.data;

import com.creeping_creeper.slimeworld.SlimeWorld;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.provider.ModFluidContainerTransferProvider;
import com.creeping_creeper.tinkersdragons.data.provider.assets.ModFluidTextureProvider;
import com.creeping_creeper.tinkersdragons.data.provider.assets.ModItemModelProvider;
import com.creeping_creeper.tinkersdragons.data.provider.assets.ModMaterialRenderInfoProvider;
import com.creeping_creeper.tinkersdragons.data.provider.assets.ModMaterialSpriteProvider;
import com.creeping_creeper.tinkersdragons.data.provider.recipes.ModSmelteryRecipeProvider;
import com.creeping_creeper.tinkersdragons.data.provider.recipes.ModToolRecipeProvider;
import com.creeping_creeper.tinkersdragons.data.provider.tags.*;
import com.creeping_creeper.tinkersdragons.data.provider.tinkering.ModMaterialProvider;
import com.creeping_creeper.tinkersdragons.data.provider.tinkering.ModModifierProvider;
import com.creeping_creeper.tinkersdragons.data.provider.tinkering.ModStatsProvider;
import com.creeping_creeper.tinkersdragons.data.provider.tinkering.ModTraitsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.mantle.fluid.texture.FluidTextureCameraProvider;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TinkersDragons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    static void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean server = event.includeServer();
        boolean client = event.includeClient();
        //resource pack
        generator.addProvider(client, new ModItemModelProvider(output, existingFileHelper));
        ModFluidTextureProvider textureProvider = new ModFluidTextureProvider(output);
        generator.addProvider(client, textureProvider);
        generator.addProvider(client, new FluidTextureCameraProvider(output, event.getExistingFileHelper(), textureProvider));
        generator.addProvider(client, new FluidBucketModelProvider(output, TinkersDragons.MODID));
        generator.addProvider(client, new FluidBlockstateModelProvider(output, TinkersDragons.MODID));
        TinkerPartSpriteProvider partSprites = new TinkerPartSpriteProvider();
        ModMaterialSpriteProvider materialSprites = new ModMaterialSpriteProvider();
        generator.addProvider(client, new ModMaterialRenderInfoProvider(output, materialSprites, existingFileHelper));
        generator.addProvider(client, new MaterialPartTextureGenerator(output, existingFileHelper, partSprites, materialSprites));

        //data pack
        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder();
        DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), registrySetBuilder, Set.of(SlimeWorld.MODID));
        generator.addProvider(server, datapackProvider);
        //recipes
        generator.addProvider(server, new ModToolRecipeProvider(output));
        generator.addProvider(server, new ModSmelteryRecipeProvider(output));
        //tags
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new ModItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new ModFluidTagProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ModEntityTypeTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ModDamageTypeTagsProvider(output, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ModModifierTagsProvider(output, existingFileHelper));
        generator.addProvider(server, new ModMaterialTagsProvider(output, existingFileHelper));
        //others
        generator.addProvider(server, new ModFluidContainerTransferProvider(output));
        ModMaterialProvider materials = new ModMaterialProvider(output);
        generator.addProvider(server, materials);
        generator.addProvider(server, new ModStatsProvider(output, materials));
        generator.addProvider(server, new ModTraitsProvider(output, materials));
        //generator.addProvider(server, new ModFluidEffectProvider(output));
        generator.addProvider(server, new ModModifierProvider(output));
    }

}
