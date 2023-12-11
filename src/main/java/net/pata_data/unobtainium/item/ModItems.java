package net.pata_data.unobtainium.item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.pata_data.unobtainium.Unobtainium;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
