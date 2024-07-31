package lol.vanished.solarwarp;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SolarWarp.MODID, name = SolarWarp.NAME, version = SolarWarp.VERSION)
public class SolarWarp {
    public static final String MODID = "solarwarp";
    public static final String NAME = "SolarWarp";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        String minecraftVersion = net.minecraftforge.common.ForgeVersion.mcVersion;
        if (!"1.12".equals(minecraftVersion)) {
            event.getWorld().getMinecraftServer().getPlayerList().sendMessage(
                new TextComponentString(TextFormatting.RED + "It seems like you're running an incompatible version of Minecraft. Please switch to 1.12 to start using SolarWarp.")
            );
        }
    }
}
