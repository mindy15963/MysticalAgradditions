package com.blakebr0.mysticalagradditions;

import com.blakebr0.mysticalagradditions.block.ModBlocks;
import com.blakebr0.mysticalagradditions.config.ModConfigs;
import com.blakebr0.mysticalagradditions.handler.ColorHandler;
import com.blakebr0.mysticalagradditions.handler.MobDropsHandler;
import com.blakebr0.mysticalagradditions.item.ModItems;
import com.blakebr0.mysticalagradditions.lib.ModCorePlugin;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MysticalAgradditions.MOD_ID)
public class MysticalAgradditions {
	public static final String MOD_ID = "mysticalagradditions";
	public static final String NAME = "Mystical Agradditions";

	public static final ItemGroup ITEM_GROUP = new MAItemGroup();

	public MysticalAgradditions() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.register(this);
		bus.register(new ModBlocks());
		bus.register(new ModItems());

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON);
	}

	@SubscribeEvent
	public void onCommonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());

		ModCorePlugin.onCommonSetup();
	}

	@SubscribeEvent
	public void onClientSetup(FMLClientSetupEvent event) {
		ColorHandler.onClientSetup();
	}
}
