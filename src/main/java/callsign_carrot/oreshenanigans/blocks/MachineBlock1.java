package callsign_carrot.oreshenanigans.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MachineBlock1 extends AbstractGlassBlock{
	
	public MachineBlock1() {
		super(Properties.create(Material.IRON)
				.sound(SoundType.METAL)
				.hardnessAndResistance(2.0f)
				.notSolid()
		);
	}
}