package me.dzyre.valheim.items;

import me.dzyre.valheim.DevMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsController {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DevMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1).saturationModifier(2f).build()));

    public static final DeferredItem<Item> DZYRITE = ITEMS.registerSimpleItem("dzyrite", new Item.Properties());

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
