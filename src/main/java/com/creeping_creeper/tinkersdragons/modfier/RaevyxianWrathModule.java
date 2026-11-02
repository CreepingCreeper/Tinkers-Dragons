package com.creeping_creeper.tinkersdragons.modfier;

import com.leon.saintsdragons.server.entity.ability.abilities.raevyx.RaevyxChainLightningAbility;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.data.loadable.record.SingletonLoader;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public enum RaevyxianWrathModule implements ModifierModule, MeleeHitModifierHook {
    INSTANCE;
    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.MELEE_HIT);

    private final SingletonLoader<RaevyxianWrathModule> LOADER = new SingletonLoader<>(this);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        Player player = context.getPlayerAttacker();
        if (!context.isExtraAttack() && player instanceof ServerPlayer sPlayer){
            RaevyxChainLightningAbility.chainFromKatana(sPlayer, context.getLivingTarget());
        }
    }


}
