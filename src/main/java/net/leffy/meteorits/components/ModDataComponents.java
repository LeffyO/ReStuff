package net.leffy.meteorits.components;

import net.leffy.meteorits.ReStuff;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE = DeferredRegister.createDataComponents(ReStuff.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ItemStack>> ITEM_STACK = register("stacks",
            itemStackBuilder ->  itemStackBuilder.persistent(ItemStack.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {
        return DATA_COMPONENT_TYPE.register(name, () -> builderUnaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus bus) {
        DATA_COMPONENT_TYPE.register(bus);
    }
}
