package callsign_carrot.oreshenanigans.init;

import callsign_carrot.oreshenanigans.OreShenanigans;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
	public static ItemGroup itemGroup = new ItemGroup(OreShenanigans.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.MACHINE_BLOCK_1.get());
		}
	};

	public void init() {
		
	}
}
