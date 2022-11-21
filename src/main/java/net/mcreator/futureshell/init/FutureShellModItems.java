
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.futureshell.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.futureshell.FutureShellMod;

public class FutureShellModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FutureShellMod.MODID);
	public static final RegistryObject<Item> NEOTRONCO = block(FutureShellModBlocks.NEOTRONCO, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NEOHIERBA = block(FutureShellModBlocks.NEOHIERBA, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NEOTIERRA = block(FutureShellModBlocks.NEOTIERRA, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NEOTABLONES = block(FutureShellModBlocks.NEOTABLONES, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> NEOHOJAS = block(FutureShellModBlocks.NEOHOJAS, CreativeModeTab.TAB_DECORATIONS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
