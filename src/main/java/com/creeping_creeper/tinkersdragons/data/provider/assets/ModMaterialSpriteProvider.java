package com.creeping_creeper.tinkersdragons.data.provider.assets;


import com.creeping_creeper.tinkersdragons.data.key.ModMaterialIds;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class ModMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    protected void addAllMaterials() {
        buildMaterial(ModMaterialIds.draconian).maille().cuirass().fallbacks("cloth")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, 0xFF000000)
                        .addARGB(102, 0xFF202020)
                        .addARGB(140, 0xFF404040)
                        .addARGB(178, 0xFF606060)
                        .addARGB(216, 0xFF808080)
                        .addARGB(255, 0xFFbfbfbf)
                        .build());

        buildMaterial(ModMaterialIds.volitansSpine).arrowShaft().fallbacks("bone")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, 0xFF4d5b6b)
                        .addARGB(102, 0xFF762333)
                        .addARGB(140, 0xFF903042)
                        .addARGB(178, 0xFF8b9bb1)
                        .addARGB(216, 0xFFbbc5d3)
                        .addARGB(255, 0xFFe8ecf1)
                        .build());

        buildMaterial(ModMaterialIds.worldroot).meleeHarvest().ranged().fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, 0xFF633503)
                        .addARGB(102, 0xFF7d410b)
                        .addARGB(140, 0xFFc65615)
                        .addARGB(178, 0xFFe17d16)
                        .addARGB(216, 0xFFf8a44e)
                        .addARGB(255, 0xFFfdc77c)
                        .build());

        buildMaterial(ModMaterialIds.dragonheartAlloy).meleeHarvest().ranged().armor().fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(63, 0xFF601d07)
                        .addARGB(102, 0xFF7f0f03)
                        .addARGB(140, 0xFFb11e19)
                        .addARGB(178, 0xFFd53c43)
                        .addARGB(216, 0xFFe16157)
                        .addARGB(255, 0xFFf6978f)
                        .build());


    }

    @Override
    public @NotNull String getName() {
        return "Tinkers' Dragons Materials";
    }
}
