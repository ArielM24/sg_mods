package com.sg.mods.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.sg.mods.interfaces.IEntityDataSaver;

import net.minecraft.entity.Entity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;

@Mixin(Entity.class)
public abstract class DataSaverMixin implements IEntityDataSaver {
    private Boolean spawnChecked = false;
    private Boolean trimChecked = false;
    @Override
    public Boolean getSpawnChecked(){
        return spawnChecked;
    }

    @Override
    public void setSpawnChecked(Boolean c){
        spawnChecked = c;
    }  

    @Override
    public Boolean getTrimChecked(){
        return trimChecked;
    }

    @Override
    public void setTrimChecked(Boolean c){
        trimChecked = c;
    }

    @Inject(method = "writeData", at = @At("HEAD"))
    protected void injectWriteMethod(WriteView data, CallbackInfo info){
       data.putBoolean("sg_mob_spawn_persistent_data", spawnChecked);
       data.putBoolean("sg_mob_trims_persistent_data", trimChecked);
    }

    @Inject(method = "readData", at = @At("HEAD"))
    protected void injectReadMethod(ReadView data, CallbackInfo info){
        spawnChecked = data.getBoolean("sg_mob_spawn_persistent_data", false);
        trimChecked = data.getBoolean("sg_mob_trims_persistent_data", false);
    }
}
