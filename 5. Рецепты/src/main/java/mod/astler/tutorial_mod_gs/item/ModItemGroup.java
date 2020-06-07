package mod.astler.tutorial_mod_gs.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

public class ModItemGroup extends ItemGroup {

    private final RegistryObject<Item> iconSupplier;

    public ModItemGroup(final String name, final RegistryObject<Item> iconSupplier) {
        super(name);
        this.iconSupplier = iconSupplier;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(iconSupplier.get());
    }
}