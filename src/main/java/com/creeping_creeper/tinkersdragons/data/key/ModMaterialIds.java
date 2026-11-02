package com.creeping_creeper.tinkersdragons.data.key;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ModMaterialIds {

    public static final MaterialId worldroot = id("worldroot");
    public static final MaterialId draconian = id("draconian");
    public static final MaterialId volitansSpine = id("volitans_spine");
    public static final MaterialId dragonheartAlloy = id("dragonheart_alloy");

    private static MaterialId id(String name) {
        return new MaterialId(TinkersDragons.MODID, name);
    }
}
