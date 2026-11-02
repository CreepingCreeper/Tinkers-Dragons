package com.creeping_creeper.tinkersdragons.mixins;

import com.creeping_creeper.tinkersdragons.data.key.ModModifierIds;
import com.leon.saintsdragons.common.item.tools.DragonlordSwordAbility;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mixin({DragonlordSwordAbility.class})
public class DragonlordSwordAbilityMixin {

    @Redirect(method = "tryUse",  at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean isDragonlord(ItemStack instance, Item p_150931_) {
        return instance.is(p_150931_) || (instance.is(TinkerTags.Items.MELEE_PRIMARY) && ToolStack.from(instance).getModifierLevel(ModModifierIds.Dragonlord) > 0);
    }
}
