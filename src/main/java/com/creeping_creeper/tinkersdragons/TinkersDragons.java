package com.creeping_creeper.tinkersdragons;

import com.creeping_creeper.tinkersdragons.data.key.ModDataKeys;
import com.creeping_creeper.tinkersdragons.init.ModFluids;
import com.creeping_creeper.tinkersdragons.init.ModItems;
import com.creeping_creeper.tinkersdragons.init.ModModifiers;
import com.leon.saintsdragons.common.registry.SaintsCreativeTab;
import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.utils.Util;

@Mod(TinkersDragons.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersDragons {
    public static final String MODID = "tinkersdragons";
    public static final Logger LOG = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public TinkersDragons() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModFluids.FLUIDS.register(bus);
        bus.register(ModModifiers.class);
        ModDataKeys.init();
    }

    @SubscribeEvent
    static void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    static void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SaintsCreativeTab.SD_CREATIVE_TAB.get()){
            event.accept(ModItems.WORLDROOT_NUGGET.get());
            event.accept(ModItems.DRAGONHEART_ALLOY_NUGGET.get());
            event.accept(ModFluids.MoltenWorldroot);
            event.accept(ModFluids.MoltenDragonheart);
            event.accept(ModFluids.MoltenDragonheartAlloy);
            event.accept(ModFluids.DragonBreath);
            event.accept(ModFluids.IgnivorusBlood);
            event.accept(ModFluids.MoltenAncientDragonite);
        }
    }

    public static String makeTranslationKey(String base, String name) {
        return Util.makeTranslationKey(base, getResource(name));
    }

    public static MutableComponent makeTranslation(String base, String name) {
        return Component.translatable(makeTranslationKey(base, name));
    }

    public static MutableComponent makeTranslation(String base, String name, Object... arguments) {
        return Component.translatable(makeTranslationKey(base, name), arguments);
    }

    public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registry, String name) {
        return ResourceKey.create(registry, TConstruct.getResource(name));
    }

    public static String makeDescriptionId(String type, String name) {
        return type + "." + MODID + "." + name;
    }

    public static ResourceLocation getResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }

    public static <T> TinkerDataCapability.TinkerDataKey<T> createKey(String name) {
        return TinkerDataCapability.TinkerDataKey.of(getResource(name));
    }
}
