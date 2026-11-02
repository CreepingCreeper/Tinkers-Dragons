package com.creeping_creeper.tinkersdragons.data.key;

import com.creeping_creeper.tinkersdragons.TinkersDragons;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierManager;

import static slimeknights.mantle.Mantle.commonResource;
import static slimeknights.tconstruct.TConstruct.getResource;


public class ModTags {
    public static class Items {
        public static final TagKey<Item> WORLDROOT_ORE = common("ores/worldroot");
        public static final TagKey<Item> RAW_WORLDROOT = common("raw_materials/worldroot");
        public static final TagKey<Item> WORLDROOT_NUGGET = common("nuggets/worldroot");
        public static final TagKey<Item> WORLDROOT_INGOT = common("ingots/worldroot");
        public static final TagKey<Item> WORLDROOT_BLOCK = common("storage_blocks/worldroot");
        public static final TagKey<Item> RAW_WORLDROOT_BLOCK = common("storage_blocks/raw_worldroot");

        public static final TagKey<Item> DRAGONHEART_ORE = common("ores/dragonheart");
        public static final TagKey<Item> RAW_DRAGONHEART = common("raw_materials/dragonheart");
        public static final TagKey<Item> RAW_DRAGONHEART_BLOCK = common("storage_blocks/raw_dragonheart");

        public static final TagKey<Item> DRAGONHEART_ALLOY_NUGGET = common("nuggets/dragonheart_alloy");
        public static final TagKey<Item> DRAGONHEART_ALLOY_INGOT = common("ingots/dragonheart_alloy");
        public static final TagKey<Item> DRAGONHEART_ALLOY_BLOCK = common("storage_blocks/dragonheart_alloy");

        private static TagKey<Item> local(String name) {
            return TagKey.create(Registries.ITEM, TinkersDragons.getResource(name));
        }
        private static TagKey<Item> common(String name) {
            return TagKey.create(Registries.ITEM, commonResource(name));
        }
    }
    public static class Blocks {
        public static final TagKey<Block> WORLDROOT_ORE = common("ores/worldroot");
        public static final TagKey<Block> WORLDROOT_BLOCK = common("storage_blocks/worldroot");
        public static final TagKey<Block> RAW_WORLDROOT_BLOCK = common("storage_blocks/raw_worldroot");

        public static final TagKey<Block> DRAGONHEART_ORE = common("ores/dragonheart");
        public static final TagKey<Block> RAW_DRAGONHEART_BLOCK = common("storage_blocks/raw_dragonheart");

        public static final TagKey<Block> DRAGONHEART_ALLOY_BLOCK = common("storage_blocks/dragonheart_alloy");

        private static TagKey<Block> local(String name) {
            return TagKey.create(Registries.BLOCK, TinkersDragons.getResource(name));
        }
        private static TagKey<Block> common(String name) {return TagKey.create(Registries.BLOCK, commonResource(name));}
    }

    public static class Fluids {
        public static final TagKey<Fluid> MOLTEN_ECHO = local("molten_echo");

        private static TagKey<Fluid> local(String name) {
            return TagKey.create(Registries.FLUID, TinkersDragons.getResource(name));
        }
        private static TagKey<Fluid> common(String name) {return TagKey.create(Registries.FLUID, commonResource(name));}
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> DRAGONSLAYER = local("dragonslayer");

        private static TagKey<EntityType<?>> local(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, TinkersDragons.getResource(name));
        }
        private static TagKey<EntityType<?>> common(String name) {return TagKey.create(Registries.ENTITY_TYPE, commonResource(name));}
    }

    public static class Modifiers {
        public static final TagKey<Modifier> DRAGONLIKE = local("dragonlike");

        private static TagKey<Modifier> local(String name) {
            return ModifierManager.getTag(TinkersDragons.getResource(name));
        }
    }
}
