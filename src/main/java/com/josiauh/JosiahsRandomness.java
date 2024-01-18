package com.josiauh;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JosiahsRandomness implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Josiah's Randomness");
	public static final CustomItem RED_TED = new CustomItem(new FabricItemSettings().maxCount(16));
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(RED_TED))
			.displayName(Text.literal("Josiah Randomness"))
			.entries((context, entries) -> {
				entries.add(RED_TED);
			})
			.build();



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Registering all assets...");
		Registry.register(Registries.ITEM_GROUP, new Identifier("jrand", "dedicated_group"), ITEM_GROUP);
		LOGGER.info("Group is ready!");
		Registry.register(Registries.ITEM, new Identifier("jrand", "redted"), RED_TED);
		LOGGER.info("Red Ted is ready!");
		LOGGER.info("Josiah's Randomness is ready! Have fun!");
	}
}