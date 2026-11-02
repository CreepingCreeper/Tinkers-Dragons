package com.creeping_creeper.tinkersdragons.data.provider.tags;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModTags;
import com.leon.saintsdragons.common.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TinkersDragons.MODID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        //vanilla

        //common
        tag(ModTags.Blocks.WORLDROOT_ORE).add(ModBlocks.DEEPSLATE_WORLDROOT_ORE.get());
        tag(ModTags.Blocks.RAW_WORLDROOT_BLOCK).add(ModBlocks.RAW_WORLDROOT_BLOCK.get());
        tag(ModTags.Blocks.WORLDROOT_BLOCK).add(ModBlocks.WORLDROOT_BLOCK.get());

        tag(ModTags.Blocks.DRAGONHEART_ORE).add(ModBlocks.DRAGONHEART_ORE.get());
        tag(ModTags.Blocks.RAW_DRAGONHEART_BLOCK).add(ModBlocks.DRAGONHEART_BLOCK.get());
        tag(ModTags.Blocks.DRAGONHEART_ALLOY_BLOCK).add(ModBlocks.DRAGONHEART_ALLOY_BLOCK.get());

        tag(Tags.Blocks.ORE_RATES_SINGULAR).addTags(ModTags.Blocks.WORLDROOT_ORE, ModTags.Blocks.DRAGONHEART_ORE);
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(ModBlocks.DEEPSLATE_WORLDROOT_ORE.get());
        tag(Tags.Blocks.ORES).addTags(ModTags.Blocks.WORLDROOT_ORE, ModTags.Blocks.DRAGONHEART_ORE);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(ModTags.Blocks.RAW_WORLDROOT_BLOCK, ModTags.Blocks.WORLDROOT_BLOCK, ModTags.Blocks.RAW_DRAGONHEART_BLOCK, ModTags.Blocks.DRAGONHEART_ALLOY_BLOCK);
    }
}
