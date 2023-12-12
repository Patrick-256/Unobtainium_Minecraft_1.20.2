package net.pata_data.unobtainium.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.pata_data.unobtainium.Unobtainium;
import net.pata_data.unobtainium.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier UNOBTAINIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5,9999,5f,4f,25,
                    ModTags.Blocks.NEEDS_UNOBTAINIUM_TOOL,() -> Ingredient.of(ModItems.UNOBTAINIUM_INGOT.get())),
            new ResourceLocation(Unobtainium.MODID,"unobtainium_ingot"),List.of(Tiers.NETHERITE), List.of());

}
