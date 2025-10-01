package com.sg.mods.init;

import com.sg.mods.events.AutoAttackEvents;
import com.sg.mods.events.BedrockBreakerEvents;
import com.sg.mods.events.CompassEvents;
import com.sg.mods.events.ExpStorerEvents;
import com.sg.mods.events.MobSpawnEvents;
import com.sg.mods.events.MobTrimsEvents;
import com.sg.mods.events.RotationEvents;
import com.sg.mods.events.StackEvents;
import com.sg.mods.events.SwapElytraEvents;
import com.sg.mods.events.TotemEvents;
import com.sg.mods.events.TradesEvents;
import com.sg.mods.events.VaultEvents;
import com.sg.mods.events.WorldModEvents;

public class InitMods {
    public static void initRegistryManager(){
        WorldModEvents.registerRegistryManagerEvent();
    }

    public static void initBedrockBreaker(){
        BedrockBreakerEvents.registerBreakBedrockEvent();
    }

    public static void initExpStorer(){
		ExpStorerEvents.registerStoreExpEvent();
		ExpStorerEvents.registerRecoverExpEvent();
	}

    public static void initMobSpawnEvents(){
        MobSpawnEvents.registerBreezeSpawnEvent();
		MobSpawnEvents.registerCaveSpiderSpawnEvent();
		MobSpawnEvents.registerSilverfishSpawnEvent();
		MobSpawnEvents.registerIllusionerSpawnEvent();
    }
    public static void initMobTrimsEvents(){
        MobTrimsEvents.registerMobTrimsEvent();
    }
    public static void initRotationEvents(){
        RotationEvents.initRotation();
    }
    public static void initStackEvents(){
        StackEvents.registerIncreaseStackEvent();
    }
    public static void initTotemEvents(){
        TotemEvents.registerTotemEvent();
    }
    public static void initTradesEvents(){
        TradesEvents.registerTradeEvent();
        TradesEvents.registerUnlimitedTradesEvent();
        TradesEvents.registerWanderingTradesEvent();
    }
    public static void initVaultEvents(){
        VaultEvents.registerVaultEvent();
    }
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
