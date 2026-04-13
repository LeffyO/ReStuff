package net.leffy.meteorits.block;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.block.custom.TripodsBlock;
import net.leffy.meteorits.block.custom.TripodsWcamBlock;
import net.leffy.meteorits.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ReStuff.MODID);

    public static final DeferredBlock<Block> TRIPOD = registerBlock("tripods",
            () -> new TripodsBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<Block> TRIPODWITHCAM = registerBlock("tripodswcam",
            () -> new TripodsWcamBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().noCollission()));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
