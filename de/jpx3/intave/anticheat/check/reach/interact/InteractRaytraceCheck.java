package de.jpx3.intave.anticheat.check.reach.interact;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.MovingObjectPositionBlock;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.check.api.BaseCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.EntityPacketReader;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.HitResult;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.anticheat.util.reach.Interaction;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown112;
import de.jpx3.intave.unknown.Unknown113;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown159;
import de.jpx3.intave.unknown.Unknown215;
import de.jpx3.intave.unknown.Unknown232;
import de.jpx3.intave.unknown.Unknown27;
import de.jpx3.intave.unknown.Unknown283;
import de.jpx3.intave.unknown.Unknown74;
import de.jpx3.intave.unknown.check.Check2;
import java.util.List;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Relocate
public final class InteractRaytraceCheck extends BaseCheck {
   private final CheckConfigValue q;
   private final Check2 n;
   private static final boolean o = MinecraftVersion.V_1_14.atOrAbove();
   private final IntavePlugin p;

   private void a(Player var1, Location var2) {
      IntaveScheduler.runTask(this::e);
   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.BLOCK_DIG}
   )
   public void c(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getData(var4);
      Unknown27 var6 = (Unknown27)this.getStorage(var5);
      PlayerStorage var7 = var5.getStorage();
      PlayerHolder var8 = var7.getPlayerHolder();
      EntityHolder var9 = var7.getEntityHolder();
      ItemHolder var10 = var7.getItemHolder();
      VersionHolder var11 = var7.getVersionHolder();
      PacketContainer var12 = event.getPacket();
      BlockPosition var13 = (BlockPosition)event.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
      if (var13 != null && !event.isCancelled()) {
         ItemStack var14 = var10.getItemInHand();
         if (Unknown159.a(var14) && var4.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(true);
         } else {
            PlayerDigType var15 = (PlayerDigType)var12.getPlayerDigTypes().readSafely(0);
            float var16 = Unknown232.a(var4, var10.getItemInHand(), var13);
            boolean var17 = var16 >= 1.0F || var9.isGamemodeWtf(de.jpx3.intave.anticheat.engine.util.GameMode.CREATIVE);
            boolean var18 = var17 || var15 == PlayerDigType.STOP_DESTROY_BLOCK;
            Direction var19 = (Direction)var12.getDirections().readSafely(0);
            int var20 = var19 == null ? 0 : var19.ordinal();
            boolean var21 = var13.getX() == 0 && var13.getY() == 0 && var13.getZ() == 0;
            if (!var21 || var20 != 0) {
               if (!var11.isHcfVersion() || !var21 || var19 != Direction.SOUTH || var15 != PlayerDigType.RELEASE_USE_ITEM) {
                  Interaction var22 = new Interaction(
                     var12.deepClone(),
                     var4.getWorld(),
                     var4,
                     var13,
                     var20,
                     var18 ? Unknown113.a : Unknown113.b,
                     var10.getMaterialInHand(),
                     Hand.MAIN_HAND,
                     var15
                  );
                  boolean var23 = var6.e > 0L;
                  if (!var23 && this.a(var22)) {
                     this.n.a(var22);
                  } else {
                     var6.d.add(var22);
                     event.setCancelled(true);
                     if (var15 == PlayerDigType.START_DESTROY_BLOCK) {
                        ++var6.e;
                     }
                  }

                  if (var18 || var15 == PlayerDigType.ABORT_DESTROY_BLOCK) {
                     var6.a = var8.digging = false;
                     var8.lastDig = System.currentTimeMillis();
                  } else if (var15 == PlayerDigType.START_DESTROY_BLOCK) {
                     var6.a = var8.digging = true;
                  }

               }
            }
         }
      } else {
         if (var8.digging) {
            var8.lastDig = System.currentTimeMillis();
         }

         var6.a = var8.digging = false;
      }
   }

   private void a(PacketContainer var1, BlockPosition var2) {
      if (o && !var1.getType().equals(Client.BLOCK_DIG)) {
         MovingObjectPositionBlock var3 = (MovingObjectPositionBlock)var1.getMovingBlockPositions().readSafely(0);
         var3.setBlockPosition(var2);
      } else {
         var1.getBlockPositionModifier().write(0, var2);
      }

   }

   private boolean a(PlayerData var1, Interaction var2) {
      BlockPosition var3 = var2.f();
      BukkitEnginePlayer var4 = var1.getStorage().getPhysicsHolder();
      double var5 = (double)(var3.getX() - MathUtil.floor(var4.x));
      double var7 = (double)(var3.getY() - MathUtil.floor(var4.y + (double)var4.getEyeHeight()));
      double var9 = (double)(var3.getZ() - MathUtil.floor(var4.z));
      return var5 == 0.0 && var7 == 0.0 && var9 == 0.0;
   }

   private void e(Player var1, Location var2) {
      var1.updateInventory();
      this.d(var1, var2);

      for(de.jpx3.intave.anticheat.util.Direction var6 : de.jpx3.intave.anticheat.util.Direction.values()) {
         Location var7 = var2.clone().add(var6.p().toVector());
         this.d(var1, var7);
      }

   }

   private void d(Player var1, Location var2) {
      PacketContainer var3 = ProtocolLibrary.getProtocolManager().createPacket(Server.BLOCK_CHANGE);
      if (WorldUtil.isChunkLoaded(var2.getWorld(), var2.getBlockX(), var2.getBlockZ())) {
         Block var4 = WorldUtil.getBlockAt(var2);
         Object var5 = Unknown15.a(var4);
         WrappedBlockData var6 = WrappedBlockData.fromHandle(var5);
         BlockPosition var7 = new BlockPosition(var2.getBlockX(), var2.getBlockY(), var2.getBlockZ());
         var3.getBlockData().write(0, var6);
         var3.getBlockPositionModifier().write(0, var7);
         ProtocolManager.sendPacket(var1, var3);
      }
   }

   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      World var3 = var2.getWorld();
      PlayerData var4 = this.getData(var2);
      BukkitEnginePlayer var5 = var4.getStorage().getPhysicsHolder();
      Unknown27 var6 = (Unknown27)this.getStorage(var4);
      List var7 = var6.d;
      if (!var7.isEmpty()) {
         Location var8 = new Location(var3, var5.lastX, var5.lastY, var5.lastZ);
         var8.setYaw(var5.yaw);
         var8.setPitch(var5.pitch);
         Location var9 = var8.clone();
         var9.setYaw(var5.lastYaw);

         for(Interaction var11 : var7) {
            this.a(var11, var8, var9);
         }

         var7.clear();
      }
   }

   private boolean a(Interaction var1) {
      World var2 = var1.h();
      Player var3 = var1.a();
      PlayerData var4 = this.getData(var3);
      BukkitEnginePlayer var5 = var4.getStorage().getPhysicsHolder();
      Unknown27 var6 = (Unknown27)this.getStorage(var4);
      Location var7 = new Location(var3.getWorld(), var5.lastX, var5.lastY, var5.lastZ);
      var7.setYaw(var5.yaw);
      var7.setPitch(var5.pitch);
      Location var8 = var7.clone();
      var8.setYaw(var5.lastYaw);

      HitResult var9;
      HitResult var10;
      try {
         var9 = ReachUtil.a(var3, var7);
         var10 = ReachUtil.a(var3, var8);
      } catch (Exception var22) {
         var22.printStackTrace();
         return var1.f().toLocation(var2).distance(var3.getLocation()) < 6.0;
      }

      boolean var11 = var6.c;
      HitResult var12 = var11 ? var10 : var9;
      boolean var13 = var12 == null || var12.pos == WrappedVec3d.c;
      BlockPos var14 = var13 ? BlockPos.NULL_BLOCKPOS : var12.getBlockPos();
      Location var15 = var14.a(var2);
      Location var16 = var1.f().toLocation(var2);
      boolean var17 = var13 || var15.distance(var16) > 0.0 || this.a(var1, var12);
      if (var17) {
         HitResult var18 = var11 ? var9 : var10;
         boolean var19 = var18 == null || var18.pos == WrappedVec3d.c;
         BlockPos var20 = var19 ? BlockPos.NULL_BLOCKPOS : var18.getBlockPos();
         Location var21 = var20.a(var2);
         var17 = var19 || var21.distance(var16) > 0.0 || this.a(var1, var18);
      }

      return !var17;
   }

   private boolean a(Interaction var1, HitResult var2) {
      Player var3 = var1.a();
      PlayerData var4 = PlayerDataManager.getPlayerData(var3);
      VersionHolder var5 = var4.getStorage().getVersionHolder();
      int var6 = var1.j();
      boolean var7 = var5.isMessyVersion() && this.a(var4, var1) && var6 == var2.direction.u().o();
      return !var7 && var2.direction.o() != var6;
   }

   public InteractRaytraceCheck(IntavePlugin var1) {
      super("InteractionRaytrace", "interactionraytrace", Unknown27.class);
      this.p = var1;
      this.q = new CheckConfigValue(this, 1.0);
      this.n = new Check2(var1);
   }

   @Override
   public boolean e() {
      return true;
   }

   private void c(Player var1, Location var2) {
      this.a(var1, var2);
   }

   private boolean a(PlayerData var1, Location var2, Location var3, HitResult var4) {
      WrappedVec3d var5 = var4.pos;
      Box var6 = new Box(
            (double)var3.getBlockX(),
            (double)var3.getBlockY(),
            (double)var3.getBlockZ(),
            (double)(var3.getBlockX() + 1),
            (double)(var3.getBlockY() + 1),
            (double)(var3.getBlockZ() + 1)
         )
         .grow(0.1);
      WrappedVec3d var7 = ReachUtil.interpolateLocation(var2, var2, (double)var1.getStorage().getPhysicsHolder().getEyeHeight(), 1.0F);
      WrappedVec3d var8 = var5.c(var7).f().a(0.2);
      WrappedVec3d var9 = var7.a(1.0);
      if (var6.c(var5)) {
         return true;
      } else {
         for(int var10 = 0; var7.distanceSqrt(var9) < 4.0 && var10 < 50; ++var10) {
            var9 = var9.b(var8);
            if (var6.c(var9)) {
               return true;
            }
         }

         return false;
      }
   }

   private void a(Player var1, PacketContainer var2) {
      this.getData(var1).c();
      ProtocolManager.receivePacket(var1, var2);
   }

   private boolean a(Interaction var1, HitResult var2, Location var3, Location var4, boolean var5, boolean var6) {
      Player var9 = var1.a();
      PlayerData var10 = this.getData(var9);
      Unknown113 var11 = var1.d();
      Block var12 = WorldUtil.getBlockAt(var3);
      Block var13 = WorldUtil.getBlockAt(var4);
      Material var14 = IntaveMaterial.from(var13);
      Material var15 = IntaveMaterial.from(var12);
      if (var15 != Material.AIR && var14 != Material.AIR) {
         double var16 = 0.0;
         boolean var18 = false;
         String var19;
         String var20;
         if (var11 == Unknown113.a) {
            boolean var21 = (double)Unknown232.a(var9, var10.getStorage().getItemHolder().getItemInHand(), var1.f()) < 0.8;
            String var22 = this.a(var15);
            String var23 = "";
            if (var5 || var4.getBlockX() == 0 && var4.getBlockY() == 0 && var4.getBlockZ() == 0) {
               var23 = "looking in air";
               var16 = var21 ? 20.0 : 5.0;
            } else if (var4.distance(var3) > 0.0) {
               String var24 = this.a(var14);
               if (var14 == var15) {
                  var24 = "a different " + var24;
               }

               var23 = "but looking at " + var24 + " block";
               var16 = var21 ? 20.0 : 5.0;
            } else if (this.a(var1, var2)) {
               var23 = "invalid block face";
               var16 = var21 ? 20.0 : 15.0;
            }

            float var34 = Unknown232.a(var9, var10.getStorage().getItemHolder().getItemInHand(), var1.f());
            boolean var25 = var34 >= 1.0F || var10.getStorage().getEntityHolder().isGamemodeWtf(de.jpx3.intave.anticheat.engine.util.GameMode.CREATIVE);
            if (var25) {
               var16 = 0.0;
            }

            if (var6) {
               double var26 = (double)this.flag("k-multiplier", var9) / 100.0;
               var16 *= var26;
            }

            var19 = "performed invalid break";
            var20 = var22 + " block, " + var23;
            var18 = true;
         } else if (var11 == Unknown113.c) {
            String var28 = this.a(var15);
            String var31 = this.a(var10.getStorage().getItemHolder().getMaterialInHand());
            String var33 = "";
            if (!var5 && (var4.getBlockX() != 0 || var4.getBlockY() != 0 || var4.getBlockZ() != 0)) {
               if (var4.distance(var3) > 0.0) {
                  String var35 = this.a(var14);
                  if (var14 == var15) {
                     var35 = "a different " + var35;
                  }

                  var33 = "looking at " + var35 + " block";
                  var16 = 2.5;
               } else if (var1.j() != var2.direction.o()) {
                  var33 = "invalid block face";
                  var16 = 2.5;
               }
            } else {
               var33 = "looking in air";
               var16 = 5.0;
            }

            if (var6) {
               double var36 = (double)this.flag("k-multiplier", var9) / 100.0;
               var16 *= var36;
            }

            var19 = "performed invalid placement";
            var20 = var31 + " block on " + var28 + " block, " + var33;
         } else {
            String var29 = this.a(var15);
            var19 = "invalid interaction";
            var20 = var29 + " block";
            var18 = true;
            var16 = 0.0;
         }

         if (var10.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
            var18 = false;
         }

         if (var10.getStorage().getPhysicsHolder().teleporting) {
            var18 = true;
         }

         Violation var30 = Violation.builder(InteractRaytraceCheck.class).player(var9).name(var19).description(var20).vl(var16).build();
         ImmutableViolation var32 = MoudleLoader.violations().dispatchViolation(var30);
         return var32.m() || var18;
      } else {
         return true;
      }
   }

   @PacketListener(
      g = {ServerPacket.BLOCK_BREAK_ANIMATION}
   )
   public void d(PacketEvent var1) {
      PacketContainer var2 = var1.getPacket();
      EntityPacketReader var3 = (EntityPacketReader)PacketInterpreters.getInterpreter(var2);
      Entity var4 = var3.getEntity(var1);
      var3.reset();
      if (var4 instanceof Player && PlayerDataManager.isInjected((Player)var4)) {
         PlayerData var5 = PlayerDataManager.getPlayerData((Player)var4);
         if (!((Unknown27)this.getStorage(var5)).a) {
            var2.getIntegers().write(1, 11);
         }
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.BLOCK_PLACE, ClientPacket.USE_ITEM}
   )
   public void a(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = this.getData(var2);
      Unknown27 var4 = (Unknown27)this.getStorage(var3);
      BukkitEnginePlayer var5 = var3.getStorage().getPhysicsHolder();
      EntityHolder var6 = var3.getStorage().getEntityHolder();
      PacketContainer var7 = var1.getPacket();
      Unknown215 var8 = (Unknown215)PacketInterpreters.getInterpreter(var7);

      try {
         BlockPosition var9 = var8.a();
         if (var9 != null && !var1.isCancelled() && !var5.isTrackingAttacked()) {
            int var10 = var8.a();
            if (var10 != 255) {
               Material var11 = WorldUtil.getMaterialAt(var3, var9.toLocation(var2.getWorld()));
               boolean var12 = Unknown232.a(var11);
               ItemStack var13 = var3.getStorage().getItemHolder().getItemInHand();
               Hand var14 = (Hand)var7.getHands().readSafely(0);
               var14 = var14 == null ? Hand.MAIN_HAND : var14;
               Material var15 = var13 == null ? Material.AIR : var13.getType();
               Material var16 = var3.getStorage().getItemHolder().getMaterialInOffHand();
               Material var17 = var14 == Hand.MAIN_HAND ? var15 : var16;
               if (var17 == null) {
                  var17 = Material.AIR;
               }

               boolean var18 = var17 != Material.AIR && var17.isBlock() && !var12 && !var6.isGameMode(GameMode.ADVENTURE);
               Interaction var19 = new Interaction(
                  var7.deepClone(), var2.getWorld(), var2, var9, var10, var18 ? Unknown113.c : Unknown113.b, var17, var14, null
               );
               boolean var20 = var4.e > 0L;
               if (!var20 && this.a(var19)) {
                  if (this.n.a(var19) == Unknown112.b) {
                     this.a(var2, var9.toLocation(var2.getWorld()));
                     var1.setCancelled(true);
                  }

                  return;
               }

               var4.d.add(var19);
               var1.setCancelled(true);
               return;
            }

            return;
         }
      } finally {
         var8.reset();
      }

   }

   private void a(Interaction var1, HitResult var2, Location var3, Location var4, boolean var5, boolean var6, boolean var7) {
      Player var8 = var1.a();
      PlayerData var9 = this.getData(var8);
      Unknown74 var10 = var1.d().c();
      IntaveWorld var11 = var9.getWorld();
      if (var7) {
         var10 = Unknown74.b;
      }

      if (var9.getStorage().getPhysicsHolder().teleporting) {
         var6 = true;
      }

      boolean var12 = var1.d() != Unknown113.b;
      if (var10 == Unknown74.a) {
         if (!var5 && var2 != null) {
            PacketContainer var13 = var1.c();
            if (var6) {
               World var14 = var8.getWorld();
               Material var15 = var9.getStorage().getItemHolder().getMaterialInHand();
               byte var16 = 0;
               boolean var17 = Unknown232.a(var14, var8, new BlockPosition(var4.toVector()));
               Location var18 = var17 ? var4 : var4.clone().add(var2.direction.p().toVector());
               boolean var19 = var15.isBlock() && CollisionUtil.a(var9, var14, var18.getBlockX(), var18.getBlockY(), var18.getBlockZ(), var15, var16);
               if (var19) {
                  this.a(var8, var3);
                  var11.c(var3.getBlockX(), var3.getBlockY(), var3.getBlockZ());
                  return;
               }

               this.a(var13, var2.direction);
               BlockPosition var20 = new BlockPosition(var4.getBlockX(), var4.getBlockY(), var4.getBlockZ());
               this.a(var13, var20);
            }

            this.a(var8, var13);
            if (var12 && var6) {
               IntaveScheduler.runTask(this::c);
            }
         } else if (var12) {
            this.a(var8, var3);
            var11.c(var3.getBlockX(), var3.getBlockY(), var3.getBlockZ());
         }
      } else if (var6) {
         if (var12) {
            this.a(var8, var3);
         }
      } else {
         this.a(var8, var1.c());
      }

   }

   private String a(Material var1) {
      return var1.name().toLowerCase().replace("_", "").replace("block", "");
   }

   private void a(Interaction var1, Location var2, Location var3) {
      if (!var1.b()) {
         var1.i();
         World var4 = var1.h();
         Player var5 = var1.a();
         PlayerData var6 = this.getData(var5);
         Unknown27 var7 = (Unknown27)this.getStorage(var5);
         if (var1.g() == PlayerDigType.START_DESTROY_BLOCK) {
            --var7.e;
         }

         HitResult var8;
         HitResult var9;
         try {
            var8 = ReachUtil.a(var5, var2);
            var9 = ReachUtil.a(var5, var3);
         } catch (Exception var23) {
            var23.printStackTrace();
            if (var1.f().toLocation(var4).distance(var5.getLocation()) < 6.0) {
               this.a(var1, null, var1.f().toLocation(var4), var1.f().toLocation(var4), false, false, false);
            }

            return;
         }

         boolean var10 = var7.c;
         HitResult var11 = var10 ? var9 : var8;
         boolean var12 = var11 == null || var11.pos == WrappedVec3d.c;
         BlockPos var13 = var12 ? BlockPos.NULL_BLOCKPOS : var11.getBlockPos();
         Location var14 = var13.a(var4);
         Location var15 = var1.f().toLocation(var4);
         boolean var16 = var12 || var14.distance(var15) > 0.0 || this.a(var1, var11);
         if (var16) {
            HitResult var17 = var10 ? var8 : var9;
            boolean var18 = var17 == null || var17.pos == WrappedVec3d.c;
            BlockPos var19 = var18 ? BlockPos.NULL_BLOCKPOS : var17.getBlockPos();
            Location var20 = var19.a(var4);
            var16 = var18 || var20.distance(var15) > 0.0 || this.a(var1, var17);
            var7.c = var16 == var7.c;
         }

         boolean var24;
         boolean var25;
         if (!var16) {
            this.q.a(var6, 0.25);
            boolean var26 = this.n.a(var1) == Unknown112.b;
            var25 = var26;
            var24 = var26;
         } else {
            HitResult var27 = var10 ? var9 : var8;
            Location var28 = var10 ? var3 : var2;
            boolean var21 = var27 != null && this.a(var6, var28, var15, var27);
            boolean var22 = var1.g() == PlayerDigType.ABORT_DESTROY_BLOCK;
            var24 = this.isEnabled() && !var22 && this.a(var1, var8, var15, var14, var12, var21);
            var25 = false;
         }

         this.a(var1, var8, var15, var14, var12, var24, var25);
      }
   }

   private void a(PacketContainer var1, de.jpx3.intave.anticheat.util.Direction var2) {
      if (o && !var1.getType().equals(Client.BLOCK_DIG)) {
         MovingObjectPositionBlock var3 = (MovingObjectPositionBlock)var1.getMovingBlockPositions().readSafely(0);
         var3.setDirection(var2.d());
      } else if (var1.getDirections().size() > 0) {
         var1.getDirections().write(0, var2.d());
      } else {
         var1.getIntegers().write(0, var2.o());
      }

   }
}
