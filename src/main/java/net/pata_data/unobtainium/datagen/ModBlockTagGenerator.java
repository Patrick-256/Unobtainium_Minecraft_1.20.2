package net.pata_data.unobtainium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.pata_data.unobtainium.Unobtainium;
import net.pata_data.unobtainium.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Unobtainium.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.UNOBTAINIUM_BLOCK.get(),
                        ModBlocks.UNOBTAINIUM_RAW.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.UNOBTAINIUM_BLOCK.get(),
                        ModBlocks.UNOBTAINIUM_RAW.get());
    }
}
