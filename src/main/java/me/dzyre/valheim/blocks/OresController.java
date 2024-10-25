package me.dzyre.valheim.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static me.dzyre.valheim.blocks.BlocksController.BLOCKS;
import static me.dzyre.valheim.items.ItemsController.ITEMS;

public class OresController {
    public static final DeferredBlock<Block> DZYRITE_ORE = BLOCKS.register("dzyrite_ore", ()-> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().destroyTime(1f)));

    public static final DeferredItem<BlockItem> DZYRITE_ORE_ITEM = ITEMS.registerSimpleBlockItem("dzyrite_ore", DZYRITE_ORE);

    public static final DeferredBlock<Block> TIN_ORE = BLOCKS.register("tin_ore", ()-> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().destroyTime(1f)));

    public static final DeferredItem<BlockItem> TIN_ORE_ITEM = ITEMS.registerSimpleBlockItem("tin_ore", TIN_ORE);

    public static final DeferredBlock<Block> SILVER_ORE = BLOCKS.register("silver_ore", ()-> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().destroyTime(1f)));



}
