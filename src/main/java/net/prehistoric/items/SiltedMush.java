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

public class SiltedMush extends Item {

    public SiltedMush(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {

            if (!user.abilities.creativeMode) {
                itemStack.decrement(1);
            }
            int RandomItem = ThreadLocalRandom.current().nextInt(1,101);
            System.out.println(RandomItem);

            //Sand = 20% Range: 1-20
            //Gravel = 20% Range: 21-40
            //Gold Nugget = 15% Range: 41-55
            //Glass Bottle = 10% Range 56-65
            //Coal = 10% Range 66-75
            //Gold Ingot = 3% 76-78
            //Fossil 2% 79-80
            //Pickaxe 5% 81-95
            //Iron Nugget 5% 96-100

            if(RandomItem >= 1 && RandomItem <= 20)
            {
                ItemEntity sand = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.SAND, 1));
                world.spawnEntity(sand);
            }else if(RandomItem >=21 && RandomItem <= 40)
            {
                ItemEntity gravel = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.GRAVEL, 1));
                world.spawnEntity(gravel);
            }else if(RandomItem >=41 && RandomItem <= 55)
            {
                ItemEntity gold_nugget = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.GOLD_NUGGET, 1));
                world.spawnEntity(gold_nugget);
            }else if(RandomItem >=56 && RandomItem <= 65)
            {
                ItemEntity glass_bottle = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.GLASS_BOTTLE, 1));
                world.spawnEntity(glass_bottle);
            }else if(RandomItem >=66 && RandomItem <= 75)
            {
                ItemEntity coal = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.COAL, 1));
                world.spawnEntity(coal);
            }else if(RandomItem >=76 && RandomItem <= 78)
            {
                ItemEntity gold_ingot = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.GOLD_INGOT, 1));
                world.spawnEntity(gold_ingot);
            }else if(RandomItem >=79 && RandomItem <= 80)
            {
                ItemEntity fossil = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Prehistoric.FOSSIL, 1));
                world.spawnEntity(fossil);
            }else if(RandomItem >=81 && RandomItem <= 95)
            {
                ItemEntity pickaxe = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.IRON_PICKAXE, 1));
                world.spawnEntity(pickaxe);
            }else if(RandomItem >=96 && RandomItem <= 100)
            {
                ItemEntity iron_ingot = new ItemEntity(world, user.getX(), user.getY(), user.getZ(), new ItemStack(Items.IRON_INGOT, 1));
                world.spawnEntity(iron_ingot);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}