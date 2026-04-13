package net.leffy.meteorits.item.custom;

import net.leffy.meteorits.block.ModBlocks;
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
import net.minecraft.world.level.block.Block;

import java.util.List;

public class Wrench extends Item {

    public Wrench(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        Block block = level.getBlockState(pos).getBlock();

        if (block == ModBlocks.TRIPOD.get() || block == ModBlocks.TRIPODWITHCAM.get()) {
            level.destroyBlock(pos, true);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("this is a ").withStyle(ChatFormatting.GRAY).append(Component.literal("Wrench").withStyle(style -> style.withColor(TextColor.fromRgb(0x93b7ff)))));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
