package com.sg.mods.events;

import com.sg.mods.util.ModConstants;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class WorldModEvents {
    public static void registerRegistryManagerEvent(){
        ServerLifecycleEvents.SERVER_STARTED.register(server->{
			ModConstants.dynamicRegistryManager = server.getRegistryManager();
		});
    }
    
}
