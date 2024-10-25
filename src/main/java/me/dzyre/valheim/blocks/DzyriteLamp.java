package me.dzyre.valheim.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class DzyriteLamp extends Block {

    public static BooleanProperty clicked = BooleanProperty.create("clicked");

    public DzyriteLamp(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(clicked, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            boolean currentState = state.getValue(clicked);
            level.setBlockAndUpdate(pos, state.setValue(clicked, !currentState));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(clicked);
    }
}
