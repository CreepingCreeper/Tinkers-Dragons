package com.creeping_creeper.tinkersdragons.mixins;

import com.creeping_creeper.tinkersdragons.data.key.ModDataKeys;
import com.leon.saintsdragons.common.item.BloodTempestArmorSetBonus;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;

import java.util.Optional;

@Mixin({BloodTempestArmorSetBonus.class})
public class BloodTempestArmorSetBonusMixin {

    @Inject(method = "isWearingFullSet", at = @At(value = "INVOKE", target = "Lcom/leon/saintsdragons/common/item/BloodTempestArmorSetBonus;isBloodTempest(Lnet/minecraft/world/item/ItemStack;)Z", ordinal = 0), remap = false, cancellable = true)
    private static void isWearingFullSet(LivingEntity wearer, CallbackInfoReturnable<Boolean> cir) {
        Optional<TinkerDataCapability.Holder> dataCap = wearer.getCapability(TinkerDataCapability.CAPABILITY).resolve();
        dataCap.ifPresent(data -> {
            if (data.get(ModDataKeys.BLOOD_TEMPEST, 0) > 3) {
              cir.setReturnValue(true);
            }
        });
    }
}
