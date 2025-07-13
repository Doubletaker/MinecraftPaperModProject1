package net.doubletaker.project1;

import net.doubletaker.project1.block.ModBlocks;
import net.doubletaker.project1.item.ModItemGroups;
import net.doubletaker.project1.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Project1 implements ModInitializer {
	public static final String MOD_ID = "project1";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}