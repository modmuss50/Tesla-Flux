package me.modmuss50.teslaflux;

import cofh.api.energy.IEnergyConnection;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;

/**
 * Created by Mark on 06/06/2016.
 */
public class TeslaCapabilityProvider implements ICapabilityProvider {

    TileEntity tileEntity;

    IEnergyConnection connection;

    TeslaRFContainer container;

    public TeslaCapabilityProvider(TileEntity tileEntity) {
        this.tileEntity = tileEntity;
        connection = (IEnergyConnection) tileEntity;
        container = new TeslaRFContainer(tileEntity);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER && connection.canConnectEnergy(facing)) {
            return true;
        }
        if (capability == TeslaCapabilities.CAPABILITY_PRODUCER && connection.canConnectEnergy(facing)) {
            return true;
        }
        if (capability == TeslaCapabilities.CAPABILITY_HOLDER && connection.canConnectEnergy(facing)) {
            return true;
        }
        return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        container.setDir(facing);
        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER && connection.canConnectEnergy(facing)) {
            return (T) container;
        }
        if (capability == TeslaCapabilities.CAPABILITY_PRODUCER && connection.canConnectEnergy(facing)) {
            return (T) container;
        }
        if (capability == TeslaCapabilities.CAPABILITY_HOLDER && connection.canConnectEnergy(facing)) {
            return (T) container;
        }
        return null;
    }
}
