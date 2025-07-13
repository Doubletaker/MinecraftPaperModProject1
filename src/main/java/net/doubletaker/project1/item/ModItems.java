package net.doubletaker.project1.item;

import net.doubletaker.project1.Project1;
import net.doubletaker.project1.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    private ModItems() {}

    public static final Item PINK_GARNET = register("pink_garnet", Item::new, new Item.Settings());
    public static final Item RAW_PINK_GARNET = register("raw_pink_garnet", Item::new, new Item.Settings().maxCount(1));

    public static final Item CHISEL = register("chisel", ChiselItem::new,
            new Item.Settings()
                    .maxCount(1) // Allow stack size of 16
                    .maxDamage(128) // Durability
    );


    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Project1.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static void registerModItems() {
        Project1.LOGGER.info("Registering Mod Items for " + Project1.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
            fabricItemGroupEntries.add(RAW_PINK_GARNET);
            fabricItemGroupEntries.add(CHISEL);
        });
    }
}
