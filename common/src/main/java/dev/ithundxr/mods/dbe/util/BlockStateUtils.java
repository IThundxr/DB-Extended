package dev.ithundxr.mods.dbe.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockStateUtils {
    @ExpectPlatform
    public static SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, Entity entity) {
        throw new AssertionError();
    }
}
