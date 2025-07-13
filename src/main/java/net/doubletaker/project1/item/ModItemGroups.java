package net.doubletaker.project1.item;

import net.doubletaker.project1.Project1;
import net.doubletaker.project1.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // ITEMS group
    public static final RegistryKey<ItemGroup> PINK_GARNET_ITEMS_GROUP =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Project1.MOD_ID, "pink_garnet_items"));
    public static final ItemGroup PINK_GARNET_ITEMS_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.PINK_GARNET))
            .displayName(Text.translatable("itemGroup.project1.pink_garnet_items"))
            .build();

    // BLOCKS group
    public static final RegistryKey<ItemGroup> PINK_GARNET_BLOCKS_GROUP =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Project1.MOD_ID, "pink_garnet_blocks"));
    public static final ItemGroup PINK_GARNET_BLOCKS_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
            .displayName(Text.translatable("itemGroup.project1.pink_garnet_blocks"))
            .build();

    public static void registerItemGroups() {
        Project1.LOGGER.info("Registering Item Groups for " + Project1.MOD_ID);

        // Register the groups
        Registry.register(Registries.ITEM_GROUP, PINK_GARNET_ITEMS_GROUP, PINK_GARNET_ITEMS_TAB);
        Registry.register(Registries.ITEM_GROUP, PINK_GARNET_BLOCKS_GROUP, PINK_GARNET_BLOCKS_TAB);

        // Add entries to items tab
        ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_ITEMS_GROUP).register(entries -> {
            entries.add(ModItems.PINK_GARNET);
            entries.add(ModItems.RAW_PINK_GARNET);
            entries.add(ModItems.CHISEL);
        });

        // Add entries to blocks tab
        ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_BLOCKS_GROUP).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_ORE);
        });
    }
}
