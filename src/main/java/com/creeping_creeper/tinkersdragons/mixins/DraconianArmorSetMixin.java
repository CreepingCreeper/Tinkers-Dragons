package com.creeping_creeper.tinkersdragons.mixins;

import com.creeping_creeper.tinkersdragons.data.key.ModDataKeys;
import com.leon.saintsdragons.common.item.DraconianArmorSet;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;

import java.util.Optional;

@Mixin({DraconianArmorSet.class})
public class DraconianArmorSetMixin {

    @Inject(method = "pacifiesSwarm", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getItemBySlot(Lnet/minecraft/world/entity/EquipmentSlot;)Lnet/minecraft/world/item/ItemStack;", ordinal = 0), remap = false, cancellable = true)
    private static void pacifiesSwarm(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        Optional<TinkerDataCapability.Holder> dataCap = entity.getCapability(TinkerDataCapability.CAPABILITY).resolve();
        dataCap.ifPresent(data -> {
            if (data.get(ModDataKeys.MALEVOLENT_FLESH, 0) > 3) {
              cir.setReturnValue(true);
            }
        });
    }
}
