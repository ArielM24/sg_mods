package com.sg.mods.init;

import com.sg.mods.events.AutoAttackEvents;
import com.sg.mods.events.CompassEvents;
import com.sg.mods.events.SwapElytraEvents;

public class InitClientMods {
    public static void initAutoAttackEvents(){
        AutoAttackEvents.registerAttackEvent();
    }
    public static void initCompassEvents(){
        CompassEvents.registerRenderCompassEvent();
    }
    public static void initSwapElytraEvents(){
        SwapElytraEvents.registerSwapElytraEvent();
    }
}
