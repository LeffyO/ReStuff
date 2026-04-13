package net.leffy.meteorits.block.custom;

import com.mojang.serialization.MapCodec;
import net.leffy.meteorits.block.ModBlocks;
import net.leffy.meteorits.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TripodsWcamBlock extends HorizontalDirectionalBlock{

    public static final MapCodec<TripodsWcamBlock> CODEC = simpleCodec(TripodsWcamBlock::new);

    public TripodsWcamBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BlockStateProperties.FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        Direction direction = state.getValue(BlockStateProperties.FACING);

        if (player.isCrouching()) {
            if (!level.isClientSide) {
                player.addItem(ModItems.CAM.toStack(1));
                level.setBlock(pos, ModBlocks.TRIPOD.get().defaultBlockState().setValue(BlockStateProperties.FACING, direction), 3);
                return InteractionResult.SUCCESS;
            }
        } else {
            level.playSound(player, pos, SoundEvents.NOTE_BLOCK_CHIME.value(), SoundSource.BLOCKS, 1f, 1f);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.restuff.tripodwcam.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }



}
