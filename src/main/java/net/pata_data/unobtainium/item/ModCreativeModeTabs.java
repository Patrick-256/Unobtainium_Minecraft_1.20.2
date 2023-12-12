package net.pata_data.unobtainium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pata_data.unobtainium.Unobtainium;
import net.pata_data.unobtainium.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Unobtainium.MODID);

    public static final RegistryObject<CreativeModeTab> UNOBTAINIUM_TAB =
            CREATIVE_MODE_TABS.register("unobtainium_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.UNOBTAINIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.unobtainium_tab"))
                    .displayItems((pParameter, pOutput) -> {
                        //Add custom items to the mod's creative mode tab:
                        pOutput.accept(ModItems.UNOBTAINIUM_INGOT.get());
                        pOutput.accept(ModItems.UNOBTAINIUM_ORE.get());

                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ModBlocks.UNOBTAINIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.UNOBTAINIUM_RAW.get());

                        pOutput.accept(ModItems.UNOBTAINIUM_SWORD.get());
                        pOutput.accept(ModItems.UNOBTAINIUM_PICKAXE.get());
                        pOutput.accept(ModItems.UNOBTAINIUM_AXE.get());
                        pOutput.accept(ModItems.UNOBTAINIUM_SHOVEL.get());
                        pOutput.accept(ModItems.UNOBTAINIUM_HOE.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
