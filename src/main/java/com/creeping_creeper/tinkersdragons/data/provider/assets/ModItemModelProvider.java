package com.creeping_creeper.tinkersdragons.data.provider.assets;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import com.creeping_creeper.tinkersdragons.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings("UnusedReturnValue")
public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinkersDragons.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.WORLDROOT_NUGGET.get());
        basicItem(ModItems.DRAGONHEART_ALLOY_NUGGET.get());

    }

}
