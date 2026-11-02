package com.creeping_creeper.tinkersdragons.data.provider;

import com.creeping_creeper.slimeworld.init.ModItems;
import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.fluid.transfer.AbstractFluidContainerTransferProvider;

public class ModFluidContainerTransferProvider extends AbstractFluidContainerTransferProvider {
    public ModFluidContainerTransferProvider(PackOutput packOutput) {
        super(packOutput, TinkersDragons.MODID);
    }

    @Override
    protected void addTransfers() {
        addFillEmpty("dragon_breath_", Items.DRAGON_BREATH, Items.GLASS_BOTTLE, ModFluids.DragonBreath.get(), ModFluids.DragonBreath.getCommonTag(), 250, false);
    }
    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Fluid Container Transfer";
    }
}
