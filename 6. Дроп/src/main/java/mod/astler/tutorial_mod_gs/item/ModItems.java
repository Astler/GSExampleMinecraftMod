package mod.astler.tutorial_mod_gs.item;

import mod.astler.tutorial_mod_gs.TutorialGSMod;
import mod.astler.tutorial_mod_gs.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TutorialGSMod.MODID);

    public static final RegistryObject<Item> STONE_STICK = ITEMS.register("stone_stick", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEMS_ITEM_GROUP)));

    public static final RegistryObject<Item> STONE_STICK_BLOCK = ITEMS.register("stone_stick_block", () -> new BlockItem(ModBlocks.STONE_STICK_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS_ITEM_GROUP)));
}

