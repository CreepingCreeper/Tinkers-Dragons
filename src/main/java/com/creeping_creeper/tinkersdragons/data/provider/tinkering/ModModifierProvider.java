package com.creeping_creeper.tinkersdragons.data.provider.tinkering;

import com.creeping_creeper.tinkersdragons.data.key.ModDataKeys;
import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import com.creeping_creeper.tinkersdragons.data.key.ModTags;
import com.creeping_creeper.tinkersdragons.modfier.RaevyxianWrathModule;
import com.leon.saintsdragons.common.registry.ModAttributes;
import com.leon.saintsdragons.common.registry.ModEntities;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.RandomLevelingValue;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierRequirementsModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalMeleeDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.ConditionalPowerModule;
import slimeknights.tconstruct.library.modifiers.modules.combat.MobEffectModule;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorLevelModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.shared.TinkerAttributes;

import static slimeknights.tconstruct.library.json.math.ModifierFormula.LEVEL;
import static slimeknights.tconstruct.library.json.math.ModifierFormula.VALUE;

public class ModModifierProvider extends AbstractModifierProvider {
    public ModModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    protected void addModifiers() {
        buildModifier(ModModifierIds.Dragonslayer)
                .addModule(ConditionalMeleeDamageModule.builder().percent()
                        .target(LivingEntityPredicate.tag(ModTags.EntityTypes.DRAGONSLAYER))
                        .formula()
                        .variable(LEVEL)
                        .constant(0.25f).multiply()
                        .constant(1).add()
                        .variable(VALUE).multiply()
                        .build())
                .addModule(ConditionalPowerModule.builder().percent()
                        .target(LivingEntityPredicate.tag(ModTags.EntityTypes.DRAGONSLAYER))
                        .formula()
                        .variable(LEVEL)
                        .constant(0.25f).multiply()
                        .constant(1).add()
                        .variable(VALUE).multiply()
                        .build());

        buildModifier(ModModifierIds.MalevolentFlesh).levelDisplay(ModifierLevelDisplay.SINGLE_LEVEL)
                .addModule(new ArmorLevelModule(ModDataKeys.MALEVOLENT_FLESH, true, null));

        buildModifier(ModModifierIds.Toxin)
                .addModule(MobEffectModule.builder(MobEffects.BLINDNESS).time(RandomLevelingValue.flat(100)).buildWeapon())
                .addModule(MobEffectModule.builder(MobEffects.POISON).time(RandomLevelingValue.flat(600)).level(RandomLevelingValue.flat(2)).buildWeapon());

        buildModifier(ModModifierIds.DragonRage)
                .addModule(AttributeModule.builder(TinkerAttributes.CRITICAL_DAMAGE, AttributeModifier.Operation.ADDITION).eachLevel(0.25f))
                .addModule(AttributeModule.builder(ForgeMod.BLOCK_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1))
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION).eachLevel(1));

        buildModifier(ModModifierIds.DragonSoul)
                .addModule(AttributeModule.builder(ModAttributes.FIRE_RESISTANCE, AttributeModifier.Operation.ADDITION).eachLevel(12.5f))
                .addModule(AttributeModule.builder(ModAttributes.BLAST_RESISTANCE, AttributeModifier.Operation.ADDITION).eachLevel(12.5f));

        buildModifier(ModModifierIds.BloodTempest).levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(ConditionalMeleeDamageModule.builder().percent()
                        .target(LivingEntityPredicate.set(ModEntities.RAEVYX.get()))
                        .formula()
                        .constant(5)
                        .variable(VALUE).multiply()
                        .build())
                .addModule(ModifierRequirementsModule.builder().requireModifier(ModTags.Modifiers.DRAGONLIKE, 1).modifierKey(ModModifierIds.BloodTempest).build())
                .addModule(RaevyxianWrathModule.INSTANCE)
                .addModule(new ArmorLevelModule(ModDataKeys.BLOOD_TEMPEST, true, TinkerTags.Items.HELD_ARMOR));

        buildModifier(ModModifierIds.Dragonlord).levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(ConditionalMeleeDamageModule.builder().percent()
                        .target(LivingEntityPredicate.set(ModEntities.IGNIVORUS.get()))
                        .formula()
                        .constant(5)
                        .variable(VALUE).multiply()
                        .build())
                .addModule(ModifierRequirementsModule.builder().requireModifier(ModTags.Modifiers.DRAGONLIKE, 1).modifierKey(ModModifierIds.Dragonlord).build())
                .addModule(new ArmorLevelModule(ModDataKeys.DRAGONLORD, true, TinkerTags.Items.HELD_ARMOR));
    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Modifier Provider";
    }
}
