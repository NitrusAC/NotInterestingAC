package de.jpx3.intave.anticheat.engine.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedAttribute;
import com.comphenix.protocol.wrappers.WrappedAttributeModifier;
import com.comphenix.protocol.wrappers.WrappedAttributeModifier.Operation;
import com.google.common.collect.ImmutableList;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.k3;
import de.jpx3.intave.kt;
import de.jpx3.intave.pU;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.EnginePlayer;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.Headings;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.BlockTypeUtil;
import de.jpx3.intave.anticheat.util.CollisionUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.PotionEffectUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.unknown.Unknown105;
import de.jpx3.intave.unknown.Unknown134;
import de.jpx3.intave.unknown.Unknown135;
import de.jpx3.intave.unknown.Unknown159;
import de.jpx3.intave.unknown.Unknown19;
import de.jpx3.intave.unknown.Unknown242;
import de.jpx3.intave.unknown.Unknown279;
import de.jpx3.intave.unknown.Unknown303;
import de.jpx3.intave.unknown.Unknown360;
import de.jpx3.intave.unknown.Unknown54;
import de.jpx3.intave.unknown.unknown79;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

@Relocate
public final class BukkitEnginePlayer implements EnginePlayer {
   public int bT;
   public float jumpStep = 0.6F;
   private float rotationX;
   public boolean m;
   private final PlayerData data;
   public double y;
   public boolean contextGround;
   public int bg;
   public double lastDeltaY;
   public boolean ah;
   private double minimumDistance;
   public double a5;
   public long af;
   public int bQ;
   public int bC;
   public Unknown242 q;
   private boolean ak;
   private Location location;
   public int A;
   public boolean be;
   public double lastDeltaZ;
   public int T;
   public float lastYaw;
   public boolean N;
   private double motionZ;
   public boolean bD;
   private boolean isModernVersion;
   private boolean e;
   private WeakReference O;
   private double motionX;
   public double serverX;
   public long n;
   public float pitch;
   public boolean bG;
   private double jumpHeight;
   public float width;
   public boolean collidedZ;
   public double z;
   public int at;
   public boolean collidedVertically;
   public int bU;
   public double lastX;
   public boolean sprint;
   public Map a8;
   public boolean aO;
   @k3
   private Vector moveVector;
   private Box boundingBox;
   public int G;
   public boolean bu;
   public double serverY;
   public boolean bW;
   public double bt;
   public boolean X;
   public boolean W;
   public int b5;
   public float aU;
   public int teleportTicks;
   public double bV;
   public int slowdownTicks;
   private int aI;
   public double Z;
   private HeadingHandler headingHandler;
   public double roundedJumpStep;
   public float lastPitch;
   public double aj;
   public double serverZ;
   public boolean collidedX;
   public boolean bJ;
   public int velocityTicks;
   private final Unknown135 L;
   public boolean sprinting;
   public boolean bi;
   public boolean bn;
   public boolean bl;
   public float height = 1.8F;
   public boolean R;
   public Vector bv;
   public double lastDeltaX;
   public double a_;
   private float movementAttribute;
   public static final WrappedAttributeModifier sprintAttributeKey = WrappedAttributeModifier.newBuilder(
         UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D")
      )
      .amount(0.3F)
      .operation(Operation.ADD_PERCENTAGE)
      .name("Sprint Boost")
      .build();
   private final Player player;
   public double deltaZ;
   public double lastZ;
   public boolean b3;
   public int P;
   public Vector E;
   public double an;
   public boolean jumping;
   public Location aB;
   public int C;
   public long flyingClickGroupTicks;
   public boolean onGround;
   public boolean t;
   public boolean isSneaking;
   private final List bp;
   public boolean c;
   public int D;
   @k3
   public Unknown105 bP;
   public double x;
   public boolean a0;
   public Map f;
   public int moveStrafe;
   private static final boolean isNewVersion = ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_9);
   public boolean bd;
   public double bZ;
   public double h;
   public Motion motion;
   public int bX;
   public int ba;
   public float U;
   public double aw;
   public Vector bo;
   public Vector velocity;
   public boolean inWeb;
   public int aT;
   public int lastMoveForward;
   public boolean teleporting;
   private Material d;
   public int r;
   public int ac;
   public Vector lookVector;
   public boolean bY;
   public List bL;
   public Location b;
   public int groundTicks;
   public int aJ;
   private float rotationZ;
   public float fallDistance;
   public float yaw;
   public int ab;
   public boolean collidedHorizontally;
   public boolean stepped;
   public boolean bm;
   public double S;
   public double bA;
   public int l;
   public long lastPhysicsIteration;
   private float acceleration;
   public List ad;
   private double motionY;
   public int bS;
   private double frictionBlockRemove;
   public boolean ap;
   private TrackedEntity trackedEntity;
   public float frictionMultiplier;
   public int aL;
   public double ar;
   private double F;
   public boolean inWater;
   private Pose pose;
   public AtomicInteger al;
   public Unknown242 H;
   public int lastMoveStrafe;
   public double Y;
   public double k;
   private float jumpMoveFactor;
   public boolean bh;
   public boolean isElytraFlying;
   public boolean a3;
   public int a;
   public double deltaX;
   public int iteratedTick;
   public double lastY;
   public boolean V;
   public int moveForward;
   public double deltaY;
   private int skipTicks;
   public double b6;
   public boolean isMoving;
   private boolean v;
   public Vector bR;
   public float o;
   public boolean ae;

   public boolean d() {
      return this.e;
   }

   public boolean F() {
      ItemHolder var3 = this.data.getStorage().getItemHolder();
      if (var3.j()) {
         return true;
      } else {
         int var4 = this.data.getAttributeValue("physics.joap-limit");
         return this.velocityTicks == 0 && this.sprinting && this.isTakingVelocity() && this.Y >= (double)var4;
      }
   }

   @Override
   public Motion getMotion() {
      return new Motion(this.motionX, this.motionY, this.motionZ);
   }

   private boolean isGliding(Player player) {
      return isNewVersion && this.is1_9(player) && player.isGliding();
   }

   private float getJumpHeight() {
      return this.isModernVersion ? 0.42F * this.getJumpModifier() : 0.42F;
   }

   public Object k() {
      return this.O.get();
   }

   public void writeGroundPacket(PacketContainer packet) {
      packet.getBooleans().write(0, this.contextGround);
   }

   @Override
   public float G() {
      return this.rotationX;
   }

   public void setPose(Pose pose) {
      this.pose = pose;
      this.y();
   }

   private Vector getLookVector(float yaw, float pitch) {
      float var3 = pitch * (float) (Math.PI / 180.0);
      float var4 = -yaw * (float) (Math.PI / 180.0);
      float var5 = MathUtil.cos(var4);
      float var6 = MathUtil.sin(var4);
      float var7 = MathUtil.cos(var3);
      float var8 = MathUtil.sin(var3);
      return new Vector((double)(var6 * var7), (double)(-var8), (double)(var5 * var7));
   }

   public void handleFlying(PacketContainer packet, boolean pos, boolean look) {
      if (!this.v) {
         this.computeFrictionFactor();
      }

      this.jumpHeight = CollisionUtil.getJumpBoost(this.player, this.getJumpHeight());
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      if (this.bl) {
         pU.a(this.player, 3, true);
         this.bl = false;
      }

      if (pos) {
         StructureModifier var4 = packet.getDoubles();
         this.x = var4.read(0);
         this.y = var4.read(1);
         this.z = var4.read(2);
         this.d = WorldUtil.getMaterialAt(this.data, this.player.getWorld(), this.x, this.y - this.frictionBlockRemove, this.z);
         this.motionX = this.x - this.serverX;
         this.motionY = this.y - this.serverY;
         this.motionZ = this.z - this.serverZ;
         boolean var5 = this.getMotionY() <= 0.0;
         if (var5 && PotionEffectUtil.c(this.player)) {
            this.fallDistance = 0.0F;
            this.ar = 0.01;
         } else {
            this.ar = 0.08;
         }

         this.z();
         this.livingUpdatePlayer();
      } else {
         this.skipTicks = 0;
         if (look) {
            this.motionX = this.x - this.serverX;
            this.motionY = this.y - this.serverY;
            this.motionZ = this.z - this.serverZ;
            this.d = WorldUtil.getMaterialAt(this.data, this.player.getWorld(), this.x, this.y - this.frictionBlockRemove, this.z);
            this.z();
            this.livingUpdatePlayer();
         }
      }

      this.lastYaw = this.yaw;
      this.lastPitch = this.pitch;
      if (look) {
         StructureModifier var6 = packet.getFloat();
         this.yaw = var6.read(0);
         this.pitch = var6.read(1);
         this.lookVector = this.getLookVector(this.yaw, this.pitch);
         float var7 = this.yaw * (float) Math.PI / 180.0F;
         this.rotationX = MathUtil.sin(var7);
         this.rotationZ = MathUtil.cos(var7);
      }

      this.computeInWeb();
      this.f();
      this.y();
      this.N();
   }

   public void setHeadingHandler(HeadingHandler handler) {
      this.headingHandler = handler;
   }

   public float getLastYaw() {
      return this.lastYaw;
   }

   public kt getRotation() {
      return new kt(this.yaw, this.pitch);
   }

   @Override
   public double getServerZ() {
      return this.serverZ;
   }

   private boolean b(PlayerData data) {
      PlayerStorage var2 = data.getStorage();
      BukkitEnginePlayer var3 = var2.getPhysicsHolder();
      VersionHolder var4 = var2.getVersionHolder();
      if (!var4.is1_13()) {
         return false;
      } else {
         boolean var5 = var3.sprint;
         boolean var6 = var3.getPose() == Pose.c;
         if (var6) {
            return var5 && var3.inWater;
         } else {
            return var5 && (var3.getPose() == Pose.ELYTRA && var3.inWater || var3.d());
         }
      }
   }

   public void U() {
      double var1 = this.y + (double)this.getEyeHeight() - 0.11111F;
      this.e = this.bP != null && this.bP.c();
      this.bP = null;
      Unknown105 var3 = Unknown360.a(this.data, this.x, var1, this.z);
      if (var3.c()) {
         double var4 = (double)((float)MathUtil.floor(var1) + 1.0F);
         if (var4 > var1) {
            this.bP = var3;
         }
      }

   }

   @Override
   public double getJumpBoostHeight() {
      return this.jumpHeight;
   }

   @Override
   public double getMotionX() {
      return this.motionX;
   }

   public int l() {
      return this.aI;
   }

   private void computeInWeb() {
      if (this.b3) {
         this.b3 = false;
         if (this.b(6)) {
            int var1 = MathUtil.floor(this.boundingBox.minX + 0.001);
            int var2 = MathUtil.floor(this.boundingBox.minY + 0.001);
            int var3 = MathUtil.floor(this.boundingBox.minZ + 0.001);
            int var4 = MathUtil.floor(this.boundingBox.maxX - 0.001);
            int var5 = MathUtil.floor(this.boundingBox.maxY - 0.001);
            int var6 = MathUtil.floor(this.boundingBox.maxZ - 0.001);
            this.inWeb = false;

            for(int var7 = var1; var7 <= var4; ++var7) {
               for(int var8 = var2; var8 <= var5; ++var8) {
                  for(int var9 = var3; var9 <= var6; ++var9) {
                     Material var10 = WorldUtil.getMaterialAt(this.data, var7, var8, var9);
                     if (var10 == IntaveMaterial.WEB) {
                        this.inWeb = true;
                     }
                  }
               }
            }

         }
      }
   }

   public double getFrictionBlockRemove() {
      return this.frictionBlockRemove;
   }

   private void updateAttributes() {
      if (this.player != null) {
         this.setSprinting(this.player.isSprinting());
         this.isSneaking = this.player.isSneaking();
      }
   }

   public Location getLocation() {
      return this.location;
   }

   @Override
   public double getMinimumMotion() {
      return this.minimumDistance;
   }

   @k3
   @Override
   public Vector getMoveVector() {
      return this.moveVector;
   }

   private void computeElytra() {
      if (this.isElytraFlying && !this.contextGround && !PotionEffectUtil.b(this.player)) {
         this.isElytraFlying = this.isWearingElytra();
      } else if (this.isElytraFlying) {
         this.isElytraFlying = false;
         this.y();
      }

   }

   private Material s() {
      return this.d;
   }

   public float getFrictionMultiplier() {
      return this.frictionMultiplier;
   }

   @Override
   public Vector getLookVector() {
      return this.lookVector;
   }

   private void computeElytraGliding() {
      this.isElytraFlying = this.isGliding(this.player);
   }

   public boolean e() {
      return this.b != null && this.getDistance(this.b) < 2.0;
   }

   @Override
   public double getX() {
      return this.x;
   }

   @Override
   public float getYaw() {
      return this.yaw;
   }

   private void z() {
      PlayerStorage var1 = this.data.getStorage();
      EntityHolder var2 = var1.getEntityHolder();
      VersionHolder var3 = var1.getVersionHolder();
      ItemHolder var4 = var1.getItemHolder();
      this.ak = this.sprinting;
      if (this.isSneaking && !var3.is1_14()) {
         this.ak = false;
      }

      if (var4.j()) {
         this.ak = false;
      }

      if (var2.foodLevel <= 6) {
         this.ak = false;
      }

   }

   @Override
   public double getServerY() {
      return this.serverY;
   }

   private float a(Material var1) {
      return BlockTypeUtil.getOrDefault(var1).e();
   }

   public boolean isWearingElytra() {
      ItemStack var1 = this.player.getInventory().getChestplate();
      return var1 != null && var1.getType() == Material.ELYTRA;
   }

   public void y() {
      boolean var1 = this.data.getStorage().getVersionHolder().getVersionId() >= VersionHolder.V_1_14;
      if (var1) {
         if (this.isColliding(Pose.c)) {
            Pose var2;
            if (this.b(this.data)) {
               var2 = Pose.c;
            } else if (this.isElytraFlying) {
               var2 = Pose.ELYTRA;
            } else if (this.player.isSleeping()) {
               var2 = Pose.SLEEPING;
            } else if (this.a(this.data)) {
               var2 = Pose.SNEAKING;
            } else {
               var2 = Pose.a;
            }

            Pose var3;
            if (!this.isColliding(var2)) {
               if (this.isColliding(Pose.SNEAKING)) {
                  var3 = Pose.SNEAKING;
               } else {
                  var3 = Pose.c;
               }
            } else {
               var3 = var2;
            }

            this.pose = var3;
         }
      } else {
         Pose var4;
         if (this.b(this.data)) {
            var4 = Pose.c;
         } else if (this.player.isSleeping()) {
            var4 = Pose.SLEEPING;
         } else if (this.isElytraFlying) {
            var4 = Pose.ELYTRA;
         } else if (this.a(this.data)) {
            var4 = Pose.SNEAKING;
         } else {
            var4 = Pose.a;
         }

         this.pose = var4;
      }

      this.X();
   }

   public void V() {
      if (this.player != null) {
         IntaveScheduler.runTask(this::computeElytraGliding);
      }

      this.updateAttributes();
      this.T();
      this.p();
   }

   public boolean isTakingVelocity() {
      return this.velocity != null && this.velocity.clone().setY(0).length() > 0.2;
   }

   public float getLastPitch() {
      return this.lastPitch;
   }

   public void setPoseDirect(Pose pose) {
      this.pose = pose;
   }

   public void a(int var1) {
      this.aI = var1;
   }

   @Override
   public float getRotationZ() {
      return this.rotationZ;
   }

   public HeadingHandler getHeadingHandler() {
      return this.headingHandler;
   }

   public boolean a(PlayerData otherData) {
      PlayerStorage var2 = otherData.getStorage();
      BukkitEnginePlayer var3 = var2.getPhysicsHolder();
      VersionHolder var4 = var2.getVersionHolder();
      ItemHolder var5 = var2.getItemHolder();
      boolean var6 = var3.isSneaking && !var5.j();
      boolean var7;
      if (var4.is_1_15()) {
         var7 = var3.X;
      } else if (var4.is_1_14_sub_1_15()) {
         var7 = var3.X || var6;
      } else {
         var7 = var6;
      }

      return var7;
   }

   public TrackedEntity getTrackedEntity() {
      return this.trackedEntity;
   }

   @Override
   public boolean isSneaking() {
      return this.isSneaking;
   }

   public void resetFall(Vector move) {
      this.fallDistance = 0.0F;
      this.moveVector = move;
   }

   public BukkitEnginePlayer(Player player, PlayerData data) {
      this.width = 0.6F;
      this.ba = 100;
      this.a0 = true;
      this.motion = new Motion();
      this.lookVector = new Vector();
      this.bo = new Vector(0, 0, 0);
      this.velocity = new Vector();
      this.b3 = false;
      this.at = 100;
      this.bC = 100;
      this.velocityTicks = 100;
      this.l = 100;
      this.bg = 100;
      this.groundTicks = 100;
      this.bU = 100;
      this.aT = 100;
      this.ab = 100;
      this.al = new AtomicInteger();
      this.iteratedTick = 100;
      this.slowdownTicks = 100;
      this.ae = false;
      this.bL = new ArrayList();
      this.a8 = new HashMap();
      this.b = null;
      this.bQ = 100;
      this.q = Unknown242.d;
      this.H = Unknown242.d;
      this.teleporting = false;
      this.W = false;
      this.V = false;
      this.ah = false;
      this.aB = null;
      this.bv = null;
      this.P = 10;
      this.ac = 0;
      this.f = Unknown19.a(new HashMap());
      this.bJ = false;
      this.t = false;
      this.R = false;
      this.bn = false;
      this.G = 0;
      this.D = 0;
      this.c = false;
      this.pose = Pose.a;
      this.headingHandler = Headings.VANILLA;
      this.d = Material.AIR;
      this.boundingBox = Box.ofDouble(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
      this.v = false;
      this.moveVector = null;
      this.player = player;
      this.data = data;
      this.L = Unknown135.a(Motion.class).a(Unknown303::a).b(Unknown303::b).a(Unknown303::a).c().a(data).a(1).a();
      this.bp = ImmutableList.of();
   }

   public void setLocation(Location location, String reason) {
      this.location = location;
   }

   public double P() {
      return this.bQ > 1 ? 0.0 : this.F * 2.0;
   }

   @Override
   public float getMovementSpeed(boolean sprinting) {
      return sprinting ? this.movementAttribute * 1.3F : this.movementAttribute;
   }

   @Override
   public double y() {
      return this.ar;
   }

   @Override
   public double getY() {
      return this.y;
   }

   public void clearTrackedEntity() {
      if (this.isTrackingAttacked()) {
         this.trackedEntity = null;
      }
   }

   @Deprecated
   public float getSprintAttributeValue() {
      return this.movementAttribute;
   }

   @Override
   public double getLastY() {
      return this.lastY;
   }

   private void f() {
      unknown79 var1 = this.data.getStorage().c();

      for(TrackedEntity var3 : var1.i()) {
         var3.n();
      }

   }

   @Override
   public double getMotionZ() {
      return this.motionZ;
   }

   public List a() {
      return this.bp;
   }

   @Override
   public double getLastX() {
      return this.lastX;
   }

   public Unknown135 A() {
      return this.L;
   }

   @Override
   public boolean isInWeb() {
      return this.inWeb;
   }

   private float getJumpModifier() {
      World var1 = this.player.getWorld();
      float var2 = this.a(WorldUtil.getMaterialAt(this.data, var1, this.x, this.y, this.z));
      float var3 = this.a(this.s());
      return (double)var2 == 1.0 ? var3 : var2;
   }

   private boolean is1_9(Player player) {
      PlayerData var2 = PlayerDataManager.getPlayerData(player);
      PlayerStorage var3 = var2.getStorage();
      VersionHolder var4 = var3.getVersionHolder();
      return var4.is1_9();
   }

   public void J() {
      ItemHolder var1 = this.data.getStorage().getItemHolder();
      if (this.player.getFoodLevel() >= 6 && !var1.j()) {
         pU.a(this.player, 3, false);
         this.bl = true;
      }

   }

   private void N() {
      ItemHolder var1 = this.data.getStorage().getItemHolder();
      Unknown279 var2 = var1.f;
      if (var2 != null) {
         int var3 = var2.a();
         ItemStack var4 = var2.b();
         boolean var5 = Unknown159.a(this.player, var4) && var1.h();
         if (var5) {
            var1.e();
         } else {
            var1.resetItem();
         }

         var1.setHeldItemSlot(var3);
         var1.g = 0;
         var1.f = null;
      }

   }

   @Override
   public float getPitch() {
      return this.pitch;
   }

   public boolean b(int var1) {
      VersionHolder var2 = this.data.getStorage().getVersionHolder();
      if (!var2.isLegacy()) {
         return this.aI <= var1;
      } else {
         return this.skipTicks <= var1 && this.aI <= var1;
      }
   }

   public void updateAcceleration(boolean value) {
      this.acceleration = CollisionUtil.getAcceleration(this.data, value, this.serverX, this.serverY, this.serverZ);
   }

   public void o() {
      this.aI = 0;
   }

   @Override
   public boolean isCollideWater() {
      return this.inWater;
   }

   public float getJumpMoveFactor() {
      return this.jumpMoveFactor;
   }

   @Override
   public float getAcceleration() {
      return this.acceleration;
   }

   private void X() {
      this.jumpStep = this.pose.getWidth(this.data);
      this.height = this.pose.getHeight(this.data);
      this.roundedJumpStep = (double)Math.round((double)this.jumpStep * 500.0) / 1000.0;
      this.S = (double)Math.round((double)this.height * 100.0) / 100.0;
   }

   public void M() {
      this.moveVector = null;
   }

   public Box getBoundingBox() {
      return this.boundingBox;
   }

   @Override
   public Pose getPose() {
      return this.pose;
   }

   public boolean w() {
      return this.ak;
   }

   public float getEyeHeight() {
      switch(Unknown54.a[this.pose.ordinal()]) {
         case 1:
         case 2:
            return 0.4F;
         case 3:
            return 0.2F;
         case 4:
            return 1.62F - this.data.getStorage().getVersionHolder().B();
         default:
            return 1.62F;
      }
   }

   @Override
   public double getMotionY() {
      return this.motionY;
   }

   public void setSprinting(boolean sprinting) {
      this.sprinting = sprinting;
      EntityHolder var4 = this.data.getStorage().getEntityHolder();
      WrappedAttribute var5 = var4.getAttribute("generic.movementSpeed");
      List var6 = var4.b(var5);
      if (sprinting) {
         if (!var6.contains(sprintAttributeKey)) {
            var6.add(sprintAttributeKey);
         }
      } else {
         var6.remove(sprintAttributeKey);
      }

   }

   @Deprecated
   public void setSpeed(float value) {
      this.movementAttribute = value;
      this.updateAcceleration(this.sprinting);
   }

   @Deprecated
   public void setJumpMoveFactor(float jumpMoveFactor, boolean sprint) {
      this.jumpMoveFactor = jumpMoveFactor;
      this.updateAcceleration(sprint);
   }

   public double L() {
      PotionHolder var1 = this.data.getStorage().getPotionHolder();
      int var2 = var1.getSpeedAmplifier();
      double var3 = 0.271;
      if (var2 != 0) {
         var3 *= 1.0 + 0.4 * (double)var2;
      }

      if (this.isSneaking) {
         var3 *= 0.2;
      }

      return var3;
   }

   public void setBoundingBox(Box box) {
      if (!this.v) {
         this.computeFrictionFactor();
      }

      this.boundingBox = box;
   }

   @Override
   public boolean isContextGround() {
      return this.contextGround;
   }

   public void n() {
      ++this.aI;
      ++this.skipTicks;
      ++this.T;
   }

   @Override
   public double getLastZ() {
      return this.lastZ;
   }

   @Override
   public double getServerX() {
      return this.serverX;
   }

   public void computeFrictionFactor() {
      VersionHolder var1 = this.data.getStorage().getVersionHolder();
      int var2 = var1.getVersionId();
      this.minimumDistance = var2 <= 47 ? 0.005 : 0.003;
      this.frictionMultiplier = var2 <= VersionHolder.V_1_15 ? 0.16277136F : 0.16277137F;
      this.frictionBlockRemove = var2 <= VersionHolder.V_1_15 ? 1.0 : 0.5000001;
      this.isModernVersion = var2 >= VersionHolder.V_1_15;
      if (!this.v) {
         Location var3 = this.player.getLocation();
         this.boundingBox = Box.of(this.data, var3.getX(), var3.getY(), var3.getZ());
         this.v = true;
      }

   }

   private void livingUpdatePlayer() {
      PlayerStorage var3 = this.data.getStorage();
      EntityHolder var4 = var3.getEntityHolder();
      this.jumpMoveFactor = 0.02F;
      this.movementAttribute = (float)var4.getAttribute("generic.movementSpeed", EntityHolder.movementSpeed);
      if (this.sprint) {
         this.jumpMoveFactor = (float)((double)this.jumpMoveFactor + 0.005999999865889549);
      }

   }

   private boolean isColliding(Pose pose) {
      return de.jpx3.intave.anticheat.engine.util.CollisionUtil.isColliding(this.data.getPlayer(), pose.from(this.data).shrink(1.0E-7));
   }

   public kt getLastRotation() {
      return new kt(this.lastYaw, this.lastPitch);
   }

   public double getDistance(Location otherPos) {
      double var2 = Math.abs(this.serverX - otherPos.getX());
      double var4 = Math.abs(this.serverY - otherPos.getY());
      double var6 = Math.abs(this.serverZ - otherPos.getZ());
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public void T() {
      if (this.player == null) {
         this.O = new WeakReference(Unknown134.a((World)Bukkit.getWorlds().get(0)));
      } else {
         this.O = new WeakReference(Unknown134.a(this.player.getWorld()));
      }
   }

   private void p() {
      Location var1;
      if (this.player == null) {
         var1 = new Location((World)Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0);
      } else {
         var1 = this.player.getLocation();
         this.fallDistance = this.player.getFallDistance();
      }

      this.location = var1.clone();
      this.x = var1.getX();
      this.y = var1.getY();
      this.z = var1.getZ();
      this.serverX = this.x;
      this.serverY = this.y;
      this.serverZ = this.z;
      this.X();
   }

   @Override
   public double getZ() {
      return this.z;
   }

   @Override
   public boolean isOnGround() {
      return this.onGround;
   }

   @Override
   public boolean isCollideLava() {
      VersionHolder var1 = this.data.getStorage().getVersionHolder();
      if (var1.isNewCollision()) {
         return this.ap;
      } else {
         Box var2 = this.boundingBox.grow(-0.1F, -0.4F, -0.1F);
         return CollisionUtil.collideLava(this.data, this.player.getWorld(), var2);
      }
   }

   public boolean i() {
      return BlockTypeUtil.getOrDefault(this.s()).c();
   }

   public void setAttacked(TrackedEntity entity) {
      this.bQ = 0;
      this.F = entity.a(this.getIntaveVector());
      this.trackedEntity = entity;
   }

   public boolean isTrackingAttacked() {
      return this.trackedEntity != null;
   }
}
