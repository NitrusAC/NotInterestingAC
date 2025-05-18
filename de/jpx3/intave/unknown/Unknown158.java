package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

@Unknown61
@Deprecated
public final class Unknown158 {
   private static final Class b = ReflectionUtil.getClazz("Entity");
   public static final boolean c = ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_16);
   private static final Field a = ReflectionUtil.getField(b, MinecraftVersion.V_1_17.atOrAbove() ? "z" : "onGround");

   @Unknown61
   public static boolean a(Player var0) {
      Entity var1 = ((CraftEntity)var0).getHandle();
      return c ? a(var1) : var1.onGround;
   }

   static {
      a.setAccessible(true);
   }

   @Unknown61
   public static void a(Player var0, Object var1) {
      ((CraftPlayer)var0).getHandle().playerConnection.sendPacket((Packet)var1);
   }

   private static boolean a(Object var0) {
      try {
         return a.get(var0);
      } catch (IllegalAccessException var2) {
         throw new IntaveInternalException(var2);
      }
   }

   @Unknown61
   public static void a(Player var0, boolean var1) {
      Entity var2 = ((CraftEntity)var0).getHandle();
      if (c) {
         a(var2, var1);
      } else {
         var2.onGround = var1;
      }

   }

   private static void a(Object var0, boolean var1) {
      try {
         a.set(var0, var1);
      } catch (IllegalAccessException var3) {
         throw new IntaveInternalException(var3);
      }
   }
}
