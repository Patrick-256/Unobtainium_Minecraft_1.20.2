package net.pata_data.unobtainium.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pata_data.unobtainium.Unobtainium;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_UNOBTAINIUM_TOOL = tag("needs_unobtainium_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Unobtainium.MODID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Unobtainium.MODID, name));
        }
    }
}
