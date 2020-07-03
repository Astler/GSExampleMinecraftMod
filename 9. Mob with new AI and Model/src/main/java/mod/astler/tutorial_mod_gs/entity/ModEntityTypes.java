package mod.astler.tutorial_mod_gs.entity;

import mod.astler.tutorial_mod_gs.TutorialGSMod;
import mod.astler.tutorial_mod_gs.entity.passive.GSCowEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            TutorialGSMod.MODID);

    public static final RegistryObject<EntityType<GSCowEntity>> GS_COW = ENTITY_TYPES
            .register("gs_cow",
                    () -> EntityType.Builder.<GSCowEntity>create(GSCowEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.49f)
                            .build(new ResourceLocation(TutorialGSMod.MODID, "gs_cow").toString()));

}
