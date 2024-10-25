package me.dzyre.valheim.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static me.dzyre.valheim.DevMod.DEVMOD_TAB;
import static me.dzyre.valheim.DevMod.MOD_ID;
import static me.dzyre.valheim.blocks.OresController.*;
import static me.dzyre.valheim.items.ItemsController.ITEMS;

public class BlocksController {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> DZYRITE_BLOCK = BLOCKS.registerSimpleBlock("dzyrite_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().destroyTime(1f));

    public static final DeferredItem<BlockItem> DZYRITE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("dzyrite_block", DZYRITE_BLOCK);

    public static final DeferredBlock<Block> DZYRITE_LAMP = BLOCKS.register("dzyrite_lamp", () -> new DzyriteLamp(BlockBehaviour.Properties.of().lightLevel(state -> state.getValue(DzyriteLamp.clicked) ? 15 : 0)));

    public static final DeferredItem<BlockItem> DZYRITE_LAMP_ITEM = ITEMS.registerSimpleBlockItem("dzyrite_lamp", DZYRITE_LAMP);

    // ORES
    public static final DeferredBlock<Block> WORKSTATION = BLOCKS.register("workstation", () -> new Workbench(BlockBehaviour.Properties.of().noOcclusion()));
    public static final DeferredItem<BlockItem> WORKSTATION_ITEM = ITEMS.registerSimpleBlockItem("workstation_item", WORKSTATION);

    public static final DeferredItem<BlockItem> SILVER_ORE_ITEM = ITEMS.registerSimpleBlockItem("silver_ore", SILVER_ORE);
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == DEVMOD_TAB.getKey()) {
            event.accept(DZYRITE_BLOCK_ITEM);
            event.accept(DZYRITE_LAMP_ITEM);
            event.accept(DZYRITE_ORE_ITEM);
            event.accept(TIN_ORE_ITEM);
            event.accept(SILVER_ORE_ITEM);
            event.accept(WORKSTATION_ITEM);;
        }

    }
}
