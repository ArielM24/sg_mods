package com.sg.mods.events;

import com.sg.mods.interfaces.IEntityDataSaver;
import com.sg.mods.util.ModFunctions;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;

public class MobTrimsEvents {
    public static void registerMobTrimsEvent(){
        ServerEntityEvents.ENTITY_LOAD.register((entity, world)->{
			if(!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)){
				return;
			}
			boolean isZombie = (entity instanceof ZombieEntity);
			boolean isSkeleton = (entity instanceof SkeletonEntity);
			if(!isZombie && !isSkeleton){
				return;
			}
			
			if(((IEntityDataSaver)entity).getTrimChecked()){
				return;
			}
			((IEntityDataSaver)entity).setTrimChecked(true);

			ItemStack head = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.HEAD);
			ItemStack chest = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.CHEST);
			ItemStack legs = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.LEGS);
			ItemStack feet = ((HostileEntity)entity).getEquippedStack(EquipmentSlot.FEET);
			boolean hasArmorTrim = head.get(DataComponentTypes.TRIM) != null || chest.get(DataComponentTypes.TRIM) != null ||legs.get(DataComponentTypes.TRIM) != null ||feet.get(DataComponentTypes.TRIM) != null;
			if(hasArmorTrim){
				return;
			}
			if(world.random.nextBoolean()){
				return;
			}
			ModFunctions.applyTrim(entity, world);
		});	
    }
}
