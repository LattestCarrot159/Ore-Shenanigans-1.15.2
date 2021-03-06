package callsign_carrot.oreshenanigans.object.screens;

import com.mojang.blaze3d.systems.RenderSystem;

import callsign_carrot.oreshenanigans.OreShenanigans;
import callsign_carrot.oreshenanigans.object.containers.NuggifierContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class NuggifierScreen extends ContainerScreen<NuggifierContainer> {
	
	private ResourceLocation GUI = new ResourceLocation(OreShenanigans.MOD_ID, "textures/gui/nuggifier.png");

	public NuggifierScreen(NuggifierContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }

}
