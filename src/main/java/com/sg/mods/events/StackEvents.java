package com.sg.mods.events;

import com.sg.mods.util.ModConstants;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;

public class StackEvents {
    public static void registerIncreaseStackEvent(){
		DefaultItemComponentEvents.MODIFY.register(context -> {
			for (int i = 0; i < ModConstants.itemsTo64.length; i++) {
				context.modify(ModConstants.itemsTo64[i], builder -> {
					builder.add(DataComponentTypes.MAX_STACK_SIZE, 64);
				});
			}
			for (int i = 0; i < ModConstants.itemsTo16.length; i++) {
				context.modify(ModConstants.itemsTo16[i], builder -> {
					builder.add(DataComponentTypes.MAX_STACK_SIZE, 16);
				});
			}
		});
	}
}
