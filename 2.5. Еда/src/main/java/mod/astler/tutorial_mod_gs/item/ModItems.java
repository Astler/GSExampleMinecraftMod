package mod.astler.tutorial_mod_gs.item;

import mod.astler.tutorial_mod_gs.TutorialGSMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TutorialGSMod.MODID);

    public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage", () -> new Item(new Item.Properties().food(ModFood.SAUSAGE).group(ModItemGroups.MOD_ITEMS_ITEM_GROUP)));
    public static final RegistryObject<Item> ENCHANTED_SAUSAGE = ITEMS.register("enchanted_sausage", () -> new EnchantedSausage(new Item.Properties().food(ModFood.ENCHANTED_SAUSAGE).group(ModItemGroups.MOD_ITEMS_ITEM_GROUP)));
}

