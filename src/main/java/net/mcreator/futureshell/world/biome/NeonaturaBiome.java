
package net.mcreator.futureshell.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.futureshell.world.features.treedecorators.NeonaturaTrunkDecorator;
import net.mcreator.futureshell.world.features.treedecorators.NeonaturaLeaveDecorator;
import net.mcreator.futureshell.world.features.treedecorators.NeonaturaFruitDecorator;
import net.mcreator.futureshell.init.FutureShellModBlocks;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class NeonaturaBiome {
	public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(Climate.Parameter.span(-0.142857142857f, 0.142857142857f),
			Climate.Parameter.span(-0.142857142857f, 0.142857142857f), Climate.Parameter.span(0.367142857143f, 0.652857142857f),
			Climate.Parameter.span(0.657142857143f, 0.942857142857f), Climate.Parameter.point(0),
			Climate.Parameter.span(-0.760806082352f, -0.475091796638f), 0);

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-16746241).waterColor(-12691790).waterFogColor(329011)
				.skyColor(-16746241).foliageColorOverride(-3915776).grassColorOverride(-897280)
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIT, 0.005f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("future_shell:tree_neonatura", FeatureUtils.register("future_shell:tree_neonatura", Feature.TREE,
						new TreeConfiguration.TreeConfigurationBuilder(
								BlockStateProvider.simple(FutureShellModBlocks.NEOTRONCO.get().defaultBlockState()), new StraightTrunkPlacer(9, 2, 0),
								BlockStateProvider.simple(FutureShellModBlocks.NEOHOJAS.get().defaultBlockState()),
								new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
								.decorators(ImmutableList.of(NeonaturaLeaveDecorator.INSTANCE, NeonaturaTrunkDecorator.INSTANCE,
										NeonaturaFruitDecorator.INSTANCE))
								.build()),
						List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
								PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
								BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("future_shell:grass_neonatura", VegetationFeatures.PATCH_GRASS,
						List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
								BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.IRON_GOLEM, 20, 1, 3));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f)
				.downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
				.build();
	}
}
