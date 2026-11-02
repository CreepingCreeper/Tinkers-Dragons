package com.creeping_creeper.tinkersdragons.data.provider.tags;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractMaterialTagProvider;

public class ModMaterialTagsProvider extends AbstractMaterialTagProvider {
    public ModMaterialTagsProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, TinkersDragons.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TinkerTags.Materials.MELEE).add(ModMaterialIds.worldroot, ModMaterialIds.dragonheartAlloy);
        tag(TinkerTags.Materials.HEAVY).add(ModMaterialIds.worldroot, ModMaterialIds.dragonheartAlloy);
        tag(TinkerTags.Materials.EXCLUDE_FROM_LOOT).add(ModMaterialIds.dragonheartAlloy);
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Material Tag Provider";
    }
}
