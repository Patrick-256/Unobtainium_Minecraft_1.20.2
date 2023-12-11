package net.pata_data.unobtainium.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.pata_data.unobtainium.Unobtainium;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.pata_data.unobtainium.item.ModItems;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Unobtainium.MODID);

    //Add custom blocks here:
    public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = registerBlock("unobtainium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> UNOBTAINIUM_RAW = registerBlock("unobtainium_raw",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f) //stone is 1.5
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3,8))); //amt of experience to drop

//    public static final RegistryObject<Block> UNOBTAINIUM_RAW_ORE = registerBlock("unobtainium_raw_ore",
//            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
//                    .strength(2f).requiresCorrectToolForDrops(),
//                    UniformInt.of(3,8))); //amt of experience to drop
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
