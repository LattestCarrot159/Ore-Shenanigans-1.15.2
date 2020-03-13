package callsign_carrot.oreshenanigans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import callsign_carrot.oreshenanigans.setup.BlockInit;
import callsign_carrot.oreshenanigans.setup.ItemInit;
import callsign_carrot.oreshenanigans.setup.ModSetup;
import callsign_carrot.oreshenanigans.worldgen.ExtensiveOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Bus.MOD)
public class OreShenanigans {
	
	public static ModSetup setup = new ModSetup();
	
	public static OreShenanigans instance;
	public static final String modid = Reference.MOD_ID;
	public static final String name = Reference.NAME;
	public static final String version = Reference.VERSION;
	public static final String acceptedMinecraftVersions = Reference.ACCEPTEDMCVERSIONS;
	
    private static final Logger LOGGER = LogManager.getLogger();

    public OreShenanigans() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        
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
