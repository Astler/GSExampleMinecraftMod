package mod.astler.tutorial_mod_gs.item;

import mod.astler.tutorial_mod_gs.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static final ItemGroup MOD_ITEMS_ITEM_GROUP = new ModItemGroup("tutorial_mod_gs_items", () -> new ItemStack(ModItems.STONE_STICK.get()));
    public static final ItemGroup MOD_BLOCKS_ITEM_GROUP = new ModItemGroup("tutorial_mod_gs_blocks", () -> new ItemStack( ModBlocks.STONE_STICK_BLOCK.get()));
}
