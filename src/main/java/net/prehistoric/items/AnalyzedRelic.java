package net.prehistoric.items;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.prehistoric.Prehistoric;

import java.util.concurrent.ThreadLocalRandom;

public class AnalyzedRelic extends Item {

    public AnalyzedRelic(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {

            if (!user.abilities.creativeMode) {
                itemStack.decrement(1);
            }
            int RandomItem = ThreadLocalRandom.current().nextInt(1,111);
            System.out.println(RandomItem);

            //Gravel = 40% Range: 1-40
            //Stone Tablet = 30% Range: 41-70
            //Flint = 18% Range: 71-88
            //Pottery Shard = 4% Range 89-92
            //Ancient Figurines = 10% Range 93-103
            //Broken Sword = 4% 104-107
            //Broken Sword = 4% 108-110

            if(RandomItem >= 1 && RandomItem <= 40)
            {
                ItemEntity gravel = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.GRAVEL, 1));
                world.spawnEntity(gravel);
            }else if(RandomItem >=41 && RandomItem <= 70)
            {
                ItemEntity stone_tablet = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Prehistoric.STONE_TABLET, 1));
                world.spawnEntity(stone_tablet);
            }else if(RandomItem >=71 && RandomItem <= 88)
            {
                ItemEntity flint = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.FLINT, 1));
                world.spawnEntity(flint);
            }else if(RandomItem >=89 && RandomItem <= 92)
            {
                ItemEntity pottery_shard = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Prehistoric.POTTERY_SHARD, 1));
                world.spawnEntity(pottery_shard);
            }else if(RandomItem >=93 && RandomItem <= 103)
            {
                ItemEntity ancient_figurine = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.ZOMBIE_HEAD, 1));
                world.spawnEntity(ancient_figurine);
            }else if(RandomItem >=104 && RandomItem <= 107)
            {
                ItemEntity ancient_sword = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Prehistoric.BROKEN_ANCIENT_SWORD, 1));
                world.spawnEntity(ancient_sword);
            }else if(RandomItem >=108 && RandomItem <= 110)
            {
                ItemEntity ancient_helmet = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Prehistoric.BROKEN_ANCIENT_HELMET, 1));
                world.spawnEntity(ancient_helmet);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}