package callsign_carrot.extensiveengineering.setup;

import callsign_carrot.extensiveengineering.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
	public static ItemGroup itemGroup = new ItemGroup(Reference.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.MACHINE_BLOCK_1.get());
		}
	};

	public void init() {
		
	}
}
