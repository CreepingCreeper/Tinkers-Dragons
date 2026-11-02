package com.creeping_creeper.tinkersdragons.data.provider.recipes;



import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import com.leon.saintsdragons.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

public class ModToolRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper {
    public ModToolRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        String tool = "tools/";
        String material = tool + "materials/";

        materialRecipe(consumer, ModMaterialIds.draconian, Ingredient.of(ModItems.DRACONIAN_FLESH.get()), 1, 1, material + "draconian");
        materialRecipe(consumer, ModMaterialIds.volitansSpine, Ingredient.of(ModItems.VOLITANS_SPINE.get()), 1, 1, material + "volitans_spine");

        metalMaterialRecipe(consumer, ModMaterialIds.worldroot, material, "worldroot", false);
        materialMeltingCasting(consumer, ModMaterialIds.worldroot, ModFluids.MoltenWorldroot, material);
        metalMaterialRecipe(consumer, ModMaterialIds.dragonheartAlloy, material, "dragonheart_alloy", false);
        materialMeltingCasting(consumer, ModMaterialIds.dragonheartAlloy, ModFluids.MoltenDragonheartAlloy, material);

        String abilityFolder = "tools/modifiers/ability/";
        String salvageFolder = "tools/modifiers/salvage/";
        String abilitySalvage = salvageFolder + "ability/";

        ModifierRecipeBuilder.modifier(ModModifierIds.BloodTempest)
                .addInput(ModItems.RAEVYX_WINGTALON.get())
                .addInput(ModItems.RAEVYX_WINGTALON.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.MELEE_PRIMARY)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.BloodTempest, abilitySalvage).withSuffix("weapon"))
                .save(consumer, prefix(ModModifierIds.BloodTempest, abilityFolder).withSuffix("weapon"));
        ModifierRecipeBuilder.modifier(ModModifierIds.BloodTempest)
                .addInput(ModItems.RAEVYX_SCALE.get())
                .addInput(ModItems.RAEVYX_WINGTALON.get())
                .addInput(ModItems.RAEVYX_SCALE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.HELMETS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.BloodTempest, abilitySalvage).withSuffix("helmets"))
                .save(consumer, prefix(ModModifierIds.BloodTempest, abilityFolder).withSuffix("helmets"));
        ModifierRecipeBuilder.modifier(ModModifierIds.BloodTempest)
                .addInput(ModItems.RAEVYX_WINGTALON.get())
                .addInput(ModItems.RAEVYX_WING_HIDE.get())
                .addInput(ModItems.RAEVYX_SCALE.get())
                .addInput(ModItems.RAEVYX_WING_HIDE.get())
                .addInput(ModItems.RAEVYX_WINGTALON.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.CHESTPLATES)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.BloodTempest, abilitySalvage).withSuffix("chestplates"))
                .save(consumer, prefix(ModModifierIds.BloodTempest, abilityFolder).withSuffix("chestplates"));
        ModifierRecipeBuilder.modifier(ModModifierIds.BloodTempest)
                .addInput(ModItems.RAEVYX_SCALE.get())
                .addInput(ModItems.RAEVYX_WING_HIDE.get())
                .addInput(ModItems.RAEVYX_SCALE.get())
                .addInput(ModItems.RAEVYX_WING_HIDE.get())
                .addInput(ModItems.RAEVYX_SCALE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.LEGGINGS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.BloodTempest, abilitySalvage).withSuffix("leggings"))
                .save(consumer, prefix(ModModifierIds.BloodTempest, abilityFolder).withSuffix("leggings"));
        ModifierRecipeBuilder.modifier(ModModifierIds.BloodTempest)
                .addInput(ModItems.RAEVYX_SCALE.get())
                .addInput(ModItems.RAEVYX_SCALE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.BOOTS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.BloodTempest, abilitySalvage).withSuffix("boots"))
                .save(consumer, prefix(ModModifierIds.BloodTempest, abilityFolder).withSuffix("boots"));

        ModifierRecipeBuilder.modifier(ModModifierIds.Dragonlord)
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.MELEE_PRIMARY)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.Dragonlord, abilitySalvage).withSuffix("weapon"))
                .save(consumer, prefix(ModModifierIds.Dragonlord, abilityFolder).withSuffix("weapon"));
        ModifierRecipeBuilder.modifier(ModModifierIds.Dragonlord)
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.HELMETS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.Dragonlord, abilitySalvage).withSuffix("helmets"))
                .save(consumer, prefix(ModModifierIds.Dragonlord, abilityFolder).withSuffix("helmets"));
        ModifierRecipeBuilder.modifier(ModModifierIds.Dragonlord)
                .addInput(ModItems.IGNIVORUS_WING_HIDE.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .addInput(ModItems.IGNIVORUS_HEART.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .addInput(ModItems.IGNIVORUS_WING_HIDE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.CHESTPLATES)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.Dragonlord, abilitySalvage).withSuffix("chestplates"))
                .save(consumer, prefix(ModModifierIds.Dragonlord, abilityFolder).withSuffix("chestplates"));
        ModifierRecipeBuilder.modifier(ModModifierIds.Dragonlord)
                .addInput(ModItems.IGNIVORUS_WING_HIDE.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .addInput(ModItems.IGNIVORUS_WING_HIDE.get())
                .addInput(ModItems.IGNIVORUS_SCALE.get())
                .addInput(ModItems.IGNIVORUS_WING_HIDE.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.LEGGINGS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.Dragonlord, abilitySalvage).withSuffix("leggings"))
                .save(consumer, prefix(ModModifierIds.Dragonlord, abilityFolder).withSuffix("leggings"));
        ModifierRecipeBuilder.modifier(ModModifierIds.Dragonlord)
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .addInput(ModItems.IGNIVORUS_TOOTH.get())
                .setSlots(SlotType.ABILITY, 1)
                .setTools(TinkerTags.Items.BOOTS)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(ModModifierIds.Dragonlord, abilitySalvage).withSuffix("boots"))
                .save(consumer, prefix(ModModifierIds.Dragonlord, abilityFolder).withSuffix("boots"));
    }

    @Override
    public @NotNull String getModId() {
        return TinkersDragons.MODID;
    }

    @Override
    public @NotNull String getName(){
        return "Tinkers' Dragons Material Recipe Provider";
    }
}
