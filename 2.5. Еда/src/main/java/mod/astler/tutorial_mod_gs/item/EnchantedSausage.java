package mod.astler.tutorial_mod_gs.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedSausage extends Item {

    public EnchantedSausage(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
