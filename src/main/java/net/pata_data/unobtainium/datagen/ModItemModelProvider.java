package net.pata_data.unobtainium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pata_data.unobtainium.Unobtainium;
import net.pata_data.unobtainium.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Unobtainium.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.UNOBTAINIUM_INGOT);
        simpleItem(ModItems.UNOBTAINIUM_ORE);

        handheldItem(ModItems.UNOBTAINIUM_SWORD);
        handheldItem(ModItems.UNOBTAINIUM_PICKAXE);
        handheldItem(ModItems.UNOBTAINIUM_AXE);
        handheldItem(ModItems.UNOBTAINIUM_SHOVEL);
        handheldItem(ModItems.UNOBTAINIUM_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Unobtainium.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Unobtainium.MODID,"item/" + item.getId().getPath()));
    }
}
