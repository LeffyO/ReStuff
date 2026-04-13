package net.leffy.meteorits.item;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReStuff.MODID);

    public static final Supplier<CreativeModeTab> RESTUFF = CREATIVE_MODE_TAB.register("restuff_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAM.get()))
                    .title(Component.translatable("creativetab.restuff.restuff_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.CAM);
                        output.accept(ModItems.TRIPOD_LEG);
                        output.accept(ModBlocks.TRIPOD);
                        output.accept(ModBlocks.TRIPODWITHCAM);
                        output.accept(ModBlocks.SOMETHING);
                        output.accept(ModItems.WRENCH);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
