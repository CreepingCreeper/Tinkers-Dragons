package com.creeping_creeper.tinkersdragons.data.provider.tinkering;

import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class ModMaterialProvider extends AbstractMaterialDataProvider {
    public ModMaterialProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        material(ModMaterialIds.draconian).tier(1).sort(ORDER_END + ORDER_SPECIAL).craftable();
        material(ModMaterialIds.volitansSpine).tier(1).sort(ORDER_RANGED).craftable();
        material(ModMaterialIds.worldroot).tier(4).sort(ORDER_WEAPON);
        material(ModMaterialIds.dragonheartAlloy).tier(4).sort(ORDER_NETHER + ORDER_WEAPON);
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Materials";
    }

}
