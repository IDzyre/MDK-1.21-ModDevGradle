package me.dzyre.valheim.worldgen;

import me.dzyre.valheim.DevMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeature {
    public static final ResourceKey<PlacedFeature> DZYRITE_ORE_PLACED_KEY = createKey("dzyrite_ore");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = createKey("tin_ore");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = createKey("silver_ore");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, DZYRITE_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeature.OVERWORLD_DZYRITE_ORE),
                ModOrePlacement.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80)))
        );

        register(context, SILVER_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeature.OVERWORLD_SILVER_ORE),
                ModOrePlacement.commonOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80)))
        );

        register(context, TIN_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeature.OVERWORLD_TIN_ORE),
                ModOrePlacement.commonOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),VerticalAnchor.absolute(80)))
        );
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DevMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
