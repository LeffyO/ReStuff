package net.leffy.meteorits.item.custom;

import net.leffy.meteorits.block.ModBlocks;
import net.leffy.meteorits.components.ModDataComponents;
import net.leffy.meteorits.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public class Camera extends Item {
    public Camera(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack items = context.getItemInHand();

        if (!level.isClientSide) {
            if (items.is(ModItems.CAM.get())) {
                level.setBlock(pos, ModBlocks.TRIPODWITHCAM.get().defaultBlockState().setValue(BlockStateProperties.FACING, state.getValue(BlockStateProperties.FACING)),3);
                items.shrink(1);
            } else {
                return InteractionResult.PASS;
            }

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("this is a ").withStyle(ChatFormatting.GRAY)
                .append(Component.literal("Camera ").withStyle(style ->  style.withColor(TextColor.fromRgb(0x93b7ff)))));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
