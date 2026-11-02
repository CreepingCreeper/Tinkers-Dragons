package com.creeping_creeper.tinkersdragons.data.provider.tags;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import com.creeping_creeper.tinkersdragons.data.key.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierTagProvider;

import static slimeknights.tconstruct.common.TinkerTags.Modifiers.GENERAL_ARMOR_ABILITIES;
import static slimeknights.tconstruct.common.TinkerTags.Modifiers.MELEE_ABILITIES;

public class ModModifierTagsProvider extends AbstractModifierTagProvider {
    public ModModifierTagsProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, TinkersDragons.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Modifiers.DRAGONLIKE).add(ModModifierIds.DragonRage, ModModifierIds.DragonSoul);
        tag(MELEE_ABILITIES).add(ModModifierIds.BloodTempest, ModModifierIds.Dragonlord);
        tag(GENERAL_ARMOR_ABILITIES).add(ModModifierIds.BloodTempest, ModModifierIds.Dragonlord);
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Modifier Tag Provider";
    }
}
