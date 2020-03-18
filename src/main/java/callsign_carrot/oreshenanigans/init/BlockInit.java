package callsign_carrot.oreshenanigans.init;

import callsign_carrot.oreshenanigans.OreShenanigans;
import callsign_carrot.oreshenanigans.object.blocks.MachineBlock1;
import callsign_carrot.oreshenanigans.object.blocks.Nuggifier;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, OreShenanigans.MOD_ID);
	
	public static final RegistryObject<Block> MACHINE_BLOCK_1 = BLOCKS.register("machine_block_1", () -> new MachineBlock1());
	public static final RegistryObject<Block> NUGGIFIER = BLOCKS.register("nuggifier", () -> new Nuggifier());
	
	private static Block.Properties metalBlockProps = Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.0f);
	private static Block.Properties metalOreProps = Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0f);
	
	//metal blocks
	public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> NICKEL_BLOCK = BLOCKS.register("nickel_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(metalBlockProps));
	public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(metalBlockProps));
	
	//ores
	public static final RegistryObject<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> NICKEL_ORE = BLOCKS.register("nickel_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(metalOreProps));
	public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new Block(metalOreProps));
}
