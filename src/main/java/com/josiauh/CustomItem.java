package com.josiauh;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import com.josiauh.AudioHelper;
import java.util.List;
import java.util.Random;

public class CustomItem extends Item {

	public SoundEvent[] sounds = { AudioHelper.burn, AudioHelper.hate, AudioHelper.you, AudioHelper.illness, AudioHelper.loser, AudioHelper.notouch };

	public CustomItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("If the earth is round, why ain't the block go nowhere?").formatted(Formatting.RED));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		Random random = new Random();
		int index = random.nextInt(sounds.length);
		SoundEvent sound = sounds[index];
		playerEntity.playSound(sound, 1.0F, 1.0F);
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
	}
}
