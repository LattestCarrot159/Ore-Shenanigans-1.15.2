package callsign_carrot.oreshenanigans.object.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MachineBlock1 extends Block{
	
	public MachineBlock1() {
		super(Properties.create(Material.IRON)
				.sound(SoundType.METAL)
				.hardnessAndResistance(2.0f)
				.notSolid()
		);
	}
}