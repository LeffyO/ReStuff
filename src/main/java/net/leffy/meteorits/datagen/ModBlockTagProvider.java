package net.leffy.meteorits.datagen;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ReStuff.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TRIPOD.get())
                .add(ModBlocks.TRIPODWITHCAM.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TRIPOD.get())
                .add(ModBlocks.TRIPODWITHCAM.get());
    }
}
