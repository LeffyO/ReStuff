package net.leffy.meteorits.item;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.item.custom.Camera;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReStuff.MODID);

    public static final DeferredItem<Item> CAM = ITEMS.register("cam",
            () -> new Camera(new Item.Properties()));

    public static final DeferredItem<Item> TRIPOD_LEG = ITEMS.register("tripod_leg",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
