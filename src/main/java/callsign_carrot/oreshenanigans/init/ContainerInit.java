package callsign_carrot.oreshenanigans.init;

import callsign_carrot.oreshenanigans.OreShenanigans;
import callsign_carrot.oreshenanigans.object.containers.NuggifierContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, OreShenanigans.MOD_ID);
    
    public static final RegistryObject<ContainerType<NuggifierContainer>> NUGGIFIER_CONTAINER = CONTAINERS.register("nuggifier", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        return new NuggifierContainer(windowId, OreShenanigans.proxy.getClientWorld(), pos, inv, OreShenanigans.proxy.getClientPlayer());
    }));
}