package me.modmuss50.teslaflux;

import cofh.api.energy.IEnergyHandler;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 * Created by Mark on 06/06/2016.
 */
public class TeslaRFContainer implements ITeslaConsumer, ITeslaHolder, ITeslaProducer {

    TileEntity entity;
    EnumFacing dir;

    public void setDir(EnumFacing dir) {
        this.dir = dir;
    }

    public TeslaRFContainer(TileEntity entity) {
        this.entity = entity;
    }

    @Override //Adding to the RF tile
    public long givePower(long power, boolean simulated) {
        return 0;
    }

    @Override
    public long getStoredPower() {
        if(entity instanceof IEnergyHandler){
            return ((IEnergyHandler) entity).getEnergyStored(dir);
        }
        return 0;
    }

    @Override
    public long getCapacity() {
        if(entity instanceof IEnergyHandler){
            return ((IEnergyHandler) entity).getMaxEnergyStored(dir);
        }
        return 0;
    }

    @Override //Removing from the RF tile
    public long takePower(long power, boolean simulated) {
        return 0;
    }
}
