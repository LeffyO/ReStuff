package net.leffy.meteorits.datagen;

import net.leffy.meteorits.ReStuff;
import net.leffy.meteorits.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ReStuff.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

//        simpleBlock(ModBlocks.TRIPOD.get(), tripodModel());
//        simpleBlock(ModBlocks.TRIPODWITHCAM.get(), createTripodWithCamModel());

        blockWithItem(ModBlocks.SOMETHING);

        getVariantBuilder(ModBlocks.TRIPOD.get())
                .forAllStates(blockState -> {
                    Direction direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    int yRot = switch (direction) {
                        case SOUTH -> 180;
                        case EAST  -> 90;
                        case WEST  -> 270;
                        default    -> 0; // NORTH
                    };
                    return ConfiguredModel.builder()
                            .modelFile(tripodModel())
                            .rotationY(yRot)
                            .build();
                });

        getVariantBuilder(ModBlocks.TRIPODWITHCAM.get())
                .forAllStates(blockState -> {
                    Direction direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                    int yRot = switch (direction) {
                        case SOUTH -> 180;
                        case EAST  -> 90;
                        case WEST  -> 270;
                        default    -> 0; // NORTH
                    };
                    return ConfiguredModel.builder()
                            .modelFile(createTripodWithCamModel())
                            .rotationY(yRot)
                            .build();
                });

        
    }

    private ModelFile tripodModel() {
        return models().withExistingParent("tripods", "block/block")
                .texture("0", modLoc("block/tripods"))
                .texture("particle", modLoc("block/tripods"))

                // Leg Right
                .element()
                    .from(12, 0, 5).to(14, 12, 7)
                    .rotation().angle(22.5f).axis(Direction.Axis.Z).origin(12, 0, 5).end()
                    .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
                    .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
                .end()

                // Leg Left
                .element()
                    .from(2, 0, 5).to(4, 12, 7)
                    .rotation().angle(-22.5f).axis(Direction.Axis.Z).origin(4, 0, 5).end()
                    .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
                    .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
                .end()

                // Leg Back
                .element()
                    .from(7, 0, 10).to(9, 12, 12)
                    .rotation().angle(-22.5f).axis(Direction.Axis.X).origin(7, 0, 10).end()
                    .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
                    .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
                    .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
                .end()

                // Top Body
                .element()
                    .from(6, 11, 4).to(10, 13, 8)
                    .rotation().angle(0).axis(Direction.Axis.Y).origin(7, 11, 5).end()
                    .face(Direction.NORTH).uvs(7, 0, 11, 2).texture("#0").end()
                    .face(Direction.EAST).uvs(11, 0, 15, 2).texture("#0").end()
                    .face(Direction.SOUTH).uvs(7, 2, 11, 4).texture("#0").end()
                    .face(Direction.WEST).uvs(3, 0, 7, 2).texture("#0").end()
                    .face(Direction.UP).uvs(11, 4, 15, 8).texture("#0").end()
                    .face(Direction.DOWN).uvs(3, 4, 7, 8).texture("#0").end()
                .end()

                // Camera/Lens piece
                .element()
                    .from(9.25f, 11, 8).to(10.25f, 12, 12)
                    .rotation().angle(45).axis(Direction.Axis.Y).origin(9, 9, 8).end()
                    .face(Direction.NORTH).uvs(8, 9, 9, 10).texture("#0").end()
                    .face(Direction.EAST).uvs(9, 9, 13, 10).texture("#0").end()
                    .face(Direction.SOUTH).uvs(8, 10, 9, 11).texture("#0").end()
                    .face(Direction.WEST).uvs(4, 9, 8, 10).texture("#0").end()
                    .face(Direction.UP).uvs(9, 11, 10, 15).texture("#0").end()
                    .face(Direction.DOWN).uvs(7, 11, 8, 15).texture("#0").end()
                .end()

                // Display transforms
                .transforms()
                    .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                        .rotation(33.25f, 0, 0)
                        .translation(0, 0, 0)
                        .scale(1, 1, 1)
                    .end()
                    .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                        .rotation(21, 0, 0)
                        .translation(0, 0, 0)
                        .scale(1, 1, 1)
                    .end()
                    .transform(ItemDisplayContext.GROUND)
                        .rotation(103.66f, -0.91f, -111.75f)
                        .translation(3.5f, -0.75f, 2.75f)
                        .scale(1, 1, 1)
                    .end()
                    .transform(ItemDisplayContext.GUI)
                        .rotation(-179.2f, -11.43f, -169.62f)
                        .translation(0, 1.25f, 0)
                        .scale(1, 1, 1)
                    .end()
                .end();
    }

    private ModelFile createTripodWithCamModel() {
        return models().withExistingParent("tripodswcam", "block/block")
        .texture("0", modLoc("block/tripods"))
        .texture("1", modLoc("block/camera"))
        .texture("particle", modLoc("block/tripods"))

        // === TRIPOD LEGS ===

        // Leg Right
        .element()
            .from(12, 0, 5).to(14, 12, 7)
            .rotation().angle(22.5f).axis(Direction.Axis.Z).origin(12, 0, 5).end()
            .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
            .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
        .end()

        // Leg Left
        .element()
            .from(2, 0, 5).to(4, 12, 7)
            .rotation().angle(-22.5f).axis(Direction.Axis.Z).origin(4, 0, 5).end()
            .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
            .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
        .end()

        // Leg Back
        .element()
            .from(7, 0, 10).to(9, 12, 12)
            .rotation().angle(-22.5f).axis(Direction.Axis.X).origin(7, 0, 10).end()
            .face(Direction.NORTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.EAST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.SOUTH).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.WEST).uvs(0, 0, 2, 12).texture("#0").end()
            .face(Direction.UP).uvs(0, 0, 2, 2).texture("#0").end()
            .face(Direction.DOWN).uvs(0, 0, 2, 2).texture("#0").end()
        .end()

        // Top Mount Body
        .element()
            .from(6, 11, 4).to(10, 13, 8)
            .rotation().angle(0).axis(Direction.Axis.Y).origin(7, 11, 5).end()
            .face(Direction.NORTH).uvs(7, 0, 11, 2).texture("#0").end()
            .face(Direction.EAST).uvs(11, 0, 15, 2).texture("#0").end()
            .face(Direction.SOUTH).uvs(7, 2, 11, 4).texture("#0").end()
            .face(Direction.WEST).uvs(3, 0, 7, 2).texture("#0").end()
            .face(Direction.UP).uvs(11, 4, 15, 8).texture("#0").end()
            .face(Direction.DOWN).uvs(3, 4, 7, 8).texture("#0").end()
        .end()

        // Mount Arm
        .element()
            .from(9.25f, 11, 8).to(10.25f, 12, 12)
            .rotation().angle(45).axis(Direction.Axis.Y).origin(9, 9, 8).end()
            .face(Direction.NORTH).uvs(8, 9, 9, 10).texture("#0").end()
            .face(Direction.EAST).uvs(9, 9, 13, 10).texture("#0").end()
            .face(Direction.SOUTH).uvs(8, 10, 9, 11).texture("#0").end()
            .face(Direction.WEST).uvs(4, 9, 8, 10).texture("#0").end()
            .face(Direction.UP).uvs(9, 11, 10, 15).texture("#0").end()
            .face(Direction.DOWN).uvs(7, 11, 8, 15).texture("#0").end()
        .end()

        // === CAMERA GROUP ===

        // Camera Body
        .element()
            .from(4, 13, 6).to(12, 18, 8)
            .face(Direction.NORTH).uvs(5, 1, 1, 3.5f).texture("#1").end()
            .face(Direction.EAST).uvs(6, 1, 5, 3.5f).texture("#1").end()
            .face(Direction.SOUTH).uvs(10, 1, 6, 3.5f).texture("#1").end()
            .face(Direction.WEST).uvs(1, 1, 0, 3.5f).texture("#1").end()
            .face(Direction.UP).uvs(1, 1, 5, 0).texture("#1").end()
            .face(Direction.DOWN).uvs(5, 0, 9, 1).texture("#1").end()
        .end()

        // Camera Lens
        .element()
            .from(5, 14, 1).to(8, 17, 6)
            .face(Direction.NORTH).uvs(2.5f, 6.5f, 4, 8).texture("#1").end()
            .face(Direction.EAST).uvs(0, 6.5f, 2.5f, 8).texture("#1").end()
            .face(Direction.SOUTH).uvs(6.5f, 6.5f, 8, 8).texture("#1").end()
            .face(Direction.WEST).uvs(4, 6.5f, 6.5f, 8).texture("#1").end()
            .face(Direction.UP).uvs(4, 6.5f, 2.5f, 4).texture("#1").end()
            .face(Direction.DOWN).uvs(5.5f, 4, 4, 6.5f).texture("#1").end()
        .end()

        // Camera Side Detail
        .element()
            .from(9, 13, 5).to(12, 18, 6)
            .face(Direction.NORTH).uvs(7, 4.5f, 8.5f, 7).texture("#1").end()
            .face(Direction.EAST).uvs(6.5f, 4.5f, 7, 7).texture("#1").end()
            .face(Direction.SOUTH).uvs(9, 4.5f, 10.5f, 7).texture("#1").end()
            .face(Direction.WEST).uvs(8.5f, 4.5f, 9, 7).texture("#1").end()
            .face(Direction.UP).uvs(8.5f, 4.5f, 7, 4).texture("#1").end()
            .face(Direction.DOWN).uvs(10, 4, 8.5f, 4.5f).texture("#1").end()
        .end()

        // Camera Top Piece
        .element()
            .from(10, 18, 6).to(12, 19, 8)
            .face(Direction.NORTH).uvs(12, 1, 13, 1.5f).texture("#1").end()
            .face(Direction.EAST).uvs(11, 1, 12, 1.5f).texture("#1").end()
            .face(Direction.SOUTH).uvs(14, 1, 15, 1.5f).texture("#1").end()
            .face(Direction.WEST).uvs(13, 1, 14, 1.5f).texture("#1").end()
            .face(Direction.UP).uvs(13, 1, 12, 0).texture("#1").end()
            .face(Direction.DOWN).uvs(14, 0, 13, 1).texture("#1").end()
        .end()

        // === DISPLAY TRANSFORMS ===
        .transforms()
            .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(33.25f, 0, 0)
                .translation(0, 0, 0)
                .scale(1, 1, 1)
            .end()
            .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(21, 0, 0)
                .translation(0, 0, 0)
                .scale(1, 1, 1)
            .end()
            .transform(ItemDisplayContext.GROUND)
                .rotation(103.66f, -0.91f, -111.75f)
                .translation(3.5f, -0.75f, 2.75f)
                .scale(1, 1, 1)
            .end()
            .transform(ItemDisplayContext.GUI)
                .rotation(-179.2f, -11.43f, -169.62f)
                .translation(0, 1.25f, 0)
                .scale(1, 1, 1)
            .end()
        .end();
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
