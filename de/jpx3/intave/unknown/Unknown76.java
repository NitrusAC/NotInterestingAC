package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.FieldAccessException;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.packet.wrap.EntityPacketReader;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.anticheat.util.reach.ReachEntityType;
import de.jpx3.intave.unknown.check.Check15;
import java.lang.reflect.Field;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

public final class Unknown76 {
   private String a;
   private static final boolean b = !MinecraftVersion.V_1_14.atOrAbove();
   private static final int c = MinecraftVersion.V_1_9.atOrAbove() ? 6 : 9;
   private static final boolean d = !MinecraftVersion.V_1_15.atOrAbove();
   private final boolean g;
   private final boolean e;
   private final boolean h;
   private final boolean f = MinecraftVersion.V_1_9.atOrAbove();

   private Object b(WrappedDataWatcher var1) {
      Object var2 = var1.getHandle();
      Class var3 = var2.getClass();

      try {
         String var10003 = this.a;
         return this.a(var2, var3.getDeclaredField(qd.c(var3, this.a)));
      } catch (NoSuchFieldException var5) {
         throw new IntaveInternalException(var5);
      }
   }

   private void a(Field var1) {
      if (!var1.isAccessible()) {
         var1.setAccessible(true);
      }

   }

   public ReachEntityType c(Entity var1) {
      HitboxSize var5 = this.a(var1);
      String var6 = this.b(var1);
      if (var1.getType() == EntityType.ZOMBIE || var1.getType() == EntityType.PIG_ZOMBIE) {
         Zombie var7 = (Zombie)var1;
         if (var7.isBaby()) {
            var5 = HitboxSize.ofPlayer();
         }
      }

      boolean var8 = var1 instanceof LivingEntity;
      return new ReachEntityType(var6, var5, var1.getType().getTypeId(), var8, 6);
   }

   public ReachEntityType b(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      int var6 = var5.getIntegers().read(0);
      Entity var7 = Check15.a(var1.getPlayer(), var6);
      if (var7 != null) {
         return this.c(var7);
      } else if (d) {
         WrappedDataWatcher var10 = (WrappedDataWatcher)var5.getDataWatcherModifier().read(0);
         if (var10 != null && this.c(var10)) {
            return this.a(var10, true);
         } else {
            int var9 = var5.getIntegers().read(1);
            return Unknown161.a(var9, true);
         }
      } else {
         int var8 = var5.getIntegers().read(1);
         return Unknown161.a(var8, true);
      }
   }

   private void a() {
      com.comphenix.protocol.utility.MinecraftVersion var4 = ServerUtil.getServerVersion();
      if (var4.isAtLeast(MinecraftVersion.V_1_14)) {
         this.a = "entity";
      } else if (var4.isAtLeast(MinecraftVersion.V_1_10)) {
         this.a = "c";
      } else if (var4.isAtLeast(MinecraftVersion.V_1_9)) {
         this.a = "b";
      } else {
         this.a = "a";
      }

      Class var5 = ReflectionUtil.getClazz("Entity");
      Class var6 = ReflectionUtil.getClazz("DataWatcher");

      for(Field var10 : var6.getDeclaredFields()) {
         if (var10.getType() == var5) {
            String var11 = var10.getName();
            this.a = var11;
            break;
         }
      }

   }

   private Object a(Object var1, Field var2) {
      try {
         this.a(var2);
         return var2.get(var1);
      } catch (Exception var4) {
         throw new IntaveInternalException(var4);
      }
   }

   public ReachEntityType a(PacketEvent var1, int var2, List var3) {
      PacketContainer var4 = var1.getPacket();
      int var5 = var4.getIntegers().read(0);
      Entity var6 = Check15.a(var1.getPlayer(), var5);
      if (var6 != null) {
         return this.c(var6);
      } else {
         Boolean var7 = this.a(var3, var2);
         if (var7 == null) {
            return null;
         } else {
            ReachEntityType var8 = Unknown161.a(var2, false);
            return var7 ? this.a(var8) : var8;
         }
      }
   }

   private ReachEntityType a(WrappedDataWatcher var1, boolean var2) {
      Object var3 = this.b(var1);
      HitboxSize var4 = Unknown364.a(var3);
      String var5 = this.a(var3);
      int var6 = this.a(var1);
      return new ReachEntityType(var5, var4, var6, var2, 7);
   }

   private int a(WrappedDataWatcher var1) {
      return var1.getEntity().getType().getTypeId();
   }

   private String a(int var1) {
      switch(var1) {
         case 1:
            return "EntityBoat";
         case 2:
            return "EntityItem";
         case 10:
            return "EntityMinecart";
         case 50:
            return "EntityTNTPrimed";
         case 51:
            return "EntityEnderCrystal";
         case 61:
            return "EntitySnowball";
         case 62:
            return "EntityEgg";
         case 63:
            return "EntityFireball";
         case 64:
            return "EntitySmallFireball";
         case 65:
            return "EntityEnderPearl";
         case 66:
            return "EntityWitherSkull";
         case 70:
            return "EntityFallingBlock";
         case 72:
            return "EntityEnderEye";
         case 73:
            return "EntityPotion";
         case 75:
            return "EntityExpBottle";
         case 76:
            return "EntityFireworkRocket";
         case 77:
            return "EntityLeashKnot";
         case 78:
            return "EntityArmorStand";
         case 90:
            return "EntityFishHook";
         default:
            return "null";
      }
   }

