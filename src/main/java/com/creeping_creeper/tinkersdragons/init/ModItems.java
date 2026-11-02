package com.creeping_creeper.tinkersdragons.init;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import net.minecraft.world.item.*;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;

public class ModItems {
    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersDragons.MODID);

    protected static final Item.Properties GENERAL_PROPS = new Item.Properties();

    public static final ItemObject<Item> WORLDROOT_NUGGET = ITEMS.register("worldroot_nugget", GENERAL_PROPS);
    public static final ItemObject<Item> DRAGONHEART_ALLOY_NUGGET = ITEMS.register("dragonheart_alloy_nugget", GENERAL_PROPS);

   // public static final ItemObject<Item> ECHO_STONE = ITEMS.register("echo_stone", GENERAL_PROPS);

}
