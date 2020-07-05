package mod.astler.tutorial_mod_gs.entity.passive;

import mod.astler.tutorial_mod_gs.entity.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;

public class GSCowEntity  extends AnimalEntity {
    private static final DataParameter<Boolean> HAS_MILK = EntityDataManager.createKey(GSCowEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> HUNGRY = EntityDataManager.createKey(GSCowEntity.class, DataSerializers.BOOLEAN);

    private int cowTimer;
    private EatGrassGoal eatGrassGoal;
    public int timeUntilMilk = this.rand.nextInt(1000) + 500;

    public GSCowEntity(EntityType<? extends GSCowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    protected void updateAITasks() {
        this.cowTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    public void livingTick() {
        if (this.world.isRemote) {
            this.cowTimer = Math.max(0, this.cowTimer - 1);
        }

        if (!hasMilk() && !isHungry()) {
            if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilMilk <= 0) {
                this.playSound(SoundEvents.ENTITY_COW_AMBIENT, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                setHasMilk(true);
                //this.glowing = hasMilk();
            }
        }

        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {

        if (id == 10) {
            this.cowTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.cowTimer <= 0) {
            return 0.0F;
        } else if (this.cowTimer >= 4 && this.cowTimer <= 36) {
            return 1.0F;
        } else {
            return this.cowTimer < 4 ? ((float)this.cowTimer - p_70894_1_) / 4.0F : -((float)(this.cowTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.cowTimer > 4 && this.cowTimer <= 36) {
            float f = ((float)(this.cowTimer - 4) - p_70890_1_) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.cowTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
        }
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25F);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(HAS_MILK, new Random().nextBoolean());
        this.dataManager.register(HUNGRY, new Random().nextBoolean());
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("hasMilk", this.hasMilk());
        compound.putBoolean("isHungry", this.isHungry());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setHasMilk(compound.getBoolean("hasMilk"));
        this.setIsHungry(compound.getBoolean("isHungry"));
    }

    public void eatGrassBonus() {
        if (isHungry())
            this.timeUntilMilk = this.rand.nextInt(1000) + 500;

        this.setIsHungry(false);


        if (this.isChild()) {
            this.addGrowth(60);
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.BUCKET && !player.abilities.isCreativeMode && !this.isChild() && hasMilk()) {

            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

            itemstack.shrink(1);

            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(Items.MILK_BUCKET));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET))) {
                player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
            }

            setHasMilk(false);
            setIsHungry(true);

            return true;
        } else if (itemstack.getItem() == Items.DEBUG_STICK) {
            if(!player.world.isRemote)
                player.sendMessage(new StringTextComponent("[TUTORMOD]\nHAS MILK: " + hasMilk() + "\nHUNGRY: " + isHungry() + "\nTIME UNTIL MILK: " + timeUntilMilk));

            return true;
        }
        else {
            return super.processInteract(player, hand);
        }
    }

    public GSCowEntity createChild(AgeableEntity ageableEntity) {
        return ModEntityTypes.GS_COW.get().create(this.world);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
    }

    public boolean hasMilk() {
        return this.dataManager.get(HAS_MILK);
    }

    public void setHasMilk(boolean hasMilk) {
        this.dataManager.set(HAS_MILK, hasMilk);
    }

    public boolean isHungry() {
        return this.dataManager.get(HUNGRY);
    }

    public void setIsHungry(boolean isHungry) {
        this.dataManager.set(HUNGRY, isHungry);
    }
}