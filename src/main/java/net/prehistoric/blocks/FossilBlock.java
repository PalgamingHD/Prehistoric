package net.prehistoric.blocks;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.prehistoric.Prehistoric;

import java.util.concurrent.ThreadLocalRandom;

public class FossilBlock extends Block
{
    public FossilBlock()
    {
        super(FabricBlockSettings.of(Material.METAL).breakByHand(false).sounds(BlockSoundGroup.STONE).strength(20,0.2f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (!world.isClient) {
            Block block = state.getBlock();
            //Fossils (22.5%)
            //Relics (23%)
            //Bones (40%)
            //Skull (10%)
            //Broken Ancient Sword (5%)
            //Scarab gem (0.1%)
            //Cobblestone
            //Broken Ancient Helmet (5%)
            Item pickcheck = player.getStackInHand(Hand.MAIN_HAND).getItem();
            if(pickcheck instanceof ToolItem){
            if(player.isCreative() == false) {
                int pickcheck2 = ((ToolItem) pickcheck).getMaterial().getMiningLevel();
                if (pickcheck2 >= 2) {
                    int RandomItem = ThreadLocalRandom.current().nextInt(1,101);
                    if (RandomItem >= 1 && RandomItem <= 22) {
                        ItemEntity fossil = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.FOSSIL, 1));
                        world.spawnEntity(fossil);
                    } else if (RandomItem >= 23 && RandomItem <= 45) {
                        ItemEntity relics = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.RELIC_SCRAP, 1));
                        world.spawnEntity(relics);
                    } else if (RandomItem >= 46 && RandomItem <= 85) {
                        ItemEntity bones = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BONE, 1));
                        world.spawnEntity(bones);
                    } else if (RandomItem >= 86 && RandomItem <= 96) {
                        ItemEntity skull = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.SKULL_BLOCK, 1));
                        world.spawnEntity(skull);
                    } else if (RandomItem >= 97 && RandomItem <= 97) {
                        ItemEntity ancient_sword = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.BROKEN_ANCIENT_SWORD, 1));
                        world.spawnEntity(ancient_sword);
                    } else if (RandomItem >= 98 && RandomItem <= 102) {
                        ItemEntity scarab = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.SCARAB, 1));
                        world.spawnEntity(scarab);
                    } else if (RandomItem >= 103 && RandomItem <= 112) {
                        ItemEntity cobblestone = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.COBBLESTONE, 1));
                        world.spawnEntity(cobblestone);
                    } else if (RandomItem >= 103 && RandomItem <= 112) {
                        ItemEntity ancient_helmet = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Prehistoric.BROKEN_ANCIENT_HELMET, 1));
                        world.spawnEntity(ancient_helmet);
                    }
                }
            }
            }
        }
    }
}
