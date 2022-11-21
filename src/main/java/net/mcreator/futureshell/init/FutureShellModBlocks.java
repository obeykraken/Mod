
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.futureshell.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.futureshell.block.NeotroncoBlock;
import net.mcreator.futureshell.block.NeotierraBlock;
import net.mcreator.futureshell.block.NeotablonesBlock;
import net.mcreator.futureshell.block.NeohojasBlock;
import net.mcreator.futureshell.block.NeohierbaBlock;
import net.mcreator.futureshell.FutureShellMod;

public class FutureShellModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FutureShellMod.MODID);
	public static final RegistryObject<Block> NEOTRONCO = REGISTRY.register("neotronco", () -> new NeotroncoBlock());
	public static final RegistryObject<Block> NEOHIERBA = REGISTRY.register("neohierba", () -> new NeohierbaBlock());
	public static final RegistryObject<Block> NEOTIERRA = REGISTRY.register("neotierra", () -> new NeotierraBlock());
	public static final RegistryObject<Block> NEOTABLONES = REGISTRY.register("neotablones", () -> new NeotablonesBlock());
	public static final RegistryObject<Block> NEOHOJAS = REGISTRY.register("neohojas", () -> new NeohojasBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			NeohierbaBlock.registerRenderLayer();
		}
	}
}
