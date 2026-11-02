package com.creeping_creeper.tinkersdragons.data.key;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class ModModifierIds {
    public static final ModifierId Dragonslayer = id("dragonslayer");
    public static final ModifierId MalevolentFlesh = id("malevolent_flesh");
    public static final ModifierId Toxin = id("toxin");

    public static final ModifierId DragonRage = id("dragonrage");
    public static final ModifierId DragonSoul = id("dragonsoul");
    public static final ModifierId BloodTempest = id("blood_tempest");
    public static final ModifierId Dragonlord = id("dragonlord");
    
    private static ModifierId id(String name) {
        return new ModifierId(TinkersDragons.MODID, name);
    }
}
