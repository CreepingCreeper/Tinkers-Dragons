package com.creeping_creeper.tinkersdragons.data.provider.assets;

import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class ModMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {
    public ModMaterialRenderInfoProvider(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, materialSprites, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(ModMaterialIds.draconian).color(0xFF606060).fallbacks("cloth");
        buildRenderInfo(ModMaterialIds.volitansSpine).color(0xFF8b9bb1).fallbacks("bone");
        buildRenderInfo(ModMaterialIds.worldroot).color(0xFFf8a44e).fallbacks("metal");
        buildRenderInfo(ModMaterialIds.dragonheartAlloy).color(0xFFe16157).fallbacks("metal");


    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Material Render Info Provider";
    }
}
