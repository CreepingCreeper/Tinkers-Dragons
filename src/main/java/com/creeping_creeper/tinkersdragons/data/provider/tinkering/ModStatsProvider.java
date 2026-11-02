package com.creeping_creeper.tinkersdragons.data.provider.tinkering;

import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.NETHERITE;

public class ModStatsProvider extends AbstractMaterialStatsDataProvider {
    public ModStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        addMeleeHarvest();
        addRanged();
        addAmmo();
        addArmor();
    }

    private void addMeleeHarvest() {
        addMaterialStats(ModMaterialIds.worldroot,
                new HeadMaterialStats(1450, 6.8f, NETHERITE, 3.3f),
                HandleMaterialStats.multipliers().durability(1.2f).attackDamage(1.2f).attackSpeed(0.9f).miningSpeed(0.9f).build(),
                StatlessMaterialStats.BINDING);
        addMaterialStats(ModMaterialIds.dragonheartAlloy,
                new HeadMaterialStats(2100, 5f, NETHERITE, 4.5f),
                HandleMaterialStats.multipliers().durability(0.85f).attackDamage(0.95f).attackSpeed(1.25f).miningSpeed(0.8f).build(),
                StatlessMaterialStats.BINDING);
    }

    private void addRanged() {
        addMaterialStats(ModMaterialIds.worldroot,
                new LimbMaterialStats(1450, -0.05f, 0.2f, 0.1f),
                new GripMaterialStats(1.2f, 0.05f, 3.3f));
        addMaterialStats(ModMaterialIds.dragonheartAlloy,
                new LimbMaterialStats(2100, 0.1f, 0.3f, -0.2f),
                new GripMaterialStats(-0.15f, -0.1f, 4.5f));
    }

    private void addAmmo() {
        addMaterialStats(ModMaterialIds.volitansSpine, StatlessMaterialStats.ARROW_SHAFT);
    }

    private void addArmor() {
        addMaterialStats(ModMaterialIds.draconian, StatlessMaterialStats.CUIRASS, StatlessMaterialStats.MAILLE);
        addArmorShieldStats(ModMaterialIds.dragonheartAlloy, PlatingMaterialStats.builder().durabilityFactor(40).armor(3, 8, 6, 3).toughness(3).knockbackResistance(0.1f), StatlessMaterialStats.MAILLE);

    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Material Stats";
    }
}
