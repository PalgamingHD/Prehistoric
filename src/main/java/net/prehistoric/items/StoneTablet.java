package net.prehistoric.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class StoneTablet extends Item
{
    private final EntityType<? extends AbstractDecorationEntity> entityType;

    public StoneTablet(EntityType<? extends AbstractDecorationEntity> type, Settings settings) {
        super(settings);
        this.entityType = type;
    }


    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        Direction direction = context.getSide();
        BlockPos blockPos2 = blockPos.offset(direction);
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();
        if (playerEntity != null && !this.canPlaceOn(playerEntity, direction, itemStack, blockPos2)) {
            return ActionResult.FAIL;
        } else {
            World world = context.getWorld();
            Object abstractDecorationEntity3;
            if (this.entityType == EntityType.PAINTING)
            {
                abstractDecorationEntity3 = new StoneTabletEntity(world, blockPos2, direction);
            } else {
                if (this.entityType != EntityType.ITEM_FRAME) {
                    return ActionResult.success(world.isClient);
                }

                abstractDecorationEntity3 = new ItemFrameEntity(world, blockPos2, direction);
            }

            CompoundTag compoundTag = itemStack.getTag();
            if (compoundTag != null) {
                EntityType.loadFromEntityTag(world, playerEntity, (Entity)abstractDecorationEntity3, compoundTag);
            }

            if (((AbstractDecorationEntity)abstractDecorationEntity3).canStayAttached()) {
                if (!world.isClient) {
                    ((AbstractDecorationEntity)abstractDecorationEntity3).onPlace();
                    world.spawnEntity((Entity)abstractDecorationEntity3);
                }

                itemStack.decrement(1);
                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.CONSUME;
            }
        }
    }

    protected boolean canPlaceOn(PlayerEntity player, Direction side, ItemStack stack, BlockPos pos) {
        return !side.getAxis().isVertical() && player.canPlaceOn(pos, side, stack);
    }
}
