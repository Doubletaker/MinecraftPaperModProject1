package net.doubletaker.project1.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class ChiselItemClient {
    public static void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.project1.chisel_1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.project1.chisel_2").formatted(Formatting.DARK_PURPLE));

        int damage = stack.getDamage();
        int max = stack.getMaxDamage();
        tooltip.add(Text.literal("Durability: " + (max - damage) + " / " + max).formatted(Formatting.GREEN));
    }
}
