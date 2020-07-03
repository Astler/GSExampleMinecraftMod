package mod.astler.tutorial_mod_gs.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.astler.tutorial_mod_gs.entity.passive.GSCowEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class GSCowModel extends EntityModel<GSCowEntity> {
    private final ModelRenderer Body;
    private final ModelRenderer Legs;
    private final ModelRenderer Back;
    private final ModelRenderer RightBack;
    private final ModelRenderer LeftBack;
    private final ModelRenderer Front;
    private final ModelRenderer RightFront;
    private final ModelRenderer LeftFront;
    private final ModelRenderer Head;
    private final ModelRenderer Nose;
    private final ModelRenderer RightEar;
    private final ModelRenderer LeftEar;
    private final ModelRenderer Chest;
    private final ModelRenderer IDK;

    private float headRotationAngleX;

    public GSCowModel() {
        textureWidth = 64;
        textureHeight = 64;

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);


        Legs = new ModelRenderer(this);
        Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(Legs);


        Back = new ModelRenderer(this);
        Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        Legs.addChild(Back);


        RightBack = new ModelRenderer(this);
        RightBack.setRotationPoint(-4.0F, -12.0F, 8.0F);
        Back.addChild(RightBack);
        RightBack.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        LeftBack = new ModelRenderer(this);
        LeftBack.setRotationPoint(4.0F, -12.0F, 8.0F);
        Back.addChild(LeftBack);
        LeftBack.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        Front = new ModelRenderer(this);
        Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        Legs.addChild(Front);


        RightFront = new ModelRenderer(this);
        RightFront.setRotationPoint(-4.0F, -12.0F, -6.0F);
        Front.addChild(RightFront);
        RightFront.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        LeftFront = new ModelRenderer(this);
        LeftFront.setRotationPoint(4.0F, -12.0F, -6.0F);
        Front.addChild(LeftFront);
        LeftFront.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, -22.0F, -8.0F);
        Body.addChild(Head);
        Head.setTextureOffset(0, 22).func_228303_a_(-4.0F, -3.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
        Head.setTextureOffset(0, 39).func_228303_a_(3.0F, -5.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        Head.setTextureOffset(0, 39).func_228303_a_(-4.0F, -5.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        Nose = new ModelRenderer(this);
        Nose.setRotationPoint(0.0F, 5.0F, -7.0F);
        Head.addChild(Nose);
        setRotationAngle(Nose, 0.1745F, 0.0F, 0.0F);
        Nose.setTextureOffset(42, 49).func_228303_a_(-3.0F, -3.0F, 0.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);

        RightEar = new ModelRenderer(this);
        RightEar.setRotationPoint(-4.0F, 0.0F, -3.0F);
        Head.addChild(RightEar);
        setRotationAngle(RightEar, 0.0873F, 0.0F, 0.0873F);
        RightEar.setTextureOffset(42, 46).func_228303_a_(-2.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        RightEar.setTextureOffset(42, 45).func_228303_a_(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        LeftEar = new ModelRenderer(this);
        LeftEar.setRotationPoint(4.0F, 0.0F, -4.0F);
        Head.addChild(LeftEar);
        setRotationAngle(LeftEar, 0.0873F, 0.0F, -0.0873F);
        LeftEar.setTextureOffset(51, 44).func_228303_a_(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        LeftEar.setTextureOffset(50, 45).func_228303_a_(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        Chest = new ModelRenderer(this);
        Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(Chest);
        Chest.setTextureOffset(0, 36).func_228303_a_(-6.0F, -22.0F, -8.0F, 12.0F, 10.0F, 18.0F, 0.0F, false);

        IDK = new ModelRenderer(this);
        IDK.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(IDK);
        IDK.setTextureOffset(0, 14).func_228303_a_(-2.0F, -12.0F, 4.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        Body.func_228308_a_(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }

    public ModelRenderer getHead() {
        return this.Head;
    }

    public void setLivingAnimations(GSCowEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
        this.Head.rotationPointY = entityIn.getHeadRotationPointY(partialTick) * 9 - 22;
        this.headRotationAngleX = entityIn.getHeadRotationAngleX(partialTick);
    }

    public void func_225597_a_(GSCowEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
       // this.getHead().rotateAngleX = p_225597_6_ * ((float)Math.PI / 180F);
       // this.getHead().rotateAngleY = p_225597_5_ * ((float)Math.PI / 180F);
        this.getHead().rotateAngleX = this.headRotationAngleX;
        this.LeftFront.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.LeftBack.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.RightFront.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.RightBack.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }
}