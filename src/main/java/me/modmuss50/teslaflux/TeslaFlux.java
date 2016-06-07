package me.modmuss50.teslaflux;

import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(name = "Tesla Flux", modid = "teslaflux", version = "@MODVERSION@", dependencies = "required-after:reborncore;after:tesla")
public class TeslaFlux {

    @Mod.Instance
    public static TeslaFlux INSTANCE;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }


    @SubscribeEvent
    public void onTELoad(AttachCapabilitiesEvent.TileEntity event) {
        TileEntity tile = event.getTileEntity();
        if (tile instanceof IEnergyConnection || tile instanceof IEnergyStorage) {
            event.addCapability(new ResourceLocation("teslaflux:tesla"), new TeslaCapabilityProvider(tile));
        }
    }


}
