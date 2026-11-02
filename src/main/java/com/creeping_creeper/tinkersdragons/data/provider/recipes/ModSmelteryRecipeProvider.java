package com.creeping_creeper.tinkersdragons.data.provider.recipes;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.data.key.ModTags;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import com.creeping_creeper.tinkersdragons.init.ModItems;
import com.leon.saintsdragons.common.registry.ModEntities;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.entitymelting.EntityMeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.data.Byproduct;

import java.util.function.Consumer;

public class ModSmelteryRecipeProvider extends RecipeProvider implements ICommonRecipeHelper, ISmelteryRecipeHelper {
    public ModSmelteryRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public @NotNull String getModId() {
        return TinkersDragons.MODID;
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        String common = "common/";
        packingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, "ingot", com.leon.saintsdragons.common.registry.ModItems.WORLDROOT_INGOT.get(), "nugget", ModItems.WORLDROOT_NUGGET, common);
        packingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, "ingot", com.leon.saintsdragons.common.registry.ModItems.DRAGONHEART_ALLOY.get(), "nugget", ModItems.DRAGONHEART_ALLOY_NUGGET, common);

        AlloyRecipeBuilder.alloy(ModFluids.MoltenDragonheartAlloy, FluidValues.INGOT)
                .addInput(ModFluids.MoltenDragonheart.getTag(), FluidValues.INGOT * 2)
                .addInput(ModFluids.MoltenWorldroot.getTag(), FluidValues.INGOT)
                .addCatalyst(ModFluids.MoltenAncientDragonite.ingredient(FluidValues.GEM * 8))
                .save(consumer, prefix(ModFluids.MoltenDragonheartAlloy, "alloy/"));

        String melting = "melting/";

        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.ANCIENT_DRAGONITE_FRAGMENT.get()), ModFluids.MoltenAncientDragonite, FluidValues.GEM)
                .save(consumer, location(melting + "ancient_dragonite_fragment"));
        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.DRACONIC_CRUCIBLE.get()), ModFluids.MoltenAncientDragonite, FluidValues.GEM * 8)
                .addByproduct(TinkerFluids.moltenIron.result(FluidValues.INGOT * 5))
                .save(consumer, location(melting + "draconic_crucible"));
        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.DRAGON_BINDER_CORE.get()), ModFluids.MoltenWorldroot, FluidValues.INGOT * 4)
                .addByproduct(FluidOutput.fromTag(ModTags.Fluids.MOLTEN_ECHO, FluidValues.GEM * 4))
                .save(consumer, location(melting + "dragon_binder_core"));
        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModTags.Items.DRAGON_BINDERS), ModFluids.MoltenWorldroot, FluidValues.INGOT * 4)
                .addByproduct(FluidOutput.fromTag(ModTags.Fluids.MOLTEN_ECHO, FluidValues.GEM * 4))
                .save(consumer, location(melting + "dragon_binder"));

        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.CINDERVANE_SCALE.get()), TinkerFluids.blazingBlood, 120)
                .save(consumer, location(melting + "cindervane_scale"));
        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.SEARING_COAL.get()), TinkerFluids.blazingBlood, 320)
                .save(consumer, location(melting + "searing_coal"));
        MeltingRecipeBuilder.melting(Ingredient.of(com.leon.saintsdragons.common.registry.ModItems.IGNIVORUS_HEART.get()), ModFluids.IgnivorusBlood, FluidValues.GLASS_BLOCK)
                .save(consumer, location(melting + "ignivorus_heart"));


        String casting = "casting/";

        ItemCastingRecipeBuilder.tableRecipe(com.leon.saintsdragons.common.registry.ModItems.ANCIENT_DRAGONITE_FRAGMENT.get())
                .setCast(TinkerSmeltery.gemCast.getMultiUseTag(), false)
                .setFluidAndTime(ModFluids.MoltenAncientDragonite, FluidValues.GEM)
                .save(consumer, location(casting + "ancient_dragonite_fragment"));

        ItemCastingRecipeBuilder.tableRecipe(com.leon.saintsdragons.common.registry.ModItems.ANCIENT_DRAGONITE_FRAGMENT.get())
                .setCast(TinkerSmeltery.gemCast.getSingleUseTag(), true)
                .setFluidAndTime(ModFluids.MoltenAncientDragonite, FluidValues.GEM)
                .save(consumer, location(casting + "ancient_dragonite_fragment_sand_cast"));

        ItemCastingRecipeBuilder.basinRecipe(com.leon.saintsdragons.common.registry.ModItems.DRACONIC_CRUCIBLE.get())
                .setCast(Items.BLAST_FURNACE, true)
                .setFluidAndTime(ModFluids.MoltenAncientDragonite, FluidValues.GEM * 8)
                .save(consumer, location(casting + "draconic_crucible"));

        ItemCastingRecipeBuilder.tableRecipe(Items.DRAGON_BREATH)
                .setCast(Items.GLASS_BOTTLE, true)
                .setFluid(ModFluids.DragonBreath.ingredient(FluidValues.SLIMEBALL))
                .setCoolingTime(1)
                .save(consumer, location(casting + "dragon_breath"));

//        ItemCastingRecipeBuilder.basinRecipe(com.leon.saintsdragons.common.registry.ModItems.DRAGON_BINDER_CORE.get())
//                .setCast(ModItems.ECHO_STONE, true)
//                .setFluid(ModTags.Fluids.MOLTEN_ECHO, FluidValues.GEM * 4)
//                .setCoolingTime(107)
//                .save(consumer, location(casting + "echo_stone"));

//        ItemCastingRecipeBuilder.basinRecipe(com.leon.saintsdragons.common.registry.ModItems.DRAGON_BINDER_CORE.get())
//                .setCast(ModItems.ECHO_STONE, true)
//                .setFluidAndTime(ModFluids.MoltenWorldroot,FluidValues.INGOT * 4)
//                .save(consumer, location(casting + "dragon_binder_core"));

        molten(consumer, ModFluids.MoltenWorldroot).metal().ore(Byproduct.COBALT).rawOre(Byproduct.DIAMOND).singularOre(2);
        molten(consumer, ModFluids.MoltenDragonheart).oreRate(IMeltingContainer.OreRateType.METAL).baseUnit(FluidValues.INGOT).rawOre(Byproduct.DEBRIS).singularOre(2);
        molten(consumer, ModFluids.MoltenDragonheartAlloy).metal();

        EntityMeltingRecipeBuilder.melting(EntityIngredient.of(ModEntities.CINDERVANE.get()), TinkerFluids.blazingBlood.result(10), 2)
                .save(consumer, location(melting + "cindervane"));
        EntityMeltingRecipeBuilder.melting(EntityIngredient.of(ModEntities.IGNIVORUS.get()), ModFluids.IgnivorusBlood.result(10), 2)
                .save(consumer, location(melting + "ignivorus"));
    }

    @Override
    public @NotNull String getName(){
        return "Tinkers' Dragons Smeltery Recipe Provider";
    }
}