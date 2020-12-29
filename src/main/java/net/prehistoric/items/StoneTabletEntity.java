package net.prehistoric.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.prehistoric.Prehistoric;
import org.jetbrains.annotations.Nullable;

public class StoneTabletEntity extends PaintingEntity {
    public StoneTabletEntity(EntityType<? extends PaintingEntity> entityType, World world) {
        super(entityType, world);
    }

    public StoneTabletEntity(World world, BlockPos pos, Direction direction) {
        super(world, pos, direction);
    }

    public StoneTabletEntity(World world, BlockPos pos, Direction direction, PaintingMotive motive) {
        super(world, pos, direction, motive);
    }
    public void onBreak(@Nullable Entity entity) {
        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
            this.playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0F, 1.0F);
            if (entity instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity)entity;
                if (playerEntity.abilities.creativeMode) {
                    return;
                }
            }

            this.dropItem(Prehistoric.STONE_TABLET);
        }
    }
}
