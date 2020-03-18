package callsign_carrot.oreshenanigans.init;

import callsign_carrot.oreshenanigans.OreShenanigans;
import callsign_carrot.oreshenanigans.object.tileentities.NuggifierTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, OreShenanigans.MOD_ID);
	
	public static final RegistryObject<TileEntityType<NuggifierTileEntity>> NUGGIFIER = TILE_ENTITY_TYPES.register("nuggifier", () -> TileEntityType.Builder.create(NuggifierTileEntity::new, BlockInit.NUGGIFIER.get()).build(null));
}
