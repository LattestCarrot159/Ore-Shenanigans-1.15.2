package callsign_carrot.oreshenanigans.object.tileentities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import callsign_carrot.oreshenanigans.init.ModTileEntityTypes;
import callsign_carrot.oreshenanigans.object.containers.NuggifierContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class NuggifierTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider{
	
	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	
	public NuggifierTileEntity() {
		super(ModTileEntityTypes.NUGGIFIER.get());
	}

	@Override
	public void tick() {
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void read(CompoundNBT tag) {
		CompoundNBT invTag = tag.getCompound("inv");
		handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(invTag));
		super.read(tag);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CompoundNBT write(CompoundNBT tag) {
		handler.ifPresent(h -> {
			CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
			tag.put("inv", compound);	
		});
		return super.write(tag);
	}
	
	private IItemHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
				if (!stack.getItem().isIn(Tags.Items.INGOTS)) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap, side);
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
		return new NuggifierContainer(id, world, pos, playerInventory, player);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent(getType().getRegistryName().getPath());
	}
}
