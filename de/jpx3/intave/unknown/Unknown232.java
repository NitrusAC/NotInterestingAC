package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class Unknown232 {
   private static final Set d = new HashSet();
   private static final boolean c = MinecraftVersion.V_1_14.atOrAbove();

   private static boolean b(Class var0, Method var1) {
      return var1.getDeclaringClass() == var0;
   }

   public static boolean a(World var0, Player var1, BlockPosition var2) {
      return Unknown410.b().a(var0, var1, var2);
   }

   public static boolean a(Material var0) {
      return d.contains(var0);
   }

   public static void d() {
      e();
   }

   private static boolean a(Class var0) {
      for(Method var5 : b(var0)) {
         String var6 = var5.getName();
         if (var6.equalsIgnoreCase("interact")) {
            String var7 = var5.getDeclaringClass().getSimpleName();
            if (!var7.equals("Block") && !var7.equals("BlockBase")) {
               return true;
            }
         }
      }

      return false;
   }

   private static void b() {
      Method var3;
      try {
         Class[] var10004 = new Class[0];
         var3 = Material.class.getMethod(qd.b("isInteractable", Material.class, var10004), var10004);
      } catch (NoSuchMethodException var10) {
         throw new IntaveInternalException(var10);
      }

      for(Material var7 : Material.values()) {
         try {
            if (var7.isBlock() && var3.invoke(var7)) {
               d.add(var7);
            }
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   private static void a() {
      for(Material var6 : Material.values()) {
         if (var6.isBlock()) {
            Object var7 = Unknown410.b().a(var6.getId());
            if (var7 == null) {
               Logger.getLogger().print("No block found for id " + var6.getId());
            } else if (a(var7.getClass())) {
               d.add(var6);
            }
         }
      }

   }

   private static void e() {
      if (c) {
         b();
      } else {
         a();
      }

   }

   private static List b(Class var0) {
      ArrayList var4 = new ArrayList();

      do {
         Arrays.stream(var0.getDeclaredMethods()).filter(Unknown232::b).forEach(var4::add);
         var0 = var0.getSuperclass();
      } while(var0 != Object.class);

      return var4;
   }

   public static float a(Player var0, ItemStack var1, BlockPosition var2) {
      return Unknown410.b().a(var0, var1, var2);
   }
}
