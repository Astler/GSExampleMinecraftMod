package mod.astler.tutorial_mod_gs.block;

import mod.astler.tutorial_mod_gs.TutorialGSMod;
import mod.astler.tutorial_mod_gs.item.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TutorialGSMod.MODID);

    public static final RegistryObject<Block> STONE_STICK_BLOCK = BLOCKS.register("stone_stick_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> STONE_STICK_STAIRS = BLOCKS.register("stone_stick_stairs", () -> new StairsBlock(() -> STONE_STICK_BLOCK.get().getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> STONE_STICK_SLAB = BLOCKS.register("stone_stick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> STONE_STICK_WALL = BLOCKS.register("stone_stick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestTool(ToolType.PICKAXE)));

}