   public boolean c(WrappedDataWatcher var1) {
      return this.b(var1) != null;
   }

   private String a(Object var1) {
      String var5 = var1.getClass().getSimpleName();
      if (var5.startsWith("Entity")) {
         var5 = var5.substring("Entity".length());
      }

      return var5;
   }

   private Boolean a(List var1, int var2) {
      byte var6;
      if (this.f) {
         if (this.g) {
            if (this.h) {
               if (this.e) {
                  if (var2 == 30) {
                     var6 = 14;
                  } else {
                     var6 = 15;
                  }
               } else if (var2 == 30) {
                  var6 = 13;
               } else {
                  var6 = 14;
               }
            } else {
               var6 = 12;
            }
         } else {
            var6 = 11;
         }
      } else {
         var6 = 12;
      }

      for(WrappedWatchableObject var8 : var1) {
         int var9 = var8.getIndex();
         if (var9 == var6) {
            Object var10 = var8.getRawValue();
            if (var10 != null) {
               if (var10 instanceof Boolean) {
                  return (Boolean)var10;
               }

               if (var10 instanceof Byte) {
                  byte var11 = (Byte)var10;
                  if (this.h && var2 == 30) {
                     return var11 == 1;
                  }

                  return var11 < 0;
               }

               return null;
            }
         }
      }

      return null;
   }

   public HitboxSize a(Entity var1) {
      return Unknown364.a(var1);
   }

   public ReachEntityType a(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      int var6 = var5.getIntegers().read(0);
      EntityPacketReader var7 = (EntityPacketReader)PacketInterpreters.getInterpreter(var5);
      Entity var8 = var7.getEntity(var1);
      var7.reset();
      if (var8 != null) {
         return this.c(var8);
      } else if (b) {
         try {
            int var13 = var5.getIntegers().read(c);
            String var14 = this.a(var13);
            HitboxSize var15 = this.b(var13);
            return new ReachEntityType(var14, var15, var13 == 1 ? 41 : -1, false, 2);
         } catch (FieldAccessException var12) {
            Logger.getLogger().info("Can't access type data of " + var6);
            var12.printStackTrace();
            return new ReachEntityType("Invalid", HitboxSize.ofEmpty(), -2, false, 3);
         }
      } else {
         EntityType var9 = (EntityType)var5.getEntityTypeModifier().read(0);
         Class var10 = var9.getEntityClass();
         String var11 = var10.getSimpleName();
         return new ReachEntityType(var11, HitboxSize.ofEmpty(), -2, false, 4);
      }
   }

   private HitboxSize b(int var1) {
      switch(var1) {
         case 1:
            return HitboxSize.of(1.5F, 0.6F);
         case 2:
         case 61:
         case 62:
         case 65:
         case 72:
         case 73:
         case 75:
         case 76:
         case 90:
            return HitboxSize.of(0.25F, 0.25F);
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 59:
         case 67:
         case 68:
         case 69:
         case 71:
         case 74:
         case 79:
         case 80:
         case 81:
         case 82:
         case 83:
         case 84:
         case 85:
         case 86:
         case 87:
         case 88:
         case 89:
         default:
            return HitboxSize.ofEmpty();
         case 10:
            return HitboxSize.of(0.98F, 0.7F);
         case 50:
         case 70:
            return HitboxSize.of(0.98F, 0.98F);
         case 51:
            return HitboxSize.of(2.0F, 2.0F);
         case 60:
            return HitboxSize.ofEmpty();
         case 63:
            return HitboxSize.of(3.0F, 3.0F);
         case 64:
         case 66:
            return HitboxSize.of(0.3125F, 0.3125F);
         case 77:
            return HitboxSize.of(0.5F, 0.5F);
         case 78:
            return HitboxSize.of(0.5F, 1.975F);
      }
   }

   public String b(Entity var1) {
      return this.a(Unknown134.b(var1));
   }

   private ReachEntityType a(ReachEntityType var1) {
      if (var1 == null) {
         return null;
      } else {
         HitboxSize var5 = HitboxSize.of(var1.getHitboxSize().getWidth() * 0.5F, var1.getHitboxSize().getHeight() * 0.5F);
         return new ReachEntityType(var1.getEntityType(), var5, var1.g(), var1.e(), 5);
      }
   }

   public Unknown76(IntavePlugin var1) {
      this.g = MinecraftVersion.V_1_10.atOrAbove();
      this.h = MinecraftVersion.V_1_14.atOrAbove();
      this.e = MinecraftVersion.V_1_15.atOrAbove();
      if (d) {
         this.a();
      }

   }
}
