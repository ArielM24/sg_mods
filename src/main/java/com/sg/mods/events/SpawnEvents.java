package com.sg.mods.events;

import java.rmi.registry.Registry;
import java.util.Random;

import com.sg.mods.interfaces.IEntityDataSaver;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.BreezeEntity;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieHorseEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Difficulty;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class SpawnEvents {
    public static final Random r = new Random();

    public static final int illusionerSpawnRatio = 30;
    public static final int breezeSpawnRatio = 70;
    public static final int caveSpiderSpawnRatio = 85;
    public static final int silverfishSpiderSpawnRatio = 50;
    public static final int zombieHorseSpawnRatio = 5;

    public static void registerBreezeSpawn() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            if (!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)) {
                return;
            }
            if (!entity.getType().equals(EntityType.BLAZE)) {
                return;
            }
            BlazeEntity blaze = (BlazeEntity) entity;
            if(((IEntityDataSaver)entity).getSpawnChecked()){
				return;
			}
            RegistryKey<Biome> biome = serverLevel.getBiome(blaze.getBlockPos()).getKey().get();
            if(!biome.toString().startsWith(BiomeKeys.WARPED_FOREST.toString())){
                return;
            }
			((IEntityDataSaver)entity).setSpawnChecked(true);
            boolean willSpawn = r.nextInt(100) <= breezeSpawnRatio;
            if (!willSpawn) {
                return;
            }
            int xOffset = 1 + r.nextInt(2);
            int zOffset = 1 + r.nextInt(2);
            xOffset = r.nextBoolean() ? xOffset : -xOffset;
            zOffset = r.nextBoolean() ? zOffset : -zOffset;
            BlockPos pos = blaze.getBlockPos();
            BlockPos spawnPos = new BlockPos(pos.getX() + xOffset, pos.getY(), pos.getZ() + zOffset);
            BlockPos floor = spawnPos.offset(Direction.DOWN);
            BlockPos air = spawnPos.offset(Direction.UP, 1);
            if (!blaze.getEntityWorld().getBlockState(floor).isOpaqueFullCube()) {
                return;
            }
            ;
            if (!blaze.getEntityWorld().getBlockState(spawnPos).isAir()) {
                return;
            }
            ;
            if (!blaze.getEntityWorld().getBlockState(air).isAir()) {
                return;
            }
            ;
            BreezeEntity breeze = EntityType.BREEZE.create(serverLevel, SpawnReason.NATURAL);
            breeze.setPos(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
            serverLevel.spawnNewEntityAndPassengers(breeze);
        });
    }

    public static void registerCaveSpiderSpawn() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            if (!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)) {
                return;
            }
            if (!entity.getType().equals(EntityType.SPIDER)) {
                return;
            }
            SpiderEntity spider = (SpiderEntity) entity;
            if(((IEntityDataSaver)entity).getSpawnChecked()){
				return;
			}
			((IEntityDataSaver)entity).setSpawnChecked(true);
            boolean willSpawn = r.nextInt(100) <= caveSpiderSpawnRatio;
            if (!willSpawn) {
                return;
            }
            if (spider.getEntityPos().getY() >= 0) {
                return;
            }
            int xOffset = 1 + r.nextInt(2);
            int zOffset = 1 + r.nextInt(2);
            xOffset = r.nextBoolean() ? xOffset : -xOffset;
            zOffset = r.nextBoolean() ? zOffset : -zOffset;
            BlockPos pos = spider.getBlockPos();
            BlockPos spawnPos = new BlockPos(pos.getX() + xOffset, pos.getY(), pos.getZ() + zOffset);
            BlockPos floor = spawnPos.offset(Direction.DOWN);
            if (!spider.getEntityWorld().getBlockState(floor).isOpaqueFullCube()) {
                return;
            }
            ;
            if (!spider.getEntityWorld().getBlockState(spawnPos).isAir()) {
                return;
            }
            ;
            CaveSpiderEntity caveSpider = EntityType.CAVE_SPIDER.create(serverLevel, SpawnReason.NATURAL);
            caveSpider.setPos(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
            serverLevel.spawnNewEntityAndPassengers(caveSpider);
        });
    }

    public static void registerIllusionerSpawn() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            if (!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)) {
                return;
            }
            if (!entity.getType().equals(EntityType.EVOKER)) {
                return;
            }
            EvokerEntity evoker = (EvokerEntity) entity;
            if(((IEntityDataSaver)entity).getSpawnChecked()){
				return;
			}
			((IEntityDataSaver)entity).setSpawnChecked(true);
            boolean willSpawn = r.nextInt(100) <= illusionerSpawnRatio;
            if (!willSpawn) {
                return;
            }
            int xOffset = 1 + r.nextInt(2);
            int zOffset = 1 + r.nextInt(2);
            xOffset = r.nextBoolean() ? xOffset : -xOffset;
            zOffset = r.nextBoolean() ? zOffset : -zOffset;
            BlockPos pos = evoker.getBlockPos();
            BlockPos spawnPos = new BlockPos(pos.getX() + xOffset, pos.getY(), pos.getZ() + zOffset);
            BlockPos floor = spawnPos.offset(Direction.DOWN);
            BlockPos air = spawnPos.offset(Direction.UP, 1);
            if (!evoker.getEntityWorld().getBlockState(floor).isOpaqueFullCube()) {
                return;
            }
            ;
            if (!evoker.getEntityWorld().getBlockState(spawnPos).isAir()) {
                return;
            }
            ;
            if (!evoker.getEntityWorld().getBlockState(air).isAir()) {
                return;
            }
            ;
            IllusionerEntity illusioner = EntityType.ILLUSIONER.create(serverLevel, SpawnReason.NATURAL);
            illusioner.setPosition(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
            serverLevel.spawnNewEntityAndPassengers(illusioner);
        });
    }

    public static void registerSilverfishSpawn() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            if (!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)) {
                return;
            }
            if (!entity.getType().equals(EntityType.BAT)) {
                return;
            }
            BatEntity bat = (BatEntity) entity;
            if(((IEntityDataSaver)entity).getSpawnChecked()){
				return;
			}
			((IEntityDataSaver)entity).setSpawnChecked(true);
            boolean willSpawn = r.nextInt(100) <= silverfishSpiderSpawnRatio;
            if (!willSpawn) {
                return;
            }
            if (bat.getEntityPos().getY() >= 0) {
                return;
            }
            SilverfishEntity silverfish = EntityType.SILVERFISH.create(serverLevel, SpawnReason.NATURAL);
            silverfish.setPos(bat.getEntityPos().getX(), bat.getEntityPos().getY(), bat.getEntityPos().getZ());
            serverLevel.spawnNewEntityAndPassengers(silverfish);
        });
    }

    public static void registerZombieHorseSpawn() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            if(!serverLevel.isThundering()){
                return;
            }
            if (!entity.getEntityWorld().getDifficulty().equals(Difficulty.HARD)) {
                return;
            }
            if (!entity.getType().equals(EntityType.ZOMBIE)) {
                return;
            }
            ZombieEntity zombie = (ZombieEntity) entity;
            if(((IEntityDataSaver)entity).getSpawnChecked()){
				return;
			}
			((IEntityDataSaver)entity).setSpawnChecked(true);
           
            boolean willSpawn = r.nextInt(100) <= zombieHorseSpawnRatio;
            if (!willSpawn) {
                return;
            }
            BlockPos pos = zombie.getBlockPos();
            if (!zombie.getEntityWorld().getBlockState(pos.offset(Direction.UP, 2)).isAir()) {
                return;
            }
            ;
            ZombieHorseEntity zombieHorse = EntityType.ZOMBIE_HORSE.create(serverLevel, SpawnReason.NATURAL);
            zombieHorse.setPos(zombie.getEntityPos().getX(), zombie.getEntityPos().getY(), zombie.getEntityPos().getZ());
            zombieHorse.equipStack(EquipmentSlot.SADDLE, new ItemStack(Items.SADDLE));
            zombieHorse.setTame(true);
            if (zombie.isBaby()) {
                zombieHorse.setBaby(true);
            }
            zombieHorse.setDespawnCounter(1);
            serverLevel.spawnNewEntityAndPassengers(zombieHorse);
            zombie.startRiding(zombieHorse);
        });
    }
}
