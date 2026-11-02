package com.creeping_creeper.tinkersdragons.data.provider.tinkering;

import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.data.ModifierIds;

import static slimeknights.tconstruct.library.materials.MaterialRegistry.*;

public class ModTraitsProvider extends AbstractMaterialTraitDataProvider {
    public ModTraitsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(ModMaterialIds.worldroot, ModModifierIds.Dragonslayer);
        addDefaultTraits(ModMaterialIds.draconian, ModModifierIds.MalevolentFlesh);
        addDefaultTraits(ModMaterialIds.volitansSpine, ModModifierIds.Toxin);
        addTraits(ModMaterialIds.dragonheartAlloy, MELEE_HARVEST, ModModifierIds.DragonRage);
        addTraits(ModMaterialIds.dragonheartAlloy, RANGED, ModifierIds.dragonshot);
        addTraits(ModMaterialIds.dragonheartAlloy, ARMOR, ModModifierIds.DragonSoul);
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Material Traits";
    }
}
