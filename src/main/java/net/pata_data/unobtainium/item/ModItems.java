package net.pata_data.unobtainium.item;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.pata_data.unobtainium.Unobtainium;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class ModItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,Unobtainium.MODID);

    //Add custom items here:
    public static final RegistryObject<Item> UNOBTAINIUM_ORE = ITEMS.register("unobtainium_ore",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNOBTAINIUM_SWORD = ITEMS.register("unobtainium_sword",
            () -> new SwordItem(ModToolTiers.UNOBTAINIUM,4,2, new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_PICKAXE = ITEMS.register("unobtainium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.UNOBTAINIUM,3,2, new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_AXE = ITEMS.register("unobtainium_axe",
            () -> new AxeItem(ModToolTiers.UNOBTAINIUM,7,1, new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_SHOVEL = ITEMS.register("unobtainium_shovel",
            () -> new ShovelItem(ModToolTiers.UNOBTAINIUM,2,2, new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_HOE = ITEMS.register("unobtainium_hoe",
            () -> new HoeItem(ModToolTiers.UNOBTAINIUM,2,2, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
