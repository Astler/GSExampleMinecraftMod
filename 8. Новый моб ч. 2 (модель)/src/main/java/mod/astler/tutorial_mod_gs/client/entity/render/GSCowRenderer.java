package mod.astler.tutorial_mod_gs.client.entity.render;

import mod.astler.tutorial_mod_gs.TutorialGSMod;
import mod.astler.tutorial_mod_gs.client.renderer.entity.model.GSCowModel;
import mod.astler.tutorial_mod_gs.entity.passive.GSCowEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GSCowRenderer extends MobRenderer<GSCowEntity, GSCowModel> {
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation(TutorialGSMod.MODID, "textures/entity/cow/gs_cow.png");

    public GSCowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GSCowModel(), 0.7F);
    }

    public ResourceLocation getEntityTexture(GSCowEntity entity) {
        return COW_TEXTURES;
    }
}