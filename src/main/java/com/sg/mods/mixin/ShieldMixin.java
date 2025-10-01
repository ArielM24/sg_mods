package com.sg.mods.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class ShieldMixin extends Entity {

	public ShieldMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method="getBlockingItem", at = @At(value = "HEAD"), cancellable = true)
	public void getBlockingItem(CallbackInfoReturnable<ItemStack> ci){
		 if (((LivingEntity)(Object)this).isUsingItem()) {
        var player = ((LivingEntity)(Object)this);
		var activeStack = player.getStackInHand(player.getActiveHand());
         BlocksAttacksComponent blocksAttacksComponent = activeStack.get(DataComponentTypes.BLOCKS_ATTACKS);
         if (blocksAttacksComponent != null) {
            int i = activeStack.getItem().getMaxUseTime(activeStack, player) - player.getItemUseTimeLeft();
            if (i >= 0) {
              ci.setReturnValue(activeStack);
            }
         }

      }
	}

	
}