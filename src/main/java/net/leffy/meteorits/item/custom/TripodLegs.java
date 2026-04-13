package net.leffy.meteorits.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class TripodLegs extends Item {

    public TripodLegs(Properties properties) {
        super(properties);
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("this is a ").withStyle(ChatFormatting.GRAY).append(Component.literal("tripod leg").withStyle(style -> style.withColor(TextColor.fromRgb(0x93b7ff)))));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
