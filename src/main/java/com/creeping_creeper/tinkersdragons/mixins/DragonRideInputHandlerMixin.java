package com.creeping_creeper.tinkersdragons.mixins;

import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import com.leon.saintsdragons.client.input.DragonRideInputHandler;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mixin({DragonRideInputHandler.class})
public class DragonRideInputHandlerMixin {

    @Redirect(method = "clientTick",  at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z", ordinal = 0))
    private static boolean isDragonlord(ItemStack instance, Item p_150931_) {
        return instance.is(p_150931_) || (instance.is(TinkerTags.Items.MELEE_PRIMARY) && ToolStack.from(instance).getModifierLevel(ModModifierIds.Dragonlord) > 0);
    }

    @Redirect(method = "clientTick",  at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z", ordinal = 1))
    private static boolean isBloodTempest(ItemStack instance, Item p_150931_) {
        return instance.is(p_150931_) || (instance.is(TinkerTags.Items.MELEE_PRIMARY) && ToolStack.from(instance).getModifierLevel(ModModifierIds.BloodTempest) > 0);
    }
}
