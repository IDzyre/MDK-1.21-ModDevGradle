package me.dzyre.valheim.worldgen;

import me.dzyre.valheim.DevMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static me.dzyre.valheim.blocks.BlocksController.*;
import static me.dzyre.valheim.blocks.OresController.*;

public class ModConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_DZYRITE_ORE = registerKey("dzyrite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_TIN_ORE = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_SILVER_ORE = registerKey("silver_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context) {
        RuleTest replaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldDzyreOres = List.of(OreConfiguration.target(replaceables, DZYRITE_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_DZYRITE_ORE, Feature.ORE, new OreConfiguration(overworldDzyreOres, 4));

        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(OreConfiguration.target(replaceables, TIN_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_TIN_ORE, Feature.ORE, new OreConfiguration(overworldTinOres, 4));

        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(OreConfiguration.target(replaceables, SILVER_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_SILVER_ORE, Feature.ORE, new OreConfiguration(overworldSilverOres, 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(DevMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}