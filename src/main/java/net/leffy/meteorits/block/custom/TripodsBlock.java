package net.leffy.meteorits.block.custom;

import com.mojang.serialization.MapCodec;
import net.leffy.meteorits.block.ModBlocks;
import net.leffy.meteorits.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TripodsBlock extends HorizontalDirectionalBlock {

    public static final MapCodec<TripodsBlock> CODEC = simpleCodec(TripodsBlock::new);

    public TripodsBlock(Properties properties) {
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
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        Direction direction = state.getValue(BlockStateProperties.FACING);
        if (entity instanceof ItemEntity itemEntity) {
            if (isValidItem(itemEntity.getItem())) {
                level.setBlock(pos, ModBlocks.TRIPODWITHCAM.get().defaultBlockState().setValue(BlockStateProperties.FACING, direction), 3);
                itemEntity.setRemoved(Entity.RemovalReason.KILLED);
            }
        }
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.ARETRIPODS);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.restuff.tripods.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
