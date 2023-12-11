package net.pata_data.unobtainium.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.pata_data.unobtainium.Unobtainium;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


import java.util.List;


public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> UNOBTAINIUM_ORE_PLACED_KEY = registerKey("unobtainium_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, UNOBTAINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.JUNGLE_UNOBTAINIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(1, //num of veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(100))));

    }
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Unobtainium.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
