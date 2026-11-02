package com.creeping_creeper.tinkersdragons.data.key;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;

import static slimeknights.tconstruct.library.tools.capability.TinkerDataKeys.INTEGER_REGISTRY;

public interface ModDataKeys {
    static void init() {}

    TinkerDataCapability.TinkerDataKey<Integer> MALEVOLENT_FLESH = intKey("malevolent_flesh");
    TinkerDataCapability.TinkerDataKey<Integer> BLOOD_TEMPEST = intKey("blood_tempest");
    TinkerDataCapability.TinkerDataKey<Integer> DRAGONLORD = intKey("dragonlord");

    private static TinkerDataCapability.TinkerDataKey<Integer> intKey(String name) {
        return INTEGER_REGISTRY.register(TinkersDragons.createKey(name));
    }
}
