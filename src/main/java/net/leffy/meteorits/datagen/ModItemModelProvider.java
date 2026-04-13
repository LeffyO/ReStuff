package net.leffy.meteorits.datagen;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.block.ModBlocks;
import net.leffy.meteorits.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ReStuff.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CAM.get());
        basicItem(ModItems.TRIPOD_LEG.get());
        basicItem(ModBlocks.TRIPOD.get().asItem());
        basicItem(ModBlocks.TRIPODWITHCAM.get().asItem());
        basicItem(ModItems.WRENCH.get());
    }
}
