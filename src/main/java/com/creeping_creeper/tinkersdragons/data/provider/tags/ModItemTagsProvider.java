package com.creeping_creeper.tinkersdragons.data.provider.tags;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModTags;
import com.leon.saintsdragons.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagProvider, TinkersDragons.MODID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        //vanilla

        //common
        tag(ModTags.Items.RAW_WORLDROOT).add(ModItems.RAW_WORLDROOT.get());
        tag(ModTags.Items.WORLDROOT_NUGGET).add(com.creeping_creeper.tinkersdragons.init.ModItems.WORLDROOT_NUGGET.get());
        tag(ModTags.Items.WORLDROOT_INGOT).add(ModItems.WORLDROOT_INGOT.get());
        copy(ModTags.Blocks.WORLDROOT_ORE, ModTags.Items.WORLDROOT_ORE);
        copy(ModTags.Blocks.RAW_WORLDROOT_BLOCK, ModTags.Items.RAW_WORLDROOT_BLOCK);
        copy(ModTags.Blocks.WORLDROOT_BLOCK, ModTags.Items.WORLDROOT_BLOCK);

        tag(ModTags.Items.RAW_DRAGONHEART).add(ModItems.DRAGONHEART_CHUNK.get());
        copy(ModTags.Blocks.DRAGONHEART_ORE, ModTags.Items.DRAGONHEART_ORE);
        copy(ModTags.Blocks.RAW_DRAGONHEART_BLOCK, ModTags.Items.RAW_DRAGONHEART_BLOCK);

        tag(ModTags.Items.DRAGONHEART_ALLOY_NUGGET).add(com.creeping_creeper.tinkersdragons.init.ModItems.DRAGONHEART_ALLOY_NUGGET.get());
        tag(ModTags.Items.DRAGONHEART_ALLOY_INGOT).add(ModItems.DRAGONHEART_ALLOY.get());
        copy(ModTags.Blocks.DRAGONHEART_ALLOY_BLOCK, ModTags.Items.DRAGONHEART_ALLOY_BLOCK);

        tag(Tags.Items.RAW_MATERIALS).addTags(ModTags.Items.RAW_DRAGONHEART, ModTags.Items.RAW_DRAGONHEART);
        tag(Tags.Items.NUGGETS).addTags(ModTags.Items.WORLDROOT_NUGGET, ModTags.Items.DRAGONHEART_ALLOY_NUGGET);
        tag(Tags.Items.INGOTS).addTags(ModTags.Items.WORLDROOT_INGOT, ModTags.Items.DRAGONHEART_ALLOY_INGOT);
        copy(Tags.Blocks.ORE_RATES_SINGULAR, Tags.Items.ORE_RATES_SINGULAR);
        copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
    }
}
