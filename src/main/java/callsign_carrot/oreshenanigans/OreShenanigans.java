package callsign_carrot.oreshenanigans;

import callsign_carrot.oreshenanigans.init.BlockInit;
import callsign_carrot.oreshenanigans.init.ContainerInit;
import callsign_carrot.oreshenanigans.init.ItemInit;
import callsign_carrot.oreshenanigans.init.ModSetup;
import callsign_carrot.oreshenanigans.init.ModTileEntityTypes;
import callsign_carrot.oreshenanigans.init.proxy.ClientProxy;
import callsign_carrot.oreshenanigans.init.proxy.IProxy;
import callsign_carrot.oreshenanigans.init.proxy.ServerProxy;
import callsign_carrot.oreshenanigans.world.gen.ExtensiveOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("oreshenanigans")
@Mod.EventBusSubscriber(modid = "oreshenanigans", bus = Bus.MOD)
public class OreShenanigans {
	
	public static ModSetup setup = new ModSetup();
	
	public static OreShenanigans instance;
	public static final String MOD_ID = "oreshenanigans";
	
    public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public OreShenanigans() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ContainerInit.CONTAINERS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
    	setup.init();
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    }
    	
    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        	
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
        	final Item.Properties properties = new Item.Properties().group(ModSetup.itemGroup);
        	final BlockItem blockItem = new BlockItem(block, properties);
        	blockItem.setRegistryName(block.getRegistryName());
        	registry.register(blockItem);
       	});
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	ExtensiveOreGen.generateOre();
    }
}
