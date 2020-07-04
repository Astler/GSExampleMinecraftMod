package mod.astler.tutorial_mod_gs.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.astler.tutorial_mod_gs.entity.passive.GSCowEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GSCowModel extends EntityModel<GSCowEntity> {
    private final ModelRenderer mBody;
    private final ModelRenderer mRightBack;
    private final ModelRenderer mLeftBack;
    private final ModelRenderer mRightFront;
    private final ModelRenderer mLeftFront;
    private final ModelRenderer mHead;
    private final ModelRenderer mNose;
    private final ModelRenderer mRightEar;
    private final ModelRenderer mLeftEar;

    public GSCowModel() {
        textureWidth = 64;
        textureHeight = 64;


        mBody = new ModelRenderer(this);
        mBody.setRotationPoint(0.0F, 24.0F, 0.0F);


        ModelRenderer legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        mBody.addChild(legs);


        ModelRenderer back = new ModelRenderer(this);
        back.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(back);


        mRightBack = new ModelRenderer(this);
        mRightBack.setRotationPoint(-4.0F, -12.0F, 8.0F);
        back.addChild(mRightBack);
        mRightBack.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        mLeftBack = new ModelRenderer(this);
        mLeftBack.setRotationPoint(4.0F, -12.0F, 8.0F);
        back.addChild(mLeftBack);
        mLeftBack.setTextureOffset(0, 38).func_228303_a_(-2.0F, -0.1551F, -1.8511F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        ModelRenderer front = new ModelRenderer(this);
        front.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(front);


        mRightFront = new ModelRenderer(this);
        mRightFront.setRotationPoint(-4.0F, -12.0F, -6.0F);
        front.addChild(mRightFront);
        mRightFront.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        mLeftFront = new ModelRenderer(this);
        mLeftFront.setRotationPoint(4.0F, -12.0F, -6.0F);
        front.addChild(mLeftFront);
        mLeftFront.setTextureOffset(0, 38).func_228303_a_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        mHead = new ModelRenderer(this);
        mHead.setRotationPoint(0.0F, -21.0F, -8.0F);
        mBody.addChild(mHead);
        mHead.setTextureOffset(0, 22).func_228303_a_(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
        mHead.setTextureOffset(0, 39).func_228303_a_(3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        mHead.setTextureOffset(0, 39).func_228303_a_(-4.0F, -6.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        mNose = new ModelRenderer(this);
        mNose.setRotationPoint(0.0F, 4.0F, -7.0F);
        mHead.addChild(mNose);
        setRotationAngle(mNose, 0.1745F, 0.0F, 0.0F);
        mNose.setTextureOffset(42, 49).func_228303_a_(-3.0F, -3.0F, 0.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);

        mRightEar = new ModelRenderer(this);
        mRightEar.setRotationPoint(-4.0F, -1.0F, -3.0F);
        mHead.addChild(mRightEar);
        setRotationAngle(mRightEar, 0.0873F, 0.0F, 0.0873F);
        mRightEar.setTextureOffset(42, 46).func_228303_a_(-2.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        mRightEar.setTextureOffset(42, 45).func_228303_a_(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        mLeftEar = new ModelRenderer(this);
        mLeftEar.setRotationPoint(4.0F, -1.0F, -4.0F);
        mHead.addChild(mLeftEar);
        setRotationAngle(mLeftEar, 0.0873F, 0.0F, -0.0873F);
        mLeftEar.setTextureOffset(50, 45).func_228303_a_(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        mLeftEar.setTextureOffset(51, 44).func_228303_a_(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        ModelRenderer chest = new ModelRenderer(this);
        chest.setRotationPoint(0.0F, -16.0F, 0.0F);
        mBody.addChild(chest);
        chest.setTextureOffset(0, 36).func_228303_a_(-6.0F, -6.0F, -8.0F, 12.0F, 10.0F, 18.0F, 0.0F, false);

        ModelRenderer IDK = new ModelRenderer(this);
        IDK.setRotationPoint(0.0F, 0.0F, 0.0F);
        mBody.addChild(IDK);
        IDK.setTextureOffset(0, 14).func_228303_a_(-2.0F, -12.0F, 4.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        mBody.func_228308_a_(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }

    public void func_225597_a_(GSCowEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.mHead.rotateAngleX = p_225597_6_ * ((float) Math.PI / 180F);
        this.mHead.rotateAngleY = p_225597_5_ * ((float) Math.PI / 180F);
        this.mLeftFront.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.mLeftBack.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 1.4F * p_225597_3_;
        this.mRightFront.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 1.4F * p_225597_3_;
        this.mRightBack.rotateAngleX = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
    }
}