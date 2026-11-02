package com.creeping_creeper.tinkersdragons.init;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.fluid.InvertedFluid;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.common.registration.FluidDeferredRegisterExtension;

import static net.minecraft.world.level.material.MapColor.*;
import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class ModFluids {
    public static final FluidDeferredRegisterExtension FLUIDS = new FluidDeferredRegisterExtension(TinkersDragons.MODID);

    public static final FlowingFluidObject<ForgeFlowingFluid> MoltenWorldroot = FLUIDS.registerMetal("molten_worldroot").type(hot("molten_worldroot").temperature(1300).lightLevel(9)).block(createBurning(TERRACOTTA_ORANGE, 9, 10, 7f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> MoltenAncientDragonite = FLUIDS.registerGem("molten_ancient_dragonite").type(hot("molten_ancient_dragonite").temperature(1300).lightLevel(9)).block(createBurning(TERRACOTTA_CYAN, 9, 10, 7f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> MoltenDragonheart = FLUIDS.registerMetal("molten_dragonheart").type(hot("molten_dragonheart").temperature(2000).lightLevel(9)).block(createBurning(TERRACOTTA_PURPLE, 9, 10, 7f)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> MoltenDragonheartAlloy = FLUIDS.registerMetal("molten_dragonheart_alloy").type(hot("molten_dragonheart_alloy").temperature(2000).lightLevel(9)).block(createBurning(TERRACOTTA_PURPLE, 9, 10, 7f)).bucket().flowing();

    public static final FlowingFluidObject<InvertedFluid> DragonBreath = FLUIDS.register("dragon_breath").type(gas("dragon_breath").temperature(2000).lightLevel(9)).block(createBurning(COLOR_PINK, 9, 10, 7f)).commonTag().bucket().invertedFlowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> IgnivorusBlood = FLUIDS.registerMetal("ignivorus_blood").type(hot("ignivorus_blood").temperature(2000).lightLevel(9)).block(createBurning(TERRACOTTA_RED, 9, 10, 7f)).bucket().flowing();

    private static FluidType.Properties gas(String name) {
        return base(name).density(-2000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY);
    }

    private static FluidType.Properties hot(String name) {
        return base(name).density(2000).viscosity(10000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }

    private static FluidType.Properties base(String name) {
        return FluidType.Properties.create()
                .descriptionId(TinkersDragons.makeDescriptionId("fluid", name))
                .motionScale(0.0023333333333333335D);
    }
}
