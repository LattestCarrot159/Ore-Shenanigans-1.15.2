package callsign_carrot.oreshenanigans.world.gen;

import callsign_carrot.oreshenanigans.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtensiveOreGen {
	public static void generateOre() {
		//SCRIPTED ORES HERE ;)
		newOre(20, 5, 5, 100, BlockInit.ALUMINUM_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.COPPER_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.LEAD_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.NICKEL_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.PLATINUM_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.SILVER_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
		newOre(20, 5, 5, 100, BlockInit.TIN_ORE.get().getDefaultState(), OreFeatureConfig.FillerBlockType.NATURAL_STONE);
	}
	
	public static void newOre(int count, int bottomOffset, int topOffset, int maximum, BlockState ore, FillerBlockType filler) {
		for (Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement<CountRangeConfig> customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(count, bottomOffset, topOffset, maximum));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(filler, ore, 10))
					.withPlacement(customConfig));
		}
	}
}